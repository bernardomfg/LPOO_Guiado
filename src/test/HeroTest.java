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

	/**
	 * Tests if hero moves
	 */
	@Test
	public void testHeroMoves() {
		Maze m = new Maze();
		Hero h = new Hero();
		ArrayList<Drake> d = new ArrayList<Drake>();

		m.generateMaze(0);
		h.setX(1);
		h.setY(1);

		h.moveHero(m, "s", d);
		assertEquals(1, h.getX());
		assertEquals(2, h.getY());
	}

	/**
	 * Tests if hero remains in same position when ordered to move towards wall
	 */
	@Test
	public void testHeroMovesWall() {
		Maze m = new Maze();
		Hero h = new Hero();
		ArrayList<Drake> d = new ArrayList<Drake>();

		m.generateMaze(0);
		h.setX(1);
		h.setY(1);

		h.moveHero(m, "a", d);
		assertEquals(1, h.getX());
		assertEquals(1, h.getY());
	}

	/**
	 * Tests if hero grabs the sword.
	 */
	@Test
	public void testGrabSword() {
		Maze m = new Maze();
		Hero h = new Hero();
		Sword s = new Sword();
		ArrayList<Drake> d = new ArrayList<Drake>();

		m.generateMaze(0);
		h.setX(1);
		h.setY(1);
		s.setX(1);
		s.setY(2);

		assertEquals(false, h.hasSword());

		h.moveHero(m, "s", d);
		Game.checkSword(h, s);

		assertEquals(true, h.hasSword());
	}

	/**
	 * Tests if unarmed hero dies near the dragon.
	 */
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

		h.moveHero(m, "s", d);
		assertEquals(true, Game.checkDead(h, d));

	}

	/**
	 * Tests if armed hero kills the dragon when near it.
	 */
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
		h.moveHero(m, "s", d);
		Game.checkDead(h, d);
		assertEquals(0, d.size());

	}

	/**
	 * Tests victory conditions
	 */
	@Test
	public void testVictory() {
		Maze m = new Maze();
		Hero h = new Hero();
		Sword s = new Sword();
		ArrayList<Drake> d = new ArrayList<Drake>();

		m.generateMaze(0);
		h.setX(8);
		h.setY(5);
		s.setX(8);
		s.setY(5);

		Game.checkSword(h, s);

		h.moveHero(m, "d", d);

		assertEquals(true, h.atExit);
	}

	/**
	 * Tests if hero can win when not carrying sword
	 */
	@Test
	public void testInvalidVictory() {
		Maze m = new Maze();
		Hero h = new Hero();
		ArrayList<Drake> d = new ArrayList<Drake>();
		d.add(new Drake());

		m.generateMaze(0);
		h.setX(8);
		h.setY(5);

		h.moveHero(m, "d", d);

		assertEquals(false, h.atExit);
	}
}
