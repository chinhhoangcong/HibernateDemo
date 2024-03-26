/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.hcc.hibernatedemo;

import com.hcc.pojo.Category;
import com.hcc.pojo.Product;
import com.hcc.repository.impl.ProductRepositoryImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author ACER
 */
public class Hibernatedemo {

    public static void main(String[] args) {
        ProductRepositoryImpl p = new ProductRepositoryImpl();
        
        
        
        
//        Map<String ,String> params = new HashMap<>();
//        params.put("kw", "Galaxy");
//        params.put("fromPrice", "18000000");
//        params.put("toPrice", "20000000");
//        p.getProducts(params).forEach(c -> System.out.println(c.getId()+ " - " + c.getName()+ " - " + c.getPrice()));
//        try (Session s = HibernateUtils.getFactory().openSession()) {
//            Query q = s.createNamedQuery("Product.findAll");
//            List<Product> pro = q.getResultList();
//            pro.forEach(p -> System.out.println(p.getName()));
//            
////            Query q = s.createQuery("from Category");
////            List<Category> cates = q.getResultList();
////            cates.forEach(c -> System.out.println(c.getName()));
//        }
    }
}
