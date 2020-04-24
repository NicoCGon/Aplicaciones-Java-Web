import java.math.BigDecimal;

public abstract class Numero {
	private BigDecimal valor;
	
	public Numero(BigDecimal valor) {
		this.valor = valor;
	}

	public void sumar(Numero n) {
		this.valor = this.valor.add(n.getValor());
	}
	
	public void restar(Numero n) {
		this.valor = this.valor.subtract(n.getValor());
	}
	
	public void multiplicarPor(Numero n) {
		this.valor = this.valor.multiply(n.getValor());
	}
	
	public void dividirPor(Numero n) {
		this.valor = this.valor.divide(n.getValor());
	}
	
	@Override
	public String toString() {
		return "Numero [valor=" + valor + "]";
	}
	

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
}
