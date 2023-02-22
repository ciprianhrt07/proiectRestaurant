package net.java.springboot.service;

import net.java.springboot.model.Desert;
import net.java.springboot.repository.DesertRepository;
import net.java.springboot.web.dto.DesertDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesertServiceImpl implements DesertService{

    private DesertRepository desertRepository;

    public DesertServiceImpl(DesertRepository desertRepository){
        this.desertRepository=desertRepository;
    }


    @Override
    public Desert save(DesertDto desertDto) {

        Desert desert = new Desert(desertDto.getNume() , desertDto.getDescriere() , desertDto.getPret() , desertDto.getCantitate());
        return desertRepository.save(desert);
    }

    @Override
    public List<Desert> getAllDesert() {
        return desertRepository.findAll();
    }

    @Override
    public Desert getDesert(long id) {
        return desertRepository.getOne(id);
    }

    @Override
    public Desert updateDesert(Desert desert) {
        return desertRepository.save(desert);
    }

    @Override
    public void deleteDesert(long id) {
        desertRepository.deleteById(id);
    }
}
