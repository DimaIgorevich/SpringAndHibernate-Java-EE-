/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacentre.controllers;

import com.datacentre.model.pojo.RegistrationCard;
import com.datacentre.service.CardService;
import com.datacentre.service.impl.CardServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */

@Controller
public class CardController {
    private static CardService cardService = new CardServiceImpl();
    //@RequestMapping(method = RequestMethod.GET)
    
    @RequestMapping("cards")
    public String init(ModelMap model){
        RegistrationCard card = new RegistrationCard();
        model.put("card", card);
        model.put("cardList", cardService.getAllRegistrationCard());       
        return "cards";
    }
    
    @RequestMapping(value="cards.htm", method=RequestMethod.POST)
    public String modelAction(@ModelAttribute("card") RegistrationCard card, BindingResult result, @RequestParam String action ,ModelMap model){
        switch(action.toLowerCase()){
            case "add":{
                int listSize = cardService.getAllRegistrationCard().size();
                cardService.add(card);
                if(listSize == cardService.getAllRegistrationCard().size()){
                    model.put("errorMessage", "Error message");
                }
                //model.put("fullName","");
            }
                break;
            case "search":
                model.put("cardList", cardService.getCardsWithFullNameParametr(card.getFullName()));
                return "cards";
        }
        
        model.put("cardList", cardService.getAllRegistrationCard());
        return "cards";
    }
    
    @RequestMapping(value="delete.htm", method = RequestMethod.GET)
    public String deleteRow(@RequestParam(value="mobile", required=true) String mobile, ModelMap model){
        RegistrationCard card = cardService.getRegistrationCardByMobile(mobile);
        cardService.delete(card);
        return "delete";
    }
    
    @RequestMapping(value="edit.htm", method = RequestMethod.GET)
    public String editRow(@RequestParam(value="mobile", required=true) String mobile, ModelMap model){        
        RegistrationCard selectCard = cardService.getRegistrationCardByMobile(mobile);
        model.put("edit", selectCard);
        return "edit";
    }
 
    @RequestMapping(value = "edit.htm", method = RequestMethod.POST)
    public String submitEdit(@ModelAttribute("edit") RegistrationCard card, BindingResult result, @RequestParam String action, ModelMap model){
        cardService.edit(card);
        model.put("edit", card);
        return "edit";
    }
}
