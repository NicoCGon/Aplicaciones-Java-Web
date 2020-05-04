package Matriz;
import java.math.BigDecimal;
import java.math.BigInteger;

public class NumeroEntero extends Numero{

	public NumeroEntero(BigInteger valor) {
		super(valor.doubleValue() > 0 ? new BigDecimal(valor.doubleValue()) : BigDecimal.ZERO);
		if(valor.doubleValue() < 0 )
			System.out.println("No se instancio el NumeroEntero correctamente");
	}
}
