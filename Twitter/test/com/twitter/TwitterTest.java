package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	
	private Twitter twitter;

	@Before
	public void setUp() throws Exception {
		twitter = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		twitter = null;
	}

	@Test
	public void testVratiSvePoruke() {
		TwitterPoruka tp1  = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();
		tp1.setKorisnik("Pera");
		tp1.setPoruka("Dobar dan");
		tp2.setKorisnik("Milan");
		tp2.setPoruka("Dobro vece");
		twitter.unesi("Pera", "Dobar dan"); // poruka 0
		twitter.unesi("Milan", "Dobro vece"); // poruka 1 (poruka.addaLast)
		assertEquals(tp1.getKorisnik(), twitter.vratiSvePoruke().get(0).getKorisnik());
		assertEquals(tp1.getPoruka(), twitter.vratiSvePoruke().get(0).getPoruka());
		assertEquals(tp2.getKorisnik(), twitter.vratiSvePoruke().get(1).getKorisnik());
		assertEquals(tp2.getKorisnik(), twitter.vratiSvePoruke().get(1).getKorisnik());
		
	}

	@Test
	public void testUnesi() {
		twitter.unesi("Pera", "Dobar dan");
		assertEquals("Pera", twitter.vratiSvePoruke().get(0).getKorisnik());
		assertEquals("Dobar dan", twitter.vratiSvePoruke().get(0).getPoruka());
	}

	@Test
	public void testVratiPoruke() {
		twitter.unesi("Petar", "Dobro jutro!");
		twitter.unesi("Mile", "Dobar dan");
		twitter.unesi("Zika", "Dobro vece");
		TwitterPoruka niz1 [] = new TwitterPoruka[2];
		niz1 = twitter.vratiPoruke(2, "Dobro");
		TwitterPoruka niz2 [] = new TwitterPoruka[2];
		niz2[0] = twitter.vratiSvePoruke().get(0);
		niz2[1] = twitter.vratiSvePoruke().get(2);
		assertArrayEquals(niz2, niz1);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanNiz(){
		twitter.vratiPoruke(15, "");
	}
	
	public void testVratiPorukePrazanString(){
		twitter.vratiPoruke(15, null);
	}
}
