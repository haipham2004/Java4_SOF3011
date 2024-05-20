package com.example.BTVN12c.config;
import com.example.BTVN12c.entity.LopHoc;
import com.example.BTVN12c.entity.SinhVien;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory FACTORY;


    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
        System.out.println("Kết nối thành công");
    }

    static {
        Configuration conf = new Configuration();
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        properties.put("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put("hibernate.connection.url", "jdbc:sqlserver://localhost:1433;databaseName=Buoi12");
        properties.put("hibernate.connection.username", "sa");
        properties.put("hibernate.connection.password", "Haitam77");
        properties.put("hibernate.show_sql", "true");
        conf.setProperties(properties);
        conf.addAnnotatedClass(LopHoc.class);
        conf.addAnnotatedClass(SinhVien.class);
        ServiceRegistry registry = (new StandardServiceRegistryBuilder()).applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);
    }
}
