package Pages;

import Utils.Locators;
import Utils.webElements;

public class CreateNewRA implements webElements {
	public static void CreateNewRAFlow(String RelationType, String RelationKeywords, String ReadyToPublish,
			String Baseload, String Resend) throws Exception {

		if (RelationType.trim().equalsIgnoreCase("Visually matching")) {
			Locators.getXPath(RelationType_VisuallyMatching).click();
		} else {
			Locators.getXPath(RelationType_notset).click();
		}

		Thread.sleep(2000);

		if (RelationKeywords.contains(",")) {
			Locators.getClassName(RelationKeywordsPlaceholder).click();
			String[] arrSplit = RelationKeywords.split(",");
			for (int i = 0; i < arrSplit.length; i++) {
				System.out.println(arrSplit[i]);
				if (arrSplit[i].trim().equalsIgnoreCase("Suit")) {
					Locators.getXPath(RelationKeywords_Suit).click();
				} else if (arrSplit[i].trim().equalsIgnoreCase("Bikini")) {
					Locators.getXPath(RelationKeywords_Bikini).click();
				} else if (arrSplit[i].trim().equalsIgnoreCase("Co-ord")) {
					Locators.getXPath(RelationKeywords_Coord).click();
				} else if (arrSplit[i].trim().equalsIgnoreCase("Coffee set")) {
					Locators.getXPath(RelationKeywords_Coffeeset).click();
				} else if (arrSplit[i].trim().equalsIgnoreCase("Tea set")) {
					Locators.getXPath(RelationKeywords_Teaset).click();
				} else if (arrSplit[i].trim().equalsIgnoreCase("Dinnerware set")) {
					Locators.getXPath(RelationKeywords_Dinnerwareset).click();
				} else if (arrSplit[i].trim().equalsIgnoreCase("Party wear")) {
					Locators.getXPath(RelationKeywords_Partwear).click();
				}
			}
		}

		else {
			Locators.getClassName(RelationKeywordsPlaceholder).click();
			if (RelationKeywords.trim().equalsIgnoreCase("Suit")) {
				Locators.getXPath(RelationKeywords_Suit).click();
			} else if (RelationKeywords.trim().equalsIgnoreCase("Bikini")) {
				Locators.getXPath(RelationKeywords_Bikini).click();
			} else if (RelationKeywords.trim().equalsIgnoreCase("Co-ord")) {
				Locators.getXPath(RelationKeywords_Coord).click();
			} else if (RelationKeywords.trim().equalsIgnoreCase("Coffeee set")) {
				Locators.getXPath(RelationKeywords_Coffeeset).click();
			} else if (RelationKeywords.trim().equalsIgnoreCase("Tea set")) {
				Locators.getXPath(RelationKeywords_Teaset).click();
			} else if (RelationKeywords.trim().equalsIgnoreCase("Dinnerware set")) {
				Locators.getXPath(RelationKeywords_Dinnerwareset).click();
			} else if (RelationKeywords.trim().equalsIgnoreCase("Party wear")) {
				Locators.getXPath(RelationKeywords_Partwear).click();
			}

		}

		Thread.sleep(2000);

		Locators.getClassName(RelationKeyword_close).click();

		if (ReadyToPublish.trim().equalsIgnoreCase("true")) {
			Locators.getXPath(ReadyToPublish_True).click();
		} else if (ReadyToPublish.trim().equalsIgnoreCase("false")) {
			Locators.getXPath(ReadyToPublish_False).click();
		}

		Thread.sleep(2000);

		if (Baseload.trim().equalsIgnoreCase("true")) {
			Locators.getXPath(Baseload_True).click();
		} else if (Baseload.trim().equalsIgnoreCase("false")) {
			Locators.getXPath(Baseload_False).click();
		}
		Thread.sleep(2000);

		if (Resend.trim().equalsIgnoreCase("true")) {
			Locators.getXPath(Resend_True).click();
		} else if (Resend.trim().equalsIgnoreCase("false")) {
			Locators.getXPath(Resend_False).click();
		}
		Thread.sleep(2000);
		Locators.getID(SaveButton).click();
		Thread.sleep(5000);

	}

	public static void VerifyCreatedRelatedArticle() throws Exception {
		Locators.getClassName(RelatedArticle).click();
		Thread.sleep(5000);

	}

}
