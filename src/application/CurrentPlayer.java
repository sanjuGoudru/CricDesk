package application;

public class CurrentPlayer {
	private static int id = -1;

	public static void setID(String pid) {
		id = Integer.parseInt(pid.substring(1));
		System.out.println("CurrentPlayer ID: " + id);
	}

	public static int getID() {
		return id;
	}
}
