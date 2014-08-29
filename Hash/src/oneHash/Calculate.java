package oneHash;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Calculate  {
/**
 * 
 * @param str
 * str ="sym" выводит символ и количество вхождений в файл
 * str ="word" выводит 5 часто используемых слов
 * str = "mm" выводит максимальное и минимальное слово
 * str = "out" выводит строку из вхождений символов в файл
 * @return
 * 
 */
	public String reedfile(String str) {
		FileInputStream input = null;
		HashDescription gather = new HashDescription("o");
		StaticWord staticWord = new StaticWord();
		StaticSym staticSym = new StaticSym();
		Search search = new Search();

		try {
			input = new FileInputStream("C:\\MyDir\\2.txt");
			int i = 0;
			do {
				i = input.read();
				if (i != -1)
					System.out.print((char) i);
				staticWord.gather(i);
				staticSym.gather(i);
				search.gather(i);
				gather.gather(i);
				// gather(i, gather, staticWord, staticSym, search);
			} while (i != -1);
			//staticWord.returnres();
			staticSym.searchsym('o');
			staticWord.wordserch("is");
			
		} catch (FileNotFoundException exc) {
			System.out.println("File not found");
			} catch (IOException exc) {
			System.out.println("Error reading file");
		} finally {
			try {
				if (input != null)
					input.close();
			} catch (IOException exc) {
				System.out.println("Error closing file");
			}
		}
		if (str == "sym") return staticSym.unittest();
		if (str == "word") return staticWord.unittest();
		if (str == "mm") return search.unittest();
		if (str == "out") return gather.unittest();
		else return "Error";

		
	}
	

}

	
