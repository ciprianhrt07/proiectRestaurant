package net.java.springboot.web;

import net.java.springboot.model.*;
import net.java.springboot.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserClientController {

    private UserService userService;
    private FelPrincipalService felPrincipalService;
    private DesertService desertService;
    private BauturiService bauturiService;


    public UserClientController(UserService userService , FelPrincipalService felPrincipalService , DesertService desertService , BauturiService bauturiService) {
        this.userService = userService;
        this.felPrincipalService = felPrincipalService;
        this.desertService = desertService;
        this.bauturiService = bauturiService;
    }

    @GetMapping("/info")
    public String getInfo(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();


        User currentUser = userService.getUser(currentPrincipalName);

        List<FelPrincipal> allFelPrincipal = felPrincipalService.getAllFelPrincipal();

        List<Desert> allDesert = desertService.getAllDesert();

        List<Bauturi> allBauturi = bauturiService.getAllBauturi();

        model.addAttribute("allFelPrincipal" , allFelPrincipal);
        model.addAttribute("allDesert" , allDesert);
        model.addAttribute("allBauturi" , allBauturi);

        //pentru afisarea tuturor produselor achizitionate:

        NotaDePlata notaDePlata = currentUser.getNotaDePlata();

        List<FelPrincipal> felPrincipalAchizitionat = notaDePlata.getFelPrincipalList();
        List<Desert> allDeserturi = notaDePlata.getDesertList();
        List<Bauturi> allDrinks = notaDePlata.getBauturiList();


        model.addAttribute("allFp",felPrincipalAchizitionat);
        model.addAttribute("allDeserturi",allDeserturi);
        model.addAttribute("allDrinks",allDrinks);

        double suma = 0.0f;

        for(FelPrincipal f:felPrincipalAchizitionat)
            suma+=f.getPret();

        for(Desert d : allDeserturi)
            suma+=d.getPret();

        for(Bauturi b: allDrinks)
            suma+=b.getPret();



        model.addAttribute("total",suma);

        return "index";
    }

    @PostMapping("/info/add_food/{id}")
    public String addFood(@PathVariable Long id ,Model model){

        //p1: gasesc in tabela felul principal cu id -ul resp

        FelPrincipal felPrincipal = felPrincipalService.getFelPrincipal(id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //p2: caut user-ul dupa email

        String  email = authentication.getName();

        User user = userService.getUser(email);

        //p3: preiau nota de plata cu tot ce a adaugat pana acum

        NotaDePlata nota = user.getNotaDePlata();

        //p4: adaug felul in nota de plata
        nota.getFelPrincipalList().add(felPrincipal);

        //p5: refresh la nota veche pana la BD
        user.setNotaDePlata(nota);

        userService.update(user);

        //p6: afisare rezultat
       // System.out.println(nota.getFelPrincipalList().toString());

        return "redirect:/user/info";
    }

    @PostMapping("/info/add_desert/{id}")
    public String addDesert(@PathVariable Long id ,Model model){

        //p1: gasesc in tabela felul principal cu id -ul resp

        Desert desert = desertService.getDesert(id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //p2: caut user-ul dupa email

        String  email = authentication.getName();

        User user = userService.getUser(email);

        //p3: preiau nota de plata cu tot ce a adaugat pana acum

        NotaDePlata nota = user.getNotaDePlata();

        //p4: adaug felul in nota de plata
        nota.getDesertList().add(desert);

        //p5: refresh la nota veche pana la BD
        user.setNotaDePlata(nota);

        userService.update(user);

        //p6: afisare rezultat
        // System.out.println(nota.getFelPrincipalList().toString());

        return "redirect:/user/info";
    }

    @PostMapping("/info/add_drink/{id}")
    public String addDrink(@PathVariable Long id ,Model model){

        //p1: gasesc in tabela felul principal cu id -ul resp

        Bauturi bauturi = bauturiService.getDrink(id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //p2: caut user-ul dupa email

        String  email = authentication.getName();

        User user = userService.getUser(email);

        //p3: preiau nota de plata cu tot ce a adaugat pana acum

        NotaDePlata nota = user.getNotaDePlata();

        //p4: adaug felul in nota de plata
        nota.getBauturiList().add(bauturi);

        //p5: refresh la nota veche pana la BD
        user.setNotaDePlata(nota);

        userService.update(user);

        //p6: afisare rezultat
        // System.out.println(nota.getFelPrincipalList().toString());

        return "redirect:/user/info";
    }

    @PostMapping("/info/remove_felPrincipal/{id}")
    public String removeFood(@PathVariable Long id ,Model model){

        FelPrincipal felPrincipal = felPrincipalService.getFelPrincipal(id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String  email = authentication.getName();

        User user = userService.getUser(email);

        NotaDePlata nota = user.getNotaDePlata();

        List<FelPrincipal> lastFelPrincipal = nota.getFelPrincipalList();

        lastFelPrincipal.remove(felPrincipal);


        nota.setFelPrincipalList(lastFelPrincipal);

        user.setNotaDePlata(nota);

        userService.update(user);


        return "redirect:/user/info";
    }

    @PostMapping("/info/remove_desert/{id}")
    public String removeDesert(@PathVariable Long id ,Model model){

        Desert desert = desertService.getDesert(id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String  email = authentication.getName();

        User user = userService.getUser(email);

        NotaDePlata nota = user.getNotaDePlata();

        List<Desert> lastDesert = nota.getDesertList();

        lastDesert.remove(desert);

        nota.setDesertList(lastDesert);

        user.setNotaDePlata(nota);

        userService.update(user);


        return "redirect:/user/info";
    }

    @PostMapping("/info/remove_drink/{id}")
    public String removeDrink(@PathVariable Long id ,Model model){

        Bauturi drink = bauturiService.getDrink(id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String  email = authentication.getName();

        User user = userService.getUser(email);

        NotaDePlata nota = user.getNotaDePlata();

        List<Bauturi> lastDrinks= nota.getBauturiList();

        lastDrinks.remove(drink);

        nota.setBauturiList(lastDrinks);

        user.setNotaDePlata(nota);

        userService.update(user);


        return "redirect:/user/info";
    }

    @PostMapping("/info/remove_All")
    public String removeAll(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String  email = authentication.getName();

        User user = userService.getUser(email);

        NotaDePlata nota = user.getNotaDePlata();

        nota.setFelPrincipalList(new ArrayList<>());
        nota.setBauturiList(new ArrayList<>());
        nota.setDesertList(new ArrayList<>());

        user.setNotaDePlata(nota);

        userService.update(user);

        return "redirect:/user/info";

    }


}
