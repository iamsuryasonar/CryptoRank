package com.example.cryptorank;

public class model {
    private String name, symbol;
    private double priceUsd, changePercent24Hr;

    public model(){
    };
    public model( String symbol, String name, double priceUsd, double changePercent24Hr) {

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

    public double getChangePercent24Hr() {
        return changePercent24Hr;
    }

    public void setChangePercent24Hr(double changePercent24Hr) {
        this.changePercent24Hr = changePercent24Hr;
    }

    public double getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(double priceUsd) {
        this.priceUsd = priceUsd;
    }


}

