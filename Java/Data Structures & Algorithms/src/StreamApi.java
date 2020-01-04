import java.util.*;
import java.util.stream.Collectors;

public class StreamApi {
public static void main(String[] args) {
	List<Integer> list = Arrays.asList(1,2,3,4,5);
	List<Integer> list2 = list.stream().map(x -> x*x).collect(Collectors.toList());
	System.out.println(list);
	System.out.println(list2);
	list.stream().map(x -> x*x).forEach(y->System.out.println(y));
}
}
