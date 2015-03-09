package src;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Team {
	long sum = 0;
	int stackAmount = 0;
	long startTime;
	long endTime;
	long average = 0;
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
		if(stackAmount==0){
			average = Long.MAX_VALUE;
		} else {
			average = sum/stackAmount;
		}
	}
	
	public void save() {
		endTime = System.currentTimeMillis();
		matchNumber = gui.matchNumberField.getText();
		teamNumber = gui.teamNumberInputField.getText();
		alliance = gui.alliancePicker.getSelectedItem().toString();
		indvPts = gui.indivPointsInput.getText();
		totalPts = gui.totalPointsField.getText();
		AVGTimeBtw = Long.toString(average/1000);
		bin = Boolean.toString(gui.binBox.isSelected());
		Automode = gui.autoTypePicker.getSelectedItem().toString();
		vision = Boolean.toString(gui.visionBox.isSelected());
		litter = Boolean.toString(gui.litterBox.isSelected());
		highest = gui.incrementStackButton.getText();
		humanPlay = gui.humanPlayerPicker.getSelectedItem().toString();
		malfunctions = Boolean.toString(gui.malfunctionButton.isSelected());
		reliability = Integer.toString(gui.reliabilitySlider.getValue());
		if(matchNumber.equals("") || teamNumber.equals("") || indvPts.equals("") || totalPts.equals("")){
			JFrame frame = new JFrame("Alert!");
			frame.setVisible(true);
			JLabel label = new JLabel("There are required fields that are blank.");
			frame.add(label, BorderLayout.NORTH);
			JButton button = new JButton("OK");
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			frame.add(button,BorderLayout.SOUTH);
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			return;
		}
		
		MatchData.writeXML.write(matchNumber, teamNumber, alliance, indvPts, totalPts, AVGTimeBtw, bin, Automode, vision, litter, highest, humanPlay, malfunctions, reliability);
		// reset the buttons
		gui.incrementStackButton.setName("0");
		gui.incrementStackButton.setText("0");
		gui.malfunctionButton.setSelected(false);
	}

	public Team(GUI gui) {
		this.gui = gui;
	}
}
