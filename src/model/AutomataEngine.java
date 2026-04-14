package model;

public class AutomataEngine {

    public void generate(AutomataGrid grid, AutomataRule rule) {
        if (grid == null) {
            throw new IllegalArgumentException("El GRID no puede ser null.");
        }
        if (rule == null) {
            throw new IllegalArgumentException("La RULE no puede ser null.");
        }

        int rows = grid.getRows();
        int cols = grid.getCols();

        for (int row = 1; row < rows; row++) {
            boolean[] previousRow = grid.getRow(row -1);

            for (int col = 0; col < cols; col++) {
                boolean left = getCellOrFalse(previousRow, col -1);
                boolean center = getCellOrFalse(previousRow, col );
                boolean right = getCellOrFalse(previousRow, col +1);

                boolean next = rule.nextState(left, center, right);
                grid.setAlive(row, col, next);
            }
        }
    }

    private boolean getCellOrFalse(boolean[] row, int index){
        if (index < 0 || index >= row.length) {
            return false;
        }
        return row[index];
    }
}
