/**
 * 
 */
package com.arianzhang.thread.learn.critical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Arian Zhang
 * @email arian_zhang@foxmail.com
 */
public class Pair {

	private int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pair() {
		this(0, 0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void incrementX() {
		x++;
	}

	public void incrementY() {
		y++;
	}

	public String toString() {
		return "x: " + x + ", y: " + y;
	}

	public void checkState() {
		if (x != y) {
			throw new PairValuesNotEqualException();
		}
	}

}

class PairValuesNotEqualException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PairValuesNotEqualException() {
		super("Pair values not equal : " + Pair.class);
	}

}

abstract class PairManager {
	AtomicInteger checkCounter = new AtomicInteger(0);

	protected Pair p = new Pair();

	private List<Pair> storage = Collections
			.synchronizedList(new ArrayList<Pair>());

	public synchronized Pair getPair() {
		// return a copy to keep the original safe;
		return new Pair(p.getX(), p.getY());
	}

	protected void store(Pair p) {
		storage.add(p);
		try {
			TimeUnit.MILLISECONDS.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void increment(){
		p.incrementX();
		p.incrementY();
		store(getPair());
	}
}

// Synchronize the entire method
class PairManager1 extends PairManager {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.arianzhang.thread.learn.critical.PairManager#increment()
	 */
	@Override
	public synchronized void increment() {
		super.increment();
	}
}

// Use a critical section
class PairManager2 extends PairManager {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.arianzhang.thread.learn.critical.PairManager#increment()
	 */
	@Override
	public void increment() {
		synchronized (this) {
			super.increment();
		}
	}
}

class PairManipulater implements Runnable {

	private PairManager pm;

	public PairManipulater(PairManager pm) {
		this.pm = pm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (true) {
			pm.increment();
		}
	}

	public String toString() {
		return "Pair : " + pm.getPair() + " checkCounter = "
				+ pm.checkCounter.get();
	}
}

class PairChecker implements Runnable {

	private PairManager pm;

	public PairChecker(PairManager pm) {
		this.pm = pm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (true) {
			pm.checkCounter.incrementAndGet();
			pm.getPair().checkState();
		}
	}
}
