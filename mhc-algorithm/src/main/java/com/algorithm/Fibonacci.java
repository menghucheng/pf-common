/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：12:10 AM 2019/4/2
 */
package com.algorithm;

/**
 *
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：12:10 AM 2019/4/2
 *
 */
public class Fibonacci {


    public static void main(String[] args) {
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
    }


    /**
     * @desc describe:
     *      n >= 3    f(n) = f(n-1) + f(n-2);
     *      n==2 || n==1  f(n) = 1;
     *      n < 1   f(n) = 0
     * @param a
     * @return
     */
    private static int fibonacci(int a){
        if(a == 0){
            return 0;
        }

        if(a==1 || a==2){
            return 1;
        }

        return fibonacci(a-1) + fibonacci(a - 2);

    }
}
