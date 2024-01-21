/*
- Desarrollar un algoritmo que imprima en pantalla todas las combinaciones posibles de 
ordenamiento de menor a mayor para un array de tamaño N=10, sin permitir combinaciones 
repetidas.
 */

/**
 * @author Alema
 * Interian Pech Jose Alejandro 
 * Ingenieria en Tecnologia de Software
 */
public class PermutacionesFuerzaBruta {
    
    // La variable contador guarda el total del numero de permutaciones hechas.
    private static int contador = 0;

    /**
     * Esta es la funcion principal que crea un arreglo de 10 numeros y llama
     * a la funcion para generar las permutaciones.
     * @param args
     */
    public static void main(String[] args) {
        
        // Aqui se crea el arreglo
        int[] numeros = {1, 2, 3};
        
        // Llama a la funcion para generar permutaciones
        generarPermutaciones(numeros, 0);
        
        // Muestra el total de permutaciones generadas
        System.out.println("Total de permutaciones: " + contador);
    }
    
    /**
     * Este metodo imprime los elementos de un arreglo de manera ordenada y 
     * las separa para evitar confusiones.
     * @param arr Esta variable es el arreglo de enteros.
     */
    public static void imprimir(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    
    /**
     * Este metodo es el corazon del codigo ya que se llama a si misma para
       generar las permutaciones ya que este se divide en subproblemas mas
       pequeños
     * @param arr Esta variable es el arreglo de enteros
     * @param inicio Este indice indica la posicion actual del arreglo.
     */
    public static void generarPermutaciones(int[] arr, int inicio) {
        /* Comenzamos desde el caso base {1,2,3}, cuando se llegue al final del
        arreglo se imprime la permutacion actual*/
        
        if (inicio == arr.length - 1) {
            imprimir(arr);
            contador++; // Aqui se incrementa en uno por cada permutacion
        } else {
            // Comenzamos el iterador a partir de la posicion inicio
            for (int i = inicio; i < arr.length; i++) {
                /* Intercambiamos el elemento en la posicion 'inicio' con 
                el elemento en la posicio ´i´ hasta que se recorran los numeros.
                */
                int temp = arr[inicio];
                arr[inicio] = arr[i];
                arr[i] = temp;
                
                /* Llamada recursiva para generar las permutaciones de la parte
                restante del arreglo
                */
                
                generarPermutaciones(arr, inicio + 1);
                
                /* Deshacemos el intercambio para volver al estado original y
                exlorar otras posibilidades
                */
                temp = arr[inicio];
                arr[inicio] = arr[i];
                arr[i] = temp;
            }
        }
    }

}
