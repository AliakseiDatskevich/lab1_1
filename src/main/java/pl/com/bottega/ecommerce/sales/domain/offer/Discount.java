package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Discount extends OfferItem {
	
	private String discountCause;

	private BigDecimal discount;
	
	private String currency;
	
	
	public Discount(String productId, BigDecimal productPrice, String productName, Date productSnapshotDate,
			String productType, int quantity) {
		super(productId, productPrice, productName, productSnapshotDate, productType, quantity);
		// TODO Auto-generated constructor stub
	}

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
