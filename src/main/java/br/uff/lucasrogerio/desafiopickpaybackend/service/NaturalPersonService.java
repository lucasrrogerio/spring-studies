package br.uff.lucasrogerio.desafiopickpaybackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.uff.lucasrogerio.desafiopickpaybackend.domain.entity.NaturalPerson;
import br.uff.lucasrogerio.desafiopickpaybackend.repository.NaturalPersonRepository;
import br.uff.lucasrogerio.desafiopickpaybackend.service.exception.EntityNotFoundException;
import br.uff.lucasrogerio.desafiopickpaybackend.service.exception.UniqueConstraintException;
import jakarta.validation.Valid;

@Service
public class NaturalPersonService {

    private static final String NOT_FOUND_MSG = "Usuário não encontrado.";
    private static final String CONFLICT_CPF_MSG = "Já existe um usuário com este CPF.";
    private static final String CONFLICT_EMAIL_MSG = "Já existe um usuário com este email.";

    @Autowired
    NaturalPersonRepository naturalPersonRepository;

    @Transactional
    public NaturalPerson save(@Valid NaturalPerson naturalPerson) {
        if (naturalPersonRepository.findByEmail(naturalPerson.getEmail()) != null) {
            throw new UniqueConstraintException(CONFLICT_EMAIL_MSG);
        }
        if (naturalPersonRepository.findByCpf(naturalPerson.getCpf()) != null) {
            throw new UniqueConstraintException(CONFLICT_CPF_MSG);
        }

        return naturalPersonRepository.save(naturalPerson);
    }

    @Transactional
    public NaturalPerson update(Long id, @Valid NaturalPerson updatedNaturalPerson) {
        return naturalPersonRepository.save(updatedNaturalPerson);
    }

    @Transactional
    public NaturalPerson findById(Long id) {
        return naturalPersonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(NOT_FOUND_MSG));
    }

    @Transactional
    public List<NaturalPerson> findAll() {
        return naturalPersonRepository.findAll();
    }

}
