import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int sum = number / 100 + number % 100 / 10 + number % 10;

        System.out.println(sum);
    }
}