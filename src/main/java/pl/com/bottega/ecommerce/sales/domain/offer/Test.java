package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		Offer offerOne = new Offer();
		List<OfferItem> availabeItems = null;
		offerOne.setAvailabeItems(availabeItems);
		List<OfferItem> unavailableItems = null;
		offerOne.setUnavailableItems(unavailableItems);
		OfferItem offerItem1 = new OfferItem();
	}

}