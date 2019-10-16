package DAO;

import java.util.*;
import Main.*;

public class Demo {
	public static void main(String[] args) throws Exception {
		T20CareerDAO dao = new T20CareerDAO();
		dao.connect();
		T20Career tc = dao.getT20Career(1);
		System.out.println(tc);
		dao.close();
	}
}
