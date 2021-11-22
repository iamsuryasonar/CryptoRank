package com.example.cryptorank;

public class model {
    private String name, symbol;
    private String priceUsd, changePercent24Hr;

    public model(){
    };
    public model( String symbol, String name, String priceUsd, String changePercent24Hr) {

        this.symbol = symbol;
        this.name = name;
        this.priceUsd = priceUsd;
        this.changePercent24Hr = changePercent24Hr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getChangePercent24Hr() {
        return changePercent24Hr;
    }

    public void setChangePercent24Hr(String changePercent24Hr) {
        this.changePercent24Hr = changePercent24Hr;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }


}

