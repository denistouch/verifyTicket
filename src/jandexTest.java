import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.readAllLines;

public class jandexTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get("").toAbsolutePath().resolve("input.txt");
        String input = "";
        String output = "";
        System.out.println(path.toAbsolutePath());
        try {
            if (exists(path)) {
                List<String> stringList = readAllLines(path);
                input = stringList.get(0);
                output = sum(input);
            } else if (Files.notExists(path)) {
                output = "File not exist";
            } else {
                output = "File not accessible";
            }
        } catch (IOException e) {
            //e.printStackTrace();
            output = "File is empty";
        }
        try {
            path = path.getParent().resolve("output.txt");
            if (Files.notExists(path)) {
                Files.createFile(path);
                output = path.toAbsolutePath().toString() + " created";
            }
            Files.write(path, Collections.singleton(output));
        } catch (IOException e) {
            output = "File not write";
        }
        System.out.println(output);
    }

    private static String sum(String input) {
        if (input.length() <= 1) {
            return "File is empty";
        }
        String inputArray[];
        int out;
        input = input.replaceAll(",", ".");
        inputArray = input.split(" ");
        //out = Float.parseFloat(inputArray[0]) + Float.parseFloat(inputArray[1]);
        out = Integer.parseInt(inputArray[0]) + Integer.parseInt(inputArray[1]);
        return String.valueOf(out);
    }
}
