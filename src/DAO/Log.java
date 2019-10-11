package DAO;

public class Log {
	static private String s = null;

	public static void add(String a) {
		s += a + "\n";
	}

	public static void print() {
		System.out.println(s);
	}
}