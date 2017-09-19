package com.arajit.crack.code.ch01.arraysandstrings;

import org.junit.Test;

import com.arajit.crack.code.helper.HelperUtils;

/**
 *  @author as47775
 *  
 * Problem 1:
 * =========
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 *  
 * Solution:
 * ========
 * How do we perform this four-way edge swap? One option is to copy the top edge to an array, and then move the left to the top, the bottom to the left, and so on. This requires O(N) memory, 
 * which is actually unnecessary.
 *  
 * A better way to do this is to implement the swap index by index. In this case, we do the following:
 * for i = 0 to n
 * temp= top[i];
 * top[i] = left[i]
 * left[i] = bottom[i]
 * bottom[i] = right[i]
 * right[i] = temp
 * 
 * This solution has been implemented in below rotate() method.
 * 
 * Problem 2:
 * =========
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 * 
 * Solution:
 * ========
 * We use two arrays to keep track of all the rows with zeros and all the columns with zeros. We then nullify rows and columns based on the values in these arrays. 
 * 
 * This has been implemented in below setZeros()/setZerosSpcaeEfficient() method.
 */
public class MatrixProblems {

	boolean rotate(int[][] matrix) {
		//System.out.println("matrix::" + matrix.length);
		if (matrix.length == 0 || matrix.length != matrix[0].length)
			return false;

		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;

				int top = matrix[first][i]; // save top

				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right

				matrix[i][last] = top; // right<- saved top
			}
		}
		System.out.println("\n90 degree rotated matrix");
		HelperUtils.getInstance().printSquareMatrix(matrix);
		return true;
	}
	
	//@Test
	public void rotateMatrixTest(){
		int[][] originalMatrix={ {1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		System.out.println("Original matrix");
		HelperUtils.getInstance().printSquareMatrix(originalMatrix);
		System.out.println(rotate(originalMatrix));
	}
	
	void setZeros(int[][] matrix){
		boolean[] rows=new boolean[matrix.length];
		boolean[]  cols=new boolean[matrix[0].length];
		
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]==0){
					rows[i]=true;
					cols[j]=true;
				}
			}
		}
		
		for(int i=0;i<rows.length;i++)
			if(rows[i])	nullifyRows(matrix,i);
		
		for(int i=0;i<cols.length;i++)
			if(cols[i])	nullifyCols(matrix,i);
		
		HelperUtils.getInstance().printSquareMatrix(matrix);
	}
	
	
	/**
	 * @param matrix
	 */
	void setZerosSpcaeEfficient(int[][] matrix) {
		boolean rowHasZero = false;
		boolean colHasZero = false;

		// Check if first row has a zero
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}

		// Check if first column has a zero
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}

		// Check for zeros in the rest of the array
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}

			// Nullify rows based on values in first column
			for (i = 1; i < matrix.length; i++) {
				if (matrix[i][0] == 0) {
					nullifyRows(matrix, i);
				}
			}

			// Nullify columns based on values in first row
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[0][j] == 0) {
					nullifyCols(matrix, j);
				}
			}

			// Nullify first row
			if (rowHasZero) {
				nullifyRows(matrix, 0);
			}
			// Nullify first column
			if (colHasZero) {
				nullifyCols(matrix, 0);
			}

		}
	}

	
	void nullifyRows(int[][] matrix,int row){
		for(int j=0;j<matrix[0].length;j++){
			matrix[row][j]=0;
		}
	}
	
	void nullifyCols(int[][] matrix,int col){
		for(int j=0;j<matrix.length;j++){
			matrix[j][col]=0;
		}
	}
	
	@Test
	public void setZerosTest(){
		int[][] originalMatrix={ {1,2,3,4}, {4,5,6,7}, {8,0,10,11}, {12,13,14,0}};
		System.out.println(originalMatrix.length);
		System.out.println(originalMatrix[0].length);
		System.out.println("Original matrix");
		HelperUtils.getInstance().printSquareMatrix(originalMatrix);
		setZeros(originalMatrix);
	}
}
