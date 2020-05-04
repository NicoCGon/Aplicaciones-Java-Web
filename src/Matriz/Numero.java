package Matriz;
import java.math.BigDecimal;

public abstract class Numero {
	private BigDecimal valor;
	
	public Numero(BigDecimal valor) {
		this.valor = valor;
	}

	public void sumar(Numero numero) {
		this.valor = this.valor.add(numero.getValor());
	}
	
	public void restar(Numero numero) {
		this.valor = this.valor.subtract(numero.getValor());
	}
	
	public void multiplicarPor(Numero numero) {
		this.valor = this.valor.multiply(numero.getValor());
	}
	
	public void dividirPor(Numero numero) {
		this.valor = this.valor.divide(numero.getValor());
	}
	
	@Override
	public String toString() {
		return "Numero [valor=" + valor + "]";
	}
	
	@Override
	public Numero clone() {
		if(this instanceof NumeroEntero || this instanceof NumeroReal) {
			return new NumeroReal(this.getValor());
		}
		NumeroComplejo numeroClone = (NumeroComplejo) this;
		return new NumeroComplejo(numeroClone.getValor(), numeroClone.getImaginario());
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
}
