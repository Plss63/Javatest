package oneHash;

import java.io.*;


public class MyHash {

	public static void main(String[] args) throws Exception {
		FileInputStream file = null;
		//Argument aa = new Argument();
		//aa.make(args);
		//for(int i=0; i < args.length; i++) System.out.println(args[i]);
		//if (true) return;
		HashDescription gather = new HashDescription("li");
		StaticWord staticWord = new StaticWord();
		StaticSym staticSym = new StaticSym();
		Search search = new Search();
		InterHash[] mas = { gather, staticWord, staticSym, search };

		try {
			file = new FileInputStream("C:\\MyDir\\2.txt");

			int i = 0;
			do {
				i = file.read();
				if (i != -1)
					System.out.print((char) i);

				gather(i, gather, staticWord, staticSym, search);
				
			} while (i != -1);
			returnstat(mas);
			staticSym.searchsym('o');
			staticWord.wordserch("is");
			
			
		} catch (FileNotFoundException exc) {
			System.out.println("File not found");
			return;

		} catch (IOException exc) {
			System.out.println("Error reading file");
		} finally {
			try {
				if (file != null)
					file.close();
			} catch (IOException exc) {
				System.out.println("Error closing file");
			}
		}
		
	}

	private static void returnstat(InterHash[] mas) throws IOException {
		for (InterHash statistic : mas) {
//			System.out.println()//;
			statistic.returnres();
		}
	}

	private static void gather(int i, InterHash... mas) throws IOException {
		for (InterHash statistic : mas) {
			statistic.gather(i);
		}
	}
}
