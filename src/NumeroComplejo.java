import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumeroComplejo extends Numero{
	private BigDecimal imaginario;
	
	public NumeroComplejo(BigDecimal valor, BigDecimal imaginario) {
		super(valor.setScale(2, RoundingMode.HALF_UP));
		this.imaginario = imaginario;
	}
	
	@Override
	public void sumar(Numero numero) {
		super.setValor(super.getValor().add(numero.getValor()));
		if(numero instanceof NumeroComplejo)
			this.imaginario = this.imaginario.add(((NumeroComplejo) numero).getImaginario());
	}
	
	@Override
	public void restar(Numero numero) {
		super.setValor(super.getValor().subtract(numero.getValor()));
		if(numero instanceof NumeroComplejo)
			this.imaginario = this.imaginario.subtract(((NumeroComplejo) numero).getImaginario());
	}
	
	@Override
	public void multiplicarPor(Numero numero) {
		super.setValor(super.getValor().multiply(numero.getValor()));
		if(numero instanceof NumeroComplejo)
			this.imaginario = this.imaginario.multiply(((NumeroComplejo) numero).getImaginario());
	}
	
	@Override
	public void dividirPor(Numero numero) {
		super.setValor(super.getValor().divide(numero.getValor()));
		if(numero instanceof NumeroComplejo)
			this.imaginario = this.imaginario.divide(((NumeroComplejo) numero).getImaginario());
	}

	@Override
	public String toString() {
		return super.toString() + " NumeroComplejo [imaginario=" + imaginario + "]";
	}

	public BigDecimal getImaginario() {
		return imaginario;
	}

	public void setImaginario(BigDecimal imaginario) {
		this.imaginario = imaginario;
	}
	
}
