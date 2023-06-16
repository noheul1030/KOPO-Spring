package practice;

import java.util.HashMap;

public class practice {

	public static void main(String[] args) {
		HashMap<Integer,String> map = new HashMap<>();
		map.put(1,"사과");
		map.put(2,"바나나");
		map.put(3,"포도");

		HashMap<Integer,String> map2 = map;
		
		System.out.println("map = "+map);
		System.out.println("map2 = "+map2);
		
		map2.put(1,"파인애플");
		System.out.println("map2 1 value change");

		System.out.println("map = "+map);
		System.out.println("map2 = "+map2);
	}
}
