import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E13_Nether_Realms {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(",\\s*");
        Map<String, List<Double>> dragons = new TreeMap<>();
        for (int i = 0; i < input.length; i++) {

//            String name = input[i].replaceAll("\\s+,","");
            String name = input[i].replaceAll("\\s+,","").trim();

//            String regexName = "([^0-9+\\-*\\\\/.])";
            String regexName = "([^\\.\\/\\-+\\*0-9]*)";
//            Pattern pattern = Pattern.compile("([^\\.\\/\\-+\\*0-9]*)"); - pachata
//            String regexDamage = "([-]?[0-9]+\\.?[0-9]*)";
            String regexDamage = "(-?\\d+\\.?\\d*)";
//            Pattern dmgPattern = Pattern.compile("(-?\\d+\\.?\\d*)"); - pachata
            Pattern patternDam = Pattern.compile(regexDamage);
            Matcher damageMatch = patternDam.matcher(name);
//             String regex = "([0-9+\\-*\\/.])";
//             String regex = "[^0-9]";
            Pattern pattern = Pattern.compile(regexName);
            Matcher nameMatch = pattern.matcher(name);
            String healthStr = "";
            double health = 0;
            double damage = 0;

            for (int j = 0; j < name.length(); j++) {
                if (nameMatch.find()) {
                    healthStr += nameMatch.group();

                }

                if (damageMatch.find()) {
                    String dama = damageMatch.group();
                    damage += Double.parseDouble(damageMatch.group());

                }
            }
            for (int k = 0; k < name.length(); k++) {
                if (name.charAt(k) == '*') {
                    damage *= 2;
                } else if (name.charAt(k) == '/') {
                    damage /= 2;
                }
            }
            for (int y = 0; y < healthStr.length(); y++) {
                health += (double) (char) healthStr.charAt(y);
            }


            if (!dragons.containsKey(name)) {
                dragons.put(name, new ArrayList<Double>());
                dragons.get(name).add(0,health);
                dragons.get(name).add(1, damage);

            } else {
                dragons.get(name).set(0, health);
                dragons.get(name).set(1, damage);
            }

        }
        dragons.entrySet().stream().forEach(e->{
//            int health = Integer.parseInt(e.getValue().get(0));
            System.out.println(String.format("%s - %.0f health, %.2f damage",e.getKey(),e.getValue().get(0),e.getValue().get(1)));
        });
    }
}
