import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        int num = sc.nextInt();
        int sum = 0;

        for (int i : array) {
            if (i > num) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}