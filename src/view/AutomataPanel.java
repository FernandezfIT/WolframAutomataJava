package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.AutomataGrid;

public class AutomataPanel extends JPanel {

    private AutomataGrid grid;
    private int cellSize;

    public AutomataPanel() {
        this.cellSize = 10;
        setBackground(Color.WHITE);
    }

    public void setGrid(AutomataGrid grid) {
        this.grid = grid;
        revalidate();
        repaint();
    }

    public AutomataGrid getGrid() {
        return grid;
    }

    public void setCellSize(int cellSize) {
        if (cellSize <= 0) {
            throw new IllegalArgumentException("El tamaño de celda debe ser mayor que 0.");
        }
        this.cellSize = cellSize;
        revalidate();
        repaint();
    }

    public int getCellSize() {
        return cellSize;
    }

    @Override
    public Dimension getPreferredSize() {
        if (grid == null) {
            return new Dimension(400, 300);
        }
        int width = grid.getCols() * cellSize;
        int height = grid.getRows() * cellSize;

        return new Dimension(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (grid == null) {
            return;
        }

        int rows = grid.getRows();
        int cols = grid.getCols();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * cellSize;
                int y = row * cellSize;

                // Fondo / Borde de la celda
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(x + 1, y + 1, cellSize - 1, cellSize - 1);

                // CELDA VIVA
                if (grid.isAlive(row, col)) {
                    g.setColor(Color.BLACK);
                    g.drawRect(x + 1, y + 1, cellSize - 1, cellSize - 1);
                }
            }
        }
    }

}
