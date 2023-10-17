package study.collections;

import java.util.LinkedList;
import java.util.Arrays;

public class LinkedListLearn {

    public static void main(String args[] ) {
        LinkedList<Integer> linkedlist = new LinkedList<>();
        System.out.println(linkedlist.size());

        linkedlist.add(5);
        linkedlist.add(10);
        linkedlist.add(50);
        linkedlist.add(0,55);
        System.out.println(linkedlist);

        linkedlist.addFirst(0);
        System.out.println(linkedlist);

        linkedlist.addLast(0);
        System.out.println(linkedlist);

        // linkedlist.clear();
        // System.out.println(linkedlist);

        System.out.println(linkedlist.element());

        // linkedlist.
        int[] arr = {1,2,3};
        int[] arr2 = {1,2,3};
        System.out.println(arr.equals(arr2));
        System.out.println(Arrays.equals(arr,arr2));
        System.out.println(arr.hashCode() + "   --   " + arr2.hashCode());

        int n1 = 2;
        int n2 = 2;
        // System.out.println(n1.equals(n2));

        String[] arr1 = { "a","b"};
        String[] arr3 = { "a","b"};

        System.out.println(arr1.equals(arr3));
        System.out.println(Arrays.equals(arr1,arr3));
        System.out.println(arr1.hashCode() + "   " + arr3.hashCode());
    }
    
}
