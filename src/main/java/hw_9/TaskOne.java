package hw_9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TaskOne {

    public static void validatePhoneNumber(String path) {
        File file = new File(path);
        List<String> lines = new ArrayList<>();
        if (file.exists() && file.isFile()) {

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    lines.add(line);
                }

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

            String regex1 = "^\\d{3}-\\d{3}-\\d{4}$";
            String regex2 = "^\\(\\d{3}\\)\\s\\d{3}-\\d{4}$";
            for (String line : lines) {
                if (Pattern.matches(regex1, line) || Pattern.matches(regex2, line)) {
                    System.out.println(line);
                }
            }
        }else{
            System.out.println("Invalid path to file");
        }
    }
}
