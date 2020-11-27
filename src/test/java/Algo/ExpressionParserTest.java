package Algo;

import Algo.Misc.ExpressionParser;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionParserTest {

    @Test
    public void test11() {
//        String expression = "-(-6 / 3) - (-(4)) + (18 - 2)";
        String expression = "-6 / 3";
        ExpressionParser expressionParser = new ExpressionParser();
        BigDecimal result = expressionParser.evaluate(expression);
        assertThat(result).isEqualTo(22);
    }
}
