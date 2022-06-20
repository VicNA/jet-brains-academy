import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int result;
        if (number % 2 == 0) {
            result = number + 2;
        } else {
            result = number + 1;
        }

        System.out.println(result);
    }
}