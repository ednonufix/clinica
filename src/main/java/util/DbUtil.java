/*
 * Copyright (C) 2016 Eduardo Noel <enoel.corebsd@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistencia.TDeficiencias;
import persistencia.TDiagnostico;
import persistencia.TPaciente;

/**
 *
 * @author Eduardo Noel <enoel.corebsd@gmail.com>
 */
public class DbUtil {

    private DbUtil() {
    }

    public static DbUtil Singleton() {
        return DbUtilHolder.INSTANCE;
    }

    private static class DbUtilHolder {

        private static final DbUtil INSTANCE = new DbUtil();

    }

    public Long Crear_Paciente(TPaciente pac) throws HibernateException, SQLException {

        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sess.beginTransaction();

        try {

            sess.persist(pac);
            tx.commit();

        } catch (HibernateException ex) {

            Logger.getLogger("Hibernate Error").log(Level.SEVERE, ex.getMessage());

            if (tx != null) {
                tx.rollback();
            }

            throw ex;

        } finally {

            sess.disconnect();

        }

        return pac.getId_paciente();

    }

    public Long Crear_Diag(TDiagnostico generico) throws RuntimeException {

        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sess.beginTransaction();

        try {

            sess.persist(generico);
            tx.commit();

        } catch (RuntimeException ex) {

            Logger.getLogger("Hibernate Error").log(Level.SEVERE, ex.getMessage());

            if (tx != null) {
                tx.rollback();
            }

            throw ex;

        } finally {

            sess.disconnect();

        }

        return generico.getId_diag();

    }
    
    public Long Crear_Def(TDeficiencias generico) throws RuntimeException {

        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sess.beginTransaction();

        try {

            sess.persist(generico);
            tx.commit();

        } catch (RuntimeException ex) {

            Logger.getLogger("Hibernate Error").log(Level.SEVERE, ex.getMessage());

            if (tx != null) {
                tx.rollback();
            }

            throw ex;

        } finally {

            sess.disconnect();

        }

        return generico.getId_def();

    }

    public ObservableList<TDiagnostico> Lista_Diag() throws RuntimeException {

        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sess.beginTransaction();

        ObservableList<TDiagnostico> lista = FXCollections.observableArrayList();

        try {

            List<TDiagnostico> lista2 = new ArrayList<>();

            lista2 = sess.createQuery("from TDiagnostico").list();

            lista2.forEach(valor -> {

                lista.add(valor);

            });

            tx.commit();

        } catch (RuntimeException ex) {

            Logger.getLogger("Hibernate Error").log(Level.SEVERE, ex.getMessage());

        } finally {

            sess.disconnect();

        }

        return lista;

    }

    public ObservableList<TDeficiencias> Lista_Def() throws RuntimeException {

        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sess.beginTransaction();

        ObservableList<TDeficiencias> lista = FXCollections.observableArrayList();

        try {

            List<TDeficiencias> lista2 = new ArrayList<>();

            lista2 = sess.createQuery("from TDeficiencias").list();

            lista2.forEach(valor -> {

                lista.add(valor);

            });

            tx.commit();

        } catch (RuntimeException ex) {

            Logger.getLogger("Hibernate Error").log(Level.SEVERE, ex.getMessage());

        } finally {

            sess.disconnect();

        }

        return lista;

    }
    
    public void Borrar_Diagnostico(Long id_diag) throws RuntimeException {

        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sess.beginTransaction();

        try {

            TDiagnostico diag = sess.load(TDiagnostico.class, id_diag);
            sess.delete(diag);

            tx.commit();


        } catch (RuntimeException ex) {

            Logger.getLogger("Hibernate Error").log(Level.SEVERE, ex.getMessage());

        } finally {

            sess.close();

        }
        
    }
    
    public void Borrar_Deficiencias(Long valor) throws RuntimeException {

        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sess.beginTransaction();

        try {

            TDeficiencias def = sess.load(TDeficiencias.class, valor);
            sess.delete(def);

            tx.commit();


        } catch (RuntimeException ex) {

            Logger.getLogger("Hibernate Error").log(Level.SEVERE, ex.getMessage());

        } finally {

            sess.close();

        }
        
    }
    
    public ObservableList<TPaciente> Lista_Paciente_dado_CI(String ci)throws RuntimeException{
    
        Session sess = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = sess.beginTransaction();
        ObservableList<TPaciente> lista = FXCollections.observableArrayList();
                
        try {
            
            String query = "from TPaciente as pac where pac.ci like :ci";
            
            List<TPaciente> gen = sess.createQuery(query)
                    .setParameter("ci", ci)
                    .list();
            
            gen.forEach(valor->{
            
                lista.add(valor);
                
            });
            
            tx.commit();
        }
        catch (HibernateException ex) {
            
            Logger.getLogger("Hibernate Error").log(Level.SEVERE, ex.getMessage());
            
        }
        finally {
            
            sess.close();
            
        }
        
        return lista;
        
    }

}
