package hw_9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TaskThree {

    public static void checkFrequencyOfWordsInFile(String path) {
        File file = new File(path);
        StringBuilder sb = new StringBuilder();
        if (file.exists() && file.isFile()) {
            String[] parts = readTextFileToArrayOfStrings(file, sb);
            List<Map.Entry<String, Integer>> entryList = getSortedFrequencyOfWordsInArrayOfStrings(parts);
            entryList.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        } else {
            System.out.println("Invalid path to file");
        }
    }

    private static List<Map.Entry<String, Integer>> getSortedFrequencyOfWordsInArrayOfStrings(String[] parts) {
        Map<String, Integer> wordsWithCount = new HashMap<>();
        Set<String> wordsSet = new HashSet<>();
        List<String> allWords = new ArrayList<>(Arrays.asList(parts));
        for (String part : parts) {
            if (!wordsSet.contains(part)) {
                wordsSet.add(part);
                wordsWithCount.put(part, Collections.frequency(allWords, part));
            }
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordsWithCount.entrySet());
        entryList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return entryList;
    }

    private static String[] readTextFileToArrayOfStrings(File file, StringBuilder sb) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line.strip());
                sb.append(" ");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        String text = sb.toString();
        text = text.replaceAll("\\s+", " ");
        String[] parts = text.split(" ");
        return parts;
    }
}
