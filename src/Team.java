import java.util.ArrayList;
import java.util.function.Consumer;

import javafx.css.ParsedValue;

import javax.xml.parsers.ParserConfigurationException;

public class Team {
	long sum = 0;
	int stackAmount = 0;
	long startTime;
	long endTime;
	String matchNumber, teamNumber, alliance, indvPts, totalPts, AVGTimeBtw, bin, Automode, vision, litter, highest, humanPlay, malfunctions, reliability;
	public long lastStackTime;
	public ArrayList<Long> stackTimes = new ArrayList<Long>();
	GUI gui;
	public void start() {
		startTime = System.currentTimeMillis();
		lastStackTime = System.currentTimeMillis();
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
	public void timeStack(){
		long stackTime = System.currentTimeMillis() - lastStackTime;
		stackTimes.add(stackTime);
	}

	public void end() {
		stackTimes.forEach(new Consumer<Long>() {
			@Override
			public void accept(Long t) {
				sum = sum + t;	
				stackAmount = stackAmount + 1;
			}
		});
		long average = 0;
		if(stackAmount==0){
			average = Long.MAX_VALUE;
		} else {
			average = sum/stackAmount;
		}
		endTime = System.currentTimeMillis();
		matchNumber = gui.matchNumberField.getText();
		teamNumber = gui.teamNumberInputField.getText();
		alliance = gui.alliancePicker.getSelectedItem().toString();
		indvPts = gui.indivPointsInput.getText();
		totalPts = gui.totalPointsField.getText();
		AVGTimeBtw = Long.toString(average);
		bin = Boolean.toString(gui.binBox.isSelected());
		Automode = gui.autoTypePicker.getSelectedItem().toString();
		vision = Boolean.toString(gui.visionBox.isSelected());
		litter = Boolean.toString(gui.litterBox.isSelected());
		highest = gui.incrementStackButton.getText();
		humanPlay = gui.humanPlayerPicker.getSelectedItem().toString();
		malfunctions = Boolean.toString(gui.malfunctionButton.isSelected());
		reliability = Integer.toString(gui.reliabilitySlider.getValue());
		MatchData.writeXML.write(matchNumber, teamNumber, alliance, indvPts, totalPts, AVGTimeBtw, bin, Automode, vision, litter, highest, humanPlay, malfunctions, reliability);
		// reset the buttons
		gui.incrementStackButton.setName("0");
		gui.malfunctionButton.setSelected(false);
	}

	public Team(GUI gui) {
		this.gui = gui;
	}
}
