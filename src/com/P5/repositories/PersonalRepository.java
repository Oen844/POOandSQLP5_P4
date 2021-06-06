package com.P5.repositories;

import com.P5.db.DBConnection;
import com.P5.entities.Personal;
import org.hibernate.Session;

import java.util.List;

public class PersonalRepository {

    public static List<Personal> getAll() {
        Session session = DBConnection.getSession();
        session.beginTransaction();
        List<Personal> personal = session.createQuery("FROM Personal", Personal.class).list();
        session.close();

        return personal;
    }

//    public static Proyecto save(Proyecto proyecto) throws ConstraintViolationException {
//        Session session = DBConnection.getSession();
//        Transaction transaction = session.beginTransaction();
//        session.saveOrUpdate(proyecto);
//        transaction.commit();
//        session.close();
//
//        return proyecto;
//    }
//
//    public static void delete(Proyecto proyecto) {
//        Session session = DBConnection.getSession();
//        Transaction transaction = session.beginTransaction();
//        session.delete(proyecto);
//        transaction.commit();
//        session.close();
//    }
}
