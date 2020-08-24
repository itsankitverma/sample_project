package com.examples;

/**
 * Created by IntelliJ IDEA.
 * User: arturog
 * Date: 24-04-2006
 * Time: 04:07:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class UtilTest {

    public static void main(String arg[]){

        /*
          double testArray[] = {10.5,-10.5,Math.PI,0};

           for(int i=0;i<testArray.length;i++){
               System.out.println("Abs Argument " + i + " = " + testArray[i] + "=> " + Math.abs(testArray[i]));
               System.out.println("Ceil Argument " + i + " = " + testArray[i] + "=> " + Math.ceil(testArray[i]));
               System.out.println("Floor Argument " + i + " = " + testArray[i] + "=> " + Math.floor(testArray[i]));
           }
        */
        /*
           double randomNumber;

           for(int i=0;i<20;i++){
               randomNumber=Math.random() * 100;
               System.out.println("randomNumber :" + randomNumber);

               System.out.println("randomNumber Rounded :" + Math.round(randomNumber));
           }
         */

        printAll(arg);

    }

    public static void printAll(String[] args){

        System.out.print("hh");
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
            //Thread.currentThread().sleep(1000);
        }
    }
}
