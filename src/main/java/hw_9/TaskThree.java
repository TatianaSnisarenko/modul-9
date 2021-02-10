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
            Map<String, Integer> wordsWithCount = new HashMap<>();
            Set<String> wordsSet = new HashSet<>();
            for (String part : parts) {
                wordsSet.add(part);
            }
            List<String> allWords = new ArrayList<>(Arrays.asList(parts));
            for (String uniqueWord : wordsSet) {
                wordsWithCount.put(uniqueWord, Collections.frequency(allWords, uniqueWord));
            }
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordsWithCount.entrySet());
            Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            for (Map.Entry<String, Integer> entry : entryList) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(key + " " + value);
            }
        }else{
            System.out.println("Invalid path to file");
        }

    }
}
