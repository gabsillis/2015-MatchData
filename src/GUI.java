import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

public class GUI {
	static final int MAX_RELIABILITY = 10;
	static final int MIN_RELIABILITY = 0;

	public static final String[] ALLIANCE_COLORS = { "Blue", "Red" };

	public static final String[] HUMAN_PLAYER_LEVELS = { "Great", "Good",
			"Bad", "Horrible", "n/a" };

	public static final String[] AUTO_TYPES = { "Push Tote", "Push Bin",
			"Tote & Bin", "Bin from centerr", "Stack", "Drive Forward" };

	public Team team;

	// Labels
	public JLabel teamNumLabel = new JLabel("Team Number");
	public JLabel matchNumLabel = new JLabel("Match Number");
	public JLabel allianceLabel = new JLabel("Alliance");
	public JLabel binLabel = new JLabel("Bin Capable");
	public JLabel visionLabel = new JLabel("Vision");
	public JLabel litterLabel = new JLabel("Litter");
	public JLabel indivPointsLabel = new JLabel("Individual Points Scored");
	public JLabel totalPointsLabel = new JLabel("Total Points Scored");
	public JLabel highestStackLabel = new JLabel("Highest Stack");
	public JLabel humanPlayerLabel = new JLabel("Human Player");
	public JLabel autoTypeLabel = new JLabel("Autonomous Type");
	public JLabel reliabilityLabel = new JLabel("Reliablility");

	// Inputs
	public JTextField teamNumberInputField = new JTextField(4);
	public JTextField matchNumberField = new JTextField(4);
	public JComboBox<String> alliancePicker = new JComboBox<String>(
			ALLIANCE_COLORS);
	public JCheckBox binBox = new JCheckBox();
	public JCheckBox visionBox = new JCheckBox();
	public JCheckBox litterBox = new JCheckBox();
	public JTextField indivPointsInput = new JTextField(15);
	public JTextField totalPointsField = new JTextField(15);
	public JButton incrementStackButton = new JButton("0");
	public JComboBox<String> humanPlayerPicker = new JComboBox<String>(
			HUMAN_PLAYER_LEVELS);
	public JComboBox<String> autoTypePicker = new JComboBox<String>(AUTO_TYPES);
	public JToggleButton malfunctionButton = new JToggleButton("MALFUNCTION");
	public JSlider reliabilitySlider = new JSlider(MIN_RELIABILITY, MAX_RELIABILITY);

	public GUI() {
		// make the team
		team = new Team();
		// make the window
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame window = new JFrame("Match Data");
		window.setSize(1000, 700);
		window.setVisible(true);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setIconImage(new ImageIcon("robodog.png").getImage());
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		window.setLayout(layout);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		window.add(teamNumLabel, gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		window.add(teamNumberInputField, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;
		window.add(matchNumLabel, gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		window.add(matchNumberField, gbc);
		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.EAST;
		window.add(allianceLabel, gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		window.add(alliancePicker, gbc);
		gbc.gridy = 3;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		window.add(binLabel, gbc);
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.EAST;
		window.add(binBox, gbc);
		gbc.gridy = 4;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		window.add(visionLabel, gbc);
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.EAST;
		window.add(visionBox, gbc);
		gbc.gridy = 5;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		window.add(litterLabel, gbc);
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.EAST;
		window.add(litterBox, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		window.add(indivPointsLabel, gbc);
		gbc.gridy = 1;
		window.add(indivPointsInput, gbc);
		gbc.gridx = 3;
		gbc.gridy = 0;
		window.add(totalPointsLabel, gbc);
		gbc.gridy = 1;
		window.add(totalPointsField, gbc);
		gbc.gridy = 2;
		gbc.gridx = 2;
		window.add(highestStackLabel, gbc);
		gbc.gridy = 3;
		incrementStackButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((JButton) e.getSource()).setText(Integer.toString(Integer
						.parseInt(((JButton) e.getSource()).getText()) + 1));
			}
		});
		window.add(incrementStackButton, gbc);
		gbc.gridy = 4;
		gbc.gridx = 2;
		window.add(highestStackLabel, gbc);
		gbc.gridy = 5;
		window.add(humanPlayerPicker, gbc);
		gbc.gridy = 4;
		gbc.gridx = 3;
		window.add(autoTypeLabel, gbc);
			gbc.gridy = 5;
		window.add(autoTypePicker, gbc);
		gbc.gridx = 4;
		malfunctionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JToggleButton button = (JToggleButton) e.getSource();
				if(!button.isSelected()){
					button.setSelected(true);
				}
			}
		});
		malfunctionButton.setBackground(Color.RED);
		window.add(malfunctionButton, gbc);
		gbc.gridy = 3;
		reliabilitySlider.setSnapToTicks(true);
		reliabilitySlider.setMajorTickSpacing(1);
		reliabilitySlider.setPaintTicks(true);
		reliabilitySlider.setPaintLabels(true);
		window.add(reliabilitySlider, gbc);
		gbc.gridy = 2;
		window.add(reliabilityLabel, gbc);
		window.pack();
		window.setLocationRelativeTo(null);
	}
}
