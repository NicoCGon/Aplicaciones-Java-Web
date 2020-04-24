import java.math.BigDecimal;

public class CalculadoraDeMatrices {
	public static Matriz sumar(Matriz matriz1, Matriz matriz2) {
		Matriz resultado = matriz1.clone();
		for (int i = 0; i < matriz1.getCantidadFilas(); i++) {
			for (int j = 0; j < matriz1.getCantidadColumnas(); j++) {
				resultado.getMatriz()[i][j].sumar(matriz2.getMatriz()[i][j]);
			}
		}
		return resultado;
	}
	
	public static Matriz restar(Matriz matriz1, Matriz matriz2) {
		Matriz resultado = matriz1.clone();
		for (int i = 0; i < matriz1.getCantidadFilas(); i++) {
			for (int j = 0; j < matriz1.getCantidadColumnas(); j++) {
				resultado.getMatriz()[i][j].restar(matriz2.getMatriz()[i][j]);
			}
		}
		return resultado;
	}
	
	public static void traza(Matriz matriz) {
		Numero traza = new NumeroComplejo(BigDecimal.ZERO);
		for (int i = 0; i < matriz.getCantidadFilas(); i++) {
			for (int j = 0; j < matriz.getCantidadColumnas(); j++) {
				if(i == j) {
					traza.sumar(matriz.getMatriz()[i][j]);
				}
			}
		}
		System.out.println("Traza: " + traza.toString());
	}
	
	public static void determinante(Matriz matriz) {
		//MATRIZ 2X2
		if(matriz.getCantidadFilas() == 2) {
			Numero diagonali = new NumeroComplejo(BigDecimal.ONE), mdiagonali = new NumeroComplejo(BigDecimal.ONE);
			for (int i = 0; i < matriz.getCantidadFilas(); i++) {
				for (int j = 0; j < matriz.getCantidadColumnas(); j++) {
					if(i == j) {
						diagonali.multiplicarPor(matriz.getMatriz()[i][j]);
					}
					else {
						mdiagonali.multiplicarPor(matriz.getMatriz()[i][j]);
					}
				}
			}
			diagonali.restar(mdiagonali);
			System.out.println("Determinante: " + diagonali.toString());
		}
		//MATRIZ 3x3
		if(matriz.getCantidadFilas() == 3) {
			Numero diagonali = recorrerCicloMatriz(0, matriz);
			Numero diagonalj = recorrerCicloMatriz(1, matriz);
			Numero diagonalk = recorrerCicloMatriz(2, matriz);
			Numero mdiagonali = recorrerCicloMatrizInvertido(2, matriz);
			Numero mdiagonalj = recorrerCicloMatrizInvertido(1, matriz);
			Numero mdiagonalk = recorrerCicloMatrizInvertido(0, matriz);
			
			diagonali.sumar(diagonalj);
			diagonali.sumar(diagonalk);
			diagonali.restar(mdiagonali);
			diagonali.restar(mdiagonalj);
			diagonali.restar(mdiagonalk);

			System.out.println("Determinante: " + diagonali.toString());
		}
	}
	
	//Recorre desde la posicion hasta devuelta llegar al mismo (ej: Para J posicion = 1 => [1][0],[2][1],[0][2])
	private static Numero recorrerCicloMatriz(int posicionInicial, Matriz matriz) {
		int posicionInicio = 0, posicion = 0;
		Numero diagonal = new NumeroComplejo(BigDecimal.ONE);
		for (int i = posicionInicial; i < matriz.getCantidadFilas(); i++) {
			diagonal.multiplicarPor(matriz.getMatriz()[i][posicion]);
			posicion++;
		}
		if(posicionInicial != posicionInicio) {
			for (int i = posicionInicio; i < posicionInicial; i++) {
				diagonal.multiplicarPor(matriz.getMatriz()[i][posicion]);
				posicion++;
			}
		}
		return diagonal;
	}
	
	//Recorre desde la posicion hasta devuelta llegar al mismo invertido
	private static Numero recorrerCicloMatrizInvertido(int posicion, Matriz matriz) {
		Numero diagonal = new NumeroComplejo(BigDecimal.ONE);
		for (int i = 0; i < matriz.getCantidadFilas(); i++) {
			posicion = posicion < 0 ? matriz.getCantidadFilas() -1 : posicion;
			diagonal.multiplicarPor(matriz.getMatriz()[i][posicion]);
			posicion--;
		}
		return diagonal;
	}
}
