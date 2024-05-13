package ir.ariana.ir.connection;

import ir.ariana.ir.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {
    private SessionFactorySingleton() {}

    public static SessionFactory getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        static SessionFactory INSTANCE;

        static {
            var registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            INSTANCE = new MetadataSources(registry)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Loan.class)
                    .addAnnotatedClass(Married.class)
                    .addAnnotatedClass(University.class)
                    .addAnnotatedClass(Semester.class)
                    .addAnnotatedClass(Installment.class)
                    .addAnnotatedClass(BankCard.class)
                    .buildMetadata()
                    .buildSessionFactory();
        }
    }

}
