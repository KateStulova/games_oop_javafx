package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {

    @Test
    public void checkPositionPositive() {
        BishopBlack bishopB = new BishopBlack(C8);
        assertThat(bishopB.position(), is(C8));
    }

    @Test
    public void checkCopyPositive() {
        BishopBlack bishopB = new BishopBlack(C8);
        assertThat(bishopB.copy(E6).position(), is(E6));
    }

    @Test
    public void checkWayFromTheBorderPositive() {
        BishopBlack bishopB = new BishopBlack(C1);
        Cell[] actual = bishopB.way(G5);
        Cell[] expected = {D2, E3, F4, G5};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void checkWayFromTheCenterPositive() {
        BishopBlack bishopB = new BishopBlack(F6);
        Cell[] actual = bishopB.way(B2);
        Cell[] expected = {E5, D4, C3, B2};
        assertArrayEquals(actual, expected);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void checkWayNegative() {
        BishopBlack bishopB = new BishopBlack(C1);
        bishopB.way(E5);
    }
}

