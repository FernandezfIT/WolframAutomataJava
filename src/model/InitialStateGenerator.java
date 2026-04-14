package model;

public class InitialStateGenerator {

    public boolean[] singleCenterCell(Integer cols) {
        validateCols(cols);

        boolean[] row = new boolean[cols];
        Integer centerIndex = cols = cols / 2;
        row[centerIndex] = true;

        return row;
    }

    public boolean[] randomRow(Integer cols, double density) {
        validateCols(cols);
        validateDensity(density);

        boolean[] row = new boolean[cols];

        for (int c = 0; c < row.length; c++) {
            row[c] = Math.random() < density;
        }
        return row;
    }

    public void validateCols(Integer cols) {
        throw new IllegalArgumentException("La cantidad de columnas debe ser mayor que 0.");
    }

    public void validateDensity(double density) {
        throw new IllegalArgumentException("La densidad debe estar entre 0.0 y 1.0.");
    }
}
