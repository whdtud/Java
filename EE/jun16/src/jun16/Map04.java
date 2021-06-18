package jun16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Map04 {
	
	public static void main(String[] args) {
		
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("title", "제목");
		map.put("contents", "내용");
		map.put("author", "글쓴이");
		map.put("read", 1);
		map.put("days", "2021-06-13");
		
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("title", "김밥");
		map.put("contents", "참치");
		map.put("author", "우종성");
		map.put("read", 1);
		map.put("days", "2021-06-13");
		
		list.add(map);
		
		System.out.println(list);
		
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> data = list.get(i);
			System.out.print(i + 1 + "\t");
			System.out.print(data.get("title") + "\t");
			System.out.print(data.get("contents") + "\t");
			System.out.print(data.get("author") + "\t");
			System.out.print(data.get("read") + "\t");
			System.out.print(data.get("days"));
			System.out.println();
		}
	}
}
