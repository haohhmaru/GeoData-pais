package deswebmob.ftce.usjt.br.geodata.model;

import static junit.framework.Assert.assertEquals;

/**
 * Alessandro Lima da silva
 * R.A 201522705
 */

public class TestePais {

    @Test
    public void testaPais() {
        Pais pais = new Pais();
        pais.setNome("Teste");
        pais.setPopulacao(15);
        pais.setArea(30);

        Pais pais2 = new Pais();
        pais2.setNome("Teste");
        pais2.setPopulacao(15);
        pais2.setArea(30);

        assertEquals(pais.getNome(), pais2.getNome());
        assertEquals(pais.getPopulacao(), pais2.getPopulacao());
        assertEquals(pais.getArea(), pais2.getArea());
    }
}
