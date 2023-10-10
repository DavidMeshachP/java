import java.util.Scanner;

public class ZeroOneTwoSort {
	public static void main(String[] args) {
	    
		Scanner sc = new Scanner(System.in);
	    
		System.out.println("Enter the size of the array: ");
	    int length = sc.nextInt();
	    
	    int[] array = new int[length];
	    
	    int zeroCount = 0;
	    int oneCount = 0;
	    int twoCount = 0;
	    
	    System.out.println( " Enter the elements of the array ( 0, 1, 2 ): ");
	    for( int i = 0; i < length; i++ ) {
	        array[i] = sc.nextInt();
	        if( array[i] == 0 ) {
	            zeroCount++;
	        }
	        else if( array[i] == 1 ) {
	            oneCount++;
	        }
	        else if( array[i] == 2 ) {
	            twoCount++;
	        }
	        else {
	            System.out.println( " YOU HAVE ENTERED A NUMBER OTHER THAN 0 OR 1 OR 2 !!!!!! \n PLEASE CHECK YOUR INPUT !!!!!!! " );
				sc.close();
	            return;
	        }
	    }
		
	    System.out.println( "The Sorted Elements are......... " );
	    for( int i = 0; i < zeroCount; i++) {
			System.out.print("0 ");
	    }
	    for( int i = 0; i < oneCount; i++ ) {
			System.out.print("1 ");
	    }
	    for( int i = 0; i < twoCount; i++ ) {
			System.out.print("2 ");
	    }
		
		sc.close();
		
	}
}
