package com.vinhnd.quan_ly_san_pham.repository;

import com.vinhnd.quan_ly_san_pham.entity.Product;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    @PersistenceContext
    private EntityManager entityManager;

    private static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product("Iphone", 12000, "Đẹp", "Apple"));
        products.add(new Product("Samsung", 15000, "Bền", "Android"));
        products.add(new Product("Oppo", 32000, "Sang trọng", "Android"));
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p", Product.class);
        return query.getResultList();
    }


    @Override
    @Transactional
    public void add(Product product) {
        entityManager.persist(product);
    }

    @Override
    @Transactional
    public void updateById(int id, Product product) {
        Product editProduct = product;
        entityManager.merge(editProduct);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.name like :name", Product.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}
