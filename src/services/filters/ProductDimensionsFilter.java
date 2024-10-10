package services.filters;

import models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDimensionsFilter {
    private List<Product> csvProducts;

    public ProductDimensionsFilter(List<Product> csvProducts){
        this.csvProducts = csvProducts;
    }

    public void filter(){
        this.csvProducts = this.csvProducts.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Product> getData(){
        return this.csvProducts;
    }
}
