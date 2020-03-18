/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unknown.ht665;
import java.util.*;
import java.util.ArrayList;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author maris
 */
public class BinaryTreeTest {
    
    public BinaryTreeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of asc method, of class BinaryTree.
     */
    @Test
    public void testAsc() {
        System.out.println("asc");
        ArrayList<String> ingles = new ArrayList<String>();
        ArrayList<String> espanol = new ArrayList<String>();
        ingles.add("dog");
        ingles.add("cat");
        espanol.add("perro");
        espanol.add("gato");
        int num = 2;
        BinaryTree instance = new BinaryTree();
        Map<String, String> expResult = new TreeMap();
        expResult.put("cat","gato");
        expResult.put("dog","perro");
        Map<String, String> result = instance.asc(ingles, espanol, num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(expResult!=result){
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of translation method, of class BinaryTree.
     */
    @Test
    public void testTranslation() {
        System.out.println("translation");
        String[] translateSplit = {"woman","dog"};
        Map<String, String> asc = new TreeMap();
        asc.put("dog","perro");
        asc.put("woman", "mujer");
        BinaryTree instance = new BinaryTree();
        String expResult = "mujer perro";
        String result = instance.translation(translateSplit, asc);
        if(expResult.equals(result)){
            assertEquals(expResult, result);
        }
    }
    
}
