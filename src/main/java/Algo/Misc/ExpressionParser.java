package Algo.Misc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExpressionParser {

    private static enum TokenType {
        NUM(0, ""), PLUS(1, "+"), MINUS(2, "-"), MUL(3, "*"),
        DIV(4, "/"), LP(5, "("), RP(6, ")"), POW(7, "^"),
        END(8, "E");

        private final int type;
        private final String operation;

        TokenType(int type, String sign) {
            this.type = type;
            this.operation = sign;
        }

        public int getType() {
            return type;
        }

        public String getOperation() {
            return operation;
        }
    }

    private static class Token {
        TokenType tokenType;
        BigDecimal value;

        public Token(TokenType tokenType, BigDecimal value) {
            this.tokenType = tokenType;
            this.value = value;
        }

        public static Token valueOf(Character c) throws Exception {
            if (Character.isDigit(c)) {
                return new Token(TokenType.NUM, new BigDecimal(String.valueOf(c)));
            }

            Token token;
            switch (c) {
                case '/':
                    token = new Token(TokenType.DIV, BigDecimal.ZERO);
                    break;
                case '*':
                    token = new Token(TokenType.MUL, BigDecimal.ZERO);
                    break;
                case '+':
                    token = new Token(TokenType.PLUS, BigDecimal.ZERO);
                    break;
                case '-':
                    token = new Token(TokenType.MINUS, BigDecimal.ZERO);
                    break;
                case '(':
                    token = new Token(TokenType.LP, BigDecimal.ZERO);
                    break;
                case ')':
                    token = new Token(TokenType.RP, BigDecimal.ZERO);
                    break;
                default:
                    throw new Exception("Unexpected token: " + c);
            }
            return token;
        }

        @Override
        public String toString() {
            return "[" + tokenType +
                    ", " + value +
                    ']';
        }
    }

    public BigDecimal evaluate(String expression) {
        if (expression.replace(" ", "").length() == 0) {
            return BigDecimal.ZERO;
        }

        try {
            List<Token> tokens = parse(expression);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return BigDecimal.ZERO;
    }

    private List<Token> parse(String expression) throws Exception {
        List<Token> tokens = new ArrayList<>();
        tokenize(expression, tokens);

        return tokens;
    }

    private void tokenize(String expression, List<Token> tokens) throws Exception {
        if (expression.length() == 0) {
            return;
        } else if (expression.charAt(0) == ' ') {
            tokenize(expression.substring(1), tokens);
            return;
        } else if (expression.length() == 1) {
            tokens.add(Token.valueOf(expression.charAt(0)));
            return;
        } else if (Character.isDigit(expression.charAt(0))) {
            if (expression.charAt(1) == ' ') {
                tokens.add(Token.valueOf(expression.charAt(0)));
                tokenize(expression.substring(2), tokens);
            } else {
                tokenize(expression.substring(1), tokens);
                tokens.add(Token.valueOf(expression.charAt(0)));
            }
        } else {
            tokens.add(Token.valueOf(expression.charAt(0)));
            if (expression.charAt(0) == '(') {
                tokenizeUnary(expression.substring(1), tokens);
            } else {
                tokenize(expression.substring(1), tokens);
            }
        }
    }

    private void tokenizeUnary(String expression, List<Token> tokens) throws Exception {
        if (expression.length() == 0) {
            return;
        } else if (expression.length() == 1) {
            tokens.add(Token.valueOf(expression.charAt(0)));
            return;
        } else if (expression.charAt(0) == ' ') {
            tokenize(expression.substring(1), tokens);
            return;
        } else if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-') {
            if (Character.isDigit(expression.charAt(1)) && expression.charAt(1) != ' ') {
                tokens.add(new Token(TokenType.NUM, new BigDecimal(expression.substring(0, 2))));
                tokenize(expression.substring(2), tokens);
            } else {
                tokenize(expression.substring(1), tokens);
                tokens.add(Token.valueOf(expression.charAt(0)));
            }
        } else {
            tokens.add(Token.valueOf(expression.charAt(0)));
            if (expression.charAt(0) == '(') {
                tokenizeUnary(expression.substring(1), tokens);
            } else {
                tokenize(expression.substring(1), tokens);
            }
        }
    }
}
