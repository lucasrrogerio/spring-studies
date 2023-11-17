package br.uff.lucasrogerio.desafiopickpaybackend.domain.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class UserTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testUserValidation() {
        User user = new User();
        user.setName("Nome Legal");
        user.setEmail("email@email.com");
        user.setPassword("12345678");

        var violations = validator.validate(user);
        assertTrue(violations.isEmpty(), "User should be valid");
    }

    @Test
    public void testInvalidUserValidation() {
        User user = new User();

        var violations = validator.validate(user);
        assertFalse(violations.isEmpty(), "User should be invalid");
    }

}
