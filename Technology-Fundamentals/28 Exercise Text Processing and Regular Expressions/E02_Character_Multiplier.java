import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class E02_Character_Multiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String first = input.substring(0, input.indexOf(' '));
        String second = input.substring(input.lastIndexOf(' ') + 1);

        int sum = multiplier(first, second);
        System.out.println(sum);

    }

    private static int multiplier(String first, String second) {

        int minLength = Math.min(first.length(), second.length());
        int sum = 0;
        for (int i = 0; i < minLength; i++) {
            sum += first.charAt(i) * second.charAt(i);
        }
        String maxLength =
                first.length() < second.length() ? second : first;
        for (int i = minLength; i < maxLength.length(); i++) {
            sum += maxLength.charAt(i);
        }
        return sum;
    }
}
