package com.vivek.problemsolving.javacode;

import java.util.Arrays;

public class Program {

    /*
     Given an array of meeting time intervals consisting of start and end times
     [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

     Input: [[1, 18],[18, 23],[15, 24],[4,15],[2,11],[5,13]]
     Output: 4

     Input: [[0, 30],[5, 10],[15, 20]]
     Output: 2

     Input: [[7,10],[2,4]]
     Output: 1

    */

    public static int getMinRooms(int [][] meetingTimings) {
        // Write your code here
        int noOfMeetings = meetingTimings.length;
        int[]start= new int[noOfMeetings];
        int[] end = new int[noOfMeetings];
        for (int i =0;i<noOfMeetings;i++){
         start[i] = meetingTimings[i][0];
         end[i] = meetingTimings[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int i = 1, j = 0, curr = 1;
        int noOfRooms = 1;

        while (i < start.length && j < end.length){
            if (start[i] < end[j])
            {
                curr++;
                i++;
            }
            else
            {
                curr--;
                j++;
            }
            noOfRooms = Integer.max(noOfRooms, curr);
        }
        return noOfRooms;
    }


    public static void main(String args[])
    {
        //Test cases
        int[][] intervals1 = { { 1, 18 }, { 18, 23 }, { 15, 24 }, {4, 15}, {2, 11}, {5, 13} };
        System.out.println("min rooms required for meetings "+getMinRooms(intervals1));
        int[][] intervals2 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println("min rooms required for meetings "+getMinRooms(intervals2));
        int[][] intervals3 = { { 7, 10 }, { 2, 4 } };
        System.out.println("min rooms required for meetings "+getMinRooms(intervals3));

}

    public static int minMeetingRooms(int[][] intervals) {
        int n = 1000010;
        int[] delta = new int[n];
        for (int[] e : intervals) {
            ++delta[e[0]];
            --delta[e[1]];
        }
        int res = delta[0];
        for (int i = 1; i < n; ++i) {
            delta[i] += delta[i - 1];
            res = Math.max(res, delta[i]);
        }
        return res;
    }

}
