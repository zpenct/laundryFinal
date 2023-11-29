package com.example.demo.service.imp;

import com.example.demo.OwnValidation.Validation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void testIsNullOrEmptyWithNullString() {
        assertTrue(Validation.isNullOrEmpty(null));
    }

    @Test
    void testIsNullOrEmptyWithSTRING() {
        assertFalse(Validation.isNullOrEmpty("Fayz"));
    }

    @Test
    void testIsNullOrEmptyWithNoChar() {
        assertTrue(Validation.isNullOrEmpty(""));
    }
}