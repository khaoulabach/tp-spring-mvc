package com.eheio.hello.web;

import com.eheio.hello.Model.Personne;
import com.eheio.hello.Service.Serviceimpl.PersonneServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
    @Autowired
    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
    @Autowired
    public void setPersonneServiceimpl(PersonneServiceimpl personneServiceimpl) {
        this.personneServiceimpl = personneServiceimpl;
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "registre";
    }
    Personne personne;
    PersonneServiceimpl personneServiceimpl ;
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView hello(@RequestParam(value = "user_name") String nom,
                              @RequestParam(value = "user_lastname") String prenom,
                              @RequestParam(value = "user_login") String login,
                              @RequestParam(value = "user_password") String password,
                              @RequestParam(value  ="user_job")String role, Model model) {
        ModelAndView m = new ModelAndView();
        m.setViewName("hello");
        personne.setNom(nom);
        personne.setPrenom(prenom);
        personne.setLogin(login);
        personne.setPasswrd(password);
        personne.setRole(role);
        personneServiceimpl.addPersonne(personne);
        return m;
    }
}