package almacenes;
/*
 * Implementar un almacén de enteros mediante una tabla de huecos
 * se supone que no puede contener el valor 0 ya que indica posiciones libre.
 */
public class Almacen2 {

	static private final int LIBRE = 0;
	// Array con los valores almacenados
	private int tvalores[];
	private int posicion=0;
	
	// Constructores sin parámetros creo una tabla de 10 elementos 
	public Almacen2(){
		this(10);  // Llamo al constructor con parámetros
	}

	// Constructor donde se fija tamaño máximo del Almacén Y SE PONEN LOS VALORES ALMACENADOS A 0
	public Almacen2( int tamaño){
		tvalores = new int [tamaño];
		init();
	}
	
	// Pone todas las posiciones a LIBRES
	public void init (){
		for (int i = 0; i < tvalores.length; i++) {
			tvalores[i] = Almacen2.LIBRE;
		}
	}
	
	// Muestra una cadena con los valores de la tabla
	public String toString (){
		String almacen2="{";
		for (int i=0; i<tvalores.length; i++) {
			almacen2+= " "+tvalores[i]+" ,";
		}
		almacen2= almacen2+"}";
		return almacen2;
	}
	
	// Devuelve el números de posiciones libres
	public int numPosicionesLibres(){
		int posicionesLibres=tvalores.length-(posicion);
		return posicionesLibres;
	}
	
	// Devuelve el número de posiones ocupadas
	public int numPosicionesOcupadas(){
		int posicionesOcupadas=posicion;
		return posicionesOcupadas;
	}
	
	// Devuelve verdadero o falso si está almacenado el valor en la tabla
	public boolean estaValor ( int num){
		for (int j=0; j<posicion; j++) {
			if (tvalores[j]==num) {
				return true;
			}
		}
	return false;
	}
	
	// Almacena el valor el la tabla, devuelve false sin no puede almacenarlo
	public boolean ponValor (int num){
		int acum;
		if(posicion==tvalores.length) {
			return false;
		}
		if(posicion==0) {
			tvalores[0]=num;
			posicion++;
			return true;
		}
	for (int i=0;i<tvalores.length;i++) {
		if (tvalores[i]>=num) {
			for (int j=i;j<tvalores.length;j++ ) {
				acum=tvalores[j];
				tvalores[j]=num;
				num=acum;
			}
			posicion++;
			acum=0;
			return true;
		}
	
	}
	tvalores[posicion]=num;
	posicion++;
	return true;
	}
	
	// Elimina el elemento de la tabla, si no esta devuelve false
	public boolean sacarValor (int num){	
		boolean resultado=false;
		for (int j=0; j<=posicion; j++) {
			if (tvalores[j]==num) {
				for (int h=j; h<=posicion; h++) {
					tvalores[h]=tvalores[h+1];	
				}
				tvalores[posicion]=LIBRE;
				posicion--;
				resultado=true;
			}
		}
	return resultado;
	}
      // Indica si el almacén esta lleno
	public boolean estaLleno (){	
    if(posicion==tvalores.length-1) {
		return true;
	}
	return false;
	}
}
