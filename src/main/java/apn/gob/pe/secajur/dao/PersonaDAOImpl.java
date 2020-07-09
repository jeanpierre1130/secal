/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.dao;

import apn.gob.pe.secajur.beans.AppPersona;
import apn.gob.pe.secajur.beans.AppUser;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PersonaDAOImpl implements PersonaDAO {

    private static final Logger console = java.util.logging.Logger.getLogger(PersonaDAOImpl.class.getName());
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexionsecajur");

    @Override
    public AppPersona obtenerPersona(int code) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(AppPersona.class, code);
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al obtener persona: " + e.getMessage(), e);
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public String grabarPersona(AppPersona obj, String opcion) {
        EntityManager em = factory.createEntityManager();
        try {
            EntityTransaction cn = em.getTransaction();
            cn.begin();
            if (opcion.equals("I")) {

                em.persist(obj);
            } else if (opcion.equals("U")) {
                em.merge(obj);
            }
            cn.commit();
            return "Registrado correctamente";
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al grabar persona: " + e.getMessage(), e);
            return "Error al grabar persona: " + e.getMessage();
        } finally {
            em.close();
        }
    }

    @Override
    public String grabarUsuario(AppPersona persona, AppUser user, String opcion) {
        EntityManager em = factory.createEntityManager();
        try {
            EntityTransaction cn = em.getTransaction();
            cn.begin();
            if (opcion.equals("I")) {
                em.persist(user);
                em.persist(persona);
            } else if (opcion.equals("U")) {
                em.merge(persona);
                em.merge(user);
            }
            cn.commit();
            return "Registro grabado";

        } catch (Exception e) {
            console.log(Level.WARNING, " Error al grabar usuario: " + e.getMessage(), e);
            return "Error al grabar usuario: " + e.getMessage();
        } finally {
            em.close();
        }
    }

    @Override
    public List<AppUser> listarUsuarios() {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createNamedQuery("AppUser.findAll", AppUser.class).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al listar usuarios: " + e.getMessage(), e);
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public AppUser obtenerUsuario(int id) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(AppUser.class, id);
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al obtener usuario: " + e.getMessage(), e);
            return null;
        } finally {
            em.close();
        }
    }
    
    @Override
    public String callFunctionU(String namefuntion) {
       EntityManager em = factory.createEntityManager();
       Query result = em.createNativeQuery("select " + namefuntion + ".nextval from dual");
       return result.getSingleResult().toString();
    }

}
