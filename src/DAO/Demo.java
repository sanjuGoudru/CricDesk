package DAO;

import Main.TestCareer;

public class Demo {
	public static void main(String[] args) throws Exception {
		TestCareerDAO dao = new TestCareerDAO();
		dao.connect();
		TestCareer tc = new TestCareer(1, 1, 1, 1, 1, 1, 1);
		tc.setId(29);
		dao.insertTestCareer(tc);
		dao.UpdateAvg(29);
		dao.close();
	}
}
