package br.com.crescer.aula01;

import static org.junit.Assert.*;

/**
 *
 * @author Diandra Rocha
 */
public class Lista01Parte01Test {

    @org.junit.Test
    public void testIsEmpty() {
        String string = "asasasa";
        Lista01Parte01 instance = new Lista01Parte01();

        boolean expResult = false;
        boolean result = instance.isEmpty(string);

        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testIsEmpty2() {
        String string = " ";
        Lista01Parte01 instance = new Lista01Parte01();

        boolean expResult = true;
        boolean result = instance.isEmpty(string);

        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testIsEmptyTrue() {
        String string = "";
        Lista01Parte01 instance = new Lista01Parte01();

        boolean expResult = true;
        boolean result = instance.isEmpty(string);

        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testInverter() {
        String string = "diandra";
        Lista01Parte01 instance = new Lista01Parte01();

        String expResult = "ardnaid";
        String result = instance.inverter(string);

        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testContaVogais() {
        String string = "ashashashu";
        Lista01Parte01 instance = new Lista01Parte01();

        int expResult = 4;
        int result = instance.contaVogais(string);

        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testIsPalindromo() {
        String string = "arara";
        Lista01Parte01 instance = new Lista01Parte01();

        boolean expResult = true;
        boolean result = instance.isPalindromo(string);

        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testIsPalindromoFalse() {
        String string = "qualquer";
        Lista01Parte01 instance = new Lista01Parte01();

        boolean expResult = false;
        boolean result = instance.isPalindromo(string);

        assertEquals(expResult, result);
    }

    /**
     * @author carloshenrique
     */
    private final StringUtils stringUtils;

    public Lista01Parte01Test() {
        this.stringUtils = new Lista01Parte01();
    }

    /**
     * Test of isEmpty method, of class StringUtils.
     */
    @org.junit.Test
    public void testIsEmpty4() {
        assertTrue(stringUtils.isEmpty(null));
        assertTrue(stringUtils.isEmpty(""));
        assertTrue(stringUtils.isEmpty(" "));
        assertFalse(stringUtils.isEmpty("a"));
        assertFalse(stringUtils.isEmpty(" a "));
    }

    /**
     * Test of inverter method, of class StringUtils.
     */
    @org.junit.Test
    public void testInverter2() {
        assertEquals("solrac", stringUtils.inverter("carlos"));
    }

    /**
     * Test of contaVogais method, of class StringUtils.
     */
    @org.junit.Test
    public void testContaVogais2() {
        assertEquals(2, stringUtils.contaVogais("carlos"));
    }

    /**
     * Test of isPalindromo method, of class StringUtils.
     */
    @org.junit.Test
    public void testIsPalindromo2() {
        assertTrue(stringUtils.isPalindromo("ovo"));
        assertFalse(stringUtils.isPalindromo("uva"));
        assertFalse(stringUtils.isPalindromo("Ame a Emo"));
    }
}
