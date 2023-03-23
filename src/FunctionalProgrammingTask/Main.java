package FunctionalProgrammingTask;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<String> list = List.of(str.split(" "));
        Map<String, Integer> mapList = new TreeMap<>();
        for (String s : list) {
            if (mapList.containsKey(s)) {
                mapList.put(s, mapList.get(s)+1);
            } else mapList.put(s, 1);
        }
        mapList.forEach((key, value) -> System.out.println(value + " " + key));
    }
}
