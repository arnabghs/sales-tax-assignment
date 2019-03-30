package com.step.sales_tax;

import java.util.List;

class basicTaxCalculator implements TaxCalculator {
  @Override
  public double calculate(List<Double> priceList) {
    return priceList.stream().reduce(0D, (sum, price) -> sum +  getPercentage(price, 10D));
  }

  private double getPercentage(double number, double percentage) {
    double value = number * percentage / 100;
    return Math.round(value * 100D) / 100D;
  }
}