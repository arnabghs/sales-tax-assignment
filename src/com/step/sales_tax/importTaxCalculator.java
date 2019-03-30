package com.step.sales_tax;

import java.util.List;

public class importTaxCalculator implements TaxCalculator {
  @Override
  public double calculate(List<Double> priceList) {
    return priceList.stream().reduce(0D,(sum, price) -> sum + getPercentage(price,5D));
  }

  private double getPercentage(double number, double percentage){
    return Math.ceil(number*percentage/100/0.05D) * 0.05D;
  }
}
