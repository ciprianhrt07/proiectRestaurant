package net.java.springboot.web;


import net.java.springboot.model.Desert;
import net.java.springboot.service.DesertService;
import net.java.springboot.web.dto.DesertDto;
import net.java.springboot.web.dto.FelPrincipalDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/desert")
public class DesertController {

    private DesertService desertService;

    public DesertController(DesertService desertService) {
        this.desertService = desertService;
    }

    @ModelAttribute("desert")
    public DesertDto desertDto() {
        return new DesertDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "desert";
    }

    @PostMapping("/insert")
    public String addDesert(@ModelAttribute("desert") DesertDto desertDto) {
        desertService.save(desertDto);
        return "redirect:/desert?success";
    }

    @PostMapping("delete/{id}")
    public String deleteDrink(@PathVariable Long id) {

        desertService.deleteDesert(id);
        return "redirect:/admin/info?succes";

    }

    @GetMapping("update/{id}")
    public String showFormForUpdate(@PathVariable Long id, Model model) {

        Desert desert = desertService.getDesert(id);

        model.addAttribute(desert);

        return "desert";

    }
}
