package com.epul4a.spring_project.controller;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class MainController {
    private static final List<String> imgs = new ArrayList<String>();

    @RequestMapping(value = {"/index" }, method =
            RequestMethod.GET)
    public String index(Model model) {
        File folder;
        folder = new File(getClass().getResource("/static/images/uploaded").getFile());
        System.out.print(folder);
        model.addAttribute("imgs", imgs);
        return "index";
    }


    @RequestMapping(value = { "/public" }, method =
            RequestMethod.GET)
    public String showfirstTemplate(Model model) {
        return "html/public";
    }

    @RequestMapping(value = { "/","/home" }, method =
            RequestMethod.GET)
    public String showHome(Model model) {
        return "html/home";
    }

    @RequestMapping(value = {"/vente" }, method =
            RequestMethod.GET)
    public String showVente(Model model) {
        return "html/vente";
    }

    @RequestMapping(value = {"/login" }, method =
            RequestMethod.GET)
    public String doLogin(Model model) {
        return "html/login";
    }

    @RequestMapping(value = {"/privee" }, method =
            RequestMethod.GET)
    public String showMyImage(Model model) {
        return "html/images";
    }

    @RequestMapping(value = {"/ajoutPage" }, method =
            RequestMethod.GET)
    public String ajoutPage(Model model) {
        return "html/ajoutPage";
    }
}