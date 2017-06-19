package test;

class Pair<X,Y> {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		return true;
	}

	X x;
	Y y;

	public Pair(X x, Y y) {
		this.x = x;
		this.y = y;
	}

	public Pair() {
	}

	public X getX() {
		return this.x;
	}

	public void setX(X x) {
		this.x = x;
	}

	public Y getY() {
		return this.y;
	}

	public void setY(Y y) {
		this.y = y;
	}
}
