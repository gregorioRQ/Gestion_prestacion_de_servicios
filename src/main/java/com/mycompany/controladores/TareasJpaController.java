/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controladores;

import com.mycompany.controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.models.Servicio;
import com.mycompany.models.Tareas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC
 */
public class TareasJpaController implements Serializable {

    public TareasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public TareasJpaController() {
        emf = Persistence.createEntityManagerFactory("clase06JPAPU");
    }
    
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tareas tareas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicio servicio = tareas.getServicio();
            if (servicio != null) {
                servicio = em.getReference(servicio.getClass(), servicio.getId());
                tareas.setServicio(servicio);
            }
            em.persist(tareas);
            if (servicio != null) {
                servicio.getListaTareas().add(tareas);
                servicio = em.merge(servicio);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tareas tareas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tareas persistentTareas = em.find(Tareas.class, tareas.getId());
            Servicio servicioOld = persistentTareas.getServicio();
            Servicio servicioNew = tareas.getServicio();
            if (servicioNew != null) {
                servicioNew = em.getReference(servicioNew.getClass(), servicioNew.getId());
                tareas.setServicio(servicioNew);
            }
            tareas = em.merge(tareas);
            if (servicioOld != null && !servicioOld.equals(servicioNew)) {
                servicioOld.getListaTareas().remove(tareas);
                servicioOld = em.merge(servicioOld);
            }
            if (servicioNew != null && !servicioNew.equals(servicioOld)) {
                servicioNew.getListaTareas().add(tareas);
                servicioNew = em.merge(servicioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tareas.getId();
                if (findTareas(id) == null) {
                    throw new NonexistentEntityException("The tareas with id " + id + " no longer exists.");
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
            Tareas tareas;
            try {
                tareas = em.getReference(Tareas.class, id);
                tareas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tareas with id " + id + " no longer exists.", enfe);
            }
            Servicio servicio = tareas.getServicio();
            if (servicio != null) {
                servicio.getListaTareas().remove(tareas);
                servicio = em.merge(servicio);
            }
            em.remove(tareas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tareas> findTareasEntities() {
        return findTareasEntities(true, -1, -1);
    }

    public List<Tareas> findTareasEntities(int maxResults, int firstResult) {
        return findTareasEntities(false, maxResults, firstResult);
    }

    private List<Tareas> findTareasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tareas.class));
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

    public Tareas findTareas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tareas.class, id);
        } finally {
            em.close();
        }
    }

    public int getTareasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tareas> rt = cq.from(Tareas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
