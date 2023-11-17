package br.uff.lucasrogerio.desafiopickpaybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uff.lucasrogerio.desafiopickpaybackend.domain.entity.NaturalPerson;

@Repository
public interface NaturalPersonRepository extends JpaRepository<NaturalPerson, Long> {

    NaturalPerson findByEmail(String email);

    NaturalPerson findByCpf(String cpf);

}
