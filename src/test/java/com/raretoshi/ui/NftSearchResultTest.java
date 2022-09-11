package com.raretoshi.ui;

import com.raretoshi.ui.page.HomePage;
import com.raretoshi.ui.page.MarketPage;
import com.raretoshi.ui.page.NftPage;
import com.raretoshi.ui.steps.NftSearchResultStep;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class NftSearchResultTest extends BaseTest {

    @Test
    public void testSearchWithEmptyQuery() {
        String expectedMessageSearchNothingMatched = "Nothing matched that search string";
        HomePage homePage = new HomePage();
        NftSearchResultStep.searchWithEmptyQuery();
        assertEquals(expectedMessageSearchNothingMatched, homePage.getMessageSearchNothingMatched());

    }

    @Test
    public void testSearchWithIncorrectQuery() {
        String expectedMessageSearchNothingMatched = "Nothing matched that search string";
        HomePage homePage = new HomePage();
        NftSearchResultStep.searchWithIncorrectQuery();
        assertEquals(expectedMessageSearchNothingMatched, homePage.getMessageSearchNothingMatched());

    }

    @Test
    public void testSearchWithResultNameMatchedQuery() {
        String inputUserCorrectSearchQuery = "[THE BOT‘s CAT]";
        HomePage homePage = new HomePage();
        NftSearchResultStep.nftSearch(inputUserCorrectSearchQuery);
        NftPage nftPage = new NftPage();
        assertEquals(homePage.getUserInputSearchQuery(), nftPage.getUserNameNft(), "Exact search match with NFT name");

    }

    @Test
    public void testSearchWithResultPartPresentNameNft() {
        String inputUserCorrectPartSearchQueryIsPresentNft = "CAT";
        int resultPartSearchQueryIsPresentNft;
        NftSearchResultStep.nftSearch(inputUserCorrectPartSearchQueryIsPresentNft);
        MarketPage marketPage = new MarketPage();
        resultPartSearchQueryIsPresentNft = marketPage.getNameNftMarket(inputUserCorrectPartSearchQueryIsPresentNft).size();
        assertNotEquals(resultPartSearchQueryIsPresentNft, 0,
                "Amount of NFT matches by searching for part of the real NFT name");

    }

    @Test
    public void testSearchWithResultHashTagPartPresentNameNft() {
        String inputUserCorrectPartSearchQueryIsPresentNft = "#CAT";
        int resultPartSearchQueryIsPresentNft;
        NftSearchResultStep.nftSearch(inputUserCorrectPartSearchQueryIsPresentNft);
        MarketPage marketPage = new MarketPage();
        resultPartSearchQueryIsPresentNft = marketPage.getNameNftMarket(inputUserCorrectPartSearchQueryIsPresentNft).size();
        assertNotEquals(resultPartSearchQueryIsPresentNft, 0,
                "Amount of NFT matches by searching for the hashtag of part of the name of the real NFT");

    }
}
