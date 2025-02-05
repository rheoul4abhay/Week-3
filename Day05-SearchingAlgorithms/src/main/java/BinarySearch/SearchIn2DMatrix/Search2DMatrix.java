package BinarySearch.SearchIn2DMatrix;
import java.util.Scanner;


public class Search2DMatrix {

    // {{1,2,3},{4,5,6},{7,8,9}}
    public static boolean search2DMatrix(int[][] arr, int target) {
        int n = arr.length;
        int rowLow = 0;
        int rowHigh = n - 1;

        while (rowLow <= rowHigh) {
            int rowMid = rowLow + (rowHigh - rowLow) / 2;
            int columnLow = 0;
            int columnHigh = arr[rowMid].length - 1;
            while (columnLow <= columnHigh) {
                int columnMid = columnLow + (columnHigh - columnLow) / 2;
                if (arr[rowMid][columnMid] == target) {
                    return true;
                } else if (arr[rowMid][columnMid] < target) {
                    columnLow = columnMid + 1;
                } else if (arr[rowMid][columnMid] > target) {
                    columnHigh = columnMid - 1;
                }
            }
            if(columnLow >= 0 && columnLow < arr[rowMid].length && arr[rowMid][columnLow] > target){
                rowHigh = rowMid - 1;
            }
            else {
                rowLow = rowMid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the number of rows: ");
        int rows = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\nEnter the number of columns: ");
        int columns = scanner.nextInt();
        int[][] arr = new int[rows][columns];

        for(int i = 0;i < rows;i++){
            System.out.print("\nEnter elements in row " + (i+1) + ": ");
            for(int j = 0;j < columns;j++){
                System.out.print("\nEnter element " + (j+1) + ": ");
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.print("\nEnter target value: ");
        int target = scanner.nextInt();

        boolean isFound = Search2DMatrix.search2DMatrix(arr, target);
        System.out.println(isFound ? "\nTarget is present" : "\nTarget not present");
    }
}
