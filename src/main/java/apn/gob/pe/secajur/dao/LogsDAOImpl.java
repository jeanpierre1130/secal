/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.dao;

import apn.gob.pe.secajur.beans.*;
import apn.gob.pe.secajur.utiles.DateUtil;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


/**
 *
 * @author eshupingahua
 */
public class LogsDAOImpl implements LogsDAO {

    private static final Logger console = java.util.logging.Logger.getLogger(LogsDAOImpl.class.getName());
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexionsecajur");
        
    @Override
    public String grabarLogUser(AppUserLog obj) {
        EntityManager em = factory.createEntityManager();
        try {
            EntityTransaction cn = em.getTransaction();
            cn.begin();
            em.persist(obj);
            cn.commit();
            return "Registrado correctamente";
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al grabar log de usuario: " + e.getMessage(), e);
            return "Error al grabar log de usuario " + e.getMessage();
        } finally {
            em.close();
        }
    }

    @Override
    public List<AppUserLog> obtenrLogUser_User(int idcaso) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createNamedQuery("AppUserLog.obtenerLogUser", AppUserLog.class).setParameter("user", idcaso).setMaxResults(10).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al obtener log-usuario: " + e.getMessage(), e);
        } finally {
            em.close();
        }

        return null;
    }


    @Override
    public String grabarLogUser(String tipo, String cnt, AppUser obj) {
        EntityManager em = factory.createEntityManager();
        Date date = new Date();
        try {
            AppUserLog objsave = new AppUserLog();
            objsave.setLogAcion(cnt);
            objsave.setLogTipo(tipo);
            objsave.setAppUser(obj);
            objsave.setLogData(date);
            EntityTransaction cn = em.getTransaction();
            cn.begin();
            em.persist(objsave);
            cn.commit();
            return "Grabar Log-User";
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al grabar log-user: " + e.getMessage(), e);
            return "Error al grabar log-user" + e.getMessage();
        } finally {
            em.close();
        }
    }

    @Override
    public List<AppUserLog> obtenrLogUser_User_sub(int usuario, Date fecha) {
        EntityManager em = factory.createEntityManager();
        try {
            console.log(Level.WARNING, "Consultando informacion del log: " + DateUtil.getFechaTexto(fecha));
            return em.createNamedQuery("AppUserLog.obtenerLogUserFecha", AppUserLog.class).setParameter("user", usuario).setParameter("dat", DateUtil.getFechaTexto(fecha)).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al consultar la información del log: " + e.getMessage(), e);
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public List<String> obtenrLogUser_UserString(int usuario) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createNamedQuery("AppUserLog.obtenerLogUserStringdate", String.class).setParameter("user", usuario).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al obtener String(fecha) de log-user: " + e.getMessage(), e);
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public List<Date> obtenrLogUser_UserDate(int usuario) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createNamedQuery("AppUserLog.obtenerLogUserStringdate", Date.class).setParameter("user", usuario).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al obtener fecha de log-user: " + e.getMessage(), e);
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public List<AppUserLog> obtenrLogUser_User_sub2(int usuario, String fecha) {
        EntityManager em = factory.createEntityManager();
        try {
            console.log(Level.WARNING, "Consultando información de perfil de usuario (Log): " + fecha);
            return em.createNamedQuery("AppUserLog.obtenerLogUserFecha", AppUserLog.class).setParameter("user", usuario).setParameter("dat", fecha).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al consultar la informacion de perfil de usuario (Log): " + e.getMessage(), e);
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public List<AppUserLog> obtenrFullLogUser(String fecha) {
        EntityManager em = factory.createEntityManager();
        try {
            console.log(Level.WARNING, "Consultar información completa de log-user: " + fecha);
            return em.createNamedQuery("AppUserLog.obtenerFullLogUserFecha", AppUserLog.class).setParameter("dat", fecha).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al consultar información completa de log-user: " + e.getMessage(), e);
        } finally {
            em.close();
        }
        return null;
    }
}
