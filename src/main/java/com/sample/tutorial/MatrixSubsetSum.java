package com.sample.tutorial;

/*

You have a website with a very large matrix. 
This matrix has some numbers in each cell. 
Your users will give input coordinates and you have to return the sum of numbers in that premises. 

1. The numbers dont change
2. The matrix is huge.
3. The api calls are also huge in number.

1 6 8 5 9 0
1 3 7 8 8 9 
1 2 6 8 4 6
8 6 4 3 8 5

Sample input - Point(1,2), Point(3, 4)
Sample output - 56

Point {
    x : int
    y : int
}

function subsetSum(P1, P2, A[][]) {
    for (i=P1.x; i <= P2.x; i++ ) { // P1.x=1, P2.x=3
        for (j=P1.y; j <= P2.y; j++) { // P2.y=2, P2.y=4
            sum += A[i][j]
        }
    }
}


1 7 15 20 29 29
1 4 11 19 27 38

P(0,1), P(1,1) - 9 - (7+4) - (1+1) - 9  
P(0, 1), P(1, 2)  - ((15+11)-(1+1)) = 24 




1 6 8 5 9 0
1 3 7 8 8 9 
1 2 6 8 4 6
8 6 4 3 8 5


1 7 15 20 29 29 
2 11 26 19 

P(0,1), P(1,1) - 9 - (11 - 2) = 9  
P(0, 1), P(1, 2)  - (26 - 2) = 24
P(1, 1), P (2, 3) - 

function subsetSum(P1, P2, S[][]) {

    S[P2.x][P1.y] = 26 // P2.x=1, P1.y=1
    S[P2.x][P1.x] = 2 // P2.x=1, P1.x = 0 
}

 */

public class MatrixSubsetSum {

	public static int getSubsetSum(Point P1, Point P2, int A[][]) {
		int sum = 0;
		for (int i = P1.x; i <= P2.x; i++) { // P1.x=1, P2.x=3
			for (int j = P1.y; j <= P2.y; j++) { // P2.y=2, P2.y=4
				sum += A[i][j];
			}
		}
		return sum;
	}

	public static void printMatrix(int A[][], String name) {
		System.out.println();
		System.out.println("Printing Matrix - " + name);
		for (int i = 0; i < A.length; i++) {
			System.out.print("{ ");
			for (int j = 0; j < A[i].length; j++) {
				System.out.print(A[i][j]);
				if (j != A[i].length - 1) {
					System.out.print(", ");
				}
			}
			System.out.print(" }");
			System.out.println();
		}
	}

	public static int[][] getRowSumMatrix(int A[][]) {
		int[][] myInt = getSimiliarSizeMatrix(A);
		for (int i = 0; i < A.length; i++) {
			int sum = 0;
			for (int j = 0; j < A[i].length; j++) {
				sum += A[i][j];
				myInt[i][j] = sum;
			}
		}
		return myInt;
	}

	public static int[][] getSumMatrix(int A[][]) {
		int[][] myInt = getSimiliarSizeMatrix(A);
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				myInt[i][j] = getSubsetSum(new Point(0, 0), new Point(i, j), A);
			}
		}
		return myInt;
	}

	public static int[][] getSimiliarSizeMatrix(int A[][]) {
		int[][] myInt = new int[A.length][];
		for (int i = 0; i < A.length; i++) {
			myInt[i] = new int[A[i].length];
		}
		return myInt;
	}

	public static int getSubsetSumOptimized(Point P1, Point P2, int S[][]) {
		int sum = S[P2.x][P2.y];
		//System.out.println(S[P2.x][P2.y]);
		//System.out.println(S[P1.x][P1.y]);
		System.out.println("P1.x - " +P1.x + " , P1.y - " + P1.y);
		System.out.println("P2.x - " +P2.x + " , P2.y - " + P2.y);
		for (int i = P1.x, j = P1.y; (i >0) || (j > 0); i--, j--) {
			System.out.println(i +" , " + j);
			if (i - 1 >= 0 || j -1 >=0) {
				sum -= S[P2.x][P1.x];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int A[][] = { { 1, 6, 8, 5, 9, 0 }, { 1, 3, 7, 8, 8, 9 }, { 1, 2, 6, 8, 4, 6 }, { 8, 6, 4, 3, 8, 5 } };

		printMatrix(A, "Original Matrix");

		int rowSumA[][] = getRowSumMatrix(A);

		//printMatrix(rowSumA, "RowSum Matrix");

		int SumA[][] = getSumMatrix(A);

		printMatrix(SumA, "Sum Matrix");

		
		Point a1 = new Point(0, 0);
		Point a2 = new Point(2, 2);
		
		System.out.println("Subset Sum - " + getSubsetSum(a1, a2, A));
		System.out.println("Subset Sum Optimized - " + getSubsetSumOptimized(a1, a2, SumA));
		
		a1 = new Point(0, 1);
		a2 = new Point(2, 2);

		System.out.println("Subset Sum - " + getSubsetSum(a1, a2, A));
		System.out.println("Subset Sum Optimized - " + getSubsetSumOptimized(a1, a2, SumA));
		
		a1 = new Point(1, 1);
		a2 = new Point(2, 2);

		
		System.out.println("Subset Sum - " + getSubsetSum(a1, a2, A));
		System.out.println("Subset Sum Optimized - " + getSubsetSumOptimized(a1, a2, SumA));
		
		/*
		a1 = new Point(1, 0);
		a2 = new Point(2, 2);

		System.out.println("Subset Sum - " + getSubsetSum(a1, a2, A));
		System.out.println("Subset Sum Optimized - " + getSubsetSumOptimized(a1, a2, SumA));
		*/
		
		
		

	}
}
