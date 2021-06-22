package tdd.bonus;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusCalculatorTest {

    @Test
    public void no_commission_when_sales_equals_quota() {
        assertThat(new BonusCalculator().calculate(BigDecimal.valueOf(15000),BigDecimal.valueOf(15000))).isEqualTo(BigDecimal.valueOf(0));
    }

    @Test
    public void no_commission_when_sales_is_lower_then_quota() {
        assertThat(new BonusCalculator().calculate(BigDecimal.valueOf(13000),BigDecimal.valueOf(15000))).isEqualTo(BigDecimal.valueOf(0));
    }

    @Test
    public void ten_percent_commission_when_sales_is_higher_then_quota() {
        assertThat(new BonusCalculator().calculate(BigDecimal.valueOf(12000),BigDecimal.valueOf(11000))).isEqualTo(BigDecimal.valueOf(90).setScale(2, RoundingMode.DOWN));
    }
}
