package com.raretoshi.ui.steps;

import com.raretoshi.ui.page.HomePage;
import com.raretoshi.ui.utils.Random;

public class NftSearchResultStep {

    public static HomePage nftSearch(String inputUserSearchQuery) {
        return new HomePage()
                .clearSearchField()
                .typeSearchQuery(inputUserSearchQuery)
                .clickButtonSearch();
    }

    public static HomePage searchWithEmptyQuery() {
        return new HomePage()
                .typeSearchQuery(Random.generateRandomAsciiString())
                .clearSearchField()
                .clickButtonSearch();
    }

    public static HomePage searchWithIncorrectQuery() {
        return new HomePage()
                .typeSearchQuery(Random.generateRandomAsciiString())
                .clickButtonSearch();
    }
}
