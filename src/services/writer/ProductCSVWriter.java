package services.writer;

import java.util.ArrayList;
import java.util.List;
import models.Product;

public class ProductCSVWriter {
    private List<Product> csvData;

    public ProductCSVWriter(){
        this.csvData = new ArrayList<>();
    }

    public void write(Product product) {
        /*String[] line = new String[5];
        line[0] = product.getCode();
        line[1] = product.getName();
        line[2] = String.valueOf(product.getWidth());
        line[3] = String.valueOf(product.getLength());
        line[4] = String.valueOf(product.getHeight());*/

        this.csvData.add(product);
    }

    public List<Product> getData(){
        return this.csvData;
    }
}
