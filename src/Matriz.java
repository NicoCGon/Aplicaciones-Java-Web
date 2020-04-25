public class Matriz {
	private int cantidadFilas;
	private int cantidadColumnas;
	private Numero[][] matriz;

	public Matriz(Numero[][] matriz) {
		this.cantidadFilas = matriz.length;
		this.cantidadColumnas = matriz.length > 0 ? matriz[0].length : 0;
		this.matriz = matriz;
	}

	public int getCantidadFilas() {
		return cantidadFilas;
	}

	public void setCantidadFilas(int cantidadFilas) {
		this.cantidadFilas = cantidadFilas;
	}

	public int getCantidadColumnas() {
		return cantidadColumnas;
	}

	public void setCantidadColumnas(int cantidadColumnas) {
		this.cantidadColumnas = cantidadColumnas;
	}

	public Numero[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(Numero[][] matriz) {
		this.matriz = matriz;
	}
	
	public Matriz clone() {
		Numero[][] tempMatriz = new Numero[this.cantidadFilas][this.cantidadColumnas];
		for (int i = 0; i < this.cantidadFilas; i++) {
			for (int j = 0; j < this.cantidadColumnas; j++) {
				tempMatriz[i][j] = matriz[i][j].clone();
			}
		}
		return new Matriz(tempMatriz);
	}
	
}
