package tim.now.shared_library.javaUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RimuoviDuplicati {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String[] orderElements(String[] arr) {
		HashSet<String> al = new HashSet<String>();
		for (int i = 0; i < arr.length; i++) {
		al.add(arr[i]);
		}
		Iterator<String> itr = al.iterator();
		arr = new String[al.size()];
		int i = 0;
		while (itr.hasNext()) {
		arr[i] = itr.next();
		i++;
		}
		Arrays.sort(arr);
		return arr;
		}
	
}
