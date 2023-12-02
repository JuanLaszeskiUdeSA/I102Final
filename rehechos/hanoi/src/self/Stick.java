package self;

import java.util.ArrayList;
import java.util.List;

public class Stick {
    private List<Disc> discs;

    public Stick() {
        this.discs = new ArrayList<Disc>();
    }

    public Stick push(Disc aDisc) {
        if (discs.isEmpty() || aDisc.stacksOn(top())) {
            discs.add(aDisc);
        } else {
            throw new RuntimeException("forbidden move");
        }
        return this;
    }

    public Disc top() {
        return discs.get(discs.size() - 1);
    }
    public Disc pop() {
        return discs.remove(discs.size() - 1);
    }
}
