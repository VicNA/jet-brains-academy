import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        int max;
        int number;
        for (int i = a; i <= b; i++) {
            Random random = new Random(i);
            max = 0;
            for (int j = 0; j < n; j++) {
                number = random.nextInt(k);
                if (number > max) max = number;
            }
            map.put(i, max);
        }
        Map.Entry<Integer, Integer> min = Collections.min(map.entrySet(), Map.Entry.comparingByValue());
        System.out.println(min.getKey());
        System.out.println(min.getValue());
    }
}