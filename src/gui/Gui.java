package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import logic.Drake;
import logic.Game;
import logic.Hero;
import logic.Maze;
import logic.Sword;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Gui implements Serializable {

	private JFrame frame;
	public static JPanel panelGame = new JPanel();
	public final JPanel panelMenu = new JPanel();
	public final JLabel lblMazeGame = new JLabel("Maze Game");
	public static final GameTile mainTheme = new GameTile(
			TextureLoader.mainTheme, 'b');

	public static boolean creating = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Gui window = new Gui();
				window.frame.setVisible(true);
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
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		//setting default keys

		KeyChanger.upKey = 87;
		KeyChanger.downKey = 83;
		KeyChanger.rightKey = 68;
		KeyChanger.leftKey = 65;
		KeyChanger.launchKey = 76;
		
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
		panelCreate.setLayout(new GridLayout(0, 1, 0, 0));
		panelCreate.setVisible(false);
		panelCreate.setPreferredSize(new Dimension(100, 150));

		userBuildMenu(panelCreate);

		panelGame.setLayout(new GridLayout(1, 0, 0, 0));
		panelGame.setFocusable(true);

		MovementListener moveListener = new MovementListener();
		panelGame.addKeyListener(moveListener);

		// Creates menu panel

		frame.getContentPane().add(panelMenu, BorderLayout.WEST);
		panelMenu.setLayout(new GridLayout(0, 1, 0, 0));
		panelGame.add(mainTheme);
		frame.getContentPane().add(panelGame);

		// New Game button actions

		final JButton btnNovoJogo = new JButton("New Game");
		btnNovoJogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				startGame();
			}
		});
		panelMenu.add(btnNovoJogo);

		// Load button actions

		JButton btnCarregar = new JButton("Load Game");
		btnCarregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				loadGame();
			}
		});
		panelMenu.add(btnCarregar);

		// Save button actions

		JButton btnGravar = new JButton("Save Game");
		btnGravar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				saveGame();
			}
		});
		panelMenu.add(btnGravar);

		// Create button actions

		JButton btnCriar = new JButton("Create Maze");
		btnCriar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				createMaze(panelCreate);
			}
		});
		panelMenu.add(btnCriar);

		// Create button change keys

		JButton btnKeys = new JButton("Change Keys");
		btnKeys.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				KeyChanger changeKeys = new KeyChanger();
				changeKeys.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
				changeKeys.setVisible(true);
				
				
			}
		});
		panelMenu.add(btnKeys);

		// Exit button actions

		JButton btnSair = new JButton("Exit");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				exit();
			}
		});
		panelMenu.add(btnSair);

		lblMazeGame.setHorizontalAlignment(SwingConstants.LEFT);
		lblMazeGame.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,
				2));
		frame.getContentPane().add(lblMazeGame, BorderLayout.SOUTH);

	}

	public void userBuildMenu(final JPanel panelCreate) {
		JLabel label = new JLabel("Size");
		panelCreate.add(label);

		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(7, 7, 50, 1));
		ChangeListener listener = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				TextureLoader.paintCreation(panelCreate, spinner);
			}
		};
		spinner.addChangeListener(listener);
		panelCreate.add(spinner);

		GameTile labelHero = new GameTile(TextureLoader.heroImg, 'H');
		panelCreate.add(labelHero);

		GameTile labelDrake = new GameTile(TextureLoader.drakeImg, 'D');
		panelCreate.add(labelDrake);

		GameTile labelSword = new GameTile(TextureLoader.swordImg, 'E');
		panelCreate.add(labelSword);

		GameTile labelExit = new GameTile(TextureLoader.exitImg, 'S');
		panelCreate.add(labelExit);

		GameTile labelBackground = new GameTile(TextureLoader.backgroundImg,
				' ');
		panelCreate.add(labelBackground);

		JButton btnCriar = new JButton("Criar");
		btnCriar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null,
						"Creating new game. Are you sure?");
				if (JOptionPane.YES_OPTION == resposta) {
					if (TextureLoader.hasExit && TextureLoader.hasSword
							&& TextureLoader.hasHero && Game.d.size() != 0) {
						panelCreate.setVisible(false);
						frame.remove(panelMenu);
						panelMenu.setVisible(true);
						frame.getContentPane()
								.add(panelMenu, BorderLayout.WEST);
						panelMenu.revalidate();
						panelMenu.repaint();
						lblMazeGame.setText("Play game");
						frame.revalidate();
						frame.repaint();
						creating = false;
						panelGame.requestFocus();
					} else {
						lblMazeGame.setText("Insert one element of each type!");
					}
				}
			}
		});
		panelCreate.add(btnCriar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int resposta = JOptionPane.showConfirmDialog(null,
						"Discarding changes. Are you sure?");
				if (JOptionPane.YES_OPTION == resposta) {
					panelCreate.setVisible(false);
					frame.remove(panelMenu);
					panelMenu.setVisible(true);
					frame.getContentPane().add(panelMenu, BorderLayout.WEST);
					panelGame.removeAll();
					panelMenu.revalidate();
					panelMenu.repaint();
					creating = false;
					lblMazeGame.setText("Maze Game");
					frame.revalidate();
					frame.repaint();
				}
			}
		});
		panelCreate.add(btnCancelar);
	}

	public void startGame() {
		int resposta = JOptionPane.showConfirmDialog(null,
				"Creating new game. Are you sure?");
		if (JOptionPane.YES_OPTION == resposta) {
			creating = false;
			Game.N = 0;
			Game.dN = 0;
			Game.d = new ArrayList<Drake>();
			Game.m = new Maze();
			Game.h = new Hero();
			Game.s = new Sword();
			panelGame.removeAll();
			SelectMode chooseButton = new SelectMode();
			lblMazeGame
					.setText("Drake number must be above 0!\nMaze size must be 0 or over 7!");
			chooseButton.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
			chooseButton.setVisible(true);
			if (!SelectMode.canceled) {
				if (Game.N % 2 == 0 && Game.N != 0) {
					Game.N--;
				}
				if (Game.N == 0)
					panelGame.setLayout(new GridLayout(10, 10, 0, 0));
				else
					panelGame.setLayout(new GridLayout(Game.N, Game.N, 0, 0));

				panelGame.setBorder(null);
				TextureLoader.paintMaze(Game.m.getMaze(), Game.h, Game.d,
						Game.s);
				lblMazeGame.setText("Play Game");
				panelGame.revalidate();
				panelGame.repaint();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void loadGame() {
		ObjectInputStream load = null;
		try {
			load = new ObjectInputStream(new FileInputStream("MazeGame.dat"));
			Game.N = (Integer) load.readObject();
			Game.m = (Maze) load.readObject();
			Game.h = (Hero) load.readObject();
			Game.d = (ArrayList<Drake>) load.readObject();
			Game.s = (Sword) load.readObject();
			if (Game.d.size() != 0) {
				Game.gameMode = Game.d.get(0).sleeps;
			}
			if (Game.N == 0) {
				panelGame.setLayout(new GridLayout(10, 10, 0, 0));
			} else {
				panelGame.setLayout(new GridLayout(Game.N, Game.N, 0, 0));
			}
			panelGame.setBorder(null);
			TextureLoader.paintMaze(Game.m.getMaze(), Game.h, Game.d, Game.s);
			creating = false;
			panelGame.revalidate();
			panelGame.repaint();
			panelGame.requestFocus();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (load != null) {
				try {
					load.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void saveGame() {
		int resposta = JOptionPane.showConfirmDialog(null,
				"Saving Game. Are you sure?");
		if (JOptionPane.YES_OPTION == resposta) {
			ObjectOutputStream save = null;
			try {
				save = new ObjectOutputStream(new FileOutputStream(
						"MazeGame.dat"));
				save.writeObject(Game.N);
				save.writeObject(Game.m);
				save.writeObject(Game.h);
				save.writeObject(Game.d);
				save.writeObject(Game.s);
				panelGame.requestFocus();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (save != null) {
					try {
						save.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void createMaze(final JPanel panelCreate) {
		int resposta = JOptionPane.showConfirmDialog(null,
				"Creating new game. Are you sure?");
		if (JOptionPane.YES_OPTION == resposta) {
			panelMenu.setVisible(false);
			panelCreate.setVisible(true);
			panelCreate.setBorder(BorderFactory.createLineBorder(
					Color.LIGHT_GRAY, 2));
			frame.getContentPane().add(panelCreate, BorderLayout.WEST);
			panelCreate.revalidate();
			panelCreate.repaint();
			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(7, 7, 50, 1));
			creating = true;
			TextureLoader.paintCreation(panelCreate, spinner);
		}
	}

	public void exit() {
		int resposta = JOptionPane.showConfirmDialog(null,
				"Exiting. Are you sure?");
		if (JOptionPane.YES_OPTION == resposta) {
			System.exit(0);
		}
	}
}
