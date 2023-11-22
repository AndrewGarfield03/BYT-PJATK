

import java.util.ArrayList;
import java.util.List;

public class User {

	private List<MyObject> userList = new ArrayList<>();
	private static int counter = 0;
	private int id;

	public User() {
		this.id = ++counter;
	}

	public void takeObjectFromPool(ObjectPool op) {
		MyObject obj = op.pullObject();
		if (obj != null) {
			userList.add(obj);
		} else {
			System.out.println("User " + this.id + " trying to get an object, but object limit is reached (10).");
		}
	}

	public void returnObjectToPool(ObjectPool op) {
		if (!userList.isEmpty()) {
			op.addObject(userList.remove(userList.size() - 1));
		} else {
			System.out.println("User " + this.id + " is out of objects. (you are trying to get them from him)");
		}
	}

	public int getListSize() {
		return userList.size();
	}

	public int getId() {
		return id;
	}
}

