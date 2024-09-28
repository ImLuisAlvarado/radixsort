/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.itson.randixsort.logic;

/**
 * Clase RadixSort que contiene métodos para ordenar un arreglo de enteros utilizando el algoritmo RadixSort.
 */
public class RadixSort {

    /**
     * Método radixSort que ordena el arreglo de enteros utilizando el algoritmo RadixSort.
     * 
     * @param arr Arreglo de enteros a ordenar.
     */
    public static void radixSort(int[] arr) {
        int max = getMax(arr); // Encuentra el máximo valor en el arreglo.
        for (int exp = 1; max / exp > 0; exp *= 10) { // Itera sobre el arreglo, empezando desde la unidad (exp = 1) y multiplicando por 10 en cada iteración.
            countingSort(arr, exp); // Llama al método countingSort para ordenar el arreglo según la cifra actual (exp).
        }
    }

    /**
     * Método getMax que devuelve el máximo valor en el arreglo.
     * 
     * @param array Arreglo de enteros.
     * @return Máximo valor en el arreglo.
     */
    private static int getMax(int[] array) {
        int max = array[0]; // Inicializa el valor máximo con el primer elemento del arreglo.
        for (int i = 1; i < array.length; i++) { // Itera sobre el arreglo, comparando cada elemento con el valor máximo actual.
            if (array[i] > max) {
                max = array[i]; // Actualiza el valor máximo si se encuentra un elemento mayor.
            }
        }
        return max;
    }

    /**
     * Método countingSort que ordena el arreglo según la cifra actual (exp) utilizando el algoritmo Counting Sort.
     * 
     * @param arr Arreglo de enteros a ordenar.
     * @param exp Cifra actual (exp) para ordenar el arreglo.
     */
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length; // Tamaño del arreglo.
        int[] output = new int[n]; // Arreglo de salida para almacenar el arreglo ordenado.
        int[] count = new int[10]; // Arreglo de conteo para almacenar la frecuencia de cada dígito (0-9) en la cifra actual.

        for (int i = 0; i < n; i++) { // Itera sobre el arreglo original, incrementando la frecuencia correspondiente en el arreglo de conteo para cada elemento.
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) { // Itera sobre el arreglo de conteo, sumando la frecuencia de cada elemento con la frecuencia del elemento anterior.
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) { // Itera sobre el arreglo original en orden inverso, colocando cada elemento en su posición final en el arreglo de salida (output).
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) { // Copia el arreglo de salida (output) al arreglo original.
            arr[i] = output[i];
        }
    }

    /**
     * Método printArray que imprime el arreglo ordenado.
     * 
     * @param arr Arreglo de enteros ordenado.
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // Itera sobre el arreglo, imprimiendo cada elemento seguido de un espacio.
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // Imprime un salto de línea al final.
    }
}