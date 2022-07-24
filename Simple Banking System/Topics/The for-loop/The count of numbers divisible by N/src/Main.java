import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();

        int lower = a % n == 0 ? a / n : (a + (n - a % n)) / n;
        int upper = b % n == 0 ? b / n : (b - b % n) / n;

        System.out.println(upper - lower + 1);
    }
}