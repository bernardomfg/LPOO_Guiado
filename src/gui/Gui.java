package gui;

import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;

import logic.Drake;
import logic.Game;
import logic.Hero;
import logic.Maze;
import logic.Sword;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;


public class Gui {

	private JFrame frame;

	public static int N = 0;
	public static int dN = 0;
	public static ArrayList<Drake> d = new ArrayList<Drake>();
	public static Maze m = new Maze();
	public static Hero h = new Hero();
	public static Sword s = new Sword();
	public static String mov;
	public static Boolean gameOver = false;

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
		final JPanel gamePanel = new JPanel();

		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel.setVisible(false);
		//frame.getContentPane().add(gamePanel);
		gamePanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		gamePanel.add(lblNewLabel);

		JButton btnNewButton = new JButton("Novo Jogo");
		btnNewButton.setBounds(252, 607, 478, 85);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				SelectMode chooseButton = new SelectMode();
				chooseButton
						.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
				chooseButton.setVisible(true);
				
				createPanel(gamePanel);
				/*gamePanel.setVisible(true);
				gamePanel.setLayout(new GridLayout(N, N, 0, 0));*/
				frame.repaint();
				

			}


		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);

	}
	
	private void createPanel(JPanel gamePanel) {
		
		gamePanel.setVisible(true);
		gamePanel.setLayout(new GridLayout(N, N, 0, 0));
		frame.getContentPane().add(gamePanel);
		
	}
	
}
