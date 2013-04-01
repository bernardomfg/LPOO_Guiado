package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import logic.Drake;
import logic.Maze;

import org.junit.Test;

public class DrakeTest {

	@Test
	public void testDragonMoves() {
		Maze m = new Maze();
		ArrayList<Drake> d = new ArrayList<Drake>();
		d.add(new Drake());

		m.generateMaze(0);
		d.get(0).setX(1);
		d.get(0).setY(3);

		d.get(0).move(3);

		assertEquals(1, d.get(0).getX());
		assertEquals(4, d.get(0).getY());
	}

	@Test
	public void testDragonSleepsAndTriesToMove() {
		Maze m = new Maze();
		ArrayList<Drake> d = new ArrayList<Drake>();
		d.add(new Drake());

		m.generateMaze(0);
		d.get(0).setX(1);
		d.get(0).setY(3);

		d.get(0).setSleep(true);
		d.get(0).moveDrake(m);

		assertEquals(1, d.get(0).getX());
		assertEquals(3, d.get(0).getY());
	}

	@Test
	public void testMultipleDragonMoves() {
		Maze m = new Maze();
		ArrayList<Drake> d = new ArrayList<Drake>();
		d.add(new Drake());
		d.add(new Drake());

		m.generateMaze(0);
		d.get(0).setX(1);
		d.get(0).setY(1);
		d.get(1).setX(1);
		d.get(1).setY(3);

		d.get(0).move(1);
		d.get(1).move(3);

		assertEquals(2, d.get(0).getX());
		assertEquals(1, d.get(0).getY());
		assertEquals(1, d.get(1).getX());
		assertEquals(4, d.get(1).getY());
	}
}
