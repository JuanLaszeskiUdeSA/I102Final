package self;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    private List<Box> queue;

	public Queue() {
		this.queue = new ArrayList<>();
		queue.add(new ErrorBox());
	}

    public boolean isEmpty() {
        return queue.size() == 1;
    }

    public Queue add(Object cargo) {
        queue.add(1,new CargoBox(cargo));
		return this;
    }

    public Object take() {
        return queue.remove(queue.size()-1).open();
    }

    public Object head() {
        return queue.get(queue.size()-1).open();
    }

    public int size() {
        return queue.size()-1;
    }

}
