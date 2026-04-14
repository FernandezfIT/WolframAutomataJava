package model;

public class AutomataGrid {
    private final boolean[][] cells;
    private final Integer rows;
    private final Integer cols;

    public AutomataGrid(Integer rows, Integer cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Filas y Columnas deben ser mayores que 0.");
        }

        this.rows = rows;
        this.cols = cols;
        this.cells = new boolean[rows][cols];
    }

    public Integer getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public boolean isAlive(Integer row, Integer col) {
        validatePosition(row, col);
        return cells[row][col];
    }

    public void setAlive(int row, int col, boolean alive) {
        validatePosition(row, col);
        cells[row][col] = alive;
    }

    public void clear() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                cells[r][c] = false;
            }
        }
    }

    public void setFirstRow(boolean[] initialRow) {
        if (initialRow == null) {
            throw new IllegalArgumentException("La fila inicial no puede ser null.");
        }
        if (initialRow.length != cols) {
            throw new IllegalArgumentException("La fila inicial debe tener exactamente " + cols + " columnas.");
        }
        System.arraycopy(initialRow, 0, cells[0], 0, cols);
    }

    public boolean[] getRow(Integer row){
        if (row < 0 || row >= rows) {
            throw new IllegalArgumentException("Fila fiera de rango: " + row);
        }
        boolean[] copy = new boolean[cols];
        System.arraycopy(cells[row],0,copy,0,cols);
        return copy;
    }

    private void validatePosition(Integer row, Integer col){
        if (row < 0 || row >= rows || col < 0  || col >= cols) {
            throw new IllegalArgumentException("Posicion fuera de rango: fila = " + row + ", columna = " + col);
        }
    }
}
