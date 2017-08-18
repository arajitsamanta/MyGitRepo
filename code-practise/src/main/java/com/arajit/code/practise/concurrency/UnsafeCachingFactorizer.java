package com.arajit.code.practise.concurrency;

import static com.arajit.code.practise.concurrency.ConcurencyUtil.*;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.concurrent.NotThreadSafe;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@NotThreadSafe
public class UnsafeCachingFactorizer implements Servlet {

	private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();
	private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();

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
	public void service(ServletRequest req, ServletResponse resp) {
		BigInteger i = extractFromRequest(req);
		if (i.equals(lastNumber.get()))
			encodeIntoResponse(resp, lastFactors.get());
		else {
			BigInteger[] factors = factor(i);
			lastNumber.set(i);
			lastFactors.set(factors);
			encodeIntoResponse(resp, factors);
		}
	}

}
