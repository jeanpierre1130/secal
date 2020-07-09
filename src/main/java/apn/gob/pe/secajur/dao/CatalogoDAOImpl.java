/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.dao;

import apn.gob.pe.secajur.beans.AppCaso;
import apn.gob.pe.secajur.beans.AppCatcabe;
import apn.gob.pe.secajur.beans.AppCatdata;
import apn.gob.pe.secajur.service.CatalologoServiceImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Desarrollo
 */
public class CatalogoDAOImpl implements CatalogoDAO {

    private static final Logger console = java.util.logging.Logger.getLogger(CatalogoDAOImpl.class.getName());
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexionsecajur");

    @Override
    public List<AppCatdata> listarestadosdeCaso() {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createNamedQuery("AppCatdata.obtenerEstadosdeCaso", AppCatdata.class).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al listar estados de caso: " + e.getMessage(), e);
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public List<AppCatdata> listarTipodeprocesoDemanda() {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createNamedQuery("AppCatdata.obtenerTipodesrpocesodeCaso", AppCatdata.class).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al listar tipo de proceso de demanda: " + e.getMessage(), e);
        } finally {
            em.close();
        }
        return null;
    }
    
    @Override
    public List<AppCatdata> listarTipoEstado() {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createNamedQuery("AppCatdata.obtenerTipoEstado", AppCatdata.class).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al listar tipo de estado: " + e.getMessage(), e);
        } finally {
            em.close();
        }

        return null;
    }
    
    @Override
    public List<AppCatdata> listarTipoArea() {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createNamedQuery("AppCatdata.obtenerTipoArea", AppCatdata.class).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al listar tipo de area: " + e.getMessage(), e);
        } finally {
            em.close();
        }

        return null;
    }
    
    @Override
    public List<AppCatdata> listarTipoMoneda() {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createNamedQuery("AppCatdata.obtenerTipoMoneda", AppCatdata.class).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al listar tipo de moneda: " + e.getMessage(), e);
        } finally {
            em.close();
        }
        return null;
    }
    
    @Override
    public List<AppCatdata> listarTipoDepend() {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createNamedQuery("AppCatdata.obtenerTipoDepend", AppCatdata.class).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al listar tipo de dependencia: " + e.getMessage(), e);
        } finally {
            em.close();
        }
        return null;
    }
    
    @Override
    public List<AppCatdata> listarTipodeMateria() {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createNamedQuery("AppCatdata.obtenerTipodeMateria", AppCatdata.class).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al listar tipo de materia: " + e.getMessage(), e);
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public AppCatdata obtenerSubCatalogo(int codcat) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createNamedQuery("AppCatdata.obtenerSubCatalgo", AppCatdata.class).setParameter("codcat", codcat).getSingleResult();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al obtener sub-catalogo: " + e.getMessage(), e);
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public String grabarCatalogo(AppCatdata obj, String opcion) {
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
            return "Registro de catalogo exitoso";
        } catch (Exception e) {
            return "Error en el registro de catalogo: " + e.getMessage();
        } finally {
            em.close();
        }
    }

    @Override
    public List<AppCatcabe> listarCabeceraCatalogo() {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createNamedQuery("AppCatcabe.catalogoMantener", AppCatcabe.class).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, " ERROR EN DAO LISTAR : " + e.getMessage(), e);
        } finally {
            em.close();
        }

        return null;
    }

}
