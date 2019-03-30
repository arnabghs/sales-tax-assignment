package com.step.sales_tax;

import java.util.List;

interface TaxCalculator {
  double calculate(List<Double> priceList);
}
