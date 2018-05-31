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
public class HelloController {
    @Autowired
    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
    @Autowired
    public void setPersonneServiceimpl(PersonneServiceimpl personneServiceimpl) {
        this.personneServiceimpl = personneServiceimpl;
    }

    Personne personne;
	PersonneServiceimpl personneServiceimpl ;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView hello(@RequestParam(value="username") String username,
                              @RequestParam(value="password") String password , Model model) {
        ModelAndView m = new ModelAndView();
        m.setViewName("Home");
        String user ="";

        personne.setLogin(username);
        personne.setPasswrd(password);

        for (Personne p : personneServiceimpl.getPersonne())
        {
            if(personne.getLogin().equals(p.getLogin()) && personne.getPasswrd().equals(p.getPasswrd()))
            {
            user =p.getNom();
            m.addObject("user", user);

            }
        }

        return m;
    }

}
