package com.buenosdev;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Sonar {

    public static void main(String[] args) {
        // System.out.println(addDigits(38));
        var pq1 = new PriorityQueue<Integer>();
        var pq2 = new PriorityQueue<Integer>();

        pq1.add(2);
        pq1 .add(3);

        pq2.add(2);
        pq2.add(3);

        System.out.println(pq2.equals(pq1));

        var map = new HashSet<List<Integer>>();
        List<Integer> list1 = new ArrayList<>(pq1);
        List<Integer> list2 = new ArrayList<>(pq2);

        list1.add(1);
        list2.add(1);

        map.add(list1);
        System.out.println(map.contains(list2));
        System.out.println(map.contains(list1));

        var set = new TreeSet<Integer>();

        set.add(3);
        set.add(1);
        set.add(4);
        set.last();
        set.remove(4);
        set.add(4);

    }

    public static int addDigits(int num) {

        var charAr = new LinkedList<Character>();

        for(char c : String.valueOf(num).toCharArray()){
            charAr.add(c);
        }

        while(charAr.size() > 1){
            var size =  charAr.size();
            var accumulator = 0;
            for(int i = 0; i < size; i++){
                accumulator += charAr.poll() - '0';
            }
            for(char c : String.valueOf(accumulator).toCharArray()){
                charAr.add(c);
            }
        }

        return charAr.poll();
    }
}
