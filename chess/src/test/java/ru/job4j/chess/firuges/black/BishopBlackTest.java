package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import java.util.Arrays;

public class BishopBlackTest extends TestCase {

    @Test
    public void testPosition() {
        BishopBlack bb = new BishopBlack(Cell.G4);
        assertEquals(bb.position().toString(),"G4");
    }

    @Test
    public void testCopy() {
        BishopBlack bb = new BishopBlack(Cell.D4);
        assertEquals(bb.copy(Cell.F5).position().toString(),"F5");
    }

    @Test
    public void testWay() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] asSteps = {Cell.D2,Cell.E3,Cell.F4,Cell.G5};
        Arrays.equals(bb.way(Cell.G5), asSteps);
    }
}