package net.java.springboot.web;

import net.java.springboot.model.FelPrincipal;
import net.java.springboot.service.FelPrincipalService;
import net.java.springboot.web.dto.FelPrincipalDto;
import net.java.springboot.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/felPrincipal")
public class FelPrincipalController {

    private FelPrincipalService felPrincipalService;

    public FelPrincipalController(FelPrincipalService felPrincipalService) {
        this.felPrincipalService = felPrincipalService;
    }

    @ModelAttribute("felPrincipal")
    public FelPrincipalDto felPrincipalDto() {
        return new FelPrincipalDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "felPrincipal";
    }

    @PostMapping("/insert")
    public String addFelPrincipal(@ModelAttribute("felPrincipal") FelPrincipalDto felPrincipalDto) {
        felPrincipalService.save(felPrincipalDto);
        return "redirect:/felPrincipal?success";
    }

    @PostMapping("delete/{id}")
    public String deleteFelPrincipal(@PathVariable Long id){

        felPrincipalService.deleteFelPrincipal(id);
        return "redirect:/admin/info?succes";

    }
    @GetMapping("update/{id}")
    public String showFormForUpdate(@PathVariable Long id , Model model){

        FelPrincipal felPrincipal = felPrincipalService.getFelPrincipal(id);

        model.addAttribute("felPrincipal" , felPrincipal);

        return "felPrincipal";
    }

}
