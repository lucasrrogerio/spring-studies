package br.uff.lucasrogerio.desafiopickpaybackend.domain.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.uff.lucasrogerio.desafiopickpaybackend.domain.enums.UserType;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class LegalPersonTest {

    private Validator validator;
    private LegalPerson user;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testFullArgsConstructorValidation() {

        user = new LegalPerson(1L, "Nome Legal", "email@email.com", "12345678", "94.892.122/0001-83", null, null);

        assertTrue(user instanceof LegalPerson, "User should be instance of LegalPerson");
        assertTrue(user.getUserType() == UserType.SHOPKEEPER, "User type should be SHOPKEEPER");
    }

    @Test
    public void noArgsConstructorValidation() {
        user = new LegalPerson();

        assertTrue(user instanceof LegalPerson, "User should be instance of LegalPerson");
        assertTrue(user.getUserType() == UserType.SHOPKEEPER, "User type should be SHOPKEEPER");
    }

    @Test
    public void testUserValidation() {
        user = new LegalPerson();
        user.setName("Lucas Rogerio");
        user.setEmail("lucasrogerio@id.uff.br");
        user.setPassword("12345678");
        user.setCnpj("94.892.122/0001-83");

        var violations = validator.validate(user);
        assertTrue(violations.isEmpty(), "User should be valid");
        assertTrue(user.getUserType() == UserType.SHOPKEEPER, "User type should be SHOPKEEPER");
    }

    @Test
    public void testInvalidUserValidation() {
        User user = new User();

        var violations = validator.validate(user);
        assertFalse(violations.isEmpty(), "User should be invalid");
    }
}
