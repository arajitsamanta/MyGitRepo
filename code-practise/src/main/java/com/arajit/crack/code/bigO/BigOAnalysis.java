/**
 * 
 */
package com.arajit.crack.code.bigO;

/**
 * @author as47775
 *
 */
public class BigOAnalysis {
    
    
       
    /**
     * @param array
     * 
     * This will take O(N) time. The fact that we iterate through the array twice doesn't matter.
     */
    void foo(int[] array) {
        int sum = 0;
        int product = 1;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        for (int i = 0; i < array.length; i++) {
            product *= array[i];
        }
        System.out.println(sum + ", " + product);
    }
    
    /**
     * @param array
     * 
     * The inner for loop has O ( N) iterations and it is called N times. Therefore, the runtime is O ( N2 ).
     * Another way we can see this is by inspecting what the "meaning" of the code is. It is printing all pairs (two element sequences). 
     * There are O(N2) pairs; therefore, the runtime is O(N2).
     */
    void printPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[i] + "," + array[j]);
            }
        }
    }
    
    /**
     * @param array
     * 
     * We can derive the runtime several ways.
     * Counting the Iterations
     *   The first time through j runs for N-1 steps. The second time, it's N-2 steps. Then N-3 steps. And so on.
     *   Therefore, the number of steps total is:
     *   (N-1) + (N-2) + (N-3) + ... + 2 + 1
     *   
     *   = 1 + 2 + 3 + ... + N-1
     *   = sum of 1 through N-1  
     *
     *  The sum of 1 through N-1 is N(N-1)/2, So the runtime will be O(N2).
     *  
     *  What It Means --> 
     *  
     *  Alternatively, we can figure out the runtime by thinking about what the code "means:' It iterates through each pair of values for ( i, j) where j is bigger than i.
     *
     *  There are N2 total pairs. Roughly half of those will have i < j and the remaining half will have i > j. This code goes through roughly Nx pairs so it does O(N2) work.
     *  
     *  Visualizing What It Does
     *  The code iterates through the following ( i, j) pairs when N = 8:
     *    (0, 1) (0, 2) (0, 3) (0, 4) (0, 5) (0, 6) (0, 7)
     *          (1, 2) (1, 3) (1, 4) (1, 5) (1, 6) (1, '7)
     *                  (2, 3) (2, 4) (2, 5) (2, 6) (2, 7)
     *                         (3, 4) (3, 5) (3, 6) (3, 7)
     *                                (4, 5) (4, 6) (4, 7)
     *                                       (5, 6) (5, 7)
     *                                              (6, 7)
     * This looks like half of an NxN matrix, which has size (roughly) (N sqrt 2)/2. Therefore, it takes O(N2) time.
     * 
     * Average Work ->
     * We know that the outer loop runs N times. How much work does the inner loop do? It varies across iterations, but we can think about the average iteration.
     * 
     * What is the average value of 1, 2, 3, 4, 5, 6, 7, 8, 9, 10? The average value will be in the middle, so it will be roughly 5. (We could give a more precise answer, of course, but we don't need to for bigO.)
     * 
     * What about for 1, 2, 3, ... , N? The average value in this sequence is N/2.
     * 
     * Therefore, since the inner loop does N/2 work on average and it is run N times, the total work is (N sqrt 2)/2 which is O(N2).
     *  
     * ==== Note: This pattern of for loop is very common. It's important that you know the runtime and that you deeply understand it. You can't rely on just memorizing common runtimes. Deep comprehension is important.
     * 
     * 
     */
    void printUnorderedPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                System.out.println(array[i] + "," + array[j]);
            }
        }
    }
    
    
    /**
     * @param arrayA
     * @param arrayB
     */
    void printUnorderedPairs(int[] arrayA, int[] arrayB) {
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayA[i] < arrayB[j]) {
                    System.out.println(arrayA[i] + "," + arrayB[j]);
                }
            }
        }
    }
    
    
}
