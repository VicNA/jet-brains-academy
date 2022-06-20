import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        System.out.print(n);

        if (n > 0 && n <= 1_000_000) {
            int num = n;
            while (num != 1) {
                num = num % 2 == 0 ? num / 2 : num * 3 + 1;
                System.out.print(" " + num);
            }
        }
    }
}