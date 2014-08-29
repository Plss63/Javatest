package oneHash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

public class StaticWord implements InterHash {
	private String word = "";
	TreeMap<String, Integer> statisticword = new TreeMap<String, Integer>();
	private String tests = "";
	
	public String wordserch(String str) {
		if (statisticword.containsKey(str)) tests = tests + str + "=" + statisticword.get(str);
		return tests;
	}
/**
 * вывод слова и значения по поиску
 */
	public String unittest() {
		return tests;
	}
	
	
	
	/**
	 * поиск слов
	 * 
	 * @param ch
	 * @param a
	 */
	public void gather(int i) {

		char ch = Character.toLowerCase((char) i);

		if (Character.isLetter(ch) == false) {
			if (word == "")
				return;
			if (word != "") {
				if (statisticword.containsKey(word) == true) {
					statisticword.put(word, statisticword.get(word) + 1);
					word = "";
				} else {
					statisticword.put(word, 1);
					word = "";
				}
			}
		}
		if (Character.isLetter(ch)) {
			word = word + ch;
			if (i == -1) {
				if (statisticword.containsKey(word) == true) {
					statisticword.put(word, statisticword.get(word) + 1);
					word = "";
				} else {
					statisticword.put(word, 1);
					word = "";
				}
			}
		}
	}

	/**
	 * вывод слов
	 * 
	 */
	public void returnres() {

		System.out.println(statisticword.entrySet());
		returnSortedList(5);
	}

	/**
	 * вывод сортированного списка слов
	 * 
	 * @param n
	 * 
	 * @return n elements
	 */
	public void returnSortedList(int n) {
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(
				statisticword.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> e1,
					Entry<String, Integer> e2) {
				return e2.getValue().compareTo(e1.getValue());
			}

		});
		for (int i = 0; i < n; i++) {
			System.out.print(list.get(i) + ";");
		}

	}

}
