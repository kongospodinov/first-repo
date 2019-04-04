import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E05_Multiply_Big_Number_TIndvowa {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] digits = reader.readLine().toCharArray();
        int multiplyBy = Integer.parseInt(reader.readLine());
        if (multiplyBy == 0){
            System.out.println("0");
            return;
        }
        String result = "";
        int rest = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int currentResult = Integer.parseInt(digits[i] + "")
                    * multiplyBy + rest;
            result = currentResult % 10 + result;
            rest = currentResult / 10;
            if (i == 0 && rest > 0){
                result = rest + result;
            }
        }
        System.out.println(result);
    }
}
