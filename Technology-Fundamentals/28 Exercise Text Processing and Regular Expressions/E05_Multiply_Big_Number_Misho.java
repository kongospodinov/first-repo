import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E05_Multiply_Big_Number_Misho {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String number = reader.readLine();
        int multiplier = Integer.parseInt(reader.readLine());

        if (multiplier == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder result = new StringBuilder();
        int remainder = 0;

        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(number.charAt(i) + "");
            int currentSum = multiplier * digit + remainder;

            remainder = currentSum / 10;
            result.append(currentSum % 10);

        }
//        result.append(remainder);
//        result=result.reverse();
//        if (String.valueOf(result.charAt(0)).equals('0')){
//            result=new StringBuilder(result.substring(1));
//        }


        if (remainder > 0) {
            System.out.println(result.reverse());
        }
    }
}