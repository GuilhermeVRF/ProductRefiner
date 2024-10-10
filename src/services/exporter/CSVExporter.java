package services.exporter;

import models.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {
    private List<Product> csvData;
    private String path;

    public CSVExporter(List<Product> csvData, String path){
        this.csvData = csvData;
        this.path = path;
    }

    public void export(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.path))){
            bufferedWriter.write("Código;Nome;Comprimento;Altura;Largura");
            bufferedWriter.newLine();
            for(Product productLine: this.csvData){
                String csvLine = productLine.getCode() + ";" + productLine.getName() + ";" + productLine.getWidth() + ";" +
                        productLine.getHeight() + ";" + productLine.getLength() + ";";
                bufferedWriter.write(csvLine);
                bufferedWriter.newLine();
            }
        }catch(IOException exception){
            System.err.print("An error occurred during the file writing: "+ exception.getMessage());
        }

    }
}
