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
                    String.format("Could not move by diagonal")
            );
        }
        int size = Math.abs(this.position.getX()-dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = (this.position.getX()-dest.getX() < 0) ? 1:-1;
        int deltaY = (this.position.getY()-dest.getY() < 0) ? 1:-1;
        int x = this.position().getX();
        int y = this.position().getY();
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(x, y);
            x =+ deltaX;
            y =+ deltaY;
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(this.position.getX() - dest.getX()) == Math.abs(this.position.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
