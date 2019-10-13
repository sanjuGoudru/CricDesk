package DAO;

import java.util.*;
import Main.*;

public class Demo {
	public static void main(String[] args) throws Exception {
		LeagueDAO ldao = new LeagueDAO();
		ldao.connect();
		ArrayList<Player> players = ldao.getAllPlayers(1, 1);
		for (Player player : players)
			System.out.println(player);
		ldao.close();
	}
}
