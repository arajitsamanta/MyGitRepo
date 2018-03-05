/*
 * FOR INTERNAL USE ONLY. NOT A CONTRIBUTION.
 *
 * This software source code contains valuable, confidential, trade secret information owned by
 * Enterprise Rent-A-Car Company and is protected by copyright laws and international copyright
 * treaties, as well as other intellectual property laws and treaties.
 *
 * ACCESS TO AND USE OF THIS SOURCE CODE IS RESTRICTED TO AUTHORIZED PERSONS WHO HAVE ENTERED INTO
 * CONFIDENTIALITY AGREEMENTS WITH ENTERPRISE RENT-A-CAR COMPANY.
 *
 * This source code may not be licensed, disclosed or used except as authorized in writing by a duly
 * authorized officer of Enterprise Rent-A-Car Company.
 *
 */
package com.barclays.design.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class PlaneReservation {
  
  int columnSize=10;
  
  int[][] seats=new int[50][columnSize];
  
  int defaultNoOfAvlSeatsEachRow=3;
  
  public int solution(int n, String s) {
    List<String> reservedList=null;
    Map<Integer,Boolean> indexMap=null;
    
    if(s.length()>0) {
      reservedList = Arrays.asList(s.split(Pattern.compile(" ").toString()));
      indexMap=convertReservedListToArrIndexesMap(reservedList);
    }
    int finalAvailablelSeats=0;
    if(null!= indexMap && !indexMap.isEmpty()) {
      for(int i=0;i<n;i++) {
        for(int j=1;j<=3;j++) {
          int sectionSize=(j==2)? 4 : 3;
          if(findIfAvailableInThisSection(i,getStartIndex(j),sectionSize,indexMap)) {
            finalAvailablelSeats++;
          }
        }
      }
    }else {
      finalAvailablelSeats=n*defaultNoOfAvlSeatsEachRow;
    }
    return finalAvailablelSeats;
  }
  
  int getStartIndex(int val) {
    int index=0;
    switch(val) {
      case 1:
        index=0;
        break;
      case 2:
        index=3;
        break;
      case 3:
        index=7;
        break;
       default:
         throw new IllegalArgumentException("Invalid switch value!!");
    }
    return index;
  }  
  boolean findIfAvailableInThisSection(int rowNo,int startIndex, int sectionSize,Map<Integer,Boolean> arrIndexMap) {
    boolean found=true;
    for(int idx=startIndex;idx<(startIndex+sectionSize);idx++) {
      String currIdx=rowNo+""+idx;
      if(arrIndexMap.containsKey(Integer.valueOf(currIdx))) {
        found=false;
        break;
      }
    }
    return found;
  }
  
  Map<Integer,Boolean> convertReservedListToArrIndexesMap(List<String> reservedList) {
    if(!reservedList.isEmpty()) {
      Map<Integer,Boolean> indexMap=new HashMap<>(reservedList.size());
      reservedList.forEach(str -> {
        int row=Integer.valueOf(str.substring(0, 1))-1;
        int col=str.charAt(1)-'A';
        String index=row+""+col;
        indexMap.put(Integer.valueOf(index), true);
      });
     return indexMap;
    }
    return null;
  }
  
  public static void main(String[] args) {
    PlaneReservation planeReservation=new PlaneReservation();
    System.out.println("Total available seats(Test Case 1)="+planeReservation.solution(1, ""));
    System.out.println("Total available seats(Test Case 2)="+planeReservation.solution(2, "1A 2F 1C"));
    System.out.println("Total available seats(Test Case 3)="+planeReservation.solution(10, "1A 2F 1C 9K 5B"));
  }

}
