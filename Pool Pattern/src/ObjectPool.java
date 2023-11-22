

import java.util.ArrayList;
import java.util.List;

public class ObjectPool {

	private static volatile ObjectPool instance = null;
	private static final int MAX_OBJECTS = 10;
	private static List<MyObject> myList = new ArrayList<>();
	private static int numberOfObjects = 0;

	private ObjectPool() {
		// Initialization logic, if needed
	}

	public void addObject(MyObject obj) {
		if (myList.size() < MAX_OBJECTS) {
			myList.add(obj);
		}
	}

	public MyObject pullObject() {
		if (myList.isEmpty() && !ObjectLimitReached()) {
			numberOfObjects++;
			return new MyObject();
		} else if (!myList.isEmpty()) {
			MyObject tmp = myList.remove(myList.size() - 1);
			return tmp;
		} else {
			return null;
		}
	}

	public static ObjectPool getInstance() {
		if (instance == null) {
			synchronized (ObjectPool.class) {
				if (instance == null) {
					instance = new ObjectPool();
				}
			}
		}
		return instance;
	}

	public static void printNumber() {
		System.out.println("Number of objects in the system: " + numberOfObjects);
	}

	public int getListSize() {
		return myList.size();
	}

	public synchronized boolean ObjectLimitReached() {
		return numberOfObjects >= MAX_OBJECTS;
	}
}

