package com.xavient.swing;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Find extends JFrame implements ActionListener {

	JFrame f;
	Component frame = null;
	JButton findNext, Cancel;
	JLabel findWhat;
	JTextField find;
	JCheckBox matchCase;
	JRadioButton up, down;
	JPanel Direction;
	ButtonGroup bg;

	public Find() {
		super("Find");
		findWhat = new JLabel("Find what:");
		findWhat.setBounds(10, 15, 50, 20);
		findWhat.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		add(findWhat);

		find = new JTextField();
		find.setBounds(75, 15, 185, 20);
		add(find);

		findNext = new JButton("Find Next");
		findNext.setBounds(265, 15, 83, 20);
		//findNext.setEnabled(find.getText().length()!= 0);
		findNext.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		findNext.addActionListener(this);
		add(findNext);

		matchCase = new JCheckBox("Match case");
		matchCase.setBounds(5, 80, 120, 15);
		matchCase.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		matchCase.addActionListener(this);
		add(matchCase);

		bg = new ButtonGroup();
		up = new JRadioButton("Up");
		up.setBounds(10, 10, 50, 10);
		up.setFont(new Font("Arial Narrow", Font.PLAIN, 13));

		down = new JRadioButton("Down");
		down.setBounds(45, 10, 50, 10);
		down.setSelected(true);
		down.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		bg.add(up);
		bg.add(down);

		Direction = new JPanel();
		Direction.setBounds(130, 48, 125, 45);
		Direction.add(up);
		Direction.add(down);
		Direction.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		Direction.setBorder(BorderFactory.createTitledBorder("Direction"));
		Direction.setLayout(new BoxLayout(Direction, BoxLayout.X_AXIS));
		Direction.setAlignmentX(Component.RIGHT_ALIGNMENT);
		add(Direction);

		Cancel = new JButton("Cancel");
		Cancel.setBounds(265, 45, 83, 20);
		Cancel.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		Cancel.addActionListener(this);
		add(Cancel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(370, 150);
		setVisible(true);
	}	

	public void actionPerformed(ActionEvent e) {
		
		String findText = find.getText();
		if (findText.equals("")) {
			findNext.setEnabled(false);
		} else {
			findNext.setEnabled(true);
		}

		if (e.getSource() == Cancel) {
			dispose();
			System.out.println("Cancel Button Clicked");
		}
		if (e.getSource() == findNext) {
			if (down.isSelected() && matchCase.isSelected()) {

				JOptionPane.showMessageDialog(frame,"Down and Match Case is Selected:");
			}else if (up.isSelected() && matchCase.isSelected()) {

				JOptionPane.showMessageDialog(frame,"Up and Match Case is Selected:");
			}			
			else if (up.isSelected()) {

				JOptionPane.showMessageDialog(frame, "Only Up is Selected:");
			}  else if (down.isSelected()) {

				JOptionPane.showMessageDialog(frame, "Only Down is Selected:");
			}

			System.out.println("Find Next Button Clicked");
		}
	}

	public static void main(String[] args) {
		new Find();
	}	
	
}
