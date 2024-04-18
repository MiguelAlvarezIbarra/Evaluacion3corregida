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
import mx.utng.MAAI.model.entity.Inventario;
import mx.utng.MAAI.model.service.IInventarioService;

@Controller
@SessionAttributes("inventario")
public class InventarioController {
    @Autowired
    private IInventarioService service;

    @GetMapping({"/inventario", "/inventario/", "/inventario/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Inventario");
        model.addAttribute("inventarios", service.list());
        return "inventario-list";
    }

    @GetMapping("/inventario/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Inventario");
        model.addAttribute("inventario", new Inventario());
        return "inventario-form";
    }

    @PostMapping("/inventario/form")
    public String save(@Valid Inventario inventario, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Invetario");
            return "inventario-form";
        }
        service.save(inventario);
        return "redirect:/inventario/list";
    }

    @GetMapping("/inventario/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Inventario inventario = null;
        if(id>0){
            inventario = service.getById(id);
        }else{
            return "redirect:/inventario/list";
        }
        model.addAttribute("title", "Editar Inventario");
        model.addAttribute("inventario", inventario);
        return "inventario-form";
    }

    @GetMapping("/inventario/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/inventario/list";
    }

}
