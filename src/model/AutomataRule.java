package model;

public class AutomataRule {
    private int ruleNumber;

    public AutomataRule(Integer ruleNumber) {
        validateRule(ruleNumber);
        this.ruleNumber = ruleNumber;
    }

    public int getRuleNumber() {
        return ruleNumber;
    }

    public void setRuleNumber(Integer ruleNumber) {
        validateRule(ruleNumber);
        this.ruleNumber = ruleNumber;
    }

    public boolean nextState(boolean left, boolean center, boolean right) {
        Integer index = patternToIndex(left, center, right);
        return ((ruleNumber >> index) & 1) == 1;
    }

    private void validateRule(Integer ruleNumber) {
        if (ruleNumber < 0 || ruleNumber > 255) {
            throw new IllegalArgumentException("La regla debe esgtar entre 0 y 255");
        }
    }

    private int patternToIndex(boolean left, boolean center, boolean right) {
        int value = 0;

        if (left) {
            value += 4;
        }
        if (center) {
            value += 2;
        }
        if (right) {
            value += 1;
        }
        return value;
    }

}
