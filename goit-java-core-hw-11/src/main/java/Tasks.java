import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tasks {

    public String task1(List<String> nameList){
        return IntStream.range(0, nameList.size())
                .filter(i -> i % 2 ==0)
                .mapToObj( i -> (i+1) + ". " + nameList.get(i))
                .collect(Collectors.joining(", "));
    }

    public List<String> task2(List<String> rows){
        return rows.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

    }

    public String task3(String[] stringArray) {
        String arr = String.join(", ", stringArray);
        return Arrays.stream(arr.split(", "))
                .mapToInt(Integer::valueOf)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public Stream<Long> task4(Long a, Long c, Long m){
        Objects.requireNonNull(a);
        Objects.requireNonNull(c);
        Objects.requireNonNull(m);

        Long seed = System.currentTimeMillis();
        return Stream.iterate(seed, i -> (a * i + c) % m );
    }

    public static <T> Stream<T> task5(Stream<T> first, Stream<T> second){
        Objects.requireNonNull(first);
        Objects.requireNonNull(second);

        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        return IntStream.range(0, Integer.MAX_VALUE)
                .takeWhile((i) -> firstIterator.hasNext() && secondIterator.hasNext())
                .mapToObj(i -> Stream.of(firstIterator.next(), secondIterator.next()))
                .flatMap(s -> s);
    }
}
