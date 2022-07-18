package org.hyperskill;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Long> map = new HashMap<>();
        File file = new File("dataset_91069.txt");
        try (Scanner sc = new Scanner(file)) {
            int count = 0;
            long population = 0;
            long growth;
            int year;
            long tmp;
            String[] line = null;
            Function<String, Long> converter = s -> Long.parseLong(s.replace(",", ""));
            while (sc.hasNextLine()) {
                if (count > 0) {
                    line = sc.nextLine().split("\\s");
                    year = Integer.parseInt(line[0]);
                    if (count > 1) {
                        tmp = converter.apply(line[1]);
                        growth = tmp - population;
                        population = tmp;
                        map.put(year, growth);
                    } else {
                        population = converter.apply(line[1]);
                        count++;
                    }
                } else {
                    count++;
                    sc.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey());
    }
}
