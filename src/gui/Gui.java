package gui;

import java.awt.Dialog;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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

import console.DisplayConsole;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class Gui {

	private JFrame frame;
	final JPanel panelGame = new JPanel();

	public static int N = 0;
	public static int dN = 0;
	public static ArrayList<Drake> d = new ArrayList<Drake>();
	public static Maze m = new Maze();
	public static Hero h = new Hero();
	public static Sword s = new Sword();
	public static String mov;

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
		frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {

				panelGame.requestFocus();
			}

			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Creates Game panel

		// final JPanel panelGame = new JPanel();
		panelGame.setBounds(138, 0, 461, 370);
		frame.getContentPane().add(panelGame);
		panelGame.setLayout(new GridLayout(1, 0, 0, 0));
		panelGame.setFocusable(true);

		panelGame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {

				// System.out.println("key\n");
				int key = arg0.getKeyCode();

				switch (key) {

				case KeyEvent.VK_W:
					Game.play("w", h, s, m, d);
					panelGame.removeAll();
					paintMaze(m.getMaze(), h, d, s);
					panelGame.revalidate();
					panelGame.repaint();
					break;

				case KeyEvent.VK_S:
					Game.play("s", h, s, m, d);
					panelGame.removeAll();
					paintMaze(m.getMaze(), h, d, s);
					panelGame.revalidate();
					panelGame.repaint();
					break;

				case KeyEvent.VK_A:
					Game.play("a", h, s, m, d);
					panelGame.removeAll();
					paintMaze(m.getMaze(), h, d, s);
					panelGame.revalidate();
					panelGame.repaint();
					break;

				case KeyEvent.VK_D:
					Game.play("d", h, s, m, d);
					panelGame.removeAll();
					paintMaze(m.getMaze(), h, d, s);
					panelGame.revalidate();
					panelGame.repaint();
					break;

				case KeyEvent.VK_L:
					Game.play("l", h, s, m, d);
					panelGame.removeAll();
					paintMaze(m.getMaze(), h, d, s);
					panelGame.revalidate();
					panelGame.repaint();
					break;

				}

				if (Game.checkDead(h, d)) {

					lostGame lost = new lostGame();
					lost.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
					lost.setVisible(true);

				}
				if (h.atExit) {
					// InterfaceConsole.wonTheGame();
				}

			}
		});

		// Creates menu panel

		final JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 134, 371);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(new GridLayout(0, 1, 0, 0));

		// New Game button actions

		final JButton btnNovoJogo = new JButton("New Game");
		panelMenu.add(btnNovoJogo);
		btnNovoJogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				N = 0;
				dN = 0;
				d = new ArrayList<Drake>();
				m = new Maze();
				h = new Hero();
				s = new Sword();
				panelGame.removeAll();
				panelGame.revalidate();
				SelectMode chooseButton = new SelectMode();
				chooseButton
						.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
				chooseButton.setVisible(true);
				panelGame.setLayout(new GridLayout(N, N, 0, 0));
				frame.setBounds(100, 100, 600 + N * 32, 400 + N * 32);
				panelGame.setBounds(144, 0, N * 32, N * 32);
				panelMenu.setBounds(0, 0, 134, 371 + N * 32);
				frame.repaint();
				paintMaze(m.getMaze(), h, d, s);
			}
		});

		// Load button actions

		JButton btnCarregar = new JButton("Load Game");
		panelMenu.add(btnCarregar);

		// Save button actions

		JButton btnGravar = new JButton("Save Game");
		panelMenu.add(btnGravar);

		// Create button actions

		JButton btnCriar = new JButton("Create Maze");
		panelMenu.add(btnCriar);

		// Exit button actions

		JButton btnSair = new JButton("Exit");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		panelMenu.add(btnSair);

	}

	public void paintMaze(char[][] maze, Hero h, ArrayList<Drake> d, Sword s) {

		char[][] temp = DisplayConsole.fillMaze(maze, h, d, s);
		BufferedImage heroImg = null;
		BufferedImage drakeImg = null;
		BufferedImage wallImg = null;
		BufferedImage eagleImg = null;
		BufferedImage exitImg = null;
		BufferedImage swordImg = null;
		BufferedImage superImg = null;
		BufferedImage backgroundImg = null;
		try {
			heroImg = ImageIO.read(new File("sprites\\goku.png"));

			drakeImg = ImageIO.read(new File("sprites\\cell.png"));
			wallImg = ImageIO.read(new File("sprites\\block.png"));
			eagleImg = ImageIO.read(new File("sprites\\cloud.png"));
			exitImg = ImageIO.read(new File("sprites\\chichi.png"));
			swordImg = ImageIO.read(new File("sprites\\dragonball.png"));
			superImg = ImageIO.read(new File("sprites\\gokuSayan.png"));
			backgroundImg = ImageIO.read(new File("sprites\\grass.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel labelBackground = null;
		JLabel labelHero = null;
		JLabel labelDrake = null;
		JLabel labelWall = null;
		JLabel labelEagle = null;
		JLabel labelExit = null;
		JLabel labelSword = null;

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {

				switch (temp[i][j]) {

				case 'H':
					labelHero = new JLabel(new ImageIcon(heroImg));
					panelGame.add(labelHero);
					break;

				case 'D':
				case 'd': // test
				case 'f':
				case 'F':
					labelDrake = new JLabel(new ImageIcon(drakeImg));
					panelGame.add(labelDrake);
					break;

				case 'P':
					labelEagle = new JLabel(new ImageIcon(eagleImg));
					panelGame.add(labelEagle);
					break;

				case 'E':
					labelSword = new JLabel(new ImageIcon(swordImg));
					panelGame.add(labelSword);
					break;

				case 'A':
					labelHero = new JLabel(new ImageIcon(superImg));
					panelGame.add(labelHero);
					break;

				case ' ':
					labelBackground = new JLabel(new ImageIcon(backgroundImg));
					panelGame.add(labelBackground);
					break;

				case 'X':
					labelWall = new JLabel(new ImageIcon(wallImg));
					panelGame.add(labelWall);
					break;

				case 'S':
					labelExit = new JLabel(new ImageIcon(exitImg));
					panelGame.add(labelExit);
					break;
				}
			}
		}

	}
}
