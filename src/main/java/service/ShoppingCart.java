package service;

import model.Food;
import model.Discountable;

public class ShoppingCart {
    private Food[] items;

    public ShoppingCart(Food[] items) {
        this.items = items;
    }

    public double getTotalPriceWithoutDiscount() {
        double total = 0.0;
        for (Food item : items) {
            total += item.getAmount() * item.getPrice();
        }
        return total;
    }

    public double getTotalPriceWithDiscount() {
        double total = 0.0;
        for (Food item : items) {
            double itemPrice = item.getAmount() * item.getPrice();
            if (item instanceof Discountable) {
                double discount = ((Discountable) item).getDiscount();
                itemPrice = itemPrice * (1 - discount / 100);
            }
            total += itemPrice;
        }
        return total;
    }

    public double getVegetarianTotalPriceWithoutDiscount() {
        double total = 0.0;
        for (Food item : items) {
            if (item.isVegetarian()) {
                total += item.getAmount() * item.getPrice();
            }
        }
        return total;
    }
}
