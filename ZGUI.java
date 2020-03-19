package zulrah;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import zulrah.ZulrahMain;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;

public class ZGUI extends JFrame {
public ZulrahMain ctx;
	private JPanel contentPane;

	public ZGUI(ZulrahMain main) {
		this.ctx = main;
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				Util.hptoeat = (int) spinner.getValue();
				System.out.println(Util.hptoeat);
			}
		});
		spinner.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {

			}
		});
		spinner.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		spinner.setBounds(12, 81, 76, 22);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Util.praytopot = (int) spinner_1.getValue();
				System.out.println(Util.praytopot);
			}
		});
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		spinner_1.setBounds(12, 160, 76, 22);
		contentPane.add(spinner_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Ranging pot(4)?");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Util.rpot = !Util.rpot;
				System.out.print(Util.rpot);
			}
		});
		chckbxNewCheckBox.setBounds(8, 204, 157, 25);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("When to eat:");
		lblNewLabel.setBounds(12, 55, 109, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("When to drink pray:");
		lblNewLabel_1.setBounds(12, 131, 133, 16);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBox.getSelectedIndex() == 0) {
					Util.food = "Shark";
				}
				
				if(comboBox.getSelectedIndex() == 1) {
					Util.food = "Manta ray";
				}
				
				if(comboBox.getSelectedIndex() == 2) {
					Util.food = "Lobster";
				}
				
				if(comboBox.getSelectedIndex() == 3) {
					Util.food = "Tuna";
				}
				
				System.out.println("Cbox = "+comboBox.getSelectedIndex());
				System.out.println(Util.food);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Shark", "Manta Ray", "Lobster", "Tuna"}));
		comboBox.setBounds(114, 81, 76, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ZulrahMain.started = true;
				System.out.println(ZulrahMain.started);
				dispose();
				
			}
		});
		btnNewButton.setBounds(100, 170, 97, 25);
		contentPane.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Rigour?");
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Util.rigour = true;
				System.out.println("Rigour: "+ Util.rigour);
			}
		});
		chckbxNewCheckBox_1.setBounds(8, 21, 113, 25);
		contentPane.add(chckbxNewCheckBox_1);
	}
}
