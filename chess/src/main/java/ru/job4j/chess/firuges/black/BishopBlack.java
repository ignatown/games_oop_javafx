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
        int deltaX = this.position.getX()-dest.getX();
        int deltaY = this.position.getY()-dest.getY();
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(this.position.getX()+deltaX*index, this.position.getY()+deltaY*index);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (Math.abs(this.position.getX()-dest.getX())/Math.abs(this.position.getY()-dest.getY()) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
