package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Can't not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = (dest.getX() - position.getX()) / size;
        int deltaY = (dest.getY() - position.getY()) / size;
        for (int index = 1; index <= size; index++) {
            steps[index - 1] = Cell.findBy((position.getX() + index * deltaX),
                    (position.getY() + index * deltaY));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int x1 = source.getX();
        int y1 = source.getY();
        int x2 = dest.getX();
        int y2 = dest.getY();
        return (x1 - x2 == y1 - y2 || x2 - x1 == y2 - y1
                || -(x1 - x2) == y1 - y2 || -(x2 - x1) == y2 - y1);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
