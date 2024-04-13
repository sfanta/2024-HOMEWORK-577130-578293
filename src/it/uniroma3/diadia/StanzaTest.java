package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Test;

public class StanzaTest {

	@Test
	public void testGetAttrezzo_StanzaVuota() {
		Stanza vuota = new Stanza("vuota");
		assertNull(vuota.getAttrezzo("inesistente"));
	}
	
	@Test
	public void testGetAttrezzo_StanzaNonVuota_Presente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo",0);
		stanza.addAttrezzo(attrezzo);
		assertNotNull(stanza.getAttrezzo("attrezzo")); /**deve esseere uguale*/
	}
	
	@Test
	public void testGetAttrezzo_StanzaNonVuota_Assente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo",0);
		stanza.addAttrezzo(attrezzo);
		assertNull(stanza.getAttrezzo("nomeDIAttrezzoNonPresente"));
	}
	
/**Test per la classe stanzaAdiacente*/
	
	@Test
	public void testGetStanzaAdiacente() {
		Stanza stanza = new Stanza("Stanza");
		assertNull(stanza.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacente_Multiple(){
		Stanza stanza1 = new Stanza("stanza1");
		Stanza stanza2 = new Stanza("stanza2");
		stanza1.impostaStanzaAdiacente("est", stanza2);
		assertEquals(stanza2, stanza1.getStanzaAdiacente("est"));
	}
	
	@Test
	public void testGetStanzaAdiacente_NonAdiacente(){
		Stanza stanza1 = new Stanza("stanza1");
		Stanza stanza2 = new Stanza("stanza2");
		stanza1.impostaStanzaAdiacente("nord", stanza2);
		assertNotEquals(stanza2, stanza1.getStanzaAdiacente("est"));
	}
	
/**Test per la classe addAttrezzo*/
	@Test
	public void testaddAttrezzo() {
		Stanza stanza = new Stanza("Stanza");
		Attrezzo trapano = new Attrezzo("Trapano", 5);
		assertTrue(stanza.addAttrezzo(trapano));
	}
	
	@Test
	public void testaddAttrezzo_MAXCAP() {
		Stanza stanza = new Stanza("Stanza");
		Attrezzo martello = new Attrezzo("martello", 5);
		stanza.impostaMAXCAP(stanza); /**metodo creato per impostare al massimo il numero attrezzi*/
		assertFalse(stanza.addAttrezzo(martello));
	}
	
	@Test
	public void testaddAttrezzo_NumeroAttrezzi() {
		Stanza stanza = new Stanza("Stanza");
		Attrezzo trapano = new Attrezzo("Trapano", 5);
		assertEquals(0, stanza.getNumeroAttrezzi());
		stanza.addAttrezzo(trapano);
		assertEquals(1, stanza.getNumeroAttrezzi());
	}
}
