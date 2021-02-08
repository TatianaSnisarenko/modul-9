package hw_9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static final String PATH_TO_FILE_TASK_ONE = "D:\\newGoITProjects\\modul-9\\src\\main\\resources\\hw\\taskOne\\file.txt";
    private static final String PATH_TO_FILE_TASK_THREE = "D:\\newGoITProjects\\modul-9\\src\\main\\resources\\hw\\taskThree\\words.txt";
    private static final String PATH_TO_FILE_TASK_TWO = "D:\\newGoITProjects\\modul-9\\src\\main\\resources\\hw\\taskTwo\\file.txt";
    private static final String PATH_TO_JSON_FILE_TASK_TWO = "D:\\newGoITProjects\\modul-9\\src\\main\\resources\\hw\\taskTwo\\user.json";

    public static void main(String[] args) {
        System.out.println("Checking Task One:");
        TaskOne.validatePhoneNumber(PATH_TO_FILE_TASK_ONE);
        System.out.println("---------------------");
        System.out.println("Checking Task Two:");
        TaskTwo.createListObjFromFileToJson(PATH_TO_FILE_TASK_TWO, PATH_TO_JSON_FILE_TASK_TWO);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(PATH_TO_JSON_FILE_TASK_TWO)))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("---------------------");
        System.out.println("Checking Task Three:");
        TaskThree.checkFrequencyOfWordsInFile(PATH_TO_FILE_TASK_THREE);
    }
}
