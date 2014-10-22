/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import bean.exceptions.NonexistentEntityException;
import bean.exceptions.PreexistingEntityException;
import bean.exceptions.RollbackFailureException;
import data.FaradayBooking;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import data.FaradayPlace;
import data.FaradayDriver;
import data.FaradayCar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Paul
 */
public class FaradayBookingJpaController implements Serializable {

    public FaradayBookingJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FaradayBooking faradayBooking) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            FaradayPlace pickupPlaceId = faradayBooking.getPickupPlaceId();
            if (pickupPlaceId != null) {
                pickupPlaceId = em.getReference(pickupPlaceId.getClass(), pickupPlaceId.getId());
                faradayBooking.setPickupPlaceId(pickupPlaceId);
            }
            FaradayPlace deliveryPlaceId = faradayBooking.getDeliveryPlaceId();
            if (deliveryPlaceId != null) {
                deliveryPlaceId = em.getReference(deliveryPlaceId.getClass(), deliveryPlaceId.getId());
                faradayBooking.setDeliveryPlaceId(deliveryPlaceId);
            }
            FaradayDriver driverLicenseNo = faradayBooking.getDriverLicenseNo();
            if (driverLicenseNo != null) {
                driverLicenseNo = em.getReference(driverLicenseNo.getClass(), driverLicenseNo.getLicenceNo());
                faradayBooking.setDriverLicenseNo(driverLicenseNo);
            }
            FaradayCar carLicensePlateNo = faradayBooking.getCarLicensePlateNo();
            if (carLicensePlateNo != null) {
                carLicensePlateNo = em.getReference(carLicensePlateNo.getClass(), carLicensePlateNo.getLicensePlateNo());
                faradayBooking.setCarLicensePlateNo(carLicensePlateNo);
            }
            em.persist(faradayBooking);
            if (pickupPlaceId != null) {
                pickupPlaceId.getFaradayBookingList().add(faradayBooking);
                pickupPlaceId = em.merge(pickupPlaceId);
            }
            if (deliveryPlaceId != null) {
                deliveryPlaceId.getFaradayBookingList().add(faradayBooking);
                deliveryPlaceId = em.merge(deliveryPlaceId);
            }
            if (driverLicenseNo != null) {
                driverLicenseNo.getFaradayBookingList().add(faradayBooking);
                driverLicenseNo = em.merge(driverLicenseNo);
            }
            if (carLicensePlateNo != null) {
                carLicensePlateNo.getFaradayBookingList().add(faradayBooking);
                carLicensePlateNo = em.merge(carLicensePlateNo);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findFaradayBooking(faradayBooking.getBookingNo()) != null) {
                throw new PreexistingEntityException("FaradayBooking " + faradayBooking + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FaradayBooking faradayBooking) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            FaradayBooking persistentFaradayBooking = em.find(FaradayBooking.class, faradayBooking.getBookingNo());
            FaradayPlace pickupPlaceIdOld = persistentFaradayBooking.getPickupPlaceId();
            FaradayPlace pickupPlaceIdNew = faradayBooking.getPickupPlaceId();
            FaradayPlace deliveryPlaceIdOld = persistentFaradayBooking.getDeliveryPlaceId();
            FaradayPlace deliveryPlaceIdNew = faradayBooking.getDeliveryPlaceId();
            FaradayDriver driverLicenseNoOld = persistentFaradayBooking.getDriverLicenseNo();
            FaradayDriver driverLicenseNoNew = faradayBooking.getDriverLicenseNo();
            FaradayCar carLicensePlateNoOld = persistentFaradayBooking.getCarLicensePlateNo();
            FaradayCar carLicensePlateNoNew = faradayBooking.getCarLicensePlateNo();
            if (pickupPlaceIdNew != null) {
                pickupPlaceIdNew = em.getReference(pickupPlaceIdNew.getClass(), pickupPlaceIdNew.getId());
                faradayBooking.setPickupPlaceId(pickupPlaceIdNew);
            }
            if (deliveryPlaceIdNew != null) {
                deliveryPlaceIdNew = em.getReference(deliveryPlaceIdNew.getClass(), deliveryPlaceIdNew.getId());
                faradayBooking.setDeliveryPlaceId(deliveryPlaceIdNew);
            }
            if (driverLicenseNoNew != null) {
                driverLicenseNoNew = em.getReference(driverLicenseNoNew.getClass(), driverLicenseNoNew.getLicenceNo());
                faradayBooking.setDriverLicenseNo(driverLicenseNoNew);
            }
            if (carLicensePlateNoNew != null) {
                carLicensePlateNoNew = em.getReference(carLicensePlateNoNew.getClass(), carLicensePlateNoNew.getLicensePlateNo());
                faradayBooking.setCarLicensePlateNo(carLicensePlateNoNew);
            }
            faradayBooking = em.merge(faradayBooking);
            if (pickupPlaceIdOld != null && !pickupPlaceIdOld.equals(pickupPlaceIdNew)) {
                pickupPlaceIdOld.getFaradayBookingList().remove(faradayBooking);
                pickupPlaceIdOld = em.merge(pickupPlaceIdOld);
            }
            if (pickupPlaceIdNew != null && !pickupPlaceIdNew.equals(pickupPlaceIdOld)) {
                pickupPlaceIdNew.getFaradayBookingList().add(faradayBooking);
                pickupPlaceIdNew = em.merge(pickupPlaceIdNew);
            }
            if (deliveryPlaceIdOld != null && !deliveryPlaceIdOld.equals(deliveryPlaceIdNew)) {
                deliveryPlaceIdOld.getFaradayBookingList().remove(faradayBooking);
                deliveryPlaceIdOld = em.merge(deliveryPlaceIdOld);
            }
            if (deliveryPlaceIdNew != null && !deliveryPlaceIdNew.equals(deliveryPlaceIdOld)) {
                deliveryPlaceIdNew.getFaradayBookingList().add(faradayBooking);
                deliveryPlaceIdNew = em.merge(deliveryPlaceIdNew);
            }
            if (driverLicenseNoOld != null && !driverLicenseNoOld.equals(driverLicenseNoNew)) {
                driverLicenseNoOld.getFaradayBookingList().remove(faradayBooking);
                driverLicenseNoOld = em.merge(driverLicenseNoOld);
            }
            if (driverLicenseNoNew != null && !driverLicenseNoNew.equals(driverLicenseNoOld)) {
                driverLicenseNoNew.getFaradayBookingList().add(faradayBooking);
                driverLicenseNoNew = em.merge(driverLicenseNoNew);
            }
            if (carLicensePlateNoOld != null && !carLicensePlateNoOld.equals(carLicensePlateNoNew)) {
                carLicensePlateNoOld.getFaradayBookingList().remove(faradayBooking);
                carLicensePlateNoOld = em.merge(carLicensePlateNoOld);
            }
            if (carLicensePlateNoNew != null && !carLicensePlateNoNew.equals(carLicensePlateNoOld)) {
                carLicensePlateNoNew.getFaradayBookingList().add(faradayBooking);
                carLicensePlateNoNew = em.merge(carLicensePlateNoNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = faradayBooking.getBookingNo();
                if (findFaradayBooking(id) == null) {
                    throw new NonexistentEntityException("The faradayBooking with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            FaradayBooking faradayBooking;
            try {
                faradayBooking = em.getReference(FaradayBooking.class, id);
                faradayBooking.getBookingNo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The faradayBooking with id " + id + " no longer exists.", enfe);
            }
            FaradayPlace pickupPlaceId = faradayBooking.getPickupPlaceId();
            if (pickupPlaceId != null) {
                pickupPlaceId.getFaradayBookingList().remove(faradayBooking);
                pickupPlaceId = em.merge(pickupPlaceId);
            }
            FaradayPlace deliveryPlaceId = faradayBooking.getDeliveryPlaceId();
            if (deliveryPlaceId != null) {
                deliveryPlaceId.getFaradayBookingList().remove(faradayBooking);
                deliveryPlaceId = em.merge(deliveryPlaceId);
            }
            FaradayDriver driverLicenseNo = faradayBooking.getDriverLicenseNo();
            if (driverLicenseNo != null) {
                driverLicenseNo.getFaradayBookingList().remove(faradayBooking);
                driverLicenseNo = em.merge(driverLicenseNo);
            }
            FaradayCar carLicensePlateNo = faradayBooking.getCarLicensePlateNo();
            if (carLicensePlateNo != null) {
                carLicensePlateNo.getFaradayBookingList().remove(faradayBooking);
                carLicensePlateNo = em.merge(carLicensePlateNo);
            }
            em.remove(faradayBooking);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FaradayBooking> findFaradayBookingEntities() {
        return findFaradayBookingEntities(true, -1, -1);
    }

    public List<FaradayBooking> findFaradayBookingEntities(int maxResults, int firstResult) {
        return findFaradayBookingEntities(false, maxResults, firstResult);
    }

    private List<FaradayBooking> findFaradayBookingEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FaradayBooking.class));
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

    public FaradayBooking findFaradayBooking(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FaradayBooking.class, id);
        } finally {
            em.close();
        }
    }

    public int getFaradayBookingCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FaradayBooking> rt = cq.from(FaradayBooking.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
