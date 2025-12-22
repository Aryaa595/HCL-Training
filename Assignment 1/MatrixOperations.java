import java.util.Scanner;

public class MatrixOperations {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---- MATRIX OPERATIONS MENU ----");
            System.out.println("1. Addition of matrices");
            System.out.println("2. Subtraction of matrices");
            System.out.println("3. Multiplication of matrices");
            System.out.println("4. Transpose of a matrix");
            System.out.println("5. Check square matrix");
            System.out.println("6. Check diagonal matrix");
            System.out.println("7. Check identity matrix");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                // 1. ADDITION
                case 1:
                    System.out.print("Enter rows and columns: ");
                    int r = input.nextInt();
                    int c = input.nextInt();

                    int[][] A = new int[r][c];
                    int[][] B = new int[r][c];
                    int[][] sum = new int[r][c];

                    System.out.println("Enter first matrix:");
                    for (int i = 0; i < r; i++)
                        for (int j = 0; j < c; j++)
                            A[i][j] = input.nextInt();

                    System.out.println("Enter second matrix:");
                    for (int i = 0; i < r; i++)
                        for (int j = 0; j < c; j++)
                            B[i][j] = input.nextInt();

                    for (int i = 0; i < r; i++)
                        for (int j = 0; j < c; j++)
                            sum[i][j] = A[i][j] + B[i][j];

                    System.out.println("Addition Result:");
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++)
                            System.out.print(sum[i][j] + " ");
                        System.out.println();
                    }
                    break;

                // 2. SUBTRACTION
                case 2:
                    System.out.print("Enter rows and columns: ");
                    r = input.nextInt();
                    c = input.nextInt();

                    A = new int[r][c];
                    B = new int[r][c];

                    System.out.println("Enter first matrix:");
                    for (int i = 0; i < r; i++)
                        for (int j = 0; j < c; j++)
                            A[i][j] = input.nextInt();

                    System.out.println("Enter second matrix:");
                    for (int i = 0; i < r; i++)
                        for (int j = 0; j < c; j++)
                            B[i][j] = input.nextInt();

                    System.out.println("Subtraction Result:");
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++)
                            System.out.print((A[i][j] - B[i][j]) + " ");
                        System.out.println();
                    }
                    break;

                // 3. MULTIPLICATION
                case 3:
                    System.out.print("Enter rows and columns of first matrix: ");
                    int r1 = input.nextInt();
                    int c1 = input.nextInt();

                    System.out.print("Enter rows and columns of second matrix: ");
                    int r2 = input.nextInt();
                    int c2 = input.nextInt();

                    if (c1 != r2) {
                        System.out.println("Matrix multiplication not possible");
                        break;
                    }

                    int[][] M1 = new int[r1][c1];
                    int[][] M2 = new int[r2][c2];
                    int[][] mul = new int[r1][c2];

                    System.out.println("Enter first matrix:");
                    for (int i = 0; i < r1; i++)
                        for (int j = 0; j < c1; j++)
                            M1[i][j] = input.nextInt();

                    System.out.println("Enter second matrix:");
                    for (int i = 0; i < r2; i++)
                        for (int j = 0; j < c2; j++)
                            M2[i][j] = input.nextInt();

                    for (int i = 0; i < r1; i++) {
                        for (int j = 0; j < c2; j++) {
                            mul[i][j] = 0;
                            for (int k = 0; k < c1; k++) {
                                mul[i][j] += M1[i][k] * M2[k][j];
                            }
                        }
                    }

                    System.out.println("Multiplication Result:");
                    for (int i = 0; i < r1; i++) {
                        for (int j = 0; j < c2; j++)
                            System.out.print(mul[i][j] + " ");
                        System.out.println();
                    }
                    break;

                // 4. TRANSPOSE
                case 4:
                    System.out.print("Enter rows and columns: ");
                    r = input.nextInt();
                    c = input.nextInt();

                    int[][] T = new int[r][c];

                    System.out.println("Enter matrix:");
                    for (int i = 0; i < r; i++)
                        for (int j = 0; j < c; j++)
                            T[i][j] = input.nextInt();

                    System.out.println("Transpose:");
                    for (int j = 0; j < c; j++) {
                        for (int i = 0; i < r; i++)
                            System.out.print(T[i][j] + " ");
                        System.out.println();
                    }
                    break;

                // 5. CHECK SQUARE MATRIX
                case 5:
                    System.out.print("Enter rows and columns: ");
                    r = input.nextInt();
                    c = input.nextInt();

                    if (r == c)
                        System.out.println("It is a Square Matrix");
                    else
                        System.out.println("It is NOT a Square Matrix");
                    break;

                // 6. CHECK DIAGONAL MATRIX
                case 6:
                    System.out.print("Enter size of square matrix: ");
                    int n = input.nextInt();

                    int[][] D = new int[n][n];
                    boolean diagonal = true;

                    System.out.println("Enter matrix:");
                    for (int i = 0; i < n; i++)
                        for (int j = 0; j < n; j++)
                            D[i][j] = input.nextInt();

                    for (int i = 0; i < n; i++)
                        for (int j = 0; j < n; j++)
                            if (i != j && D[i][j] != 0)
                                diagonal = false;

                    if (diagonal)
                        System.out.println("Matrix is Diagonal");
                    else
                        System.out.println("Matrix is NOT Diagonal");
                    break;

                // 7. CHECK IDENTITY MATRIX
                case 7:
                    System.out.print("Enter size of square matrix: ");
                    n = input.nextInt();

                    int[][] I = new int[n][n];
                    boolean identity = true;

                    System.out.println("Enter matrix:");
                    for (int i = 0; i < n; i++)
                        for (int j = 0; j < n; j++)
                            I[i][j] = input.nextInt();

                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (i == j && I[i][j] != 1)
                                identity = false;
                            if (i != j && I[i][j] != 0)
                                identity = false;
                        }
                    }

                    if (identity)
                        System.out.println("Matrix is Identity");
                    else
                        System.out.println("Matrix is NOT Identity");
                    break;

                case 8:
                    System.out.println("Program exited");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 8);

        input.close();
    }
}
