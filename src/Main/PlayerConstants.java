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
}
