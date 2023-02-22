package net.java.springboot.service;


import net.java.springboot.model.FelPrincipal;
import net.java.springboot.web.dto.FelPrincipalDto;

import java.util.List;


public interface FelPrincipalService {

    FelPrincipal save(FelPrincipalDto felPrincipalDto);
    List<FelPrincipal> getAllFelPrincipal();
    FelPrincipal getFelPrincipal(long id);
    FelPrincipal updateFelPrincipal(FelPrincipal felPrincipal);
    void deleteFelPrincipal(long id);

}
