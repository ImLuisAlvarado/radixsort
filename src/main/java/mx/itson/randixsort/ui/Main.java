/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.randixsort.ui;

import static mx.itson.randixsort.logic.RadixSort.printArray;
import static mx.itson.randixsort.logic.RadixSort.radixSort;

/**
 *
 * @author darkheaven
 */
public class Main {
    
    public static void main(String[] args) {
        int[] data = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(data);
        printArray(data);
    }
    
}
