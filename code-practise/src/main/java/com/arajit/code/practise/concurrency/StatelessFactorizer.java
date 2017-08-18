/**
 * 
 */
package com.arajit.code.practise.concurrency;

import static com.arajit.code.practise.concurrency.ConcurencyUtil.*;

import java.io.IOException;
import java.math.BigInteger;

import javax.annotation.concurrent.ThreadSafe;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author as47775
 *
 */
@ThreadSafe
public class StatelessFactorizer implements Servlet{

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
		BigInteger[] factors = factor(i);
		encodeIntoResponse(resp, factors);
		
	}
	
}

