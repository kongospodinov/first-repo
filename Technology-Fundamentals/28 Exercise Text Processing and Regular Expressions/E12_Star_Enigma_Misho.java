import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E12_Star_Enigma_Misho {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());
        Pattern pattern = Pattern.compile("[star]", Pattern.CASE_INSENSITIVE);

        while (n-- > 0) {
            String encryptedMessage = reader.readLine();
            Matcher matcher = pattern.matcher(encryptedMessage);
            int countletters = 0;
            while (matcher.find()) {
                countletters++;

            }
            StringBuilder decryptMessage = new StringBuilder();
            for (int i = 0; i < encryptedMessage.length(); i++) {
                decryptMessage.append(String.valueOf(Character.toChars(encryptedMessage.charAt(i) - countletters)));
            }

            String regex = "@([A-Za-z]+)(?:[^@!\\-:>]*):(\\d+)(?:[^@!\\-:>]*)!([AD])!(?:[^@!\\-:>]*)->(\\d+)";
            Pattern patternPlanets = Pattern.compile(regex);
            Matcher matcherPlanets = patternPlanets.matcher(decryptMessage.toString());
            while (matcherPlanets.find()) {
                String planetName = matcherPlanets.group(1);
                String attackType = matcherPlanets.group(3);
                if (attackType.equals("A")) {
                    attackedPlanets.add(planetName);
                } else {
                    destroyedPlanets.add(planetName);
                }
            }

        }
        System.out.println(String.format("Attacked planets: %d",attackedPlanets.size()));
        attackedPlanets.stream().sorted(String::compareTo).forEach(e->{
            System.out.println(String.format("-> %s", e));
        });
        System.out.println(String.format("Destroyed planets: %d",destroyedPlanets.size()));
        destroyedPlanets.stream().sorted(String::compareTo).forEach(e->{
            System.out.println(String.format("-> %s", e));
        });
    }
}
