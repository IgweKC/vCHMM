/*******************************************************************************
 * Copyright (c) 2020 KC Igwe
 ******************************************************************************
 */

package VAIPPLsequence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class HMMTest {

    double[] pi = {0.5, 0.5};
    double[][] a = {{0.8, 0.2}, {0.2, 0.8}};
    double[][] b = {{0.6, 0.4}, {0.4, 0.6}};

    public HMMTest() {
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

    /**
     * Test of getInitialStateProbabilities method, of class HMM.
     */
    @Test
    public void testGetInitialStateProbabilities() {
        System.out.println("getInitialStateProbabilities");
        HMM hmm = new HMM(pi, a, b);
        double[] result = hmm.getInitialStateProbabilities();
        for (int i = 0; i < pi.length; i++) {
            assertEquals(pi[i], result[i], 1E-7);
        }
    }

    /**
     * Test of getStateTransitionProbabilities method, of class HMM.
     */
    @Test
    public void testGetStateTransitionProbabilities() {
        System.out.println("getStateTransitionProbabilities");
        HMM hmm = new HMM(pi, a, b);
        double[][] result = hmm.getStateTransitionProbabilities();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                assertEquals(a[i][j], result[i][j], 1E-7);
            }
        }
    }

    /**
     * Test of getSymbolEmissionProbabilities method, of class HMM.
     */
    @Test
    public void testGetSymbolEmissionProbabilities() {
        System.out.println("getSymbolEmissionProbabilities");
        HMM hmm = new HMM(pi, a, b);
        double[][] result = hmm.getSymbolEmissionProbabilities();
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                assertEquals(b[i][j], result[i][j], 1E-7);
            }
        }
    }

    /**
     * Test of p method, of class HMM.
     */
    @Test
    public void testJointP() {
        System.out.println("joint p");
        int[] o = {0, 0, 1, 1, 0, 1, 1, 0};
        int[] s = {0, 0, 1, 1, 1, 1, 1, 0};
        HMM hmm = new HMM(pi, a, b);
        double expResult = 7.33836e-05;
        double result = hmm.p(o, s);
        assertEquals(expResult, result, 1E-10);
    }

    /**
     * Test of logp method, of class HMM.
     */
    @Test
    public void testJointLogp() {
        System.out.println("joint logp");
        HMM hmm = new HMM(pi, a, b);
        int[] o = {0, 0, 1, 1, 0, 1, 1, 0};
        int[] s = {0, 0, 1, 1, 1, 1, 1, 0};
        double expResult = -9.51981;
        double result = hmm.logp(o, s);
        assertEquals(expResult, result, 1E-5);
    }

    /**
     * Test of p method, of class HMM.
     */
    @Test
    public void testP() {
        System.out.println("p");
        HMM hmm = new HMM(pi, a, b);
        int[] o = {0, 0, 1, 1, 0, 1, 1, 0};
        double expResult = 0.003663364;
        double result = hmm.p(o);
        assertEquals(expResult, result, 1E-9);
    }

    /**
     * Test of logp method, of class HMM.
     */
    @Test
    public void testLogp() {
        System.out.println("logp");
        HMM hmm = new HMM(pi, a, b);
        int[] o = {0, 0, 1, 1, 0, 1, 1, 0};
        double expResult = -5.609373;
        double result = hmm.logp(o);
        assertEquals(expResult, result, 1E-6);
    }

    /**
     * Test of predict method, of class HMM.
     */
    @Test
    public void testPredict() {
        System.out.println("predict");
        HMM hmm = new HMM(pi, a, b);
        int[] o = {0, 0, 1, 1, 0, 1, 1, 0};
        int[] s = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] result = hmm.predict(o);
        assertEquals(o.length, result.length);
        for (int i = 0; i < s.length; i++) {
            assertEquals(s[i], result[i]);
        }
    }

    /**
     * Test of fit method, of class HMM.
     */
    @Test
    public void testFit() {
        System.out.println("fit");
        // to be completed
    }

    /**
     * Test of update method, of class HMM.
     */
    @Test
    public void testUpdate() {
        // to be completed
    }
}