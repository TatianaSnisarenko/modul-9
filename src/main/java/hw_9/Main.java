package hw_9;

public class Main {
    private static final String PATH_TO_FILE_TASK_ONE = "D:\\newGoITProjects\\modul-9\\src\\main\\resources\\hw\\taskOne\\file.txt";
    private static final String PATH_TO_FILE_TASK_THREE = "D:\\newGoITProjects\\modul-9\\src\\main\\resources\\hw\\taskThree\\words.txt";

    public static void main(String[] args) {
        System.out.println("Checking Task One:");
        TaskOne.validatePhoneNumber(PATH_TO_FILE_TASK_ONE);
        System.out.println("---------------------");
        System.out.println("Checking Task Three:");
        TaskThree.checkFrequencyOfWordsInFile(PATH_TO_FILE_TASK_THREE);
        System.out.println("---------------------");
    }
}
