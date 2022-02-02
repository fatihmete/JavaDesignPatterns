package creational.builder.fluent_builder;

import java.util.ArrayList;

class Item
{
    public String name;
    public double count;

    public Item(String name, double count)
    {
        this.name = name;
        this.count = count;
    }

}

class ShoppingListBuilder
{
    ArrayList<Item> list = new ArrayList<>();
    String name;

    public ShoppingListBuilder(String name){
        this.name = name;
    }

    public ShoppingListBuilder addItem(String name, double count)
    {
        Item item = new Item(name, count);
        this.list.add(item);
        return this;
    }
    public void printList()
    {

        System.out.println("List for " + this.name + ":");
        for(Item item : this.list)
        {
            System.out.println("-" + item.name + "(" +item.count+ ")");
        }
    }
}

public class FluentBuilder {

    public static void main(String[] args) {
        ShoppingListBuilder shoppingList = new ShoppingListBuilder("Supermarket");
        shoppingList.addItem("Apple", 0.4)
                    .addItem("Juice", 3)
                    .addItem("Cheese", 5)
                    .addItem("Bread", 4)
                    .printList();
    }

}
