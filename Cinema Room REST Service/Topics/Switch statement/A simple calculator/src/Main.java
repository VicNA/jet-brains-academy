import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num1 = scanner.nextLong();
        String op = scanner.next();
        long num2 = scanner.nextLong();

        String result;
        switch (op) {
            case "+":
                result = String.valueOf(num1 + num2);
                break;
            case "-":
                result = String.valueOf(num1 - num2);
                break;
            case "/":
                if (num2 == 0) {
                    result = "Division by 0!";
                } else {
                    result = String.valueOf(num1 / num2);
                }
                break;
            case "*":
                result = String.valueOf(num1 * num2);
                break;
            default:
                result = "Unknown operator";
                break;
        }
        System.out.println(result);
    }
}