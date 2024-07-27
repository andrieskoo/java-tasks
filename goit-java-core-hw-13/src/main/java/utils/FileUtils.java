package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import comments.dto.Comment;

import java.io.FileOutputStream;
import java.util.List;

public class FileUtils {
    public void writeToFile(String fileName, List<Comment> commentList) {
        if (commentList.isEmpty()){
            System.out.println("Comments list is empty");
            return;
        }

        Thread exportThread = new Thread(() -> {
            System.out.println("Start export in separate thread");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            StringBuilder jsonSB = new StringBuilder();
            jsonSB.append(gson.toJson(commentList));
            try(FileOutputStream fileOutputStream = new FileOutputStream(fileName + ".json")){
                fileOutputStream.write(jsonSB.toString().getBytes());
            }
            catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Finish export");
        });
        exportThread.start();


    }
}
