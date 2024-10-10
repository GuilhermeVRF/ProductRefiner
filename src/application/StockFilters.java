/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import models.Product;
import services.cleaner.ProductNameCleaner;
import services.readers.CSVReader;
import services.readers.ColorsTXTReader;
import services.writer.ProductCSVWriter;

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
        ColorsTXTReader colorsArrayManipulator = new ColorsTXTReader();
        colorsArrayManipulator.read("C:\\Users\\guilh\\Documentos\\IdeaProjects\\StockFilter\\src\\contents\\Colors.txt");

        // Lendo a planilha comprodutos
        CSVReader sheetReader = new CSVReader(";");
        sheetReader.read("C:\\Users\\guilh\\Documentos\\IdeaProjects\\StockFilter\\src\\contents\\Sheet.csv");
        ProductNameCleaner productNameCleaner = new ProductNameCleaner();

        ProductCSVWriter productCSVWriter = new ProductCSVWriter();
        for(String[] line : sheetReader.getData() ){
            Product product = new Product(line[0], line[1], Double.parseDouble(line[2]), Double.parseDouble(line[3]), Double.parseDouble(line[4]));
            product = productNameCleaner.clean(product);

            productCSVWriter.write(product);
        }
    }
    
}
