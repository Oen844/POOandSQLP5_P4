package com.P5.repositories;

import com.P5.db.DBConnection;
import com.P5.entities.Proyecto;
import org.hibernate.Session;

import java.util.List;

public class ProyectoRepository {

    public static List<Proyecto> getAll() {
        Session session = DBConnection.getSession();
        session.beginTransaction();
        List<Proyecto> proyectos = session.createQuery("FROM Proyecto ", Proyecto.class).list();
        session.close();

        return proyectos;
    }

//    public static Delegacion save(Delegacion delegacion) throws ConstraintViolationException {
//        Session session = DBConnection.getSession();
//        Transaction transaction = session.beginTransaction();
//        session.saveOrUpdate(delegacion);
//        transaction.commit();
//        session.close();
//
//        return delegacion;
//    }
//
//    public static void delete(Delegacion delegacion) {
//        Session session = DBConnection.getSession();
//        Transaction transaction = session.beginTransaction();
//        session.delete(delegacion);
//        transaction.commit();
//        session.close();
//    }
}
