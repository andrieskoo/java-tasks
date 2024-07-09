package task1;

import java.io.FileInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {



    public void readFile(String path){
    try(FileInputStream fileInputStream = new FileInputStream(path)) {
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNextLine()){
            validateNumber(scanner.nextLine());
        }
    }
    catch (Exception e){
        e.printStackTrace();
    }

    }

    private void validateNumber(String line){
        String patternString = "(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\s\\d{3}-?\\d{4}";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()){
            System.out.println(line);
        }
    }
}
