package com.prova.service;

import com.prova.entity.Academy;
import com.prova.exception.NotAcademyException;
import com.prova.exception.NotFoundException;

import java.util.List;
import java.util.Map;

public interface AcademyService {

    public Academy saveOrUpdateAcademy(Academy academy);

    public Map<String,Boolean> removeAcademy(String code);

    public Academy findAcademyByCode(String code) throws NotFoundException;

    public List<Academy> findAllAcademies() throws NotAcademyException;


}
