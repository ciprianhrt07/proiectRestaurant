package net.java.springboot.service;

import net.java.springboot.model.Desert;
import net.java.springboot.web.dto.DesertDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DesertService {

    Desert save(DesertDto desertDto);
    List<Desert> getAllDesert();
    Desert getDesert(long id);
    Desert updateDesert(Desert desert);
    void deleteDesert(long id);
}
