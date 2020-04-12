package other;

import com.google.common.collect.Lists;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Description
 * Date 2019-11-27 10:57
 */
public class CollectionTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");


//		Iterator<String> iterator = list.iterator();
//		while (iterator.hasNext()) {
//			String item = iterator.next();
//			if ("2".equals(item)) {
//				iterator.remove();
//			}
//		}

		list.forEach(e -> {
			if ("2".equals(e)) {
				list.remove(e);
			}
		});
		list.forEach(System.out::println);
	}
}
