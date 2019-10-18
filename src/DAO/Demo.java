package DAO;

import Main.Player;
import Main.TestCareer;

public class Demo {
	public static void main(String[] args) throws Exception {
		PlayerDAO dao = new PlayerDAO();
		dao.connect();
		Player p = new Player("a", 1, 1, 1, 1, "1111-11-1");
		int id = dao.insertPlayer(p);
		System.out.println("ID: " + id);
		dao.close();
	}
}
