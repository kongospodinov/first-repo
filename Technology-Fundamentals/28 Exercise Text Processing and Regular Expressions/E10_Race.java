import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class E10_Race {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] participants = reader.readLine().split(", ");
        String input = "";


        Map<String, Integer> runners = new LinkedHashMap<>();
        while (!"end of race".equals(input = reader.readLine())) {
            String name = "";
            int distance = 0;
            for (int i = 0; i < input.length(); i++) {
                if (Character.isLetter(input.charAt(i))) {
                    name += input.charAt(i);
                } else if (Character.isDigit(input.charAt(i))) {
                    distance += Integer.parseInt(String.valueOf(input.charAt(i)));
                }

            }
            for (String participant : participants) {
                if (participant.equals(name)) {
                    if (!runners.containsKey(name)) {
                        runners.putIfAbsent(name, 0);
                        runners.put(name, distance);


                    } else {
                        runners.put(name, runners.get(name) + distance);

                    }
                }


            }

        }
        int index = 1;

//        int first = Integer.MIN_VALUE;
//        int second = Integer.MIN_VALUE;
//        String firstPlace = "";
//        String seoondPlace = "";
//        String thirdPlace = "";
//        for (Map.Entry<String, Integer> kvp : runners.entrySet()) {
//            if (kvp.getValue() > first) {
//                first = kvp.getValue();
//                firstPlace = kvp.getKey();
//            } else if (kvp.getValue() > second) {
//                seoondPlace = kvp.getKey();
//            }else {
//                thirdPlace=kvp.getKey();
//
//        }
//
//    }
List<String> collect = new ArrayList<>();
         runners.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())).
                limit(3).forEach(e->{
                    collect.add(e.getKey());
         });
//        for (String s : collect) {
//            System.out.println(String.format("%dst place: %s",index++,s));
//        }
        System.out.println("1st place: "+collect.get(0));
        System.out.println("2nd place: "+collect.get(1));
        System.out.println("3rd place: "+collect.get(2));

//        System.out.println("2nd place: "+seoondPlace);
//        System.out.println("3rd place: "+thirdPlace);
}
}
