
package br.andre.turmas;

import org.junit.Test;
import static org.junit.Assert.*;

public class AlunoTest {
    Aluno a1;
    
    
    @Test
    public void media(){
        assertEquals(7, a1.media(), 0);
    }
}
