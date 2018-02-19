package com.arajit.code.practise.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Message {
  String msg;

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}


class Response {
  Message msg;

  public Message getMsg() {
    return msg;
  }

  public void setMsg(Message msg) {
    this.msg = msg;
  }

}


class ServiceResponse extends Response {

  String code;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

}


class ServiceResponse2 extends Response {

  String code;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

}


public class AmazonSDE {


  public static void main(String[] args) {
    long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
    System.out.println("beforeUsedMem:"+beforeUsedMem);
   /* Message msg = new Message();
    msg.setMsg("i am a msg");

    Response response1 = new ServiceResponse();
    response1.setMsg(msg);

    if (response1 instanceof ServiceResponse)
      System.out.println("I am service response, " + response1.getMsg().getMsg());

    if (response1 instanceof ServiceResponse2)
      System.out.println("I am service response2, " + response1.getMsg().getMsg());*/

   
      //String braces = "{h[e{lo}!]}~()()()("; 
      String braces1 = "[()]{}{[()()()}";
      
      System.out.println(isBalanced(braces1));
     

    /*
     * if(isBalanced(braces)){ System.out.println("YES"); }else{
     * //System.out.print(isBalanced(braces1));
     * 
     * int[][] maze1={{0,0,0,0},{1,0,1,0},{1,0,0,0}}; findMinNumSteps(maze1,3,4,2,3);
     * 
     * int[][] maze2={{0,0,0},{0,1,0},{0,0,0}}; findMinNumSteps(maze2,3,3,2,1);
     */
    //System.out.println("EOL"+System.lineSeparator());
    //System.out.println("EOL"+System.lineSeparator());
      long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
      System.out.println("afterUsedMem:"+afterUsedMem);
      long actualMemUsedInMB=(afterUsedMem-beforeUsedMem);
      System.out.println("Memory(B): "+actualMemUsedInMB);
  }

  private static boolean isBalanced(String str) {
    Map<Character, Character> bracketPairs = new HashMap<Character, Character>() {
      {
        put('(', ')');
        put('[', ']');
        put('{', '}');
        put('<', '>');
      }
    };

    if (str.length() % 2 != 0) {
      return false;
    }

    Stack<Character> halfBraces = new Stack<Character>();

    for (int i = 0; i < str.length(); i++) {
      if (bracketPairs.containsKey(str.charAt(i))) {
        halfBraces.push(str.charAt(i));
      } else if (halfBraces.isEmpty() || bracketPairs.get(halfBraces.pop()) != str.charAt(i)) {
        return true;
      }
    }
    return halfBraces.isEmpty() ? true : false;
  }

  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public static int findMinNumSteps(int[][] maze, int rows, int columns, int exitRow, int exitCol) {
    // WRITE YOUR CODE HERE
    int countRow = 0;
    int countStep = -1;
    for (int rowIdx = 0; rowIdx < rows; rowIdx++) {

      for (int colIdx = 0; colIdx < columns; colIdx++) {
        if (rowIdx == exitRow && colIdx == exitCol) {
          System.out.println(countRow);
          System.out.println("found" + (countRow + colIdx));
          countStep = countRow + colIdx;
          break;
        }
      }

      countRow = rowIdx + 1;
    }

    System.out.println("count::" + countStep);
    return countStep;
  }
  // METHOD SIGNATURE ENDS

}
