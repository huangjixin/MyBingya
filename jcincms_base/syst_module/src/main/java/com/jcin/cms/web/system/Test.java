package com.jcin.cms.web.system;

public class Test {
	public int div(int a, int b) {
		try {
			return a / b;
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException");
		} catch (Exception e) {
			System.out.println("Exception");
		} finally {
			System.out.println("finally");
		}
		return 0;
	}

	public static void main(String[] args) {
		Test demo = new Test();
		System.out.println("商是：" + demo.div(9, 0));
	}
}