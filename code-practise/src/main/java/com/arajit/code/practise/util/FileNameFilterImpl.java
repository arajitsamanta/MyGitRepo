/**
 * 
 */
package com.arajit.code.practise.util;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author as47775
 *
 */
public class FileNameFilterImpl implements FilenameFilter {
	
	String regex;
	/**
	 * 
	 */
	public FileNameFilterImpl(String regex) {
		// TODO Auto-generated constructor stub
		this.regex=regex;
	}

	/* (non-Javadoc)
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.matches(regex);
	}

}
