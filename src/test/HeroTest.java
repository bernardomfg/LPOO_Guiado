package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import logic.Drake;
import logic.Hero;
import logic.Maze;
import logic.Sword;
import logic.Game;

import org.junit.Test;

public class HeroTest {

	@Test
	public void testHeroMoves() {
		Maze m = new Maze();
		Hero h = new Hero();

		m.generateMaze(0);
		h.setX(1);
		h.setY(1);

		h.moveHero(m, "s");
		assertEquals(1, h.getX());
		assertEquals(2, h.getY());
	}

	@Test
	public void testHeroMovesWall() {
		Maze m = new Maze();
		Hero h = new Hero();

		m.generateMaze(0);
		h.setX(1);
		h.setY(1);

		h.moveHero(m, "a");
		assertEquals(1, h.getX());
		assertEquals(1, h.getY());
	}

	@Test
	public void testGrabSword() {
		Maze m = new Maze();
		Hero h = new Hero();
		Sword s = new Sword();

		m.generateMaze(0);
		h.setX(1);
		h.setY(1);
		s.setX(1);
		s.setY(2);

		assertEquals(false, h.hasSword());

		h.moveHero(m, "s");
		Game.checkSword(h, s);

		assertEquals(true, h.hasSword());
	}

	@Test
	public void testHeroDies() {
		Maze m = new Maze();
		Hero h = new Hero();
		ArrayList<Drake> d = new ArrayList<Drake>();
		d.add(new Drake());

		m.generateMaze(0);
		h.setX(1);
		h.setY(1);
		d.get(0).setX(1);
		d.get(0).setY(3);

		h.moveHero(m, "s");
		assertEquals(true, Game.checkDead(h, d));

	}

	@Test
	public void testHeroKills() {
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
		s.setX(1);
		s.setY(1);

		Game.checkSword(h, s);
		h.moveHero(m, "s");
		Game.checkDead(h, d);
		assertEquals(0, d.size());

	}

	@Test
	public void testVictory() {
		Maze m = new Maze();
		Hero h = new Hero();
		Sword s = new Sword();

		m.generateMaze(0);
		h.setX(8);
		h.setY(5);
		s.setX(8);
		s.setY(5);

		Game.checkSword(h, s);

		h.moveHero(m, "d");

		assertEquals(true, h.atExit);
	}

	@Test
	public void testInvalidVictory() {
		Maze m = new Maze();
		Hero h = new Hero();

		m.generateMaze(0);
		h.setX(8);
		h.setY(5);

		h.moveHero(m, "d");

		assertEquals(false, h.atExit);
	}
}
