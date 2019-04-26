/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBA.ui;

/**
 *
 * @author Jason
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDB {

        //Insert method
	public static void insert(User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
                try {
                    em.persist(user);
                    trans.commit();
                } catch (Exception e) {
                    System.out.println(e);
                    trans.rollback();
                } finally {
                    em.close();
                }
        }
        
        //Update method
	public static void update(User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
                try {
                    em.merge(user);
                    trans.commit();
                } catch (Exception e) {
                    System.out.println(e);
                    trans.rollback();
                } finally {
                    em.close();
                }
        }
}
        
