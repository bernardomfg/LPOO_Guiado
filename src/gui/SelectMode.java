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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import logic.Game;

public class SelectMode extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public String op;

	

	/**
	 * Create the dialog.
	 */
	public SelectMode() {
		setBounds(100, 100, 565, 398);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("1 - Dragao parado");
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
			JRadioButtonMenuItem rdbtnmntmDragao = new JRadioButtonMenuItem("2 - Dragao com movimento");
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
		
		JRadioButtonMenuItem rdbtnmntmDragao_1 = new JRadioButtonMenuItem("3 - Dragao com movimento intercalado com dormir");
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
						
						//Game.gameMode = Integer.parseInt(buttonGroup.getSelection().toString());
						dispose();
						
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
