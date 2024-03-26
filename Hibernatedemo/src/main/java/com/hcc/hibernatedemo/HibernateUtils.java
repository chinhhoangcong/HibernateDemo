/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hcc.hibernatedemo;

import com.hcc.pojo.Category;
import com.hcc.pojo.Comment;
import com.hcc.pojo.OrderDetail;
import com.hcc.pojo.ProdTag;
import com.hcc.pojo.Product;
import com.hcc.pojo.SaleOrder;
import com.hcc.pojo.Tag;
import com.hcc.pojo.User;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author ACER
 */
public class HibernateUtils {

    private static SessionFactory factory;

    static {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
//        Properties pros = new Properties();
//        pros.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//        pros.put(Environment.URL, "jdbc:mysql://localhost/saledb");
//        pros.put(Environment.USER, "root");
//        pros.put(Environment.PASS, "38948034");
//        pros.put(Environment.SHOW_SQL, "true");
//        conf.setProperties(pros);
        
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Comment.class);
        conf.addAnnotatedClass(OrderDetail.class);
        conf.addAnnotatedClass(ProdTag.class);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(SaleOrder.class);
        conf.addAnnotatedClass(Tag.class);
        conf.addAnnotatedClass(User.class);
        
        
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        factory = conf.buildSessionFactory(registry);
        
        
    }

    /**
     * @return the factory
     */
    public static SessionFactory getFactory() {
        return factory;
    }
}
