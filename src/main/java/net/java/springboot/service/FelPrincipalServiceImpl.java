package net.java.springboot.service;

import net.java.springboot.model.FelPrincipal;
import net.java.springboot.repository.FelPrincipalRepository;
import net.java.springboot.web.dto.FelPrincipalDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FelPrincipalServiceImpl implements FelPrincipalService{

    private FelPrincipalRepository felPrincipalRepository;

    public FelPrincipalServiceImpl(FelPrincipalRepository felPrincipalRepository) {
        this.felPrincipalRepository = felPrincipalRepository;
    }

    @Override
    public FelPrincipal save(FelPrincipalDto felPrincipalDto) {

        FelPrincipal felPrincipal = new FelPrincipal(felPrincipalDto.getNume() , felPrincipalDto.getDescriere() , felPrincipalDto.getPret() , felPrincipalDto.getCantitate());

        return felPrincipalRepository.save(felPrincipal);

    }

    @Override
    public List<FelPrincipal> getAllFelPrincipal() {
        return felPrincipalRepository.findAll();
    }

    @Override
    public FelPrincipal getFelPrincipal(long id) {
        return felPrincipalRepository.getOne(id);
    }

    @Override
    public FelPrincipal updateFelPrincipal(FelPrincipal felPrincipal) {
        return felPrincipalRepository.save(felPrincipal);
    }

    @Override
    public void deleteFelPrincipal(long id) {
        felPrincipalRepository.deleteById(id);
    }
}
