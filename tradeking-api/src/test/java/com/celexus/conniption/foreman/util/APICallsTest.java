package com.celexus.conniption.foreman.util;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.celexus.conniption.foreman.util.APICall.TopList;

public class APICallsTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void accountsTest() {
        String accounts = APICall.getAccounts(ResponseFormat.XML);
        String balances = APICall.getAccountBalances(ResponseFormat.XML);
        String byID = APICall.getAccountByID(ResponseFormat.XML, "myId");

        assertEquals(accounts, APICall.TK_HOST + "accounts.xml");
        assertEquals(balances, APICall.TK_HOST + "accounts/balances.xml");
        assertEquals(byID, APICall.TK_HOST + "accounts/myId.xml");
    }

    @Test
    public void ordersTest() {
        String orderByID = APICall.getOrderByAccountID(ResponseFormat.XML, "myId");
        String postOrder = APICall.postOrderByAccountID(ResponseFormat.XML, "myId");
        String preview = APICall.postOrderByAccountIDPreview(ResponseFormat.XML, "myId");

        assertEquals(orderByID, APICall.TK_HOST + "accounts/myId/orders.xml");
        assertEquals(postOrder, APICall.TK_HOST + "accounts/myId/orders.xml");
        assertEquals(preview, APICall.TK_HOST + "accounts/myId/orders/preview.xml");
    }

    @Test
    public void marketTest() {
        String clock = APICall.getMarketClock(ResponseFormat.XML);
        String quote = APICall.getQuote(ResponseFormat.XML);
        String newsSearch = APICall.searchNews(ResponseFormat.XML);
        String news = APICall.getNews(ResponseFormat.XML, "234899d5fd2ee9a501a8349a0f571f6f");
        String optionsSearch = APICall.searchOptions(ResponseFormat.XML);
        String optionStrikes = APICall.getOptionStrikes(ResponseFormat.XML);
        String optionExpirations = APICall.getOptionExpirations(ResponseFormat.XML);
        String timeSales = APICall.getTimeSales(ResponseFormat.XML);
        String gainers = APICall.getTopList(TopList.GAINERS_ACTIVE, ResponseFormat.XML);

        assertEquals(clock, APICall.TK_HOST + "market/clock.xml");
        assertEquals(quote, APICall.TK_HOST + "market/ext/quotes.xml");
        assertEquals(newsSearch, APICall.TK_HOST + "market/news/search.xml");
        assertEquals(
                news,
                APICall.TK_HOST + "market/news/234899d5fd2ee9a501a8349a0f571f6f.xml");
        assertEquals(optionsSearch, APICall.TK_HOST + "market/options/search.xml");
        assertEquals(optionStrikes, APICall.TK_HOST + "market/options/strikes.xml");
        assertEquals(
                optionExpirations, APICall.TK_HOST + "market/options/expirations.xml");
        assertEquals(timeSales, APICall.TK_HOST + "market/timesales.xml");
        assertEquals(
                gainers,
                APICall.TK_HOST + "market/toplists/topactivegainersbydollarvalue.xml");
    }

    @Test
    public void memberTest() {
        String member = APICall.getMemberProfile(ResponseFormat.XML);
        assertEquals(member, APICall.TK_HOST + "member/profile.xml");
    }

    @Test
    public void utilityTest() {
        String status = APICall.getTKStatus(ResponseFormat.XML);
        String version = APICall.getTKVersion(ResponseFormat.XML);
        assertEquals(status, APICall.TK_HOST + "utility/status.xml");
        assertEquals(version, APICall.TK_HOST + "utility/version.xml");
    }

    @Test
    public void watchlistTest() {
        String watchlists = APICall.getWatchlists(ResponseFormat.XML);
        String postWatchlists = APICall.postWatchlists(ResponseFormat.XML);
        String getWatchlistsId = APICall.getWatchlistsById("myId", ResponseFormat.XML);
        String deleteWatchlistsId = APICall.deleteWatchlistsById("myId", ResponseFormat.XML);
        String getWatchlistsSymbol = APICall.postWatchlistsBySymbol("myId", ResponseFormat.XML);
        String deleteSymbolWatchList =
                APICall.deleteSymbolFromWatchList("myId", "sym", ResponseFormat.XML);

        assertEquals(watchlists, APICall.TK_HOST + "watchlists.xml");
        assertEquals(postWatchlists, APICall.TK_HOST + "watchlists.xml");
        assertEquals(getWatchlistsId, APICall.TK_HOST + "watchlists/myId.xml");
        assertEquals(deleteWatchlistsId, APICall.TK_HOST + "watchlists/myId.xml");
        assertEquals(
                getWatchlistsSymbol, APICall.TK_HOST + "watchlist/myId/symbols.xml");
        assertEquals(deleteSymbolWatchList, APICall.TK_HOST + "watchlists/myId/sym.xml");
    }
}
