import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Enter number of rows and columns for matrices: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        
        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        
        System.out.println("Enter elements of Matrix 1:");
        readMatrix(sc, matrix1);
        
        System.out.println("Enter elements of Matrix 2:");
        readMatrix(sc, matrix2);
        
        System.out.println("Addition:");
        printMatrix(addMatrices(matrix1, matrix2));
        
        System.out.println("Subtraction:");
        printMatrix(subtractMatrices(matrix1, matrix2));
        
        System.out.println("Multiplication:");
        printMatrix(multiplyMatrices(matrix1, matrix2));
        
        sc.close();
    }
    
   
    public static void readMatrix(Scanner sc, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }
    
   
    public static int[][] addMatrices(int[][] mat1, int[][] mat2) {
        int[][] result = new int[mat1.length][mat1[0].length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                result[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        return result;
    }
    
    
    public static int[][] subtractMatrices(int[][] mat1, int[][] mat2) {
        int[][] result = new int[mat1.length][mat1[0].length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                result[i][j] = mat1[i][j] - mat2[i][j];
            }
        }
        return result;
    }
    
    
    public static int[][] multiplyMatrices(int[][] mat1, int[][] mat2) {
        int rows1 = mat1.length;
        int cols1 = mat1[0].length;
        int rows2 = mat2.length;
        int cols2 = mat2[0].length;
        
        if (cols1 != rows2) {
            throw new IllegalArgumentException("Invalid dimensions for multiplication");
        }
        
        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return result;
    }
    
    
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
