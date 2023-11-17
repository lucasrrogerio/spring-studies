package br.uff.lucasrogerio.desafiopickpaybackend.service.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.uff.lucasrogerio.desafiopickpaybackend.domain.entity.NaturalPerson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NaturalPersonResponseDTO extends UserResponseDTO {

    private String cpf;

    NaturalPersonResponseDTO(NaturalPerson naturalPerson) {
        super(naturalPerson);
        this.cpf = naturalPerson.getCpf();
    }

    public static NaturalPersonResponseDTO dtoFromNaturalPerson(NaturalPerson naturalPerson) {
        return new NaturalPersonResponseDTO(naturalPerson);
    }

    public static List<NaturalPersonResponseDTO> dtoListFromNaturalPersons(List<NaturalPerson> naturalPersons) {
        return naturalPersons.stream().map(NaturalPersonResponseDTO::new).collect(Collectors.toList());
    }

}