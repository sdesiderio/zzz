package com.prova.controller;

import com.prova.entity.Academy;
import com.prova.exception.NotAcademyException;
import com.prova.exception.NotFoundException;
import com.prova.service.AcademyService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/api/academies")
public class AcademyController {

    private AcademyService academyService;

    public AcademyController(AcademyService academyService) {

        this.academyService = academyService;
    }

    @PostMapping
    public Academy saveAcademy(@Valid @RequestBody Academy academy){

        return academyService.saveOrUpdateAcademy(academy);

    }

    @PutMapping
    public Academy updateAcademy(@Valid @RequestBody Academy academy){

        return academyService.saveOrUpdateAcademy(academy);

    }

    @DeleteMapping("/code/{code}")
    public Map<String,Boolean> removeAcademy(@PathVariable String code){

        return academyService.removeAcademy(code);
    }

    @GetMapping("/code/{code}")
    public Academy findAcademyByCode(@PathVariable String code) throws NotFoundException {

        return academyService.findAcademyByCode(code);
    }

    @GetMapping
    public List<Academy> findAllAcademies() throws NotAcademyException {

        return academyService.findAllAcademies();
    }

}
