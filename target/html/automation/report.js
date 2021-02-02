$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/features/ProductPriceValidationUi.feature");
formatter.feature({
  "line": 2,
  "name": "Product Price Validation",
  "description": "As a user I want to verify the price of item on different pages",
  "id": "product-price-validation",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@web"
    }
  ]
});
formatter.before({
  "duration": 3611710149,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "user navigates to search page",
  "keyword": "Given "
});
formatter.match({
  "location": "PriceValidationSteps.userNavigates()"
});
formatter.result({
  "duration": 3124874986,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Validate item price of first element at Add To Cart Page and Checkout Pages remains same",
  "description": "",
  "id": "product-price-validation;validate-item-price-of-first-element-at-add-to-cart-page-and-checkout-pages-remains-same",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@uiScenario"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "use searches for \"qa testing for beginners\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "verify item price at search and add to cart matches",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "verify item price at search and checkout out page matches",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "qa testing for beginners",
      "offset": 18
    }
  ],
  "location": "PriceValidationSteps.userSearches(String)"
});
formatter.result({
  "duration": 8098552926,
  "status": "passed"
});
formatter.match({
  "location": "PriceValidationSteps.verifyItemPriceAtAddToCart()"
});
formatter.result({
  "duration": 988967665,
  "status": "passed"
});
formatter.match({
  "location": "PriceValidationSteps.verifyItemPriceAtCheckout()"
});
formatter.result({
  "duration": 2206568,
  "status": "passed"
});
formatter.write("Scenario Status :: passed");
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 462615420,
  "status": "passed"
});
});