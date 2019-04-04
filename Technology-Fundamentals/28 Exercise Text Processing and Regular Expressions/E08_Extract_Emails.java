import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E08_Extract_Emails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String regex = "(^| )[A-Za-z][\\w.-]*@[A-Za-z-]+(\\.[A-Za-z]+)+";
        Pattern pattern = Pattern.compile(regex);
        Matcher emailMatch = pattern.matcher(input);

        while (emailMatch.find()){
            System.out.println(emailMatch.group().trim());


        }
    }
}
