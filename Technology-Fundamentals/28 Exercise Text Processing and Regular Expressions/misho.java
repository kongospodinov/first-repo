import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class misho {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, LinkedHashMap<String, List<Double>>> army = new LinkedHashMap();


//        List<String> keys = army.keySet().stream().collect(Collectors.toList());

        List<String> keys = new ArrayList<>();

        army.entrySet().forEach(e -> {
            keys.add(e.getKey());

        });

//        keys.stream().sorted((e1,e2)->e2.compareTo(e1))
//                .forEach(e->{
//                    System.out.println(army.get(e));
//                });
        keys.stream().sorted(Comparator.reverseOrder())
                .forEach(e->{
                    System.out.println(army.get(e));
                });
    }
}