package com.arajit.code.practise.concurrency;

import static com.arajit.code.practise.concurrency.ConcurencyUtil.encodeIntoResponse;
import static com.arajit.code.practise.concurrency.ConcurencyUtil.extractFromRequest;
import static com.arajit.code.practise.concurrency.ConcurencyUtil.factor;

import java.io.IOException;
import java.math.BigInteger;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@ThreadSafe
public class SynchronizedFactorizer implements Servlet {

	@GuardedBy("this")
	private BigInteger lastNumber;
	@GuardedBy("this")
	private BigInteger[] lastFactors;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public synchronized void  service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		BigInteger i = extractFromRequest(req);
		if (i.equals(lastNumber))
			encodeIntoResponse(resp, lastFactors);
		else {
			BigInteger[] factors = factor(i);
			lastNumber = i;
			lastFactors = factors;
			encodeIntoResponse(resp, factors);
		}
	}

}
