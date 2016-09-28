/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacentre.service.impl;

import com.datacentre.model.dao.CardDao;
import com.datacentre.model.dao.impl.CardDaoImpl;
import com.datacentre.model.pojo.RegistrationCard;
import com.datacentre.service.CardService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */

@Service
public class CardServiceImpl implements CardService{
    private static CardDao cardDao = new CardDaoImpl();
    
    @Transactional
    public void add(RegistrationCard card) {
        cardDao.add(card);
    }

    @Transactional
    public void edit(RegistrationCard card) {
        cardDao.edit(card);
    }

    @Transactional
    public void delete(RegistrationCard card) {
        cardDao.delete(card);
    }

    @Transactional
    public RegistrationCard getRegistrationCardByMobile(String mobile) {
        return cardDao.getRegistrationCardByMobile(mobile);
    }

    @Transactional
    public List<RegistrationCard> getAllRegistrationCard() {
        return cardDao.getAllRegistrationCard();
    }

    @Transactional
    public List<RegistrationCard> getCardsWithFullNameParametr(String fullName) {
        return cardDao.getCardsWithFullNameParametr(fullName);
    }
        
}
