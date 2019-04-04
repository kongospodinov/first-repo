import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E13_Nether_Realms_Misho {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(",\\s*");

        Pattern patternAlfabet = Pattern.compile("[^\\d\\-+*\\/.]");
        Pattern patternDigits = Pattern.compile("[-+]?\\d*\\.?\\d+");

        List<Demon> demons = new ArrayList<>();

        for (String text : input) {
            text = text.trim();
            Matcher matchAlfabet = patternAlfabet.matcher(text);
            Matcher matchDigits = patternDigits.matcher(text);

            int healthSum = 0;
            double damage = 0.0;
            while (matchAlfabet.find()) {
                healthSum += matchAlfabet.group(0).charAt(0);
            }
            while (matchDigits.find()) {
                damage += Double.parseDouble(matchDigits.group());
            }
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == '*') {
                    damage *= 2;
                } else if (text.charAt(i) == '/') {
                    if (damage != 0) {
                        damage /= 2;
                    }
                }
            }

            Demon demon = new Demon(text, healthSum, damage);
            demons.add(demon);
        }
        demons.stream()
                .sorted(Comparator.comparing(Demon::getName))
                .forEach(System.out::println);
    }
}

class Demon {
    private String name;
    private int health;
    private double damage;

    public Demon(String name, int health, double damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }

@Override
    public String toString() {
        return (String.format("%s - %d health, %.2f damage", this.getName()
                , this.getHealth(), this.getDamage()));
    }
}


