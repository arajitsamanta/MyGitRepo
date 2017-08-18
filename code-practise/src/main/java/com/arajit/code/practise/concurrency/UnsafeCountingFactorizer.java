/**
 * 
 */
package com.arajit.code.practise.concurrency;

import static com.arajit.code.practise.concurrency.ConcurencyUtil.*;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author as47775
 *
 */
public class UnsafeCountingFactorizer implements Servlet {
	
	private long count = 0;
	
	public long getCount() { return count; }
	
	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#destroy()
	 */
	@Override
	public void destroy() {

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#getServletConfig()
	 */
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#getServletInfo()
	 */
	@Override
	public String getServletInfo() {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig arg0) throws ServletException {

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factor(i);
		++count;
		encodeIntoResponse(resp, factors);
	}
	
}

