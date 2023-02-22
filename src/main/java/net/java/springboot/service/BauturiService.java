package net.java.springboot.service;

import net.java.springboot.model.Bauturi;
import net.java.springboot.web.dto.BauturiDto;

import java.util.List;

public interface BauturiService {

    Bauturi save(BauturiDto bauturiDto);
    List<Bauturi> getAllBauturi();
    Bauturi getDrink(long id);
    Bauturi updateBauturi(Bauturi bauturi);
    void deleteBauturi(long id);


}
