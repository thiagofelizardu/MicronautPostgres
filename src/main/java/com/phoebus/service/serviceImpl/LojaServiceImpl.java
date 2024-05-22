package com.phoebus.service.serviceImpl;

import com.phoebus.entites.Loja;
import com.phoebus.exception.LojaException;
import com.phoebus.repository.LojaRepository;
import com.phoebus.service.LojaService;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;


@Singleton
public class LojaServiceImpl implements LojaService {

    @Inject
    private LojaRepository lojaRepository;


    public List<Loja> listAll() {
        return lojaRepository.findAll();
    }

    public Loja save(Loja loja) {
        return lojaRepository.save(loja);
    }

    public Optional<Loja> findById(Long id) throws LojaException {
        Optional<Loja> existingLoja = lojaRepository.findById(id);
        if(existingLoja.isEmpty()){
            throw new LojaException("Loja Not Found with id" + id );
        }
        return existingLoja;
    }


    public void deletById(Long id) throws LojaException {
        Optional<Loja> existingLoja = lojaRepository.findById(id);
        if(existingLoja.isEmpty()){
            throw new LojaException("Loja Not Found with id" + id );
        }
         lojaRepository.deleteById(id);
    }

    public Loja update(@NonNull Long id, Loja loja) throws LojaException {
        Optional<Loja> existingLoja = lojaRepository.findById(id);
        if (existingLoja.isEmpty()) {
            throw new LojaException("Loja Not Found with id" + id );
        }
        Loja updatedLoja = existingLoja.get();
        updatedLoja.setName(loja.getName());
        return lojaRepository.save(updatedLoja);
    }

}