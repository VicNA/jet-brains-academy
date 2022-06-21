import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];
        boolean sorted = true;

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
            if (i > 0 && arr[i] < arr[i - 1]) {
                sorted = false;
                break;
            }
        }

        System.out.println(sorted);
    }
}