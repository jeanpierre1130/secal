/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apn.gob.pe.secajur.dao;

import apn.gob.pe.secajur.beans.AppUser;
import java.util.List;
import java.util.logging.Level;
import static java.util.logging.Level.INFO;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Desarrollo
 */
public class AccesoDAOImpl implements AccesoDAO {

    private static final Logger console = java.util.logging.Logger.getLogger(AccesoDAOImpl.class.getName());
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexionsecajur");

    @Override
    public AppUser comprobarUsuario(String usr, String pwd) {
        EntityManager em = factory.createEntityManager();
        AppUser objAppUser = null;
        try {
            objAppUser = (AppUser) em.createNamedQuery("AppUser.findbyUser").setParameter("usr", usr).getSingleResult();
            console.log(INFO, "USUARIO COMPROBADO");
        } catch (Exception e) {
            console.log(Level.WARNING, " ERROR EN AccesoDAOImpl : " + e.getMessage(), e);
        } finally {
            em.close();
        }
        return objAppUser;

    }

    @Override
    public AppUser comprobarUsuarioActivo(String usr, String pwd) {
        EntityManager em = factory.createEntityManager();
        try {
            return (AppUser) em.createNamedQuery("AppUser.validateUser").setParameter("usr", usr).setParameter("pwd", pwd).getSingleResult();
            //return (AppUser) em.createNamedQuery("AppUser.findbyUser").setParameter("usr", usr).setParameter("pwd", org.apache.commons.codec.digest.DigestUtils.sha512Hex(pwd)).getSingleResult();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al buscar el usuario" + e.getMessage(),e);
            return null;
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<AppUser> listarUsuario() {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createNamedQuery("AppUser.Listar.Todos", AppUser.class).getResultList();
        } catch (Exception e) {
            console.log(Level.WARNING, "Error al Listar Usuario" + e.getMessage(), e);
        } finally {
            em.close();
        }
        return null;
    }
}
