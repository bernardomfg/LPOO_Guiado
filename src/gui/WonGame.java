package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class WonGame extends JDialog {
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public WonGame() {
		setBounds(100, 100, 450, 215);
		getContentPane().setLayout(new BorderLayout());
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
		JLabel lblGanhouOJogo = new JLabel("Ganhou o Jogo!");
		contentPanel.add(lblGanhouOJogo);
		
		lblGanhouOJogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanhouOJogo.setForeground(Color.BLUE);
		lblGanhouOJogo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton okButton = new JButton("OK");
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Gui.panelGame.removeAll();
				Gui.panelGame.revalidate();
				Gui.panelGame.repaint();
				Gui.creating=true;
				dispose();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Gui.panelGame.removeAll();
				Gui.panelGame.revalidate();
				Gui.panelGame.repaint();
				Gui.creating=true;
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
}
