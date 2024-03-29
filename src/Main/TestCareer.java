package Main;

public class TestCareer {
	public int id, matches, runs, wickets;
	public double batting_avg, bowling_avg, batting_sr, bowling_sr;
	public boolean isIDSet;
	public int innings;

	public TestCareer(int i, int m, int r, int w, int inn, double bta, double boa, double bts, double bos) {
		isIDSet = true;
		id = i;
		matches = m;
		runs = r;
		wickets = w;
		batting_avg = bta;
		bowling_avg = boa;
		batting_sr = bts;
		bowling_sr = bos;
		innings = inn;
	}

	public TestCareer(int m, int r, int w, int inn, double bta, double boa, double bts, double bos) {
		isIDSet = false;
		id = -1;
		matches = m;
		runs = r;
		wickets = w;
		batting_avg = bta;
		bowling_avg = boa;
		batting_sr = bts;
		bowling_sr = bos;
		innings = inn;
	}

	public TestCareer(int m, int r, int w, int inn, double boa, double bts, double bos) {
		isIDSet = false;
		id = -1;
		matches = m;
		runs = r;
		wickets = w;
		bowling_avg = boa;
		batting_sr = bts;
		bowling_sr = bos;
		innings = inn;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return id + " " + matches + " " + runs + " " + wickets + " " + batting_avg + " " + bowling_avg + " "
				+ batting_sr + " " + bowling_sr + " " + innings;
	}
}
