package easy;

public class Base {
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
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
		Base other = (Base) obj;
		if (x != other.x)
			return false;
		return true;
	}

public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

private int x;
	
}

class A extends Base{
	
}

class B extends Base{
	
}
