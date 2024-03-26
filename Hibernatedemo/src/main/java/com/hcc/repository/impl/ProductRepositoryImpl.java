/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.repository.impl;

import com.hcc.hibernatedemo.HibernateUtils;
import com.hcc.pojo.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author ACER
 */
public class ProductRepositoryImpl {

    public List<Product> getProducts(Map<String, String> params) {
        try (Session session = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b  = session.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            Root root = q.from(Product.class);
            q.select(root);
            
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if(kw != null && !kw.isEmpty())
                predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
            
            String fromPrice = params.get("fromPrice");
            if(fromPrice != null && !fromPrice.isEmpty())
                predicates.add(b.greaterThanOrEqualTo(root.get("price"), Double.parseDouble(fromPrice) ));

            String toPrice = params.get("toPrice");
            if(toPrice != null && !toPrice.isEmpty())
                predicates.add(b.lessThanOrEqualTo(root.get("price"), Double.parseDouble(toPrice)));
            
            String cateId = params.get("cateId");
            if(cateId != null && !cateId.isEmpty())
                predicates.add(b.equal(root.get("Category").as(Integer.class), Integer.parseInt(cateId)));
            
            q.where(predicates.toArray(Predicate[]::new));
            
            
            
            q.orderBy(b.desc(root.get("id")));
            
            Query query = session.createQuery(q);
            List<Product> products = query.getResultList();

                        
            return products;
        }
    }
    public Product getProductById(int id) {
        try(Session s = HibernateUtils.getFactory().openSession()) {
            
            return s.get(Product.class, id);
        }
    }
    public void addOrUpdateProduct(Product p ) {
        try(Session s = HibernateUtils.getFactory().openSession()) {
            s.persist(p);
        }
    }
}
