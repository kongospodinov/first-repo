import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E14_Letters_Change_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        String regex = "(?<before>[A-Za-z](?=[0-9]+))(?<number>(?<=[A-Za-z])[0-9]+)(?=[A-Za-z]*)(?<after>(?=[0-9]*)[A-Za-z])";
        Pattern pattern = Pattern.compile(regex);

//        String regexAfter = "";
//        Pattern patternAft = Pattern.compile(regexAfter);
//
//        String regexNumber = "";
//        Pattern patternNum = Pattern.compile(regexNumber);

        String before = "";
        String after = "";
        double number = 0;
        double sum = 0;


        for (int i = 0; i < input.length; i++) {
            Matcher matcher = pattern.matcher(input[i]);
            if (matcher.find()) {

                before = matcher.group("before");
                after = matcher.group("after");
//    after=Integer.parseInt(matcher.group(befo|re));
                number = Double.parseDouble(matcher.group("number"));


                if (Character.isUpperCase(before.charAt(0))) {

                    int divide = (int) before.charAt(0) - 64;

                    number /= divide;
                } else if (Character.isLowerCase(before.charAt(0))) {
                    int multip = (int) before.charAt(0) - 96;

                    number *= multip;
                }

                if (Character.isUpperCase(after.charAt(0))) {

                    int subt = (int) after.charAt(0) - 64;

                    number -= subt;
                } else if (Character.isLowerCase(after.charAt(0))) {
                    int add = (int) after.charAt(0) - 96;

                    number += add;
                }
                sum += number;
            }

        }
        System.out.printf("%.2f\n", sum);
    }
}
