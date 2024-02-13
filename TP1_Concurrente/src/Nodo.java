import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Nodo {
	private Lock lock = new ReentrantLock();
	public Object item;
	public int key;
	public Nodo next;
	public Nodo (int key, Object item) {
		this.key=key;
		this.item=item;
	}
	public void lock() {
		lock.lock();
	}
	public void unlock() {
		lock.unlock();
	}

}
