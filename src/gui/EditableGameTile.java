package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class EditableGameTile extends GameTile implements MouseListener
{
	Boolean mode;
	int[] lc;
	public EditableGameTile(ImageIcon img, char sym, Boolean mode, int[] pos) {
		super(img, sym);
		this.mode = mode;
		lc = pos;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("teste");
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}