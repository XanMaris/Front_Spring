package com.epul4a.spring_project.controller;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/addImage")
    public @ResponseBody ResponseEntity<?> addImage(
            @RequestParam String name,
            @RequestParam("price") double price,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile image,
            Model model
    ) {
            ImageGallery ig = new ImageGallery();
        try {
            ig.setImage(image.getBytes());
            ig.setDescription(description);
            ig.setPrice(price);
            ig.setName(name);
            Gson gson = new Gson();

            String url = "http://localhost:8081/api/imageGallery"; // Remplace avec ton endpoint
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            String body = gson.toJson(ig);;

            HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

            restTemplate.exchange(url, HttpMethod.POST, requestEntity, Void.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


}