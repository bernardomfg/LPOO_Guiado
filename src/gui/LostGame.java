package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**Informs the player that he lost the game
 * 
 *
 */
public class LostGame extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public LostGame() {
		setResizable(false);
		setBounds(100, 100, 450, 215);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblPerdeuOJogo = new JLabel("Perdeu o Jogo!");
		lblPerdeuOJogo.setForeground(Color.RED);
		lblPerdeuOJogo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblPerdeuOJogo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblPerdeuOJogo);

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
				Gui.creating = true;
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
				Gui.creating = true;
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
}
