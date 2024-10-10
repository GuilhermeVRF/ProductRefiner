package services.cleaner;

import models.Product;
import services.readers.ColorsTXTReader;

import java.sql.SQLOutput;
import java.util.List;

public class ProductNameCleaner {
    public Product clean(Product product){
        List<String> colors = ColorsTXTReader.txtData;
        String[] sizes = {"P", "M", "G"};
        for(String color: colors){
            //if(product.getName().contains(color))  System.out.println("contém");
            product.setName(product.getName().replaceAll("(?i)\\b" + color + "\\b", "").trim());
        }

        for(String size: sizes){
            product.setName(product.getName().replaceAll("\\b"+size+"\\b", "").trim());
        }
        System.out.println(product.getName());
        return product;
    }
}
