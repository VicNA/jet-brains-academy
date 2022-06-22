import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        String[][] arr = new String[size][size];
        int middle = size / 2;

        for (int i = 0; i < arr.length; i++) {
            if (i != middle) {
                Arrays.fill(arr[i], ".");
            }
            arr[i][i] = "*";
            arr[i][size - 1 - i] = "*";
            arr[middle][i] = "*";
            arr[i][middle] = "*";
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}