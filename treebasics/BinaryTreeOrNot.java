package treebasics;

import java.util.Scanner;

public class BinaryTreeOrNot {

    public static void main(String args[] ) {

        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the number of pairs: ");
        int pairLength = sc.nextInt();
    
        int[] child = new int[pairLength];
        int[] parent = new int[pairLength];

        for( int i = 0; i < pairLength; i++ ) {
            System.out.println("Enter the pair as child and parent:  ");
            child[i] = sc.nextInt();
            parent[i] = sc.nextInt();
        }

        for( int i = 0; i < pairLength - 1; i++ ) {
            int parentCount = 0;
            for ( int j = i + 1; j < pairLength; j++ ) {
                if( child[i] == child[j]) {
                    System.out.println("It is not a binary tree, since it has two parents.......");
                    sc.close();
                    return;
                }
                if( parent[i] == parent[j] ) {
                    parentCount++;
                    if( parentCount > 1) {
                        System.out.println("It is not a binary tree, since it has more than two childs.........");
                        sc.close();
                        return;
                    }
                }
            }
        }
        System.out.println("It is a binary tree, since it satisfies all the conditions.....");

        sc.close();
    }
    
}
