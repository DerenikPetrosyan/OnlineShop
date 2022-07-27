package am.shop;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {

        BigDecimal a1 = BigDecimal.valueOf(2);
        BigDecimal a2 = BigDecimal.valueOf(150);
        a1 =a1.add(a2.multiply(new BigDecimal(2)));

        System.out.println(a1);
    }
}
