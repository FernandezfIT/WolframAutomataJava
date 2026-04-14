package controller;

import model.AutomataEngine;
import model.AutomataGrid;
import model.AutomataRule;
import model.InitialStateGenerator;
import view.MainWindow;

public class AutomataController {
    private final MainWindow view;
    private final InitialStateGenerator initialState;
    private final AutomataEngine engine;

    public AutomataControllerx(MainWindow vieMainWindow){
        if (view == null) {
            throw new IllegalAccessException("La vista no puede ser null.");
        }
        this.view = view;
        this.initialState = new InitialStateGenerator();
        this.engine = new AutomataEngine();

        setupListeners();
    }

    private void setupListeners() {
        view.addGenerateListener(e -> generateAutomaton());
        view.addClearListener(e -> clearAutomaton());
    }

    private void generateAutomaton() {
        try {
            int ruleNumber = parseRule(view.getRuleInput());
            int rows = parsePositiveInt(view.getRowsInput());
            int cols = parsePositiveInt(view.getColsInput());
            String mode = view.getInitialMode();

            double density = 0.0;
            if ("Aleatorio".equals(mode)) {
                density = parseDensity(view.getDensityInput());
            }

            AutomataRule rule = new AutomataRule(ruleNumber);
            AutomataGrid grid = new AutomataGrid(rows, cols);

            boolean[] firstRow = buildInitialRow(mode, cols, density);
            grid.setFirstRow(firstRow);

            engine.generate(grid, rule);

            view.setGrid(grid);

        } catch (IllegalArgumentException ex) {
            view.showError(ex.getMessage());
        }
    }

    private void clearAutomaton() {
        view.clearGrid();
    }

    private int parseRule(String text) {
        int rule = parseInteger(text, "Regla");

        if (rule < 0 || rule > 255) {
            throw new IllegalArgumentException("La regla debe estar entre 0 y 255.");
        }
        return rule;
    }

    
}
