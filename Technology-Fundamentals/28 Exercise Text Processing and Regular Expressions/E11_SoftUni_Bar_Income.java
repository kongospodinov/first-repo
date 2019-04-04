import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E11_SoftUni_Bar_Income {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "%(?<customer>[A-Z][a-z]+)%" +
                "(?:[^|$%.]*)<(?<product>[^<>]+)>" +
                "(?:[^|$%.])*\\|(?<count>\\d+)" +
                "\\|(?:[^|$%.]*?)(?<price>[-+]?[\\d+.?\\d+]+)\\$";
        Pattern pattern = Pattern.compile(regex);

//String regProduct = "";
//String regCount = "";
//String regPrice = "";


        String input = "";
        double totalIncome = 0;
        double totalPrice = 0;

        while (!"end of shift".equals(input = reader.readLine())) {
            Matcher orderMatch = pattern.matcher(input);

//            String customer = orderMatch.group("customer");
//            String product = orderMatch.group("customer");
//            int count = Integer.parseInt(orderMatch.group("count"));
//            double price = Double.parseDouble(orderMatch.group("price"));

            if (orderMatch.find()) {
                totalPrice = Double.parseDouble(orderMatch.group("count"))
                        * Double.parseDouble(orderMatch.group("price"));

                System.out.println(String.format("%s: %s - %.2f",
                        orderMatch.group("customer"),
                        orderMatch.group("product"),
                        totalPrice));
                totalIncome += totalPrice;
            }

        }

        System.out.println(String.format("Total income: %.2f", totalIncome));
    }
}
