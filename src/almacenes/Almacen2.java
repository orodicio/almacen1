package almacenes;

import java.util.Arrays;

/*
 * Implementar un almacén de enteros mediante una tabla de huecos
 * se supone que no puede contener el valor 0 ya que indica posiciones libre.
 */
public class Almacen2 {

	// Array con los valores almacenados
	private int tvalores[];
	private int posicion;

	// Constructores sin parámetros creo una tabla de 10 elementos
	public Almacen2() {
		this(10); // Llamo al constructor con parámetros
	}

	// Constructor donde se fija tamaño máximo del Almacén 
	public Almacen2(int tamaño) {
		tvalores = new int[tamaño];
		posicion = 0;
	}

	// Muestra una cadena con los valores de la tabla
	public String toString() {
		String almacen2 = "{";
		for (int i = 0; i < tvalores.length; i++) {
			almacen2 += " " + tvalores[i] + " ,";
		}
		almacen2 = almacen2 + "}";
		return almacen2;
	}

	// Devuelve el números de posiciones libres
	public int numPosicionesLibres() {
		int posicionesLibres = tvalores.length - (posicion);
		return posicionesLibres;
	}

	// Devuelve el número de posiones ocupadas
	public int numPosicionesOcupadas() {
		int posicionesOcupadas = posicion;
		return posicionesOcupadas;
	}

	// Devuelve verdadero o falso si está almacenado el valor en la tabla
	public boolean estaValor(int num) {
		return (Arrays.binarySearch(tvalores, 0, posicion, num)>= 0);
	}

	// Almacena el valor el la tabla, devuelve false sin no puede almacenarlo
	public boolean ponValor(int num) {
		
		boolean  noEstaLLena = false ;
		if (posicion < tvalores.length) {
			tvalores[posicion] = num;
			posicion++;	
			Arrays.sort(tvalores, 0, posicion);
			noEstaLLena=true;
		}
		return noEstaLLena;
	}


	// Elimina el elemento de la tabla, si no esta devuelve false//
	public boolean sacarValor(int num) {
		boolean estavalor = false;
		

		int buscado = Arrays.binarySearch(tvalores, 0,posicion, num);
        System.out.println(buscado);
		while (buscado>=0) {
			estavalor = true;
			for (int j = buscado; j <posicion-1; j++) {
				tvalores[j] = tvalores[j + 1];
			}
			tvalores[posicion-1] = 0;
			posicion--;
			buscado = Arrays.binarySearch(tvalores, 0,posicion, num);
			
		}
		return estavalor;
	}

	// Indica si el almacén esta lleno
	public boolean estaLleno() {
		if (posicion == tvalores.length - 1) {
			return true;
		}
		return false;
	}
}
