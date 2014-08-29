package oneHash;

import static org.junit.Assert.*;

public class Test  {
	Calculate calc = new Calculate();
	

	

	@org.junit.Test
	public void testSym() {
		
		assertEquals("o=15", calc.reedfile("sym"));
	}
	
	@org.junit.Test
	public void testWord() {
		
		assertEquals("is=3", calc.reedfile("word"));
	}
	
	@org.junit.Test
	public void maxmin() {
		
		assertEquals("maxword:population; minword:in;", calc.reedfile("mm"));
	}
	
	@org.junit.Test
	public void output() {
		
		assertEquals("ooooooooooooooo", calc.reedfile("out"));
	}
}
