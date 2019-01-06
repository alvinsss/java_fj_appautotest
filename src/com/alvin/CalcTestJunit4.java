/**
 * @Title: CalcTestJunit4.java
 * @Package com.alvin
 * @Description: TODO
 * @author alvin
 * @date 2019年1月6日 上午11:40:45
 * @version V1.0
 */

package com.alvin;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
  * @ClassName: CalcTestJunit4
  * @Description: TODO
  * @author Comsys-Administrator
  * @date 2019年1月6日 上午11:40:45
  *
  */

public class CalcTestJunit4 {
	
	Calc math = null;
	@Before
	public void setUp() throws Exception {
		math = new Calc();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.alvin.Calc#add(int, int)}.
	 */
	@Test
	public void testAdd() {
//		fail("Not yet implemented");
		int c = math.add(1, 2);
		assertEquals("失败了，实际结果不是3",3, c);
		
	}

	/**
	 * Test method for {@link com.alvin.Calc#div(int, int)}.
	 */
	@Test
	public void testDiv() {
		fail("Not yet implemented");
	}

}
