package logic.expression.calculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionCalculator {
    private ArrayList<MathExpression> listExpression;
    private final static String REGEX_SPLITTER = "_+";
    private final static String VALID_EXPRESSION_REGEX = "\\[.+\\]";

    public ExpressionCalculator(String expression) {
        listExpression = new ArrayList<>();
        parse(expression);
    }

    private void parse(String expression) {
        Pattern pattern = Pattern.compile(VALID_EXPRESSION_REGEX);
        Matcher matcher = pattern.matcher(expression);
        matcher.find();
        String validExpression = matcher.group();
        String tmpExpression = validExpression.substring(1, validExpression.length() - 2);

        for (String lexeme : tmpExpression.split(REGEX_SPLITTER)) {
            if (lexeme.isEmpty()) {
                continue;
            }

            char temp = lexeme.charAt(0);
            switch (temp) {
                case '+':
                    listExpression.add(new TerminalExpressionPlus());
                    break;
                case '-':
                    listExpression.add(new TerminalExpressionMinus());
                    break;
                case '*':
                    listExpression.add(new TerminalExpressionMultiply());
                    break;
                case '/':
                    listExpression.add(new TerminalExpressionDivide());
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if (scan.hasNextInt()) {
                        listExpression.add(new NonTerminalExpressionNumber(scan.nextInt()));
                    }
            }
        }
    }

    public Number calculate() {
        Context context = new Context();
        for (MathExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue();
    }
}