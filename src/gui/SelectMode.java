package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.Drake;
import logic.Game;

@SuppressWarnings("serial")
public class SelectMode extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final JPanel contentPanel1 = new JPanel();
	private final JPanel contentPanel2 = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldTamanho;
	private JTextField textFieldNDragoes;
	public String op;
	int ok = 0;

	/**
	 * Create the dialog.
	 */
	public SelectMode() {
		setResizable(false);
		setBounds(100, 100, 352, 400);
		getContentPane().setLayout(new BorderLayout());
		final JButton okButton = new JButton("OK");

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel1.setVisible(false);
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		contentPanel.setLayout(null);
		contentPanel1.setLayout(null);
		contentPanel2.setLayout(null);

		{
			JRadioButtonMenuItem rdbDragaoParado = new JRadioButtonMenuItem(
					"1 - Dragao parado");
			rdbDragaoParado.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {

					Game.gameMode = 1;
				}
			});
			rdbDragaoParado.setSelected(true);
			buttonGroup.add(rdbDragaoParado);
			rdbDragaoParado.setBounds(10, 47, 328, 37);
			contentPanel.add(rdbDragaoParado);
		}
		{
			JRadioButtonMenuItem rdbDragaoMov = new JRadioButtonMenuItem(
					"2 - Dragao com movimento");
			rdbDragaoMov.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {

					Game.gameMode = 2;
				}
			});
			buttonGroup.add(rdbDragaoMov);
			rdbDragaoMov.setBounds(10, 93, 328, 37);
			contentPanel.add(rdbDragaoMov);
		}

		JLabel lblTamanhoDoLabirinto = new JLabel("Tamanho do Labirinto:");
		lblTamanhoDoLabirinto.setBounds(10, 189, 234, 37);
		lblTamanhoDoLabirinto.setVisible(true);
		textFieldTamanho = new JTextField();
		textFieldTamanho.setBounds(10, 214, 234, 37);
		textFieldTamanho.setColumns(10);

		final JRadioButtonMenuItem rdbDragaoMovSleep = new JRadioButtonMenuItem(
				"3 - Dragao com movimento intercalado com dormir");
		rdbDragaoMovSleep.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Game.gameMode = 3;
			}
		});
		buttonGroup.add(rdbDragaoMovSleep);
		rdbDragaoMovSleep.setBounds(10, 141, 347, 37);
		contentPanel.add(rdbDragaoMovSleep);
		contentPanel.add(lblTamanhoDoLabirinto);
		contentPanel.add(textFieldTamanho);

		JLabel lblNumeroDeDragoes = new JLabel("Numero de Dragoes:");
		lblNumeroDeDragoes.setBounds(10, 262, 234, 37);
		lblNumeroDeDragoes.setVisible(true);
		textFieldNDragoes = new JTextField();
		textFieldNDragoes.setBounds(10, 287, 234, 37);
		textFieldNDragoes.setColumns(10);
		contentPanel.add(lblNumeroDeDragoes);
		contentPanel.add(textFieldNDragoes);

		JLabel lblModoDeJogo = new JLabel("Modo de Jogo:");
		lblModoDeJogo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblModoDeJogo.setBounds(10, 11, 234, 37);
		contentPanel.add(lblModoDeJogo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{

				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						@SuppressWarnings("resource")
						Scanner s = new Scanner(textFieldTamanho.getText());
						if (s.hasNextInt())
							Gui.N = s.nextInt();

						s = new Scanner(textFieldNDragoes.getText());
						if (s.hasNextInt())
							Gui.dN = s.nextInt();

						if ((Gui.dN > 0)
								&& ((Gui.N >= 7) || (Gui.N == 0 && textFieldTamanho
										.getText().length() == 1))) {
							if (Gui.N == 0)
								Gui.dN = 1;

							for (int i = 0; i < Gui.dN; i++) {
								Gui.d.add(new Drake());
							}

							Game.BuildMaze(Gui.d, Gui.m, Gui.h, Gui.s, Gui.N);

							dispose();
						}
					}

				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);

			}

		}
	}
}
