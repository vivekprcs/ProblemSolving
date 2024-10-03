package com.vivek.problemsolving.javacode;

 /*
 Print following patterns
  1:-
                *
              *   *
            *   *   *
          *   *   *   *

  2:-           *
              *   *
            *   *   *
          *   *   *   *
            *   *   *
              *   *
                *
*/
public class Pattern {
    public static void main(String args[]) {
        printPattern1(5);
        printPattern2(5);
    }
     static void printPattern1(int n){
         for(int row =0;row< n; row++){
             int noOfSpaces = n-row;
             for(int s=0;s<noOfSpaces;s++){
                 System.out.print(" ");
             }
             for(int col =0; col<row; col++){
                 System.out.print("* ");
             }
             System.out.println();
         }
     }
    static void printPattern2(int n){
        for(int row =0;row< n*2; row++){
            int totalColsInRow = row>n? 2*n-row :row;
            int noOfSpaces = n-totalColsInRow;
            for(int s=0;s<noOfSpaces;s++){
                System.out.print(" ");
            }
            for(int col =0; col<totalColsInRow; col++){
            System.out.print("* ");
            }
            System.out.println();
        }
    }

}
