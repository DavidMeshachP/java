package sorting;

import java.util.Scanner;

public class MergeSort {
    
    public static void main(String args[] ) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the array size...");
        int length = sc.nextInt();
        
        int[] array = new int[length];
        System.out.println("Enter the unsorted elements: ");
        for( int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }
        
        mergeSort(array);
        
        print(array);

        sc.close();
    }
    
    public static void mergeSort(int[] array) {
        int length = array.length;
        
        if(array.length < 2 ) 
            return;
        
        int mid = length / 2;
        int leftHalf[] = new int[mid];
        int rightHalf[] = new int[length - mid];
        
        for ( int i = 0; i < mid; i++ ) {
            leftHalf[i] = array[i];
        }
        
        for ( int i = mid; i < length; i++ ) {
            rightHalf[i - mid] = array[i];
        }
        
        mergeSort(leftHalf);
        mergeSort(rightHalf);
        
        merge(array, leftHalf, rightHalf);
    }
    
    public static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        
        int i = 0, j = 0, k = 0;
        
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                array[k] = leftHalf[i];
                i++;
            }
            else {
                array[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        
        while ( i < leftSize ) {
            array[k] = leftHalf[i];
            i++;
            k++;
        }
        
        while ( j < rightSize ) {
            array[k] = rightHalf[j];
            j++;
            k++;
        }
        
    }
    
    public static void print(int[] array) {
        System.out.println(" The sorted array is ....");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " " );
        }
    }
}
