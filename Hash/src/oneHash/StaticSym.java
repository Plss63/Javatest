package oneHash;

import java.util.HashMap;

public class StaticSym implements InterHash {
	HashMap<Character, Integer> statisticsym = new HashMap<Character, Integer>();
	private String sym="";
	
	/**поиск символов
	 * 
	 * @param ch
	 */

	@Override
	public void gather(int i) {
		
		char ch = Character.toLowerCase((char) i);
		if (statisticsym.containsKey(ch) ==true ) statisticsym.put(ch, statisticsym.get(ch)+1);
		else statisticsym.put(ch, 1);
	
		
	}

	
	/**
	 * return symbol table
	 */
	@Override
	public void returnres() {
		
		System.out.println(statisticsym.entrySet());
	}
	
	public void searchsym(char ch){
		sym=sym + ch + "=" + statisticsym.get(ch);
	}
	/**
	 * вывод символа и количество вхождений
	 */
	public String unittest(){
		return sym;
	}
	
}
