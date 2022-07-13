import java.util.Scanner;

class FixingArithmeticException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        if (d == 0) {
            System.out.println("Division by zero!");
        } else {
            int bcd = (b + c) / d;
            if (bcd == 0) {
                System.out.println("Division by zero!");
            } else {
                int result = a / bcd;
                System.out.println(result);
            }
        }

    }
}