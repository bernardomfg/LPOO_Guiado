package gui;

import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import logic.Game;
import logic.Hero;
import logic.Maze;
import logic.Sword;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButtonMenuItem;

public class Gui {

	private JFrame frame;
	private JDialog dialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Maze m = new Maze();
		Hero h = new Hero();
		Sword s = new Sword();
		String mov;
		Boolean gameOver = false;
		
	
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 819, 548);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				SelectMode chooseButton = new SelectMode();
				chooseButton.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
				chooseButton.setVisible(true);
			}
		});
		btnNewButton.setBounds(321, 444, 147, 51);
		frame.getContentPane().add(btnNewButton);
		
		
		
			
		

	}
}
