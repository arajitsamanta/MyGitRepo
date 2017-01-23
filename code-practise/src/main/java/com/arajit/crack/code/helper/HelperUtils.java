/**
 * 
 */
package com.arajit.crack.code.helper;

import java.util.Map;
import java.util.Map.Entry;

import com.arajit.crack.code.linkedlist.Node;

/**
 * @author as47775
 * @param <T>
 *
 */
public class HelperUtils {
	
	private static final HelperUtils _instance=new HelperUtils();
	
	private HelperUtils(){}
	
	public static HelperUtils getInstance(){
		if(null==_instance)
			return new HelperUtils();
		else
			return _instance;
		
	}
	
	public void displayCharArray(char[] charArr){
		System.out.println();
		for(int idx=0;idx<charArr.length;idx++){
			System.out.print(charArr[idx]);
		}
		
	}
	
	public void displayIntArray(int[] intArr){
		System.out.println();
		for(int idx=0;idx<intArr.length;idx++){
			System.out.print(intArr[idx]);
		}
		
	}
	
	public <V, T> void displayMap(Map<T, V> mapObj) {
		System.out.println();
		for (Entry<T, V> entry : mapObj.entrySet()) {
			String key = entry.getKey().toString();
			V value = entry.getValue();
			System.out.println("key, " + key + " value " + value);
		}

	}
	
	public void printSquareMatrix(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/*public <T> void display(Node<T> head){
		//Node<T> n=this;
		while(head.next!=null){
			System.out.print(head.data+"->");		
			head = head.next;
		}
	}*/
}
