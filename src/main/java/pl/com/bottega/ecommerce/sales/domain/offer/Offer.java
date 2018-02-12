package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.ArrayList;
import java.util.List;

public class Offer {

    private List<OfferItem> availableItems = new ArrayList<OfferItem>();

    private List<OfferItem> unavailableItems = new ArrayList<OfferItem>();

    public Offer(List<OfferItem> availabeItems, List<OfferItem> unavailableItems) {
        this.availableItems = availabeItems;
        this.unavailableItems = unavailableItems;
    }

    public List<OfferItem> getAvailabeItems() {
        return availableItems;
    }

    public List<OfferItem> getUnavailableItems() {
        return unavailableItems;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (availableItems == null ? 0 : availableItems.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Offer other = (Offer) obj;
        if (availableItems == null) {
            if (other.availableItems != null) {
                return false;
            }
        } else if (!availableItems.equals(other.availableItems)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param seenOffer
     * @param delta
     *            acceptable difference in percent
     * @return
     */
    public boolean sameAs(Offer seenOffer, double delta) {
        if (!(availableItems.size() == seenOffer.availableItems.size())) {
            return false;
        }

        for (OfferItem item : availableItems) {
            OfferItem sameItem = seenOffer.findItem(item.product.getProductId());
            if (sameItem == null) {
                return false;
            }
            if (!sameItem.sameAs(item, delta)) {
                return false;
            }
        }

        return true;
    }

    private OfferItem findItem(String productId) {
        for (OfferItem item : availableItems) {
            if (item.product.getProductId().equals(productId)) {
                return item;
            }
        }
        return null;
    }

    public void addAvailableItem(OfferItem offerItem) {
        availableItems.add(offerItem);
    }

    public void addUnavailableItem(OfferItem offerItem) {
        unavailableItems.add(offerItem);
    }

    public void removeAvailableItem(int index) {
        availableItems.remove(index);
    }

    public void removeUnavailableItem(int index) {
        unavailableItems.remove(index);
    }

    public boolean availableItemsIsEmpty() {
        return availableItems.isEmpty();
    }

    public boolean unavailableItemsIsEmpty() {
        return unavailableItems.isEmpty();
    }

    public void printAvailableItems() {
        if (availableItems.isEmpty() != false) {
            for (int i = 0; i < availableItems.size(); i++) {
                System.out.println(availableItems.get(i).toString());
            }
        }
    }

    public void printUnvailableItems() {
        if (availableItems.isEmpty() != false) {
            for (int i = 0; i < unavailableItems.size(); i++) {
                System.out.println(unavailableItems.get(i).toString());
            }
        }
    }
}
