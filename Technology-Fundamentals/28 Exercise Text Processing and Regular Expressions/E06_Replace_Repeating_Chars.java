import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E06_Replace_Repeating_Chars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        String result = "";

        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) != text.charAt(i + 1)) {
                result += text.charAt(i);

            }

        }
        result+= text.charAt(text.length() - 1);
//        if (text.charAt(text.length() - 1) == text.charAt(text.length() - 2)) {
//            result += text.charAt(text.length() - 1);
//        } else {
//            result += text.charAt(text.length() - 2);
//            result += text.charAt(text.length() - 1);
//        }
            System.out.println(result);
        }
    }
