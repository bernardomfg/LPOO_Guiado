package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import logic.Drake;
import logic.Game;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.Scanner;
import java.awt.Font;

public class SelectMode extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final JPanel contentPanel1 = new JPanel();
	private final JPanel contentPanel2 = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField textField1;
	public String op;
	int ok = 0;

	/**
	 * Create the dialog.
	 */
	public SelectMode() {
		setBounds(100, 100, 456, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel1.setVisible(false);
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		contentPanel.setLayout(null);
		contentPanel1.setLayout(null);
		contentPanel2.setLayout(null);

		{
			JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem(
					"1 - Dragao parado");
			rdbtnmntmNewRadioItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {

					Game.gameMode = 1;
				}
			});
			rdbtnmntmNewRadioItem.setSelected(true);
			buttonGroup.add(rdbtnmntmNewRadioItem);
			rdbtnmntmNewRadioItem.setBounds(36, 89, 328, 37);
			contentPanel.add(rdbtnmntmNewRadioItem);
		}
		{
			JRadioButtonMenuItem rdbtnmntmDragao = new JRadioButtonMenuItem(
					"2 - Dragao com movimento");
			rdbtnmntmDragao.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {

					Game.gameMode = 2;
				}
			});
			buttonGroup.add(rdbtnmntmDragao);
			rdbtnmntmDragao.setBounds(36, 135, 328, 37);
			contentPanel.add(rdbtnmntmDragao);
		}

		JLabel lblTamanhoDoLabirinto = new JLabel("Tamanho do Labirinto:");
		lblTamanhoDoLabirinto.setBounds(36, 250, 234, 37);
		lblTamanhoDoLabirinto.setVisible(true);
		textField = new JTextField();
		textField.setBounds(36, 275, 234, 37);
		textField.setColumns(10);
		contentPanel.add(lblTamanhoDoLabirinto);
		contentPanel.add(textField);

		JLabel lblNumeroDeDragoes = new JLabel("Numero de Dragoes:");
		lblNumeroDeDragoes.setBounds(36, 323, 234, 37);
		lblNumeroDeDragoes.setVisible(true);
		textField1 = new JTextField();
		textField1.setBounds(36, 348, 234, 37);
		textField1.setColumns(10);
		contentPanel.add(lblNumeroDeDragoes);
		contentPanel.add(textField1);

		final JRadioButtonMenuItem rdbtnmntmDragao_1 = new JRadioButtonMenuItem(
				"3 - Dragao com movimento intercalado com dormir");
		rdbtnmntmDragao_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Game.gameMode = 3;
			}
		});
		buttonGroup.add(rdbtnmntmDragao_1);
		rdbtnmntmDragao_1.setBounds(36, 183, 347, 37);
		contentPanel.add(rdbtnmntmDragao_1);

		JLabel lblModoDeJogo = new JLabel("Modo de Jogo:");
		lblModoDeJogo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblModoDeJogo.setBounds(36, 24, 234, 37);
		contentPanel.add(lblModoDeJogo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");

				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						// System.out.println(textField.getText());
						Scanner s = new Scanner(textField.getText());
						if (s.hasNextInt())
							Gui.N = s.nextInt();

						// System.out.println(Gui.N);

						// if (ok == 3 && Gui.N != 0) {

						/*
						 * contentPanel2.setVisible(true);
						 * contentPanel.setVisible(false);
						 * contentPanel1.setVisible(false);
						 * 
						 * getContentPane().add(contentPanel2,
						 * BorderLayout.CENTER); }
						 */

						// System.out.println(textField.getText());
						s = new Scanner(textField1.getText());
						if (s.hasNextInt())
							Gui.dN = s.nextInt();
						// System.out.println(Gui.N);
						if ((Gui.dN > 0)
								&& ((Gui.N >= 7) || (Gui.N == 0 && textField
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
					// Game.gameMode =
					// Integer.parseInt(buttonGroup.getSelection().toString());

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
