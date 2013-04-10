package gui;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

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

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.Serializable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Gui implements Serializable {

	private JFrame frame;
	public static JPanel panelGame = new JPanel();

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
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		final JPanel panelCreate = new JPanel();
		// frame.getContentPane().add(panelCreate, BorderLayout.NORTH);
		panelCreate.setLayout(new GridLayout(0, 1, 0, 0));
		panelCreate.setVisible(false);
		panelCreate.setPreferredSize(new Dimension(50, 150));

		userBuildMenu(panelCreate);
		
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
					texturesLoader.paintMaze(m.getMaze(), h, d, s);
					panelGame.revalidate();
					panelGame.repaint();
					break;

				case KeyEvent.VK_S:
					Game.play("s", h, s, m, d);
					panelGame.removeAll();
					texturesLoader.paintMaze(m.getMaze(), h, d, s);
					panelGame.revalidate();
					panelGame.repaint();
					break;

				case KeyEvent.VK_A:
					Game.play("a", h, s, m, d);
					panelGame.removeAll();
					texturesLoader.paintMaze(m.getMaze(), h, d, s);
					panelGame.revalidate();
					panelGame.repaint();
					break;

				case KeyEvent.VK_D:
					Game.play("d", h, s, m, d);
					panelGame.removeAll();
					texturesLoader.paintMaze(m.getMaze(), h, d, s);
					panelGame.revalidate();
					panelGame.repaint();
					break;

				case KeyEvent.VK_L:
					Game.play("l", h, s, m, d);
					panelGame.removeAll();
					texturesLoader.paintMaze(m.getMaze(), h, d, s);
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

					wonGame won = new wonGame();
					won.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
					won.setVisible(true);
				}

			}
		});

		// Creates menu panel

		final JPanel panelMenu = new JPanel();
		frame.getContentPane().add(panelMenu, BorderLayout.WEST);
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
				SelectMode chooseButton = new SelectMode();
				chooseButton
						.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
				chooseButton.setVisible(true);
				if (N % 2 == 0 && N != 0)
					N--;
				if (N == 0)
					panelGame.setLayout(new GridLayout(10, 10, 0, 0));
				else
					panelGame.setLayout(new GridLayout(N, N, 0, 0));
				panelGame.setBorder(null);
				texturesLoader.paintMaze(m.getMaze(), h, d, s);
				panelGame.revalidate();
				panelGame.repaint();
			}
		});

		// Load button actions

		JButton btnCarregar = new JButton("Load Game");
		btnCarregar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings({ "resource", "unchecked" })
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ObjectInputStream load = null;
				try {

					load = new ObjectInputStream(new FileInputStream(
							"MazeGame.dat"));
					N = (Integer) load.readObject();
					m = (Maze) load.readObject();
					h = (Hero) load.readObject();
					d = (ArrayList<Drake>) load.readObject();
					s = (Sword) load.readObject();
					if (d.size() != 0)
						Game.gameMode = d.get(0).sleeps;

					if (N == 0)
						panelGame.setLayout(new GridLayout(10, 10, 0, 0));
					else
						panelGame.setLayout(new GridLayout(N, N, 0, 0));
					panelGame.setBorder(null);
					texturesLoader.paintMaze(m.getMaze(), h, d, s);
					panelGame.revalidate();
					panelGame.repaint();
					panelGame.requestFocus();

				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					if (load != null)
						try {
							load.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
				}
			}
		});
		panelMenu.add(btnCarregar);

		// Save button actions

		JButton btnGravar = new JButton("Save Game");
		btnGravar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("resource")
			@Override
			public void mouseClicked(MouseEvent arg0) {

				ObjectOutputStream save = null;
				try {

					save = new ObjectOutputStream(new FileOutputStream(
							"MazeGame.dat"));
					save.writeObject(N);
					save.writeObject(m);
					save.writeObject(h);
					save.writeObject(d);
					save.writeObject(s);
					panelGame.requestFocus();

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (save != null)
						try {
							save.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
				}
			}
		});
		panelMenu.add(btnGravar);

		// Create button actions

		JButton btnCriar = new JButton("Create Maze");
		btnCriar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				panelMenu.setVisible(false);
				panelCreate.setVisible(true);
				frame.getContentPane().add(panelCreate, BorderLayout.WEST);
				panelCreate.revalidate();
				panelCreate.repaint();

			}
		});
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

	public void userBuildMenu(final JPanel panelCreate) {
		JLabel label = new JLabel("Size");
		panelCreate.add(label);

		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(7, 7, 50, 1));
		ChangeListener listener = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				panelGame.removeAll();
				
				N = (Integer) spinner.getValue();
				panelGame.setLayout(new GridLayout(N, N, 0, 0));
				panelCreate.revalidate();
				panelCreate.repaint();
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						
						panelGame.add(new gameTiles(texturesLoader.wallImg,' '));
					}
				}
				panelCreate.revalidate();
				panelCreate.repaint();

			}
		};
		spinner.addChangeListener(listener);
		panelCreate.add(spinner);

		gameTiles labelHero = new gameTiles(texturesLoader.heroImg,'H');
		panelCreate.add(labelHero);

		gameTiles labelDrake = new gameTiles(texturesLoader.drakeImg,'H');
		panelCreate.add(labelDrake);

		gameTiles labelSword = new gameTiles(texturesLoader.swordImg,'H');
		panelCreate.add(labelSword);

		gameTiles labelExit = new gameTiles(texturesLoader.exitImg,'H');
		panelCreate.add(labelExit);

		gameTiles labelBackground = new gameTiles(texturesLoader.backgroundImg,'H');
		panelCreate.add(labelBackground);
	}
}
