package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import logic.Drake;
import logic.Game;
import logic.Hero;
import logic.Maze;
import logic.Sword;

import org.junit.Test;

public class EagleTest {

	@Test
	public void testEagleGetsSword() {
		Maze m = new Maze();
		Hero h = new Hero();
		Sword s = new Sword();
		ArrayList<Drake> d = new ArrayList<Drake>();
		d.add(new Drake());

		m.generateMaze(0);
		h.setX(1);
		h.setY(1);
		d.get(0).setX(1);
		d.get(0).setY(3);
		s.setX(4);
		s.setY(4);
		
		h.launchEagle();
		assertEquals(1, h.e.getX());
		assertEquals(1, h.e.getY());
		assertEquals(true, h.e.inFlight);
		h.e.moveEagle(s);
		assertEquals(2, h.e.getX());
		assertEquals(2, h.e.getY());
		assertEquals(true, h.e.inFlight);
		h.e.moveEagle(s);
		assertEquals(3, h.e.getX());
		assertEquals(3, h.e.getY());
		assertEquals(true, h.e.inFlight);
		h.e.moveEagle(s);
		assertEquals(4, h.e.getX());
		assertEquals(4, h.e.getY());
		assertEquals(true, h.e.inFlight);
		h.e.moveEagle(s);
		assertEquals(4, h.e.getX());
		assertEquals(4, h.e.getY());
		assertEquals(false, h.e.inFlight);
		assertEquals(true, h.e.hasSword);
		h.e.moveEagle(s);
		assertEquals(4, h.e.getX());
		assertEquals(4, h.e.getY());
		assertEquals(true, h.e.inFlight);
		h.e.moveEagle(s);
		assertEquals(3, h.e.getX());
		assertEquals(3, h.e.getY());
		assertEquals(true, h.e.inFlight);
		h.e.moveEagle(s);
		assertEquals(2, h.e.getX());
		assertEquals(2, h.e.getY());
		assertEquals(true, h.e.inFlight);
		h.e.moveEagle(s);
		assertEquals(1, h.e.getX());
		assertEquals(1, h.e.getY());
		assertEquals(false, h.e.inFlight);
		Game.checkSword(h, s);
		assertEquals(true, h.hasSword());
		assertEquals(false, h.e.hasSword);
	}
	
	@Test
	public void testEagleGetsKilled() {
		Maze m = new Maze();
		Hero h = new Hero();
		Sword s = new Sword();
		ArrayList<Drake> d = new ArrayList<Drake>();
		d.add(new Drake());

		m.generateMaze(0);
		h.setX(1);
		h.setY(1);
		d.get(0).setX(1);
		d.get(0).setY(3);
		s.setX(4);
		s.setY(4);
		
		h.launchEagle();
		assertEquals(1, h.e.getX());
		assertEquals(1, h.e.getY());
		assertEquals(true, h.e.inFlight);
		h.e.moveEagle(s);
		assertEquals(2, h.e.getX());
		assertEquals(2, h.e.getY());
		assertEquals(true, h.e.inFlight);
		h.e.moveEagle(s);
		assertEquals(3, h.e.getX());
		assertEquals(3, h.e.getY());
		assertEquals(true, h.e.inFlight);
		h.e.moveEagle(s);
		assertEquals(4, h.e.getX());
		assertEquals(4, h.e.getY());
		assertEquals(true, h.e.inFlight);
		h.e.moveEagle(s);
		assertEquals(4, h.e.getX());
		assertEquals(4, h.e.getY());
		assertEquals(false, h.e.inFlight);
		assertEquals(true, h.e.hasSword);
		h.e.moveEagle(s);
		assertEquals(4, h.e.getX());
		assertEquals(4, h.e.getY());
		assertEquals(true, h.e.inFlight);
		h.e.moveEagle(s);
		assertEquals(3, h.e.getX());
		assertEquals(3, h.e.getY());
		assertEquals(true, h.e.inFlight);
		
		h.x=9;
		h.y=9;
		d.get(0).x=1;
		d.get(0).y=1;
		
		h.e.moveEagle(s);
		assertEquals(2, h.e.getX());
		assertEquals(2, h.e.getY());
		assertEquals(true, h.e.inFlight);
		assertEquals(false, h.e.isDead);
		h.e.moveEagle(s);
		assertEquals(1, h.e.getX());
		assertEquals(1, h.e.getY());
		assertEquals(true, h.e.hasSword);
		assertEquals(false, h.e.inFlight);
		Game.checkDead(h, d);
		assertEquals(true, h.e.isDead);
	}

}
