package HanoiG1;

public class Hanoi {
    private Stick left;
    private Stick middle;
    private Stick right;

    public Hanoi(Stick left, Stick middle, Stick right) {
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    public void moveRL() {
        left.push(right.pop());
    }

    public Stick left() {
        return left;
    }

    public Stick middle() {
        return middle;
    }

    public Stick right() {
        return right;
    }
}
