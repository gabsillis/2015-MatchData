import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
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

	//Panel for main GUI
	public JPanel GUIPanel = new JPanel();
	// Panel for comment box because gridbag is just annoying
	public JPanel commentPanel = new JPanel();
	
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
	public JLabel commentsLabel = new JLabel("Comments");

	// Inputs
	public JTextField teamNumberInputField = new JTextField(4);
	public JTextField matchNumberField = new JTextField(4);
	// TextArea start
	public JTextArea comments = new JTextArea(10,15);
	public JScrollPane commentContainer = new JScrollPane(comments);
	//TextArea End
	public JComboBox<String> alliancePicker = new JComboBox<String>(ALLIANCE_COLORS);
	public JCheckBox binBox = new JCheckBox();
	public JCheckBox visionBox = new JCheckBox();
	public JCheckBox litterBox = new JCheckBox();
	public JTextField indivPointsInput = new JTextField(15);
	public JTextField totalPointsField = new JTextField(15);
	public JButton incrementStackButton = new JButton("0");
	public JComboBox<String> humanPlayerPicker = new JComboBox<String>(HUMAN_PLAYER_LEVELS);
	public JComboBox<String> autoTypePicker = new JComboBox<String>(AUTO_TYPES);
	public JToggleButton malfunctionButton = new JToggleButton("MALFUNCTION");
	public JButton stackTimer = new JButton("STACKED A TOTE/BIN!");
	public JButton matchStart = new JButton("Start Match!");
	public JButton matchEnd = new JButton("Match over");
	public JButton save = new JButton("Save Data/Match");
	public JSlider reliabilitySlider = new JSlider(MIN_RELIABILITY, MAX_RELIABILITY);

	public GUI() {
		// make the team
		team = new Team(this);
		// make the window
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame window = new JFrame("Match Data");
		window.setSize(1000, 700);
		window.setVisible(true);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setIconImage(new ImageIcon("robodog.png").getImage());
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		GUIPanel.setLayout(layout);
		// EVENT LISTENERS
		incrementStackButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((JButton) e.getSource()).setText(Integer.toString(Integer
						.parseInt(((JButton) e.getSource()).getText()) + 1));
			}
		});
		incrementStackButton.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)){
					((JButton) e.getSource()).setText(Integer.toString(Integer.parseInt(((JButton) e.getSource()).getText()) - 1));
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		stackTimer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				team.timeStack();
			}
		});
		
		matchStart.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				team.start();
			}			
		});
		
		matchEnd.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				team.end();
			}
		});
		
		save.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				team.save();
				
			}
			
		});
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		GUIPanel.add(teamNumLabel, gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		GUIPanel.add(teamNumberInputField, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;
		GUIPanel.add(matchNumLabel, gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		GUIPanel.add(matchNumberField, gbc);
		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.EAST;
		GUIPanel.add(allianceLabel, gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		GUIPanel.add(alliancePicker, gbc);
		gbc.gridy = 3;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		GUIPanel.add(binLabel, gbc);
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.EAST;
		GUIPanel.add(binBox, gbc);
		gbc.gridy = 4;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		GUIPanel.add(visionLabel, gbc);
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.EAST;
		GUIPanel.add(visionBox, gbc);
		gbc.gridy = 5;
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		GUIPanel.add(litterLabel, gbc);
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.EAST;
		GUIPanel.add(litterBox, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		GUIPanel.add(indivPointsLabel, gbc);
		gbc.gridy = 1;
		GUIPanel.add(indivPointsInput, gbc);
		gbc.gridx = 3;
		gbc.gridy = 0;
		GUIPanel.add(totalPointsLabel, gbc);
		gbc.gridy = 1;
		GUIPanel.add(totalPointsField, gbc);
		gbc.gridy = 3;
		gbc.gridx = 3;
		GUIPanel.add(incrementStackButton, gbc);
		gbc.gridx = 3;
		gbc.gridy = 5;
		stackTimer.setBackground(Color.GREEN);
		GUIPanel.add(stackTimer,gbc);
		gbc.gridy = 2;
		gbc.gridx = 3;
		GUIPanel.add(highestStackLabel, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		GUIPanel.add(humanPlayerPicker, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		GUIPanel.add(humanPlayerLabel,gbc);
		gbc.gridx = 2;
		gbc.gridy = 4;
		GUIPanel.add(autoTypeLabel, gbc);
		gbc.gridx = 2;
		gbc.gridy = 5;
		GUIPanel.add(autoTypePicker, gbc);
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
		GUIPanel.add(malfunctionButton, gbc);
		gbc.gridy = 3;
		reliabilitySlider.setSnapToTicks(true);
		reliabilitySlider.setMajorTickSpacing(1);
		reliabilitySlider.setPaintTicks(true);
		reliabilitySlider.setPaintLabels(true);
		GUIPanel.add(reliabilitySlider, gbc);
		gbc.gridy = 2;
		GUIPanel.add(reliabilityLabel, gbc);
		gbc.gridx = 4;
		gbc.gridy = 0;
		GUIPanel.add(save,gbc);
		gbc.gridx = 5;
		gbc.gridy = 0;
		GUIPanel.add(matchStart, gbc);
		gbc.gridx = 5;
		gbc.gridy = 2;
		GUIPanel.add(matchEnd, gbc);

		
		// commentPanel stuff
		commentPanel.setPreferredSize(new Dimension(800,200));
		commentPanel.add(commentsLabel,BorderLayout.NORTH);
		commentContainer.setPreferredSize(new Dimension(800,150));
		commentPanel.add(commentContainer,BorderLayout.SOUTH);
		// Border Layout for the GUIPanel and commentPanel top bottom respectively
		window.add(GUIPanel,BorderLayout.PAGE_START);
		window.add(commentPanel,BorderLayout.PAGE_END);
		window.pack();
		window.setLocationRelativeTo(null);
	}
}