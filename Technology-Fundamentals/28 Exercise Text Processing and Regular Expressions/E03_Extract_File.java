import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E03_Extract_File {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String name = input.substring(input.lastIndexOf('\\')+1,input.lastIndexOf('.'));
        String extension = input.substring(input.lastIndexOf('.')+1);

        System.out.println("File name: "+name);
        System.out.println("File extension: "+extension);

    }
}
