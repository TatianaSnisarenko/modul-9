package hw_9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class TaskOne {

    public static void validatePhoneNumber(String path) {
        File file = new File(path);
        String regex1 = "^\\d{3}-\\d{3}-\\d{4}$";
        String regex2 = "^\\(\\d{3}\\)\\s\\d{3}-\\d{4}$";

        if (file.exists() && file.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    if (Pattern.matches(regex1, line) || Pattern.matches(regex2, line)) {
                        System.out.println(line);
                    }
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("Invalid path to file");
        }
    }
}
