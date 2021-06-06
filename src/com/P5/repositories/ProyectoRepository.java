package com.P5.repositories;

import com.P5.db.DBConnection;
import com.P5.entities.Personal;
import com.P5.entities.Proyecto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class ProyectoRepository {

    public static List<Proyecto> getAll() {
        Session session = DBConnection.getSession();
        session.beginTransaction();
        List<Proyecto> proyectos = session.createQuery("FROM Proyecto", Proyecto.class).list();
        session.close();

        return proyectos;
    }

    public static Proyecto save(Proyecto proyecto) throws ConstraintViolationException {
        Session session = DBConnection.getSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(proyecto);

        for (Personal p : proyecto.getPersonalAsociado()) {
            boolean insertProyect = true;
            List<Proyecto> proyectos = p.getProyectos();
            for (int i = 0; i < proyectos.size(); i++) {
                Proyecto proyectoPersonal = proyectos.get(i);
                if (proyectoPersonal.getId() == proyecto.getId()) {
                    insertProyect = false;
                }
            }
            if (insertProyect) {
                proyectos.add(proyecto);
            }
            p.setProyectos(proyectos);
            session.saveOrUpdate(p);
        }

        transaction.commit();
        session.close();

//        session = DBConnection.getSession();
//        transaction = session.beginTransaction();
//
//        NativeQuery personalProyecto = session.createSQLQuery("SELECT * FROM Personal_Proyecto");
//        List<Object[]> entities = personalProyecto.list();
//        List<Object[]> real = new ArrayList<>();
//        for (Object[] entity : entities) {
//            boolean insert = true;
//            for (Object[] r : real) {
//                if (r[0] == entity[0] && r[1] == entity[1]) {
//                    insert = false;
//                }
//            }
//
//            if (insert) {
//                real.add(new Object[]{entity[0], entity[1]});
//            }
//        }
//
//        NativeQuery truncate = session.createSQLQuery("TRUNCATE Personal_Proyecto");
//        truncate.executeUpdate();
//
//        for (Object[] r : real) {
//            NativeQuery insert = session.createSQLQuery("INSERT INTO Personal_Proyecto (personalAsociado_id, proyectos_id) VALUES(?, ?)");
//            insert.setParameter(1, r[0]);
//            insert.setParameter(2, r[1]);
//            insert.executeUpdate();
//        }
//        transaction.commit();
//        session.close();

        return proyecto;
    }

    public static void delete(Proyecto proyecto) {
        Session session = DBConnection.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(proyecto);
        transaction.commit();
        session.close();
    }
}
