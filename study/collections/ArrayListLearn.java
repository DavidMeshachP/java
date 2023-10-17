package study.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListLearn {

    public static void main(String args[] ) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println(arrayList.size());
        arrayList.add(1);
        arrayList.remove(0);
        System.out.println(arrayList);
        // arrayList.add(5,10);  //exception indexoutofbound
        arrayList.add(10);
        System.out.println(arrayList);

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        arrayList2.add(5);
        arrayList.addAll(arrayList2);
        System.out.println(arrayList);

        System.out.println(arrayList.contains(arrayList2));

        System.out.println(arrayList.get(2));

        System.out.println(arrayList.equals(arrayList2));

        System.out.println(arrayList.hashCode());

        System.out.println(arrayList.isEmpty());

        // arrayList.removeAll(arrayList2);

        System.out.println(arrayList);

        // arrayList.retainAll(arrayList2);
        System.out.println(arrayList);

        Iterator<Integer> a = arrayList.iterator();
        while (a.hasNext()) {
            System.out.print(a.next() + " ");
        }
        System.out.println();

        System.out.println(arrayList.indexOf(5));

        arrayList.add(5);
        System.out.println(arrayList.lastIndexOf(5));

        Iterator<Integer> b = arrayList.listIterator(2);
        while ( b.hasNext() ) {
            System.out.print(b.next() + " ");
        }
        System.out.println();

    }

}
