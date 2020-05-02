package Práctica2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;

import Practica1.CalculadoraDeMatrices;
import Practica1.Matriz;
import Practica1.Numero;
import Practica1.NumeroComplejo;
import Practica1.NumeroEntero;
import Practica1.NumeroReal;

public class Init {

	public static void main(String[] args) throws SQLException {
		Numero[][] matrizEjemplo1 = {	{new NumeroReal(new BigDecimal("-3")), new NumeroEntero(new BigInteger("3"))}, 
										{new NumeroReal(new BigDecimal("4")), new NumeroComplejo(new BigDecimal("2"), new BigDecimal("3"))}
		};
		Matriz matriz1 = new Matriz(matrizEjemplo1);
		CalculadoraDeMatrices.traza(matriz1);
		CalculadoraDeMatrices.determinante(matriz1);
		throw new SQLException("Error al consultar la matriz");
	}

}
