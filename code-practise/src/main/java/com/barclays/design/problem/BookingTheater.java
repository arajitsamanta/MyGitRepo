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
import java.util.Map;
import java.util.Scanner;

public class BookingTheater {

  private static Scanner scanner = new Scanner(System.in);

  private int rowCount;

  int[][] theaterArr;
  
  private Map<String,Integer> bookingReqMap=new HashMap<String,Integer>();
  

  BookingTheater(int rowCount) {
    this.rowCount = rowCount;
    this.theaterArr = new int[rowCount][];
  }

  public void startBooking() {
    System.out.println( "Enter each row(press 'q' to quit): " );
    readTheaterLayout();
  }

  void readTheaterLayout() {
    int idx=0;
    while (scanner.hasNextLine()) {
      String theaterRow = scanner.nextLine();
      if ("q".equals(theaterRow)) {
        //System.out.println("Theater Layout reading done, Exiting !");
        break;
      }else {
        
        if(idx==rowCount)
          throw new IllegalStateException("No-of rows can't be greater than entered row count " + rowCount);
        
        int[] tempRows = Arrays.stream(theaterRow.split(" ")).mapToInt(Integer::parseInt).toArray();
        theaterArr[idx]=tempRows;
        idx++;
      }
    }
  
    //printArr();
    System.out.println( "Enter booking row(press 'q' to quit): " );
    readBookingRequest();
    scanner.close();
    
    System.out.println("ma value"+bookingReqMap.get("Davis"));
  }
  
  private void readBookingRequest(){
    while (scanner.hasNextLine()) {
      String bookingRow = scanner.nextLine();
      Object[] temp=bookingRow.split(" ");
      bookingReqMap.put((String) temp[0], Integer.valueOf((String) temp[1]));
    }
  }
  
  void printArr(){
    for(int rows=0;rows<rowCount;rows++) {
      for(int cols=0;cols<theaterArr[rows].length;cols++) {
        System.out.print(theaterArr[rows][cols]+" ");
      }
      System.out.println();
    }
  }

}
