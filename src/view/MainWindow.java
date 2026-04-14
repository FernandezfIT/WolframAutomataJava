package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.AutomataGrid;

public class MainWindow extends JFrame {
    private final JTextField ruleField;
    private final JTextField rowsField;
    private final JTextField colsField;
    private final JTextField densityField;
    private final JComboBox<String> initialModeCombo;

    private final JButton generateButton;
    private final JButton clearButton;

    private final AutomataPanel automataPanel;

    public MainWindow() {
        super("Autómata Celular 1D");

        // Panel de dibujo
        this.automataPanel = new AutomataPanel();

        // CAMPOS
        this.ruleField = new JTextField("30", 5);
        this.rowsField = new JTextField("60", 5);
        this.colsField = new JTextField("101", 5);
        this.densityField = new JTextField("0.3", 5);

        // MODO INICIAL
        this.initialModeCombo = new JComboBox<>(new String[] {
                "Centro",
                "Aleatorio",
                "Vacío"
        });

        // Botones
        this.generateButton = new JButton("Generar");
        this.clearButton = new JButton("Limpiar");

        // Layout Principal
        setLayout(new BorderLayout());

        // Panel superior de CONTROLRES
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        controlPanel.add(new JLabel("Regla:"));
        controlPanel.add(ruleField);

        controlPanel.add(new JLabel("Generaciones:"));
        controlPanel.add(rowsField);

        controlPanel.add(new JLabel("Columnas:"));
        controlPanel.add(colsField);

        controlPanel.add(new JLabel("Modo Inicial:"));
        controlPanel.add(initialModeCombo);

        controlPanel.add(new JLabel("Densidad:"));
        controlPanel.add(densityField);

        controlPanel.add(generateButton);
        controlPanel.add(clearButton);

        add(controlPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocation(null);

    }

    public String getRuleInput() {
        return ruleField.getText();
    }

    public String getRowsInput() {
        return rowsField.getText();
    }

    public String getColsInput() {
        return colsField.getText();
    }

    public String getDensityInput() {
        return densityField.getText();
    }

    public String getInitialMode() {
        return (String) initialModeCombo.getSelectedItem();
    }

    public void setGrid(AutomataGrid grid){
        automataPanel.setGrid(grid);
        pack();
    }

    public void repaintGrud(){
        automataPanel.setGrid(null);
    }

    public void clearGrid(){
        automataPanel.setActionMap(null);
        pack();
    }

    public void showError(String message){
        JOptionPane.showMessageDialog(
            this,
            message,
            "Error",
            JOptionPane.ERROR_MESSAGE
        );
    }

    public void addGenerateListener(ActionListener listener){
        generateButton.addActionListener(listener);
    }

    public void addClearListener(ActionListener listener){
        clearButton.addActionListener(listener);
    }

}
