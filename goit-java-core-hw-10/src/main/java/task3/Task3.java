package task3;

import java.io.FileInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Task3 {
    private HashMap<String, Integer> wordsMap;

    public Task3() {
        this.wordsMap = new HashMap<>();
    }

    public void countWordFrequency(String path){

        try(FileInputStream fileInputStream = new FileInputStream(path)){
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNextLine()){
                String[] words = scanner.nextLine().trim().split(" ");
                for (String word : words){
                    if (wordsMap.containsKey(word.trim())){
                        wordsMap.put(word.trim(), wordsMap.get(word.trim()) + 1);
                    }
                    else {
                        wordsMap.put(word.trim(), 1);
                    }
                }
            }
            System.out.println("wordsMap = " +
                    wordsMap.entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new)));

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
