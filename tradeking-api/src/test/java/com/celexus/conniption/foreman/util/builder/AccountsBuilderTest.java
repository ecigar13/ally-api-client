package com.celexus.conniption.foreman.util.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.celexus.conniption.foreman.util.APICall;
import com.celexus.conniption.foreman.util.ResponseFormat;

public class AccountsBuilderTest {

    @Test
    public void getAccountTest() {
        APIBuilder b = AccountsBuilder.getAccount("XXX", ResponseFormat.XML);
        assertTrue(b.getParameters().isEmpty());
        assertEquals(
                "Resource URL different",
                APICall.TK_HOST + "accounts/XXX.xml",
                b.getResourceURL());
    }

    @Test
    public void getAccountsTest() {
        APIBuilder b = AccountsBuilder.getAccounts(ResponseFormat.XML);
        assertTrue(b.getParameters().isEmpty());
        assertEquals("", APICall.TK_HOST + "accounts.xml", b.getResourceURL());
    }

    @Test
    public void getBalanceTest() {
        APIBuilder b = AccountsBuilder.getAccountBalance("XXX", ResponseFormat.XML);
        assertTrue(b.getParameters().isEmpty());
        assertEquals(
                "Resource URL different",
                APICall.TK_HOST + "accounts/XXX/balances.xml",
                b.getResourceURL());
    }

    @Test
    public void getBalancesTest() {
        APIBuilder b = AccountsBuilder.getAccountBalances(ResponseFormat.XML);
        assertTrue(b.getParameters().isEmpty());
        assertEquals(
                "Resource URL different",
                APICall.TK_HOST + "accounts/balances.xml",
                b.getResourceURL());
    }
}
