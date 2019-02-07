package almacenes;
/*
 * Implementar un almacén de enteros mediante una tabla de huecos
 * se supone que no puede contener el valor 0 ya que indica posiciones libre.
 */
public class Almacen1 {

	static private final int LIBRE = 0;
	// Array con los valores almacenados
	private int tvalores[];
	private int valoresAlmacenados = 0;
	
	// Constructores sin parámetros creo una tabla de 10 elementos 
	public Almacen1(){
		this(10);  // Llamo al constructor con parámetros
	}

	// Constructor donde se fija tamaño máximo del Almacén
	public Almacen1( int tamaño){
		tvalores = new int [tamaño];
		init();
	}
	
	// Pone todas las posiciones a LIBRES
	public void init (){
		for (int i = 0; i < tvalores.length; i++) {
			tvalores[i] = Almacen1.LIBRE;
		}
		valoresAlmacenados = 0;
	}
	
	// Muestra una cadena con los valores de la tabla
	public String toString (){
		String almacen1="{";
		for (int i=0; i<tvalores.length; i++) {
			almacen1+= " "+tvalores[i]+" ,";
		}
		almacen1= almacen1+"}";
		return almacen1;
	}
	
	// Devuelve el números de posiciones libres
	public int numPosicionesLibres(){
		int contador=tvalores.length-valoresAlmacenados;
		return contador;
	}
	
	// Devuelve el número de posiones ocupadas
	public int numPosicionesOcupadas(){
		int contador=0;
		for (int j=0; j<tvalores.length; j++) {
			if (tvalores[j]!= LIBRE) {
			contador++;	
			}
		}
		return contador;
	}
	
	// Devuelve verdadero o falso si está almacenado el valor en la tabla
	public boolean estaValor ( int num){
		for (int j=0; j<tvalores.length; j++) {
			if (tvalores[j]==num) {
				return true;
			}
		}
	return false;
	}
	
	// Almacena el valor el la tabla, devuelve false sin no puede almacenarlo
	public boolean ponValor (int num){
			for (int j=valoresAlmacenados; j<tvalores.length;j++) {
			if (tvalores[j]==LIBRE) {
				tvalores[j]=num;
				valoresAlmacenados++;
				return true;
			}
		}
		return false;
	}
	
	// Elimina el elemento de la tabla, si no esta devuelve false
	public boolean sacarValor (int num){	
		boolean resultado=false;
		for (int j=0; j<tvalores.length; j++) {
			if (tvalores[j]==num) {
				tvalores[j]=0;
				valoresAlmacenados--;
				resultado=true;
			}
		}
	return resultado;
	}
      // Indica si el almacén esta lleno
	public boolean estaLleno (){	
		for (int j=0; j<tvalores.length; j++) {
			if (tvalores[j]==LIBRE) {
			return false;
			}
		}
	return true;
	}
}