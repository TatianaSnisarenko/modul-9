package hw_9;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskTwo {

    public static void createListObjFromFileToJson(String pathToIncomingFile, String pathToJsonFile) {
        File file = new File(pathToIncomingFile);
        List<User> users = new ArrayList<>();

        if (file.exists() && file.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line = bufferedReader.readLine();
                while ((line = bufferedReader.readLine()) != null) {
                    String[] parts = line.strip().split(" ");
                    users.add(new User(parts[0], Integer.parseInt(parts[1])));
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }else{
            System.out.println("Invalid path to file");
            return;
        }

        if (users.size() != 0) {
            File fileToJson = new File(pathToJsonFile);
            if (!file.exists()) {
                file.mkdirs();
            }
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToJson))) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(users);
                bufferedWriter.write(json);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
