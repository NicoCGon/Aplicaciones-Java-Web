import java.math.BigDecimal;
import java.math.BigInteger;

public class NumeroReal extends Numero{

	public NumeroReal(BigInteger valor) {
		super(new BigDecimal(valor.doubleValue()));
	}
}
