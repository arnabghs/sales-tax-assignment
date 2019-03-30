package com.step.sales_tax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Goods {

  private HashMap<Product, Integer> goods;

  Goods() {
    this.goods = new HashMap<>();
  }

  void addProduct(Product product, int quantity) {
    goods.put(product, quantity);

  }

  double getTotaltax() {
    List<Product> importedGoods = goods.keySet().stream().filter(this::isImported).collect(Collectors.toList());
    List<Product> taxableGoods = goods.keySet().stream().filter(this::isTaxable).collect(Collectors.toList());

    List<Double> taxableGoodsBasePrices = taxableGoods.stream().map(Product::getPrice).collect(Collectors.toList());
    List<Double> importedGoodsBasePrices = importedGoods.stream().map(Product::getPrice).collect(Collectors.toList());

    double baseTax = calculateTax(new basicTaxCalculator(), taxableGoodsBasePrices);
    double importTax = calculateTax(new importTaxCalculator(), importedGoodsBasePrices);

    return baseTax + importTax;
  }

  private boolean isTaxable(Product product) {
    return product.isTaxable();
  }

  private boolean isImported(Product product) {
    return product.isImported();
  }

  private double calculateTax(TaxCalculator taxCalculator, List<Double> priceList) {
    return taxCalculator.calculate(priceList);
  }

  double getTotalCostIncludingTax() {
    double totalCost = 0D;
    for(Map.Entry<Product,Integer> entry: goods.entrySet()) {
      Product product = entry.getKey();
      Integer quantity = entry.getValue();
      totalCost += quantity * product.getPrice();
    }
    return getTotaltax() + totalCost;
  }
}