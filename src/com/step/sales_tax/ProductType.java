package com.step.sales_tax;

enum ProductType {
  BOOK(false),
  MUSIC_CD(true),
  CHOCOLATE_BAR(false),
  CHOCOLATES(false),
  PERFUME(true),
  HEADACHE_PILLS(false);

  private final Boolean isTaxable;

  ProductType(Boolean isTaxable) {
    this.isTaxable = isTaxable;
  }

  public boolean isTaxable() {
    return this.isTaxable;
  }
}
