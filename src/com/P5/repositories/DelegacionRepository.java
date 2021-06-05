package com.P5.repositories;

import com.P5.entities.Delegacion;
import org.hibernate.Session;
import com.P5.db.DBConnection;

import java.util.List;

public class DelegacionRepository {

    public static List<Delegacion> getAll() {
        Session session = DBConnection.getSession();
        session.beginTransaction();
        List<Delegacion> delegaciones = session.createQuery("FROM Delegacion", Delegacion.class).list();
        session.close();

        return delegaciones;
    }
}
