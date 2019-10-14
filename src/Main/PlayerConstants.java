package Main;

public final class PlayerConstants {
	public static final int MAX_ROLES = 4;
	public static final int MAX_BATTING_STYLE = 2;
	public static final int MAX_BOWLING_STYLE = 4;
	public static final int MAX_COUNTRIES = 10;
	public static final int MIN_ROLES = 0;
	public static final int MIN_BATTING_STYLE = 0;
	public static final int MIN_BOWLING_STYLE = 0;
	public static final int MIN_COUNTRIES = 0;

	public static class Role {
		public static final int ANYTHING = 0;
		public static final int BATSMAN = 1;
		public static final int BOWLER = 2;
		public static final int BATTING_ALLROUNDER = 3;
		public static final int BOWLING_ALLROUNDER = 4;
	}

	public static class BattingStyle {
		public static final int ANYTHING = 0;
		public static final int RIGHT_HANDED = 1;
		public static final int LEFT_HANDED = 2;
	}

	public static class BowlingStyle {
		public static final int ANYTHING = 0;
		public static final int RIGHT_PACER = 1;
		public static final int RIGHT_SPINNER = 2;
		public static final int LEFT_PACER = 3;
		public static final int LEFT_SPINNER = 4;
	}

	public static class Country {
		public static final int ANYTHING = 0;
		public static final int INDIA = 1;
		public static final int AUSTRALIA = 2;
		public static final int ENGLAND = 3;
		public static final int SOUTH_AFRICA = 4;
		public static final int NEW_ZEALAND = 5;
		public static final int PAKISTAN = 6;
		public static final int SRI_LANKA = 7;
		public static final int WEST_INDIES = 8;
		public static final int BANGLADESH = 9;
		public static final int AFGHANISTAN = 10;
	}

	public static class League {
		public static final int IPL = 1;
		public static final int BBL = 2;
		public static final int CPL = 3;
		public static final int TBL = 4;
	}

	public static class Team {
		public static final int RCB = 1;
		public static final int CSK = 2;
		public static final int MI = 3;
		public static final int SRH = 4;
		public static final int KXIP = 5;
		public static final int RR = 6;
		public static final int DC = 7;
		public static final int KKR = 8;
		public static final int ST = 1;
		public static final int SS = 2;
		public static final int MS = 3;
		public static final int MR = 4;
		public static final int PS = 5;
		public static final int BH = 6;
		public static final int AS = 7;
		public static final int HH = 8;
		public static final int TKR = 1;
		public static final int JT = 2;
		public static final int GAW = 3;
		public static final int SNP = 4;
		public static final int BT = 5;
		public static final int STZ = 6;
		public static final int SOM = 1;
		public static final int GLO = 2;
		public static final int WAR = 3;
		public static final int LEIS = 4;
		public static final int ESS = 5;
		public static final int YOR = 6;
		public static final int DUR = 7;
		public static final int HAM = 8;
		public static final int MIDL = 9;
		public static final int LAN = 10;
		public static final int KEN = 11;
		public static final int SUS = 12;
		public static final int SUR = 13;
		public static final int WARC = 14;
	}

	public static String getRole(int role) {
		String s = "";
		switch (role) {
		case Role.BATSMAN:
			s = "Batsman";
			break;
		case Role.BOWLER:
			s = "Bowler";
			break;
		case Role.BATTING_ALLROUNDER:
			s = "Batting Allrounder";
			break;
		case Role.BOWLING_ALLROUNDER:
			s = "Bowling Allrounder";
			break;
		default:
			throw new IllegalArgumentException("role is invalid. role: " + role);
		}
		return s;
	}

	public static String getCountry(int country) {
		String s = "";
		switch (country) {
		case Country.AFGHANISTAN:
			s = "AFGHANISTAN";
			break;
		case Country.AUSTRALIA:
			s = "AUSTRALIA";
			break;
		case Country.BANGLADESH:
			s = "BANGLADESH";
			break;
		case Country.ENGLAND:
			s = "ENGLAND";
			break;
		case Country.INDIA:
			s = "INDIA";
			break;
		case Country.NEW_ZEALAND:
			s = "NEW ZEALAND";
			break;
		case Country.PAKISTAN:
			s = "PAKISTAN";
			break;
		case Country.SOUTH_AFRICA:
			s = "SOUTH AFRICA";
			break;
		case Country.SRI_LANKA:
			s = "SRI LANKA";
			break;
		case Country.WEST_INDIES:
			s = "WEST INDIES";
			break;
		default:
			throw new IllegalArgumentException("Country is invalid. Country: " + country);
		}
		return s;
	}

