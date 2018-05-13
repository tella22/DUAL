import java.io.Serializable;
public class Punto2D implements Serializable {

	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	
	public Punto2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	 public String toString(){
		 return "x: " + x+ " , y: " + y;
	 }
}

