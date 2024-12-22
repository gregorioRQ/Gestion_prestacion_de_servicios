/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controladores;

import com.mycompany.controladores.exceptions.NonexistentEntityException;
import com.mycompany.models.Prestador;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author PC
 */
public class PrestadorJpaController implements Serializable {

    public PrestadorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
     public PrestadorJpaController() {
         emf = Persistence.createEntityManagerFactory("clase06JPAPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Prestador prestador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(prestador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Prestador prestador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            prestador = em.merge(prestador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = prestador.getId();
                if (findPrestador(id) == null) {
                    throw new NonexistentEntityException("The prestador with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Prestador prestador;
            try {
                prestador = em.getReference(Prestador.class, id);
                prestador.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The prestador with id " + id + " no longer exists.", enfe);
            }
            em.remove(prestador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Prestador> findPrestadorEntities() {
        return findPrestadorEntities(true, -1, -1);
    }

    public List<Prestador> findPrestadorEntities(int maxResults, int firstResult) {
        return findPrestadorEntities(false, maxResults, firstResult);
    }

    private List<Prestador> findPrestadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Prestador.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Prestador findPrestador(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Prestador.class, id);
        } finally {
            em.close();
        }
    }

    public int getPrestadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Prestador> rt = cq.from(Prestador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
