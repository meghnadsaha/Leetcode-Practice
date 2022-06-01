package com.interview.random.google;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendarI {


//    List<int[]> calendar;
//
//    public MyCalendarI() {
//        calendar = new ArrayList();
//    }
//
//    public boolean book(int start, int end) {
//        for (int[] arr : calendar) {
//            if (arr[0] < end && start < arr[1])
//                return false;
//        }
//        calendar.add(new int[]{start, end});
//        return true;
//    }

    TreeMap<Integer, Integer> calendar;

    MyCalendarI() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }

//    In Java, a TreeMap is the perfect candidate.
//    TreeMap where the keys are the start of each interval, and the values are the ends of those intervals.



    public static void main(String[] args) {
        MyCalendarI myCalendar = new MyCalendarI();
        boolean param_1 = myCalendar.book(10, 20); // return True
        System.out.println("param_1 :"+param_1);
        boolean param_2 = myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
        System.out.println("param_2 :"+param_2);

        boolean param_3 = myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
        System.out.println("param_3 :"+param_3);

    }




}
