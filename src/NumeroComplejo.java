import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumeroComplejo extends Numero{
	
	public NumeroComplejo(BigDecimal valor) {
		super(valor.setScale(2, RoundingMode.HALF_UP));
	}
}
