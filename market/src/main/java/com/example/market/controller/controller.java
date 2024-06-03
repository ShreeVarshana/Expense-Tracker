package com.example.market.controller;

import com.example.market.entity.entity;
import com.example.market.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class controller {




    @Autowired
    private service Service;


    @GetMapping("/table")
    public String show(Model model) {
        List<entity> market = Service.getAll();
        model.addAttribute("market",market);
        return "table";
    }

    @GetMapping("/entry")
    public String showform(Model model) {
        model.addAttribute("market", new entity());
        return "index";
    }


    @PostMapping("/save")
    public String save(entity market) {
        Service.save(market);
        return "redirect:/table";

    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model){
        try{
            entity user = Service.get(id);
            if(user==null){
                throw new ArithmeticException("Could not find a user");
            }
            model.addAttribute("market",user);

            return "index";
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
            return "Error";
        }
    }
    @GetMapping("/delete/{id}")
    public String Delete(@PathVariable("id") Integer id, Model model){
        try{
            Service.delete(id);
            return "redirect:/table";
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Error";
        }
    }
}


