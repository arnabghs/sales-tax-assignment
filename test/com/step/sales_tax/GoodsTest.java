package com.step.sales_tax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoodsTest {
  @Test
  void shouldReturnTotalTaxForLocalProducts() {
    Product book = new Product(ProductType.BOOK, Origin.LOCAL, 12.49);
    Product musicCD = new Product(ProductType.MUSIC_CD, Origin.LOCAL, 14.99);
    Product chocolateBar = new Product(ProductType.CHOCOLATE_BAR, Origin.LOCAL, 0.85);

    Goods goods = new Goods();
    goods.addProduct(book, 1);
    goods.addProduct(musicCD, 1);
    goods.addProduct(chocolateBar, 1);

    double actualSalesTax = goods.getTotaltax();
    double actualTotal = goods.getTotalCostIncludingTax();

    double expectedSalesTax = 1.50;
    double expectedTotal = 29.83;

    assertEquals(expectedSalesTax, actualSalesTax);
    assertEquals(expectedTotal, actualTotal);
  }

  @Test
  void shouldReturnTotalTaxForImported() {
    Product chocolates = new Product(ProductType.CHOCOLATES, Origin.IMPORTED, 10.00);
    Product perfume = new Product(ProductType.PERFUME, Origin.IMPORTED, 47.50);

    Goods goods = new Goods();
    goods.addProduct(chocolates, 1);
    goods.addProduct(perfume, 1);

    double actualSalesTax = goods.getTotaltax();
    double actualTotal = goods.getTotalCostIncludingTax();

    double expectedSalesTax = 7.65;
    double expectedTotal = 65.15;

    assertEquals(expectedSalesTax, actualSalesTax);
    assertEquals(expectedTotal, actualTotal);
  }

  @Test
  void shouldReturnTotalTaxForBothImportedAndLocal() {
    Product importedChocolates = new Product(ProductType.CHOCOLATES, Origin.IMPORTED, 11.25);
    Product headachePills = new Product(ProductType.HEADACHE_PILLS, Origin.LOCAL, 9.75);
    Product importedPerfume = new Product(ProductType.PERFUME, Origin.IMPORTED, 27.99);
    Product localPerfume = new Product(ProductType.PERFUME, Origin.LOCAL, 18.99);

    Goods goods = new Goods();
    goods.addProduct(importedChocolates, 1);
    goods.addProduct(headachePills, 1);
    goods.addProduct(importedPerfume, 1);
    goods.addProduct(localPerfume, 1);

    double actualSalesTax = goods.getTotaltax();
    double actualTotal = goods.getTotalCostIncludingTax();

    double expectedSalesTax = 6.70;
    double expectedTotal = 74.68;

    assertEquals(expectedSalesTax, actualSalesTax, 0.5D);
    assertEquals(expectedTotal, actualTotal,0.5D);
  }
}