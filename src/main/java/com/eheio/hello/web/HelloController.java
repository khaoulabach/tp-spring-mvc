package com.eheio.hello.web;

import com.eheio.hello.Model.Maladie;
import com.eheio.hello.Model.Personne;
import com.eheio.hello.Service.Serviceimpl.MaladieServiceimpl;
import com.eheio.hello.Service.Serviceimpl.PersonneServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
    @Autowired
    public void setMaladie(Maladie maladie) { this.maladie = maladie; }
    @Autowired
    public void setPersonneServiceimpl(PersonneServiceimpl personneServiceimpl) {
        this.personneServiceimpl = personneServiceimpl;
    }
    @Autowired
    public void setMaladieServiceimpl(MaladieServiceimpl maladieServiceimpl) {
        this.maladieServiceimpl = maladieServiceimpl;
    }
    Personne personne;
    Maladie maladie;

    MaladieServiceimpl maladieServiceimpl;
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
        String role="";
        List<Personne> list = new ArrayList<Personne>();
        List<Maladie> listm = new ArrayList<Maladie>();
        personne.setLogin(username);
        personne.setPasswrd(password);
        for (Personne p : personneServiceimpl.getPersonne())
        {
            if(personne.getLogin().equals(p.getLogin()) && personne.getPasswrd().equals(p.getPasswrd()))
            {
                user =p.getNom();
                role =p.getRole();
                m.addObject("user", user);
                m.addObject("role",role);
            }
        }
        for (Personne o : personneServiceimpl.getPersonne())
        {
            list.add(o);
            m.addObject("list", list);

        }
        for (Maladie maladie : maladieServiceimpl.getMaldie())
        {
            listm.add(maladie);
            System.out.println(m.toString());
            m.addObject("listm", listm);

        }

        return m;
    }
}
