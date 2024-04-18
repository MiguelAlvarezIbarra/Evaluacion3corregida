package mx.utng.MAAI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.MAAI.model.entity.Subjet;
import mx.utng.MAAI.model.service.ISubjetService;

@Controller
@SessionAttributes("subjet")
public class SubjetController {
    @Autowired 
    private ISubjetService service;

    @GetMapping({"subjet", "/subjet", "/subjet/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de materias");
        model.addAttribute("subjets", service.list());
        return "subjet-list";
    }

    @GetMapping("/subjet/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de materias");
        model.addAttribute("subjet", new Subjet());
        return "subjet-form";
    }

    @PostMapping("/subjet/form")
    public String save(@Valid Subjet subjet, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de materias");
            return "subjet-form";
        }
        service.save(subjet);
        return "redirect:/subjet/list";
    }

    @GetMapping("/subjet/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Subjet subjet = null;
        if(id > 0){
            subjet=service.getByID(id);
        }else{
            return "redirect:/subjet/list";
        }
        model.addAttribute("title", "Editar materias");
        model.addAttribute("subjet", subjet);
        return "subjet-form";
    }
    @GetMapping("/subjet/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id>0){
            service.delete(id);
        }
        return "redirect:/subjet/list";
    }

}
