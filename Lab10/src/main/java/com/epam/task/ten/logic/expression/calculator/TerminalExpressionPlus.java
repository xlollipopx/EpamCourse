package logic.expression.calculator;

public class TerminalExpressionPlus implements MathExpression {
    @Override
    public void interpret(Context c) {
        c.pushValue(c.popValue() + c.popValue());
    }
}