package com.vinhnd.quan_ly_san_pham.repository;

import com.vinhnd.quan_ly_san_pham.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{

    private static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product("Iphone", 12000, "Đẹp", "Apple"));
        products.add(new Product("Samsung", 15000, "Bền", "Android"));
        products.add(new Product("Oppo", 32000, "Sang trọng", "Android"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void update(Product product) {
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getId() == product.getId()){
                products.set(i, product);
                return;
            }
        }
    }

    @Override
    public void deleteById(int id) {
        for(Product product : products){
            if (product.getId() == id){
                products.remove(product);
                return;
            }
        }
    }

    @Override
    public Product findById(int id) {
        for (Product product : products){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products){
            if(product.getName().toLowerCase().contains(name.toLowerCase())){
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }
}
