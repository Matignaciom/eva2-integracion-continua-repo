package com.auth.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Prueba unitaria para App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Constructor
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * Suite de pruebas
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Prueba básica
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
