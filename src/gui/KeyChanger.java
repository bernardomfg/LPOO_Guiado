package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/** Class that extends JDialog to create a dialog that changes the keys in game
 * 
 *
 */
public class KeyChanger extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static int upKey = -1;
	public static int downKey = -1;
	public static int leftKey = -1;
	public static int rightKey = -1;
	public static int launchKey = -1;
	int ok = 0;

	/**Initializes the JDialog
	 * 
	 */
	public KeyChanger() {
		setResizable(false);
		setBounds(100, 100, 450, 215);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(1, 0, 0, 0));

		final JLabel changeKey = new JLabel("Insert UP key!");		//label informing the user of which key to select
		changeKey.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {					//listener to change the value of the key used depending on the value of ok

				switch (ok) {
				case 0:
					upKey = arg0.getKeyCode();
					System.out.println(upKey);
					break;
				case 1:
					downKey = arg0.getKeyCode();
					System.out.println(downKey);
					break;
				case 2:
					leftKey = arg0.getKeyCode();
					System.out.println(leftKey);
					break;
				case 3:
					rightKey = arg0.getKeyCode();
					System.out.println(rightKey);
					break;
				case 4:
					launchKey = arg0.getKeyCode();
					System.out.println(launchKey);
					break;
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
		changeKey.setForeground(Color.BLUE);
		changeKey.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		changeKey.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(changeKey);
		
		changeKey.setFocusable(true);
		changeKey.requestFocusInWindow();
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {			//Changes the information in the label

				switch (ok) {
				case 0:
					changeKey.setText("Insert DOWN key!");
					ok++;
					changeKey.requestFocus();
					break;
				case 1:
					changeKey.setText("Insert LEFT key!");
					ok++;
					changeKey.requestFocus();
					break;
				case 2:
					changeKey.setText("Insert RIGHT key!");
					ok++;
					changeKey.requestFocus();
					break;
				case 3:
					changeKey.setText("Insert LAUNCH key!");
					ok++;
					changeKey.requestFocus();
					break;
				default:
					dispose();
				}

			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		changeKey.requestFocus();
	}
}
