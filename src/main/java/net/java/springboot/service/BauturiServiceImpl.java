package net.java.springboot.service;

import net.java.springboot.model.Bauturi;
import net.java.springboot.repository.BauturiRepository;
import net.java.springboot.web.dto.BauturiDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BauturiServiceImpl implements BauturiService{

    private BauturiRepository bauturiRepository;

    public BauturiServiceImpl(BauturiRepository bauturiRepository) {
        super();
        this.bauturiRepository = bauturiRepository;
    }

    @Override
    public Bauturi save(BauturiDto bauturiDto) {

        Bauturi bauturi = new Bauturi(bauturiDto.getNume() , bauturiDto.getDescriere() , bauturiDto.isContineAlcool() , bauturiDto.getPret() , bauturiDto.getVolum());
        return bauturiRepository.save(bauturi);
    }

    @Override
    public List<Bauturi> getAllBauturi() {
       return bauturiRepository.findAll();
    }

    @Override
    public Bauturi getDrink(long id) {
        return bauturiRepository.getOne(id);
    }

    @Override
    public Bauturi updateBauturi(Bauturi bauturi) {
        return bauturiRepository.save(bauturi);
    }

    @Override
    public void deleteBauturi(long id) {
        bauturiRepository.deleteById(id);
    }
}
