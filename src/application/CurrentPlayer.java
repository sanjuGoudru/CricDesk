package application;

public class CurrentPlayer {
	private static int id = -1;
	private static int tid = -1;
	private static int lid = -1;

	public static void setID(String pid) {
		id = Integer.parseInt(pid.substring(1));
		System.out.println("CurrentPlayer ID: " + id);
	}

	public static int getID() {
		return id;
	}

	public static void setTID(int ptid) {
		tid = ptid;
		System.out.println("CurrentTeam ID: " + tid);
	}

	public static int getTID() {
		return tid;
	}

	public static void setLID(int plid) {
		lid = plid;
		System.out.println("CurrentLeague ID: " + lid);
	}

	public static int getLID() {
		return lid;
	}
}
