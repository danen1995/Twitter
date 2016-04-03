/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Dane
 *
 */
public class TwitterPorukaTest {
	private TwitterPoruka twitterPoruka;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		twitterPoruka = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		twitterPoruka = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		String korisnik = "Dane";
		twitterPoruka.setKorisnik(korisnik);
		assertEquals(korisnik, twitterPoruka.getKorisnik());
		
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull(){
		twitterPoruka.setKorisnik(null);
	}
	@Test (expected = java.lang.RuntimeException.class)	
	public void testSetKorisnikPrazan(){
		twitterPoruka.setKorisnik("");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		twitterPoruka.setPoruka("Testiranje poruke");
		assertEquals("Testiranje poruke", twitterPoruka.getPoruka());
	}
	@Test (expected = java.lang.RuntimeException.class)	
	public void testSetPorukaNull(){
		twitterPoruka.setPoruka(null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaDuzaOd140(){
		String por = "";
		for (int i = 0; i < 50; i++) {
			por = por + "JUnit ";
		}
		twitterPoruka.setPoruka(por);
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		String korisnik = "Dane";
		String poruka = "Testiranje";
		twitterPoruka.setKorisnik(korisnik);
		twitterPoruka.setPoruka(poruka);
		assertEquals("KORISNIK:"+korisnik+" PORUKA:"+poruka, twitterPoruka.toString());
	}

}
