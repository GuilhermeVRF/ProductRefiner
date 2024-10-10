/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import models.Product;
import services.cleaner.ProductNameCleaner;
import services.exporter.CSVExporter;
import services.filters.ProductDimensionsFilter;
import services.readers.CSVReader;
import services.readers.ColorsTXTReader;
import services.writer.ProductCSVWriter;

import java.util.List;

/**
 *
 * @author Guilherme
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String contentsDirectoryPath = "C:\\Users\\guilh\\Documentos\\IdeaProjects\\StockFilter\\src\\contents\\";

        // Inicializando o array com todas as cores disponíveis na loja
        ColorsTXTReader colorsArrayManipulator = new ColorsTXTReader();
        colorsArrayManipulator.read(contentsDirectoryPath + "Colors.txt");

        // Lendo a planilha comprodutos
        CSVReader sheetReader = new CSVReader(";");
        sheetReader.read("C:\\Users\\guilh\\Documentos\\IdeaProjects\\StockFilter\\src\\contents\\Sheet.csv");
        ProductNameCleaner productNameCleaner = new ProductNameCleaner();

        // Limpando o nome dos produtos "Retirando cor e tamanho"
        ProductCSVWriter productCSVWriter = new ProductCSVWriter();
        List<String[]> unrefinedProductSheet = sheetReader.getData();
        for(int line = 1; line < unrefinedProductSheet.size();line++) {
            String[] lineProduct = unrefinedProductSheet.get(line);
            Product product = new Product(lineProduct[0], lineProduct[1], Double.parseDouble(lineProduct[2]), Double.parseDouble(lineProduct[3]), Double.parseDouble(lineProduct[4]));
            product = productNameCleaner.clean(product);

            productCSVWriter.write(product);
        }

        // Filtrando os produtos iguais
        ProductDimensionsFilter productDimensionsFilter = new ProductDimensionsFilter(productCSVWriter.getData());
        productDimensionsFilter.filter();

        // Exportando os Produtos Refinados como um CSV
        CSVExporter sheetExporter = new CSVExporter(productDimensionsFilter.getData(), contentsDirectoryPath + "RefinedSheet.csv");
        sheetExporter.export();

        System.out.println(productDimensionsFilter.getData().size());
    }
}
