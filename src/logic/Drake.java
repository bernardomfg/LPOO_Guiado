package logic;

public class Drake extends Mobile {
	public Boolean alive = true;
	public Boolean sleeping = false;

	public void kill() {
		alive = false;
	}

	public void setSleep(Boolean state) {
		sleeping = state;
	}

	public Boolean isAlive() {
		return alive;
	}

	public Boolean isSleeping() {
		return sleeping;
	}

}
