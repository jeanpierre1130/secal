/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.dao;

import apn.gob.pe.secajur.beans.AppCaso;
import apn.gob.pe.secajur.beans.AppCasoAbogado;
import apn.gob.pe.secajur.beans.AppCasoIncidencia;
import apn.gob.pe.secajur.beans.AppCatdata;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Desarrollo
 */
public class CasoDAOImpl implements CasoDAO {

    private static final Logger console = java.util.logging.Logger.getLogger(CasoDAOImpl.class.getName());
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexionsecajur");

    @Override
    public List<AppCaso> listarCasos() {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createNamedQuery("AppCaso.listarDescendente", AppCaso.class).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error en DAO - Listar Casos: " + e.getMessage(), e);
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public String grabarCaso(AppCaso obj, String opcion) {
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
            return "Se registró el caso correctamente";

        } catch (Exception e) {
            console.log(Level.WARNING, "Error al grabar caso: " + e.getMessage(), e);
            return "Error en el registro del caso: " + e.getMessage();
        } finally {
            em.close();
        }
    }

    @Override
    public String registrarIncidencia(int idcaso, AppCasoIncidencia incidencia, String opcion) {
        EntityManager em = factory.createEntityManager();
        try {
            EntityTransaction cn = em.getTransaction();
            cn.begin();
            if (opcion.equals("I")) {
                incidencia.setAppCaso(em.find(AppCaso.class, idcaso));
                em.persist(incidencia);
            } else if (opcion.equals("U")) {
                console.log(Level.WARNING, "Actualizando: " + incidencia.getIncCod());
                em.merge(incidencia);
            }
            cn.commit();
            return "Registrado correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            console.log(Level.WARNING, "Error al registrar la incidencia: " + e.getMessage(), e);
            return "Error en el registro de incidencia " + e.getMessage();
        } finally {
            em.close();
        }
    }

    @Override
    public List<AppCasoIncidencia> listarIncidencias(int idcaso) {
        return null;
    }

    @Override
    public String desactivarIncidencia(int idIncidencia) {
        EntityManager em = factory.createEntityManager();
        try {
            EntityTransaction cn = em.getTransaction();
            AppCasoIncidencia tmp = em.find(AppCasoIncidencia.class, idIncidencia);
            tmp.setIncFlag(0);
            cn.begin();
            em.merge(tmp);
            cn.commit();
            return "Actualizado correctamente";
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al desactivar la incidencia" + e.getMessage(), e);
            return "Error en la actualización de la incidencia: " + e.getMessage();
        } finally {
            em.close();
        }
    }

    @Override
    public String actualizarCaso(AppCaso obj) {
        EntityManager em = factory.createEntityManager();
        try {
            EntityTransaction cn = em.getTransaction();
            cn.begin();
            em.merge(obj);
            cn.commit();
            return "Caso actualizado correctamente";
        } catch (Exception e) {
            em.getTransaction().rollback();
            console.log(Level.WARNING, "Error al actualizar caso: " + e.getMessage(), e);
            return "Error al actualizar caso: " + e.getMessage();
        } finally {
            em.close();
        }
    }

    @Override
    public AppCaso obtenerCaso(int code) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(AppCaso.class, code);
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al obtener caso: " + e.getMessage(), e);
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public AppCasoIncidencia obtenerIncidencia(int idIncidencia) {
        return null;
    }

    @Override
    public String callFunction(String namefuntion) {
       EntityManager em = factory.createEntityManager();
       Query result = em.createNativeQuery("select " + namefuntion + ".nextval from dual");
       return result.getSingleResult().toString();
    }

    @Override
    public List<AppCasoAbogado> obtenerDetalleCasoI(int code) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createNamedQuery("AppCasoAbogado.traerCasoAbogado", AppCasoAbogado.class).setParameter("cod", code).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, " Error en DAO - Listar Casos Abogado: " + e.getMessage(), e);
        } finally {
            em.close();
        }
        return null;
    }

}
