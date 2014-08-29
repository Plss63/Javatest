package oneHash;
import java.util.*;

public class Argument {
	private TreeMap<String, String> inputargs = new TreeMap<String, String>();
	
	private String key ="";
	private String value =""; 
	private String s;

	/**
	 * заносит массив аргументов в TreeMap
	 */
	public void make(String[] mas){
		int nums;
		for (int i=0; i < mas.length; i++){
			s=mas[i];	
			nums=s.indexOf('=');
			for (int j =1; j<nums;j++) key=key+s.charAt(j);
			for (int j =(nums+1); j<s.length();j++) value=value+s.charAt(j);
			inputargs.put(key, value);
			key="";
			value="";
		}
	}
	/**
	 * возвращает значение по ключу 
	 * @param k
	 * @return value
	 */
	public String makeprint(String k){
		return inputargs.get(k);
	}

}
