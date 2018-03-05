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

import java.util.Scanner;

public class TheaterMain {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
   
    System.out.println( "Enter no of rows for the theater: " );
    Scanner scanner = new Scanner( System.in );
    int rows=scanner.nextInt();
    //scanner.close();
    BookingTheater bt=new BookingTheater(rows);
    bt.startBooking();
  }

}
