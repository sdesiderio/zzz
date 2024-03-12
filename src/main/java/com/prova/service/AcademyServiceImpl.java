package com.prova.service;

import com.prova.entity.Academy;
import com.prova.exception.NotAcademyException;
import com.prova.exception.NotFoundException;
import com.prova.repository.AcademyRepository;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AcademyServiceImpl implements AcademyService{

    private AcademyRepository academyRepository;

    public AcademyServiceImpl(AcademyRepository academyRepository) {

        this.academyRepository = academyRepository;
    }

    @Override
    public Academy saveOrUpdateAcademy(Academy academy) {

        Academy savedOrUpdated = null;

        try {

            savedOrUpdated = academyRepository.save(academy);
        }

        catch(IllegalArgumentException | OptimisticLockingFailureException ex){

            ex.printStackTrace();

        }

        return savedOrUpdated;

    }

    @Override
    public Map<String,Boolean> removeAcademy(String code) {

        Map<String,Boolean> map = new HashMap<>();

        try {

            academyRepository.deleteById(code);
            map.put("deletion",true);
        }

        catch(IllegalArgumentException ex){

            ex.printStackTrace();

        }

        return map;

    }

    @Override
    public Academy findAcademyByCode(String code) throws NotFoundException {

        return academyRepository.findById(code).orElseThrow(()->new NotFoundException("Academy not found"));
    }

    @Override
    public List<Academy> findAllAcademies() throws NotAcademyException {

        List<Academy> academies = academyRepository.findAll();

        if (academies.isEmpty()) throw new NotAcademyException("No Academies");

        return academies;
    }
}
