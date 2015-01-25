package com.actimem.test.visualvm;

import com.actimem.test.visualvm.excluded.Excluded;
import com.actimem.test.visualvm.included.Included;

public class Test {

	public static void main(String[] args) throws Exception {
		Included included = new Included();
		Excluded excluded = new Excluded();
		while (true) {
			included.doSomeStuff();
			excluded.doSomeStuffExcluded();
		}
	}

}
