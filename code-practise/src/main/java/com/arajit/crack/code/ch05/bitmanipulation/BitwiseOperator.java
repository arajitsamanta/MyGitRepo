/**
 * 
 */
package com.arajit.crack.code.ch05.bitmanipulation;

/**
 * @author as47775
 *
 */
public class BitwiseOperator {
    
    public int add(int a,int b){
        /*
         * a=0010
         * b=0111
         * Sum=
         */
        
        while(b!=0){
            int carry=a&b;
            a=a^b;
            b=carry<<1;        
        }
        return a;
    }
    
    public static void main(String[] args){
        
        BitwiseOperator oprtns=new BitwiseOperator();
        
        System.out.println("Addition without using arithmatic operator"+oprtns.add(2,3));
    }
}
