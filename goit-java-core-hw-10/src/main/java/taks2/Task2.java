package taks2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class Task2 {

    private List<User> userList;

    public Task2() {
        this.userList = new ArrayList<>();
    }

    public void readFile(String path){
        try (FileInputStream fileInputStream = new FileInputStream(path)){
            Scanner scanner = new Scanner(fileInputStream);
            scanner.nextLine();
            while (scanner.hasNextLine()){
                String[] line = scanner.nextLine().split(" ");
                System.out.println("Arrays.toString(line) = " + Arrays.toString(line));
                User user = new User();
                if (line[0].trim().length() > 0 ){
                    user.setName(line[0]);
                }
                if (line[1].trim().length() > 0 ){
                    user.setAge(Integer.parseInt(line[1]));
                }
                userList.add(user);
                System.out.println("user.toString() = " + user.toString());

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void convertToJSON(String pathFile) {
        if (userList.isEmpty()){
            System.out.println("User list is empty");
            return;
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        StringBuilder jsonSB = new StringBuilder();
        jsonSB.append(gson.toJson(userList));
        try(FileOutputStream fileOutputStream = new FileOutputStream(pathFile + "user.json")){
            fileOutputStream.write(jsonSB.toString().getBytes());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
