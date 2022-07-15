import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String number;
        while (!"0".equals(number = sc.next())) {
            try {
                System.out.println(Integer.parseInt(number) * 10);
            } catch (NumberFormatException e) {
                System.out.printf("Invalid user input: %s\n", number);
            }
        }
    }
}