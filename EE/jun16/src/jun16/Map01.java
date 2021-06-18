package jun16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Map01 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "jongseong");
		map.put("2", "jongseong");
		map.put("1", "jongseong2");
		
		System.out.println(map);
		System.out.println(map.size());
		
		Set<String> set = map.keySet();
		
		List<String> list = new ArrayList<String>(set);
		
		for (int i = 0; i < list.size(); i++ ) {
			System.out.print(list.get(i) + " : ");
			System.out.println(map.get(list.get(i)));
		}
	}
}
