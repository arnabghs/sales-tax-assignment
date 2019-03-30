package com.step.sales_tax;

class Product {
  private final Origin originType;
  private ProductType productType;
  private double price;

  Product(ProductType productType, Origin originType, double price) {
    this.productType = productType;
    this.originType = originType;
    this.price = price;
  }

  boolean isTaxable() {
    return this.productType.isTaxable();
  }

  double getPrice() {
    return price;
  }

  boolean isImported() {
    return this.originType == Origin.IMPORTED;
  }
}