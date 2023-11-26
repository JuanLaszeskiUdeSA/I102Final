package booleans0;

public abstract class Boolean {

	static Boolean True() {
		return new BTrue();
	}

	static Boolean False() {
		return new BFalse();
	}

	public boolean equals(Object other) {
		return other.getClass() == getClass();
	}

	public abstract Boolean yy(Boolean v);

	public abstract Boolean oo(Boolean v);

	public abstract Boolean not();

}
