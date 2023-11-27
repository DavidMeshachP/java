package sorting;

import java.util.Scanner;

public class ZeroOneTwoSort {
	public static void main(String[] args) {
	    
		Scanner sc = new Scanner(System.in);
	    
		System.out.println("Enter the size of the array: ");
	    int length = sc.nextInt();
	    
	    int[] countArray = new int[3];
	    
	    System.out.println( " Enter the elements of the array ( 0, 1, 2 ): ");
	    for( int i = 0; i < length; i++ ) {
			int val = sc.nextInt();
	        if( val == 0 ) {
	            countArray[0]++;
	        }
	        else if( val == 1 ) {
	            countArray[1]++;
	        }
	        else if( val == 2 ) {
	            countArray[2]++;
	        }
	        else {
	            System.out.println( " YOU HAVE ENTERED A NUMBER OTHER THAN 0 OR 1 OR 2 !!!!!! \n PLEASE CHECK YOUR INPUT !!!!!!! " );
				sc.close();
	            return;
	        }
	    }
		
	    System.out.println( "The Sorted Elements are......... " );
	    for( int i = 0; i < countArray.length; i++) {
			for( int j = 0; j < countArray[i]; j++) {
				System.out.print(i + " ");
			}
		}
		
		sc.close();
		
	}
}
