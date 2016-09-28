/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacentre.model.dao;

import com.datacentre.model.pojo.RegistrationCard;
import java.util.List;

/**
 *
 * @author admin
 */
public interface CardDao {
    public void add(RegistrationCard card);
    public void edit(RegistrationCard card);
    public void delete(RegistrationCard card);
    public RegistrationCard getRegistrationCardByMobile(String mobile);
    public List<RegistrationCard> getCardsWithFullNameParametr(String fullName);
    public List<RegistrationCard> getAllRegistrationCard();
}
