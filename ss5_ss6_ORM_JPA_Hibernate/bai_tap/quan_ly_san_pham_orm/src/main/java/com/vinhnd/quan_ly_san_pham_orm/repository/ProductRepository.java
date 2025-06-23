package com.vinhnd.quan_ly_san_pham_orm.repository;

import com.vinhnd.quan_ly_san_pham_orm.entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{

    @Override
    public List<Product> findAll() {
        Session session = ConnectUtil.sessionFactory.openSession();
        TypedQuery<Product> query = session.createQuery("FROM Product", Product.class);
        return query.getResultList();
    }

    @Override
    public void add(Product product) {
        Transaction transaction = null;
        try (Session session = ConnectUtil.sessionFactory.openSession();){
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
        }catch (RuntimeException e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        Product updateProduct = product;
        Transaction transaction = null;
        try (Session session = ConnectUtil.sessionFactory.openSession();){
            transaction = session.beginTransaction();
            session.merge(updateProduct);
            transaction.commit();
        }catch (RuntimeException e){
            transaction.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void deleteById(int id) {
        Product product = findById(id);
        Transaction transaction = null;
        try (Session session = ConnectUtil.sessionFactory.openSession();){
            transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();
        }catch (RuntimeException e){
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
        Session session = ConnectUtil.sessionFactory.openSession();
        return session.find(Product.class, id);
    }

    @Override
    public List<Product> findByName(String name) {
        Session session = ConnectUtil.sessionFactory.openSession();
        TypedQuery<Product> query = session.createNativeQuery("select * from products where name like ?1", Product.class);
        query.setParameter(1, "%" + name + "%");
        return query.getResultList();
    }
}