	public static String getBattingStyle(int bs) {
		String s = null;
		switch (bs) {
		case BattingStyle.LEFT_HANDED:
			s = "LEFT HANDED";
			break;
		case BattingStyle.RIGHT_HANDED:
			s = "RIGHT HANDED";
			break;

		default:
			throw new IllegalArgumentException("Batting Style is invalid. BattingStyle: " + bs);
		}
		return s;
	}

	public static String getBowlingStyle(int bs) {
		String s = null;
		switch (bs) {
		case BowlingStyle.LEFT_PACER:
			s = "LEFT PACER";
			break;
		case BowlingStyle.LEFT_SPINNER:
			s = "LEFT SPINNER";
			break;
		case BowlingStyle.RIGHT_PACER:
			s = "RIGHT PACER";
			break;
		case BowlingStyle.RIGHT_SPINNER:
			s = "RIGHT SPINNER";
			break;
		default:
			throw new IllegalArgumentException("Bowling Style is invalid. BowlingStyle: " + bs);
		}
		return s;
	}

	public static String getLeague(int lid) {
		String s = null;
		switch (lid) {
		case League.IPL:
			s = "IPL";
			break;
		case League.BBL:
			s = "BBL";
			break;
		case League.CPL:
			s = "CPL";
			break;
		case League.TBL:
			s = "TBL";
			break;
		}
		return s;
	}

	public static String getTeam(int lid, int tid) {
		String s = null;
		switch (lid) {
		case League.IPL:
			s = getIPLTeam(tid);
			break;
		case League.BBL:
			s = getBBLTeam(tid);
		case League.CPL:
			s = getCPLTeam(tid);
		case League.TBL:
			s = getTBLTeam(tid);
		}
		return s;
	}

	private static String getIPLTeam(int tid) {
		String s = null;
		switch (tid) {
		case Team.RCB:
			s = "RCB";
			break;
		case Team.CSK:
			s = "CSK";
			break;
		case Team.MI:
			s = "MI";
		case Team.SRH:
			s = "SRH";
			break;
		case Team.KXIP:
			s = "KXIP";
		case Team.RR:
			s = "RR";
			break;
		case Team.DC:
			s = "DC";
			break;
		case Team.KKR:
			s = "KKR";
			break;
		}
		return s;
	}

	private static String getBBLTeam(int tid) {
		String s = null;
		switch (tid) {
		case Team.ST:
			s = "ST";
			break;
		case Team.SS:
			s = "SS";
			break;
		case Team.MS:
			s = "MS";
			break;
		case Team.MR:
			s = "MR";
			break;
		case Team.PS:
			s = "PS";
			break;
		case Team.BH:
			s = "BH";
			break;
		case Team.AS:
			s = "AS";
			break;
		}
		return s;
	}

	private static String getCPLTeam(int tid) {
		String s = null;
		switch (tid) {
		case Team.TKR:
			s = "TKR";
			break;
		case Team.JT:
			s = "BT";
			break;
		case Team.GAW:
			s = "GAW";
			break;
		case Team.SNP:
			s = "SNP";
			break;
		case Team.BT:
			s = "BT";
			break;
		case Team.STZ:
			s = "STZ";
			break;
		}
		return s;
	}

	private static String getTBLTeam(int tid) {
		String s = null;
		switch (tid) {
		case Team.SOM:
			s = "SOM";
			break;
		case Team.GLO:
			s = "GLO";
			break;
		case Team.WAR:
			s = "WAR";
			break;
		case Team.LEIS:
			s = "LEIS";
			break;
		case Team.DUR:
			s = "DUR";
			break;
		case Team.ESS:
			s = "ESS";
			break;
		case Team.HAM:
			s = "HAM";
			break;
		case Team.KEN:
			s = "KENT";
			break;
		case Team.LAN:
			s = "LAN";
			break;
		case Team.MIDL:
			s = "MIDL";
			break;
		case Team.SUR:
			s = "SUR";
			break;
		case Team.SUS:
			s = "SUS";
			break;
		case Team.WARC:
			s = "WARC";
			break;
		case Team.YOR:
			s = "YORK";
			break;
		}
		return s;
	}
}
