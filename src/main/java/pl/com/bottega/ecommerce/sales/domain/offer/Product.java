package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

    private String productId;

    private BigDecimal productPrice;

    private String productName;

    private Date productSnapshotDate;

    private String productType;

    public Product(String productId, String productName, BigDecimal productPrice, Date productSnapshotDate,
            String productType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
    }

    public Product() {}

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductSnapshotDate(Date productSnapshotDate) {
        this.productSnapshotDate = productSnapshotDate;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductId() {
        return productId;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public String getProductType() {
        return productType;
    }

    public boolean sameAs(Product other, double delta) {
        if (productName == null) {
            if (other.productName != null) {
                return false;
            }
        } else if (!productName.equals(other.productName)) {
            return false;
        }
        if (productPrice == null) {
            if (other.productPrice != null) {
                return false;
            }
        } else if (!productPrice.equals(other.productPrice)) {
            return false;
        }
        if (productId == null) {
            if (other.productId != null) {
                return false;
            }
        } else if (!productId.equals(other.productId)) {
            return false;
        }
        if (productType != other.productType) {
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max, min;
        if (totalCost.compareTo(other.totalCost) > 0) {
            max = totalCost;
            min = other.totalCost;
        } else {
            max = other.totalCost;
            min = totalCost;
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(new BigDecimal(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
