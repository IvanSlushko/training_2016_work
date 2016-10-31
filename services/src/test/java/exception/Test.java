package exception;

import exception.sample.CustomRuntimeException;

public class Test {
	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		test2();
	}

	public static void test2() {
		try {
			System.out.println("test2-before");
			test3();
			System.out.println("test2-after");

		} catch (CustomRuntimeException e) {

			System.out.println("CustomRuntimeException has been caught");
		} catch (NullPointerException e) {
			System.out.println("NullPointerException has been caught");
		} catch (RuntimeException e) {
			System.out.println("RuntimeException has been caught");
		} finally {
			System.out.println("test2-finally");
		}
		System.out.println("test2-after catch");
	}

	public static void test3() {
		System.out.println("test3-before");
		test4();
		System.out.println("test3-after");
	}

	public static void test4() throws CustomRuntimeException {
		throw new CustomRuntimeException("не найден объект");
	}
}
