package com.actimem.test.visualvm.excluded;

public class Excluded {
	public void doSomeStuffExcluded() throws Exception {
		System.out.println("Executing excluded...");
		Thread.sleep(1000);
		InnerExcluded e = new InnerExcluded();
		e.doSomeStuffExcluded();
	}

	public static class InnerExcluded {
		public void doSomeStuffExcluded() throws Exception {
			System.out.println("Executing inner excluded...");
			Thread.sleep(1000);
		}
	}
}
