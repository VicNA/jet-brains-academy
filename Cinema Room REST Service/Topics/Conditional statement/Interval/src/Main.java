import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int value = scanner.nextInt();

        boolean result = value > -15 && value <= 12;
        if (!result) result = value > 14 && value < 17;
        if (!result) result = value >= 19;

        String s;
        if (result) {
            s = "True";
        } else {
            s = "False";
        }
        System.out.println(s);
    }
}