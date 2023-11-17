package br.uff.lucasrogerio.desafiopickpaybackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uff.lucasrogerio.desafiopickpaybackend.domain.entity.NaturalPerson;
import br.uff.lucasrogerio.desafiopickpaybackend.service.NaturalPersonService;
import br.uff.lucasrogerio.desafiopickpaybackend.service.dto.NaturalPersonDTO;
import br.uff.lucasrogerio.desafiopickpaybackend.service.dto.NaturalPersonResponseDTO;

@RestController
@RequestMapping("natural-person")
public class NaturalPersonController {

    @Autowired
    NaturalPersonService naturalPersonService;

    @PostMapping
    public ResponseEntity<NaturalPersonResponseDTO> save(@RequestBody NaturalPersonDTO naturalPersonDTO) {
        NaturalPerson naturalPerson = naturalPersonService.save(naturalPersonDTO.toEntity());
        return new ResponseEntity<>(NaturalPersonResponseDTO.dtoFromNaturalPerson(naturalPerson), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<NaturalPersonResponseDTO>> findAll() {
        return ResponseEntity.ok(NaturalPersonResponseDTO.dtoListFromNaturalPersons(naturalPersonService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity<NaturalPersonResponseDTO> findById(@PathVariable Long id) {
        NaturalPersonResponseDTO naturalPersonResponseDTO = NaturalPersonResponseDTO
                .dtoFromNaturalPerson(naturalPersonService.findById(id));
        return ResponseEntity.ok(naturalPersonResponseDTO);
    }

}
