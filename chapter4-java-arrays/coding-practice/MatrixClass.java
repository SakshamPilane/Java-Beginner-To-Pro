import java.util.Scanner;

public class MatrixClass {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        while (true)
        {
            System.out.println("******************************");
            System.out.println("1. Addition of Matrices.");
            System.out.println("2. Transpose of Matrices.");
            System.out.println("3. Multiplication of Matrices.");
            System.out.println("4. Exit.");
            System.out.println("******************************");
            System.out.print("Select one from above: ");
            int choice = input.nextInt();
            switch (choice)
            {
                case 1:
                    addMatrix(input);
                    break;
                case 2:
                    transposeMatrix(input);
                    break;
                case 3:
                    multiplyMatrix(input);
                    break;
                case 4:
                    input.close();
                    return;
                default:
                    System.out.println("Invalid Choice Try Again!");
                    break;
            }
        }
    }

    public static void addMatrix(Scanner input)
    {
        System.out.print("Enter Number of Rows for First Matrix: ");
        int rows1 = input.nextInt();
        System.out.print("Enter Number of Cols for First Matrix: ");
        int cols1 = input.nextInt();

        System.out.print("Enter Number of Rows for Second Matrix: ");
        int rows2 = input.nextInt();
        System.out.print("Enter Number of Cols for Second Matrix: ");
        int cols2 = input.nextInt();

        if (rows1 != rows2 || cols1 != cols2)
        {
            System.out.println("Invalid! Number of Rows and Columns must be same for addition of both matrices");
            return;
        }

        int i, j;

        int[][] matrix1 = readMatrix(input, rows1, cols1);

        int[][] matrix2 = readMatrix(input, rows2, cols2);

        printMatrix(matrix1);

        printMatrix(matrix2);

        System.out.println("Adding both Matrices....");
        int[][] addedMatrix = new int[rows1][cols1];
        for (i = 0; i < rows1; i++) {
            for (j = 0; j < cols1; j++) {
                addedMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("Added Matrix: ");
        for (i = 0; i < rows1; i++) {
            System.out.print("[ ");
            for (j = 0; j < cols1; j++) {
                System.out.print(addedMatrix[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void transposeMatrix(Scanner input)
    {
        System.out.print("Enter Number of Rows Matrix: ");
        int rows = input.nextInt();
        System.out.print("Enter Number of Cols Matrix: ");
        int cols = input.nextInt();

        int i, j;

        int[][] matrix = new int[rows][cols];

        System.out.print("Enter Elements into Matrix: ");
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        System.out.println("Matrix Entered: ");
        for (i = 0; i < rows; i++) {
            System.out.print("[ ");
            for (j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }

        System.out.println("Transposing both Matrices....");
        int[][] copyMatrix = new int[cols][rows];
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                copyMatrix[j][i] = matrix[i][j];
            }
        }

        System.out.println("Transposed Matrix: ");
        for (i = 0; i < cols; i++) {
            System.out.print("[ ");
            for (j = 0; j < rows; j++) {
                System.out.print(copyMatrix[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void multiplyMatrix(Scanner input)
    {
        System.out.print("Enter Number of Rows for First Matrix: ");
        int rows1 = input.nextInt();
        System.out.print("Enter Number of Cols for First Matrix: ");
        int cols1 = input.nextInt();

        System.out.print("Enter Number of Rows for Second Matrix: ");
        int rows2 = input.nextInt();
        System.out.print("Enter Number of Cols for Second Matrix: ");
        int cols2 = input.nextInt();

        if (cols1 != rows2)
        {
            System.out.println("Invalid! Number of columns of first matrix must be equal to number of rows of second matrix.");
            return;
        }

        int i, j;

        int[][] matrix1 = new int[rows1][cols1];

        int[][] matrix2 = new int[rows2][cols2];

        System.out.print("Enter Elements into First Matrix: ");
        for (i = 0; i < rows1; i++) {
            for (j = 0; j < cols1; j++) {
                matrix1[i][j] = input.nextInt();
            }
        }

        System.out.print("Enter Elements into Second Matrix: ");
        for (i = 0; i < rows2; i++) {
            for (j = 0; j < cols2; j++) {
                matrix2[i][j] = input.nextInt();
            }
        }

        System.out.println("First Matrix Entered: ");
        for (i = 0; i < rows1; i++) {
            System.out.print("[ ");
            for (j = 0; j < cols1; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }

        System.out.println("Second Matrix Entered: ");
        for (i = 0; i < rows2; i++) {
            System.out.print("[ ");
            for (j = 0; j < cols2; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }

        System.out.println("Multiplying both Matrices....");
        int[][] multipliedMatrix = new int[rows1][cols2];
        for (i = 0; i < rows1; i++) {
            for (j = 0; j < cols2; j++) {
                multipliedMatrix[i][j] = 0;
                for (int k = 0; k < cols1; k++) {
                    multipliedMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        System.out.println("Multiplied Matrix: ");
        for (i = 0; i < rows1; i++) {
            System.out.print("[ ");
            for (j = 0; j < cols2; j++) {
                System.out.print(multipliedMatrix[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static int[][] readMatrix(Scanner input, int rows, int cols) {
        System.out.print("Enter elements into matrix: ");
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println("Matrix Entered: ");
        for (int[] row : matrix) {
            System.out.print("[ ");
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println("]");
        }
    }

}
