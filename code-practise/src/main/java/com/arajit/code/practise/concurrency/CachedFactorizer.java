package com.arajit.code.practise.concurrency;

import static com.arajit.code.practise.concurrency.ConcurencyUtil.encodeIntoResponse;
import static com.arajit.code.practise.concurrency.ConcurencyUtil.extractFromRequest;
import static com.arajit.code.practise.concurrency.ConcurencyUtil.factor;

import java.io.IOException;
import java.math.BigInteger;

import javax.annotation.concurrent.GuardedBy;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CachedFactorizer implements Servlet {

	@GuardedBy("this")
	private BigInteger lastNumber;
	@GuardedBy("this")
	private BigInteger[] lastFactors;
	@GuardedBy("this")
	private long hits;
	@GuardedBy("this")
	private long cacheHits;

	public synchronized long getHits() {
		return hits;
	}

	public synchronized double getCacheHitRatio() {
		return (double) cacheHits / (double) hits;
	}

	@Override
	public void destroy() {

	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {

	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		BigInteger i = extractFromRequest(req);
		
		BigInteger[] factors = null;
		synchronized (this) {
			++hits;
			if (i.equals(lastNumber)) {
				++cacheHits;
				factors = lastFactors.clone();
			}
		}
		if (factors == null) {
			factors = factor(i);
			synchronized (this) {
				lastNumber = i;
				lastFactors = factors.clone();
			}
		}
		encodeIntoResponse(resp, factors);
	}

}
