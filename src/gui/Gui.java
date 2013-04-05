package gui;

import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;

import logic.Drake;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Creates Game panel

		JPanel panelGame = new JPanel();
		panelGame.setBounds(144, 0, 455, 370);
		frame.getContentPane().add(panelGame);
		panelGame.setLayout(new GridLayout(1, 0, 0, 0));
		
		//Creates menu panel
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 134, 371);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(new GridLayout(0, 1, 0, 0));
		
		//New Game button actions
		
		JButton btnNovoJogo = new JButton("New Game");
		panelMenu.add(btnNovoJogo);
		btnNovoJogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectMode chooseButton = new SelectMode();
				chooseButton.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
				chooseButton.setVisible(true);
				frame.repaint();
				
			}
		});

		//Load button actions
		
		JButton btnCarregar = new JButton("Load Game");
		panelMenu.add(btnCarregar);

		//Save button actions
		
		JButton btnGravar = new JButton("Save Game");
		panelMenu.add(btnGravar);

		//Create button actions
		
		JButton btnCriar = new JButton("Create Maze");
		panelMenu.add(btnCriar);

		//Exit button actions
		
		JButton btnSair = new JButton("Exit");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		panelMenu.add(btnSair);


	}

}
