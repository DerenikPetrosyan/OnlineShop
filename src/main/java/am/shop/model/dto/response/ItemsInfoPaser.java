package am.shop.model.dto.response;

import java.math.BigDecimal;

public interface ItemsInfoPaser {

    long getId();
    String getName();
    String getBrand();
    String getCategory();
    BigDecimal getPrice();
}
