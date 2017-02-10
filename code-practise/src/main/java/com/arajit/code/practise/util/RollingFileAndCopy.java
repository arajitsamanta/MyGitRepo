/**
 * 
 */
package com.arajit.code.practise.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

import org.junit.Test;

/**
 * @author as47775
 * 
 *         This class will copy a file from one location to another location and
 *         rotate it first if file exists.
 * 
 *         Example: rotateCopy("/var/log/test.txt", "/var/tmp/")
 * 
 *         O/P -> test.txt will be copied to /var/tmp
 * 
 *         Another call to rotateCopy("/var/log/test.txt", "/var/tmp/") will
 *         first rename test.txt to test1.txt and then start copy test.txt to
 *         /var/tmp
 */
public class RollingFileAndCopy {

	private static final String FRONT_SLASH = "/";
	private static final String FILE_SEPERATOR = ".";

	private static final String REGEX_PATTERN = ".*";

	public void rotateCopy(File src, String destDir) {
		File dir = new File(destDir);
		
		/* Get original fine name*/
		String fileName = src.getName().substring(0,
				(src.getName().indexOf('.')));
		
		/* Get original fine extension*/
		String fileExtension = src.getName().substring(
				src.getName().lastIndexOf('.') + 1, src.getName().length());
		
		/* Generate file name pattern to use for FilenameFilter. pattern is like filename.*filextension */
		StringBuffer fileNamePattern = new StringBuffer();
		fileNamePattern.append(fileName).append(REGEX_PATTERN)
				.append(fileExtension);
		
		/* get all the files in destination directory using filename pattern filter */
		File[] files = dir.listFiles(new FileNameFilterImpl(fileNamePattern
				.toString()));
		
		/* get max file index from all the files in destination directory */
		int maxIndex = getMaxFileIndex(files);

			
		/**
		 *  Rename all files starting from max index. For e.g. log.txt will be rename to log.1.txt, log.1.txt will be rename to log.2.txt 
		 */
		while (maxIndex >= 0) {
			
			/* Generate original file path */
			String originalFilePath=generateFilePath(true,destDir,fileName,maxIndex,fileExtension);
						
			File file = new File(originalFilePath);
			if (file.exists()) {
				/* Generate destination file path */
				String destFilePath=generateFilePath(false,destDir,fileName,maxIndex,fileExtension);
				System.out.println("Renaming file --> "
						+ originalFilePath + " to "
						+ destFilePath);
				/* Rename files */
				try {
					Files.move(file.toPath(),
							new File(destFilePath).toPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			maxIndex--;			
		}

		try {
			System.out.println("\nRotation done! Copying original file..... "
					+ src.getAbsolutePath());
			copyFile(src, new File(destDir));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * @param isSource
	 * @param destDirectory
	 * @param name
	 * @param maxIndex
	 * @param extension
	 * @return
	 */
	String generateFilePath(boolean isSource, String destDirectory, String name, int maxIndex, String extension){
		StringBuilder filePath=new  StringBuilder();
		if(isSource){
			if (maxIndex == 0) {
				filePath = filePath.append(destDirectory).append(FRONT_SLASH)
						.append(name).append(FILE_SEPERATOR).append(extension);
			} else {
				filePath = filePath.append(destDirectory).append(FRONT_SLASH)
						.append(name).append(FILE_SEPERATOR)
						.append(maxIndex).append(FILE_SEPERATOR)
						.append(extension);
			}
		}else{
			filePath = filePath.append(destDirectory).append(FRONT_SLASH)
					.append(name).append(FILE_SEPERATOR)
					.append(maxIndex + 1).append(FILE_SEPERATOR)
					.append(extension);
			
		}
		//System.out.println("file path:"+filePath.toString());
		return filePath.toString();
	}

	/**
	 * @param list Of files
	 * @return max file index from all the files.
	 */
	int getMaxFileIndex(File[] files) {
		int max = Integer.MIN_VALUE;

		for (File file : files) {

			int firstIndexOfDot = Integer.valueOf(file.getName().indexOf(
					FILE_SEPERATOR));
			int lastIndexOfDot = Integer.valueOf(file.getName().lastIndexOf(
					FILE_SEPERATOR));

			if (firstIndexOfDot != lastIndexOfDot) {
				int index = Integer.valueOf(
						file.getName().substring(firstIndexOfDot + 1,
								lastIndexOfDot)).intValue();
				if (Integer.valueOf(index).intValue() > max)
					max = Integer.valueOf(index).intValue();
			} else if (files.length == 1) {
				max = 0;
			}

		}
		return max;

	}

	/**
	 * @param srcLocation
	 * @param destLocation
	 * @throws IOException
	 */
	void copyFile(File srcLocation, File destLocation)
			throws IOException {
		InputStream in = new FileInputStream(srcLocation);
		OutputStream out = new FileOutputStream(destLocation + FRONT_SLASH
				+ srcLocation.getName());

		// Copy the bits from input stream to output stream
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}
	
	@Test
	public void rotateCopyTest() {
		//for (int i = 0; i < 10; i++) {
			rotateCopy(new File("C:/Arajit/log.txt"), "c:/temp");
		//}
	}

}
