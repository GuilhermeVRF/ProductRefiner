/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import models.manipulators.ColorsArrayManipulator;

/**
 *
 * @author Guilherme
 */
public class StockFilters {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Inicializando o array com todas as cores disponíveis na loja
        ColorsArrayManipulator colorsArrayManipulator = new ColorsArrayManipulator();
        System.out.println(colorsArrayManipulator.get());
    }
    
}
