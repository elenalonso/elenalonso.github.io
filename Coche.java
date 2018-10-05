public class Coche {
	

protected double v; //velocidad
protected double a; //angulo de giro
protected double x;
protected double y;
private String piloto;

public Coche(double v, double a, double x, double y, String piloto) {
		super();
		this.v = v;
		this.a = a;
		this.x = x;
		this.y = y;
		this.piloto = piloto;
	}

public Coche() {
	super();
	this.v = 0;
	this.a = 0;
	this.x = 0;
	this.y = 0;
	this.piloto = "";
}

public double getV() {
	return v;
}

public void setV(double v) {
	this.v = v;
}

public double getA() {
	return a;
}

public void setA(double a) {
	this.a = a;
}

public double getX() {
	return x;
}

public void setX(double x) {
	this.x = x;
}

public double getY() {
	return y;
}

public void setY(double y) {
	this.y = y;
}

public String getPiloto() {
	return piloto;
}

public void setPiloto(String piloto) {
	this.piloto = piloto;
}

public String toString() {
	return "[";
}



}
