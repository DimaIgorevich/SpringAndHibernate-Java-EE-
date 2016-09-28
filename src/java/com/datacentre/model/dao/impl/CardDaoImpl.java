/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacentre.model.dao.impl;

import com.datacentre.model.dao.CardDao;
import com.datacentre.model.pojo.RegistrationCard;
import com.datacentre.model.utils.HibernateUtil;
import java.util.Calendar;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public class CardDaoImpl implements CardDao{    
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    @Override
    public void add(RegistrationCard card) {
        card.setDateRegistration(Calendar.getInstance().getTime());
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery insertQuery = session.createSQLQuery("" +
		"INSERT INTO registration_card(mobile,full_name,age,date_registration)VALUES(?,?,?,?)");
        insertQuery.setParameter(0, card.getMobile());
        insertQuery.setParameter(1, card.getFullName());
        insertQuery.setParameter(2, card.getAge());
        insertQuery.setParameter(3, card.getDateRegistration());
        insertQuery.executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void edit(RegistrationCard card) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery updateQuery = session.createSQLQuery("" + 
                "UPDATE registration_card SET full_name = '" + card.getFullName() + "'" + ", age = " + card.getAge() +" WHERE mobile = '" + card.getMobile() +"'");
        updateQuery.executeUpdate();
        session.getTransaction().commit();    
    }

    @Override
    public void delete(RegistrationCard card) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery deleteQuery = session.createSQLQuery("" + 
                "DELETE FROM registration_card WHERE mobile = '" + card.getMobile() + "'");
        deleteQuery.executeUpdate();
        session.getTransaction().commit();    
    }

    @Override
    public RegistrationCard getRegistrationCardByMobile(String mobile) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        RegistrationCard card = (RegistrationCard)session.createQuery("from RegistrationCard where mobile ='" + mobile + "'").list().get(0);
        return card;
    }

    @Override
    public List<RegistrationCard> getAllRegistrationCard() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from RegistrationCard").list();
    }
    
    @Override
    public List<RegistrationCard> getCardsWithFullNameParametr(String fullName) {
        Session session = sessionFactory.openSession();
        return session.createQuery("from RegistrationCard where fullName like '" + fullName +"%'").list();
    }
    
//     
//    public static List<RegistrationCard> getAllCard(){
//        List<RegistrationCard> list = null;
//        
//        try {
//            list = HibernateUtil.getSessionFactory().openSession().createQuery("from RegistrationCard").list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//    
//    public static List<RegistrationCard> requestSearch(String param){
//        List<RegistrationCard> list = null;
//        
//        try {
//            list = HibernateUtil.getSessionFactory().openSession().createQuery("from RegistrationCard where fullName like '" + param +"%'").list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        return list;
//    }
//    
//    public static void removeCardByKey(String key){
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        
//        SQLQuery deleteQuery = session.createSQLQuery("" + 
//                "DELETE FROM registration_card WHERE mobile = '" + key + "'");
//        deleteQuery.executeUpdate();
//        session.getTransaction().commit();
//    }
//    
//    public static void saveCard(RegistrationCard card){
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        SQLQuery insertQuery = session.createSQLQuery("" +
//		"INSERT INTO registration_card(mobile,full_name,age,date_registration)VALUES(?,?,?,?)");
//        insertQuery.setParameter(0, card.getMobile());
//        insertQuery.setParameter(1, card.getFullName());
//        insertQuery.setParameter(2, card.getAge());
//        insertQuery.setParameter(3, card.getDateRegistration());
//        insertQuery.executeUpdate();
//        session.getTransaction().commit();
//    }
//    
//    public static void updateCard(RegistrationCard card){
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        SQLQuery updateQuery = session.createSQLQuery("" + 
//                "UPDATE registration_card SET full_name = '" + card.getFullName() + "'" + ", age = " + card.getAge() +" WHERE mobile = '" + card.getMobile() +"'");
//        updateQuery.executeUpdate();
//        session.getTransaction().commit();
//    }
//    
//    public static RegistrationCard getCardByMobile(String mobile){
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        RegistrationCard card = (RegistrationCard)session.createQuery("from RegistrationCard where mobile ='" + mobile + "'").list().get(0);
//        return card;
//    }
    
}