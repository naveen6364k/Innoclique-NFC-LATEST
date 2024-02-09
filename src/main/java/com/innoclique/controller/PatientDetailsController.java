package com.innoclique.controller;

import com.innoclique.dto.PatientDetailsDTO;
import com.innoclique.entity.PatientDetails;
import com.innoclique.service.PatientDetailsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Naveen Kumar Chintala
 */


@Validated
@RestController
@RequestMapping("/patientDetails")
public class PatientDetailsController {

    @Autowired
    private PatientDetailsService patientdetailsService;

    @PostMapping
    public ResponseEntity<?> save(@Validated @RequestBody PatientDetailsDTO patientDetailsDTO) {

        PatientDetails patientDetails =  patientdetailsService.save(patientDetailsDTO);
       return new ResponseEntity<>(patientDetails, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
        patientdetailsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Long id,
                       @Valid @RequestBody PatientDetailsDTO vO) {
        patientdetailsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PatientDetailsDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return patientdetailsService.getById(id);
    }

    @GetMapping
    public Page<PatientDetailsDTO> query(@Valid PatientDetailsDTO vO) {
        return patientdetailsService.query(vO);
    }
}
