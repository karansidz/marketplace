package com.sidhuz.marketplace.exception;

public class MarketplaceException extends RuntimeException {
    public MarketplaceException(String errorMessage, Throwable throwable) {
        super("MarketPlace Error: " + errorMessage, throwable);
    }

    public MarketplaceException (String errorMessage) {
        super("MarketPlace Error: " + errorMessage);
    }
}
