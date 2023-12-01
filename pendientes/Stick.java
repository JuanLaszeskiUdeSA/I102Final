package HanoiG1;

import java.util.ArrayList;

public class Stick {
	private ArrayList<Disc> discs = new ArrayList();

	public Stick push(Disc newTop) {
		if(discs.isEmpty() || newTop.stacksOn(top())) {
			discs.add(newTop);
		}
		else{
			throw new RuntimeException("forbidden move");
		}
		
		return this;
		
	}

	public Disc top() {
		
		return discs.get(discs.size()-1);
	}

	public Disc pop() {
		return discs.remove(discs.size()-1);
	}

}
