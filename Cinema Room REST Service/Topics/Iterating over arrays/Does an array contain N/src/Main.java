import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        int value = sc.nextInt();
        boolean bool = false;
        for (int num : array) {
            if (num == value) {
                bool = true;
                break;
            }
        }

        System.out.println(bool);
    }
}