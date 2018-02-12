package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {

    public Discount(String discountCause, BigDecimal discount, String currency) {
        super();
        this.discountCause = discountCause;
        this.discount = discount;
        this.currency = currency;
    }

    public Discount() {}

    private String discountCause;

    public BigDecimal discount;

    private String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTotalCostCurrency() {
        return currency;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public void setDiscountCause(String discountCause) {
        this.discountCause = discountCause;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

}
