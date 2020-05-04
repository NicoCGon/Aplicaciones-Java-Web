package FlujoDatos;

public class ExampleThread extends  Thread {  
	private String in;
	private String out;

	public ExampleThread(String in, String out) {
		this.in = in;
		this.out = out;
	}

	public void  run () {   
		System.out.println ("Ejecutando hilo, entrada: " + this.in + " salida: " + this.out); 
	}  
	public String getIn() {
		return in;
	}
	public void setIn(String in) {
		this.in = in;
	}
	public String getOut() {
		return out;
	}
	public void setOut(String out) {
		this.out = out;
	}  
}
