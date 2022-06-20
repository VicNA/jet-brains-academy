import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int sum = 0;
        int input;
        for (int i = 0; i < size; i++) {
            input = scanner.nextInt();
            sum = input % 6 == 0 ? sum + input : sum;
        }

        System.out.println(sum);
    }
}