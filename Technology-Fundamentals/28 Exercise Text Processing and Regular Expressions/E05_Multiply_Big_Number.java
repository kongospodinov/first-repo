import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E05_Multiply_Big_Number {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String number = reader.readLine();
        int multip = Integer.parseInt(reader.readLine());

//String remainder = "";

        int remainder = 0;

        if (multip == 0) {
            System.out.println("0");
            return;
        }
        String result = "";

        for (int i = number.length() - 1; i >= 0; i--) {

            int current = Integer.parseInt(String.valueOf(number.charAt(i))) * multip + remainder;

            result = current % 10 + result;
            remainder = current / 10;
            if (i == 0 && remainder > 0) {
                result = remainder+result;
            }
        }
        System.out.println(result);
    }
}
