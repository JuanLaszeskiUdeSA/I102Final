package self;

public class Hanoi {
    private Stick left;
    private Stick middle;
    private Stick right;

    public Hanoi() {
        left = new Stick();
        middle = new Stick();
        right = new Stick();
    }

    public Hanoi move(Stick from, Stick to) {
        to.push(from.pop());
        return this;
    }

    public Hanoi moveLR() {
        return move(left, right);
    }
    public Hanoi moveRL() {
        return move(right, left);
    }
    public Hanoi moveLM() {
        return move(left, middle);
    }
    public Hanoi moveML() {
        return move(middle, left);
    }
    public Hanoi moveRM() {
        return move(right, middle);
    }

    public Stick getStickLeft() {
        return left;
    }
    public Stick getStickMiddle() {
        return middle;
    }
    public Stick getStickRight() {
        return right;
    }
}
