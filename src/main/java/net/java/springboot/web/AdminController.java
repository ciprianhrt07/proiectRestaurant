package net.java.springboot.web;

import net.java.springboot.model.*;
import net.java.springboot.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private BauturiService bauturiService;
    private FelPrincipalService felPrincipalService;
    private DesertService desertService;


    public AdminController(UserService userService , BauturiService bauturiService ,FelPrincipalService felPrincipalService , DesertService desertService ){
        this.userService = userService;
        this.bauturiService= bauturiService;
        this.felPrincipalService = felPrincipalService;
        this.desertService = desertService;

    }

    @GetMapping("/info")
    public String getInfo(Model model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        List<Desert> desertList = desertService.getAllDesert();
        List<FelPrincipal> felPrincipalList = felPrincipalService.getAllFelPrincipal();
        List<Bauturi> bauturiList = bauturiService.getAllBauturi();

        model.addAttribute("allDeserts" , desertList);
        model.addAttribute("allBauturi" , bauturiList);
        model.addAttribute("allFelPrincipal",felPrincipalList);


        return "indexAdmin";
    }



}
