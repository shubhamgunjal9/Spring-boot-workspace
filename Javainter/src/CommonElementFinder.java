import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElementFinder {

	public static void main(String[] args) {
		
		List<Integer> list1= List.of(1,2,3);
		List<Integer> list2= List.of(2,5,7);
		List<Integer> list3= List.of(2,5,6);
		
		
		
		Integer commonEllement = findCommonElement(list1,list2,list3);
		
		
		if(commonEllement !=null ) {
			System.out.println(commonEllement);
		}
		else {
			System.out.println("no common element");
			
		}			
		}
		
		
		public static List<Integer> findCommonElement(List<Integer> list1, List<Integer> list2,List<Integer> list3  ) {
		
		Set<Integer> set1=new HashSet<>(list1);
		Set<Integer> set2=new HashSet<>(list2);
		Set<Integer> set3=new HashSet<>(list3);
		
		set1.retainAll(set2);
		set1.retainAll(set3);
		
		
		while(!set1.isEmpty()) {
			
			return Arrays.asList(set1.iterator().next());
			
		}
		return null;
}
		
}
		
		
		


