package tdd.bonus;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BonusCalculator {

    public static final BigDecimal COMMISSION = BigDecimal.valueOf(0.1);
    public static final BigDecimal TAX = BigDecimal.valueOf(0.1);

    public BigDecimal calculate(BigDecimal sales, BigDecimal quota) {
        if (sales.compareTo(quota) <= 0) {
            return BigDecimal.valueOf(0);
        }
        return getCommissionNetto(getCommissionGross(sales, quota)).setScale(2, RoundingMode.DOWN);
    }

    private BigDecimal getCommissionNetto(BigDecimal commission) {
        return commission.subtract(getTax(commission));
    }

    private BigDecimal getTax(BigDecimal commission) {
        return commission.multiply(TAX);
    }

    private BigDecimal getCommissionGross(BigDecimal sales, BigDecimal quota) {
        return sales.subtract(quota).multiply(COMMISSION);
    }
}
