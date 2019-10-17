package DAO;

public class Demo {
	public static void main(String[] args) throws Exception {
		ODICareerDAO dao = new ODICareerDAO();
		dao.connect();
		dao.UpdateAvg(1);
		dao.close();
	}
}
