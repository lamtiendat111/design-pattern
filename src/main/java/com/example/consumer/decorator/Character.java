package com.example.consumer.decorator;

public class Character {
    int price = 0;

    private Item i;

    public Character addItem(Item item){
        price += item.price;
        return this;
    }


    public static void main(String[] args) {
        Character trasua = new Character();
        trasua
                .addItem(new Item1Impl(3))
                .addItem(new Item2Impl(21))
                .addItem(new Item3Impl(6));

        System.out.println(trasua
                .addItem(new Item1Impl(11))
                .addItem(new Item1Impl(2)).price);
    }

}
