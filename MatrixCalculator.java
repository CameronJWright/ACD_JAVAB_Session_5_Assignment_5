package Session6;

import java.util.Scanner;

public class MatrixCalculator {

	public static void main(String[] args) {
		int rows, cols, n, flag = 0;
		int[][] mat1, mat2;
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the Matrix creation engine!");
		System.out.println("Enter the 1st Matrix row amount.");
		rows = scan.nextInt();
		System.out.println("Enter the 1st Matrix column amount.");
		cols = scan.nextInt();
		mat1 = new int[rows][cols];
		System.out.println("Enter the values for each row descending");
		for (int row = 0; row < mat1.length; ++row) {
			for (int col = 0; col < mat1[row].length; ++col)
				mat1[row][col] = scan.nextInt();
		}
		System.out.println("Enter the 2nd Matrix row amount.");
		rows = scan.nextInt();
		System.out.println("Enter the 1nd Matrix column amount.");
		cols = scan.nextInt();
		mat2 = new int[rows][cols];
		System.out.println("Enter the values for each row descending");
		for (int row = 0; row < mat2.length; ++row) {
			for (int col = 0; col < mat2[row].length; ++col)
				mat2[row][col] = scan.nextInt();
		}

		do {
			System.out.println();
			System.out.println("What will you do?");
			System.out.println("1. Add");
			System.out.println("2. Subtract");
			System.out.println("3. Multiply");
			System.out.println("4. Transpose");
			System.out.println("5. Print");
			n = scan.nextInt();
			switch (n) {
			case 1:
				System.out.println("Which matrix will be first?");
				System.out.println("1. Matrix 1");
				System.out.println("2. Matrix 2");
				n = scan.nextInt();
				switch (n) {
				case 1:
					addMatrix(mat1, mat2);
					break;
				case 2:
					addMatrix(mat2, mat1);
					break;
				default:
					System.out.println("Please enter 1 or 2");
					break;
				}
				break;
			case 2:
				System.out.println("Which matrix will be first?");
				System.out.println("1. Matrix 1");
				System.out.println("2. Matrix 2");
				n = scan.nextInt();
				switch (n) {
				case 1:
					subMatrix(mat1, mat2);
					break;
				case 2:
					subMatrix(mat2, mat1);
					break;
				default:
					System.out.println("Please enter 1 or 2");
					break;
				}
				break;
			case 3:
				System.out.println("Which matrix will be first?");
				System.out.println("1. Matrix 1");
				System.out.println("2. Matrix 2");
				n = scan.nextInt();
				switch (n) {
				case 1:
					multiplyMatrix(mat1, mat2);
					break;
				case 2:
					multiplyMatrix(mat2, mat1);
					break;
				default:
					System.out.println("Please enter 1 or 2");
					break;
				}
				break;
			case 4:
				System.out.println("Which matrix will be transposed?");
				System.out.println("1. Matrix 1");
				System.out.println("2. Matrix 2");
				n = scan.nextInt();
				switch (n) {
				case 1:
					transposeMatrix(mat1);
					break;
				case 2:
					transposeMatrix(mat2);
					break;
				default:
					System.out.println("Please enter 1 or 2");
					break;
				}
				break;
			case 5:
				System.out.println("Which matrix will be printed?");
				System.out.println("1. Matrix 1");
				System.out.println("2. Matrix 2");
				n = scan.nextInt();
				switch (n) {
				case 1:
					printMatrix(mat1);
					break;
				case 2:
					printMatrix(mat2);
					break;
				default:
					System.out.println("Please enter 1 or 2");
					break;
				}
				break;

			default:
				System.out.println("Please enter 1, 2, 3, 4, or 5");
			}
		} while (flag == 0);
		
		scan.close();

	}

	static void addMatrix(int[][] mat1, int[][] mat2) {
		int[][] add = new int[mat1.length][mat1[0].length];
		if (mat2.length == mat1.length && mat2[0].length == mat1[0].length) {
			for (int row = 0; row < mat1.length; ++row) {
				for (int col = 0; col < mat1[0].length; ++col) {
					add[row][col] = mat1[row][col] + mat2[row][col];
				}
			}
		} else
			System.out.println("Matrix are not the same dimensions! Cannot add.");

		printMatrix(add);
	}

	static void subMatrix(int[][] mat1, int[][] mat2) {
		int[][] sub = new int[mat1.length][mat1[0].length];
		if (mat2.length == mat1.length && mat2[0].length == mat1[0].length) {
			for (int row = 0; row < mat1.length; ++row) {
				for (int col = 0; col < mat1[0].length; ++col) {
					sub[row][col] = mat1[row][col] - mat2[row][col];
				}
			}
		} else
			System.out.println("Matrix are not the same dimensions! Cannot subtract.");

		printMatrix(sub);
	}

	static void printMatrix(int[][] mat1) {
		for (int row = 0; row < mat1.length; ++row) {
			System.out.println();
			for (int col = 0; col < mat1[row].length; ++col)
				System.out.print(mat1[row][col] + " ");
		}
		System.out.println();
	}

	static void multiplyMatrix(int[][] mat1, int[][] mat2) {
		int[][] mul = new int[mat1.length][mat2[0].length];
		int temp = 0;

		if (mat1[0].length == mat2.length) {
			for (int row = 0; row < mat1.length; ++row) {
				for (int col = 0; col < mat2[0].length; ++col) {
					for (int inner = 0; inner < mat2.length; inner++) {
						temp = temp + mat1[row][inner] * mat2[inner][col];
					}
					mul[row][col] = temp;
					temp = 0;
				}
			}
		} else
			System.out.println(
					"Matrix 1's column dimensions are not the same as matrix 2's row dimensions! Cannot multiply.");
		printMatrix(mul);
	}

	static void transposeMatrix(int[][] mat1) {
		int[][] tran = new int[mat1[0].length][mat1.length];
		for (int row = 0; row < mat1.length; row++)
			for (int col = 0; col < mat1[0].length; col++) {
				tran[col][row] = mat1[row][col];
			}

		printMatrix(tran);

	}

}
