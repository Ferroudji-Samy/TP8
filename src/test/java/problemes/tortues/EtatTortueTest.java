/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package problemes.tortues;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class EtatTortueTest {
        EtatTortue defaut = new EtatTortue();
        EtatTortue defaut2 = new EtatTortue();
        boolean[] tab1 = {true, true, false,false,false,false};
        EtatTortue et1 = new EtatTortue(tab1);
        boolean[] tab2 = {true, false,false,true, false,false};
        EtatTortue et2 = new EtatTortue(tab1);
        boolean[] tab3 = {true, true, true,false,false,false};
        EtatTortue et3 = new EtatTortue(tab1);

        public EtatTortueTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
     }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
     }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void TestEgal() {
     assertEquals(defaut, defaut2);
     }
}