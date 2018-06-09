// Estudiantes:
// Joaquin Fernando Aguilar
// Daniel Ramos
// Davis Guerra

public class MyClass {
    public static void main(String args[]) {
        int rta = editDistance("Clumbia","Colombia");

        System.out.println("El valor final es " + rta);
    }
    
    public static int editDistance(String cadena1, String cadena2) {
    	// Se obtienen las longitudes de las cadenas de texto.
    	int num1 = cadena1.length();
    	int num2 = cadena2.length();
    	
    	// Se declara una matriz con las dimensiones de las cadenas de texto mas uno,
    	// que corresponde a la celda de la esquina superior izquierda de la matriz.
    	int[][] matriz = new int[num1 + 1][num2 + 1];
     
    	// La primera fila y columna se deben inicializar con numeros del 1 hasta la cantidad que sea.
    	for (int i = 0; i <= num1; i++) {
    		matriz[i][0] = i;
    	}
     
    	for (int j = 0; j <= num2; j++) {
    		matriz[0][j] = j;
    	}
     
    	// Ahora se inician las iteraciones.
    	for (int i = 0; i < num1; i++) {
    		// Primero se recupera el caracter en la posicion i de la primera cadena.
    		char c1 = cadena1.charAt(i);
    		for (int j = 0; j < num2; j++) {
    			// Ahora el caracter en la posicion j de la segunda cadena.
    			char c2 = cadena2.charAt(j);
    			
    			// Defino las posiciones usadas para comparar.
    			int diagonal = matriz[i][j] + ((c1 == c2) ? 0 : 1);
    			int arriba = matriz[i][j + 1] + 1;
    			int anterior = matriz[i + 1][j] + 1;
    			
    			// Ahora se selecciona el minimo de los tres valores.
    			int minimo = 0;
    			if (diagonal <= arriba && diagonal <= anterior){
    			    minimo = diagonal;
			    } else if (arriba <= diagonal && arriba <= anterior) {
		            minimo = arriba;
    			}else if (anterior <= diagonal && anterior <= arriba) {
    			    minimo = anterior;
    			}
    			
    			// Ahora se puede llenar el valor de la posicion calculada.
    			matriz[i + 1][j + 1] = minimo;
    		}
    	}
     
    	return matriz[num1][num2];
    }
}

