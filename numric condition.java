package ast;

public class NumericCondition implements Condition {
    private String field;
    private String operator;
    private int value;

    public NumericCondition(String field, String operator, int value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public boolean evaluate(UserData data) {
        int userValue = data.getFieldValue(field);
        switch (operator) {
            case ">":
                return userValue > value;
            case "<":
                return userValue < value;
            case "==":
                return userValue == value;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
