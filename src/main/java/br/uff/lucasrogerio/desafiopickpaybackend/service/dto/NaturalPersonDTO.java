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
public class NaturalPersonDTO extends UserDTO {

    private String cpf;

    public NaturalPersonDTO(NaturalPerson naturalPerson) {
        super(naturalPerson);
        this.cpf = naturalPerson.getCpf();
    }

    public NaturalPerson toEntity() {
        NaturalPerson entity = new NaturalPerson();
        entity.setCpf(this.getCpf());
        entity.setName(this.getName());
        entity.setEmail(this.getEmail());
        entity.setPassword(this.getPassword());
        return entity;
    }

    public static List<NaturalPersonDTO> listOf(List<NaturalPerson> naturalPersons) {
        return naturalPersons.stream().map(NaturalPersonDTO::new).collect(Collectors.toList());
    }

}
