package br.uff.lucasrogerio.desafiopickpaybackend.domain.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.uff.lucasrogerio.desafiopickpaybackend.domain.enums.UserType;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class NaturalPersonTest {
    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testFullArgsConstructorValidation() {

        NaturalPerson user = new NaturalPerson(1L, "Nome Legal", "email@email.com", "12345678", "94.892.122/0001-83",
                null, null);

        assertTrue(user instanceof NaturalPerson, "User should be instance of NaturalPerson");
        assertTrue(user.getUserType() == UserType.COMMON, "User type should be COMMON");
    }

    public void noArgsConstructorValidation() {
        NaturalPerson user = new NaturalPerson();

        assertTrue(user instanceof NaturalPerson, "User should be instance of NaturalPerson");
        assertTrue(user.getUserType() == UserType.COMMON, "User type should be COMMON");
    }

    @Test
    public void testInvalidUser() {
        NaturalPerson user = new NaturalPerson();

        var violations = validator.validate(user);
        assertFalse(violations.isEmpty(), "User should be invalid");
    }

    @Test
    public void testValidUserType() {
        NaturalPerson user = new NaturalPerson();

        assertTrue(user.getUserType() == UserType.COMMON, "User type should be COMMON");
    }

    @Test
    public void testValidCPF() {
        NaturalPerson user = new NaturalPerson();
        user.setCpf("937.480.190-68");

        var violations = validator.validateProperty(user, "cpf");

        assertTrue(violations.isEmpty(), "CPF should be valid");
    }

    @Test
    public void testInvalidCPF() {
        NaturalPerson user = new NaturalPerson();

        ArrayList<String> invalidCPFs = new ArrayList<String>();
        invalidCPFs.add("12345678901");
        invalidCPFs.add("123.45678901");
        invalidCPFs.add("123456.78901");
        invalidCPFs.add("123456789-01");
        invalidCPFs.add("123.456.78901");
        invalidCPFs.add("123.456.789-01");
        invalidCPFs.add("123.456.789-0a");

        invalidCPFs.forEach(cpf -> {
            user.setCpf(cpf);
            var violations = validator.validateProperty(user, "cpf");
            assertFalse(violations.isEmpty(), "All CPFs should be invalid");
        });

    }
}
