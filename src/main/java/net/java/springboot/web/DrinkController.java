package net.java.springboot.web;

import net.java.springboot.model.Bauturi;
import net.java.springboot.model.FelPrincipal;
import net.java.springboot.service.BauturiService;
import net.java.springboot.web.dto.BauturiDto;
import net.java.springboot.web.dto.DesertDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/drink")
public class DrinkController {

    private BauturiService bauturiService;

    public DrinkController(BauturiService bauturiService) {
        this.bauturiService = bauturiService;
    }

    @ModelAttribute("drink")
    public BauturiDto bauturiDto() {
        return new BauturiDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "drink";
    }

    @PostMapping("/insert")
    public String addDrink(@ModelAttribute("drink") BauturiDto bauturiDto) {
        bauturiService.save(bauturiDto);
        return "redirect:/drink?success";
    }

    @PostMapping("delete/{id}")
    public String deleteDrink(@PathVariable Long id){

        bauturiService.deleteBauturi(id);
        return "redirect:/admin/info?succes";

    }

    @GetMapping("update/{id}")
    public String showFormForUpdate(@PathVariable Long id , Model model){

        Bauturi bauturi = bauturiService.getDrink(id);

        model.addAttribute("bauturi" , bauturi);

        return "drink";
    }

}
