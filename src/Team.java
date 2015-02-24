public class Team {
	long startTime;
	long endTime;
	String matchNumber, teamNumber, alliance, indvPts, totalPts, AVGTimeBtw, bin, Automode, vision, litter, highest, humanPlay, malfunctions, reliability;
	
	public void start() {
		startTime = System.currentTimeMillis();
		matchNumber = "";
		teamNumber = "";
		alliance = "";
		indvPts = "";
		AVGTimeBtw = "";
		bin = "";
		Automode = "";
		vision = "";
		litter = "";
		highest = "";
		humanPlay = "";
		malfunctions = "";
		reliability = "";		
	}

	public void end() {
		endTime = System.currentTimeMillis();
	}

	public Team() {
		
	}
}
