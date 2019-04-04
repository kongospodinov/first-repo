import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E04_Caesar_Cipher {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        char[] result = new char[input.length()];
        String resulta = "";


        for (int i = 0; i < input.length(); i++) {
//            resulta.charAt(i)=Character.valueOf('3');
            result[i] = (char) ((int) input.charAt(i) + 3);
            resulta += (char) ((int) input.charAt(i) + 3);
//            System.out.println(input.charAt(i)+3);
        }
        System.out.println(String.valueOf(result));
        System.out.println(result.toString());
//        System.out.println(resulta);
    }
}