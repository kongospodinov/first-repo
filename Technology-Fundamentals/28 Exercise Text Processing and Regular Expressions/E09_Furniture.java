import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E09_Furniture {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = ">>([\\w]+)<<([\\d]+\\.?[\\d]*)!(\\d+)";
        Pattern pattern = Pattern.compile(regex);

        String input = "";
        List<String> items = new ArrayList<>();
        double totalPrice = 0;
        while (!"Purchase".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);

            double price = 0;
            if (matcher.find()) {

                price = Integer.parseInt(matcher.group(3))
                        * Double.parseDouble(matcher.group(2));

                items.add(matcher.group(1));
                totalPrice += price;


            }
        }
        System.out.println("Bought furniture:");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println(String.format("Total money spend: %.2f", totalPrice));
    }
}