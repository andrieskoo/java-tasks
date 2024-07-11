import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> nameList = List.of("Petro", "Marko", "Vladyslav", "Vasyl", "Ivan", "Volodymyr");
        List<String> surnameList = List.of("Petrenko", "Makarenko", "Vladyslavenko", "Vasylenko", "Ivanko");

        Tasks tasks = new Tasks();

        //Task 1
        System.out.println("tasks.oddNamesString(nameList) = " + tasks.task1(nameList));

        //Task 2
        System.out.println("tasks.task2(nameList) = " + tasks.task2(nameList));

        //Task 3
        String[] stringArray = {"1, 2, 0", "4, 5"};
        System.out.println("tasks.task3(stringArray) = " + tasks.task3(stringArray));

        //Task4
        tasks.task4(25214903917L, 11L, 1L << 48)
                .limit(10)
                .forEach(System.out::println);

        //Task5
        Stream<String> resultStream = Tasks.task5(nameList.stream(), surnameList.stream());
        resultStream.forEach(System.out::println);

    }
}
