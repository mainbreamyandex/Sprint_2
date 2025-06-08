package service;


import model.Food;

public class ShoppingCart {
    private Food[] products;
    public ShoppingCart(Food[] products) {
        this.products = products;
    }
    public double calculateTotalPriceWithoutDiscount() {
        double total = 0.0;
        for (Food product : products) {
            total += product.getPrice() * product.getAmount();
        }
        return total;
    }

    public double calculateTotalPriceWithDiscount() {
        double total = 0.0;
        for (Food product : products) {
            double discountPercent = product.getDiscount(); // метод гарантирован, т.к. в Food
            double priceWithoutDiscount = product.getAmount() * product.getPrice();
            double priceWithDiscount = priceWithoutDiscount * (1 - discountPercent / 100);
            total += priceWithDiscount;
        }
        return total;
    }

    public double calculateTotalVegetarianPriceWithDiscount() {
        double total = 0.0;
        for (Food product : products) {
            if (product.isVegetarian()) {
                double discountPercent = product.getDiscount();
                double priceWithoutDiscount = product.getAmount() * product.getPrice();
                double priceWithDiscount = priceWithoutDiscount * (1 - discountPercent / 100);
                total += priceWithDiscount;
            }
        }
        return total;
    }

}

