import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E12_Star_Enigma {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


//        String regex = "@([A-Za-z]+)(?:[^@:!\\->]*):([0-9]+)(?:[^@:!\\->]*)!([A|D])!(?:[^@:!\\->]*)->([0-9]+)";
//        String regex = "@([A-Za-z]+)(?:[^@:!\\->]*):([0-9]+)(?:[^@:!\\->]*)!([A|D])!(?:[^@:!\\->]*)->([0-9]+)(?:[^@\\-!:>]*)*?$";
        String regex = "([A-Za-z]+)(?:[^@\\-!;>]*):([0-9]+)!([A-Z])!->([0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        int number = Integer.parseInt(reader.readLine());


        String name = "";
        String type = "";
        int destroyed = 0;
        int attacked = 0;
        List<String> aplanet = new ArrayList<>() {
        };
        List<String> dplanet = new ArrayList<>();

        while (number-- > 0) {
            String input = reader.readLine();
            int index=0;
            for (int i = 0; i < input.length(); i++) {
                if (String.valueOf(input.charAt(i)).equalsIgnoreCase("s")
                        || String.valueOf(input.charAt(i)).equalsIgnoreCase("t")
                        || String.valueOf(input.charAt(i)).equalsIgnoreCase("a")
                        || String.valueOf(input.charAt(i)).equalsIgnoreCase("r")
                ){
                    index++;
                }
            }
            String message ="";
            for (int i = 0; i < input.length(); i++) {
                message+=(char)((int)input.charAt(i)-index);
            }

            Matcher matcher = pattern.matcher(message);





            if (matcher.find()) {

              name= matcher.group(1);
              type= matcher.group(3);

              if ("A".equals(type)){
                  attacked++;
                  aplanet.add(name);

              }else if ("D".equals(type)){
                  destroyed++;
                  dplanet.add(name);
              }


            }


        }
        System.out.println("Attacked planets: "+attacked);

        aplanet.stream().sorted((e1,e2)->e1.compareTo(e2)).forEach(e->{
            System.out.println("-> "+e);
        });
        System.out.println("Destroyed planets: "+destroyed);
        dplanet.stream().sorted((e1,e2)->e1.compareTo(e2)).forEach(e->{
            System.out.println("-> "+e);
        });

    }
}