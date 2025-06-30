package com.vinhnd.quan_ly_gio_hang.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

    public void removeProduct(Product product) {
        if (checkItemInCart(product)) {
            products.remove(product);
        }
    }

    public void decreaseQuantity(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
                Integer newQuantity = itemEntry.getValue() - 1;
                if (newQuantity <= 0) {
                    products.remove(product);
                } else {
                    products.replace(itemEntry.getKey(), newQuantity);
                }
            }
        }
    }

    public void increaseQuantity(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
                Integer newQuantity = itemEntry.getValue() + 1;
                products.replace(itemEntry.getKey(), newQuantity);
            }
        }
    }

    public void cleanAll() {
        products = new HashMap<>();
    }
}
