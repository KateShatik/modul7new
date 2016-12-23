import java.util.*;

import java.util.TreeSet;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Set;

/**
 * Created by Катя on 09.12.2016.
 */
public class Main {

    public static Set<Order> unique_city(List<Order> orders, String city){

        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getUser().getCity().compareTo(o2.getUser().getCity());
            }
        });

        Set<Order> unique_city = new TreeSet<>();
       /*  Iterator<Order>iterator= unique_city.iterator();
        while(iterator.hasNext()){
            if(!(iterator.next().getUser().getCity().equals(city))){
                iterator.remove();
            }}*/

        for(Order o: orders){
            if(o.getUser().getCity().equals(city)){unique_city.add(o);}
        }

        return unique_city;
    }

    public static void main(String[] args) {
        User user1 = new User(100,"Marina","Shilkova","Kiev", 1000);
        User user2 = new User(101,"Masha","Stepko","Lviv", 1500);
        User user3 = new User(102,"Sasha","Borovaya","Odessa", 2000);
        User user4 = new User(103,"Olya","Gogol","Kiev", 3000);
        User user5 = new User(104,"Kate","Orel","Odessa", 6000);
        User user6 = new User(105,"Karina","Donchenko","Kiev", 700);
        User user7 = new User(106,"Oleg","Petrov","Lviv", 500);
        User user8 = new User(107,"Lera","Ivanova","Donezk", 1000);
        User user9 = new User(108,"Yulia","Lebedeva","Lviv", 2000);
        User user10 = new User(109,"Dana","Sava","Donezk", 1700);

        Order order1 = new Order(100,2000,Currency.UAH,"pen","Shop1",user1 );
        Order order2 = new Order(101,100,Currency.USD,"bag","Shop2",user2 );
        Order order3 = new Order(102,200,Currency.UAH,"bag","Shop2",user3 );
        Order order4 = new Order(103,2030,Currency.UAH,"iron","Shop1",user4 );
        Order order5 = new Order(104,200,Currency.USD,"cup","Shop1",user5 );
        Order order6 = new Order(105,250,Currency.UAH,"dress","Shop2",user6 );
        Order order7 = new Order(106,270,Currency.UAH,"t-shirt","Shop2",user7 );
        Order order8 = new Order(107,290,Currency.USD,"gloves","Shop2",user8 );
        Order order9 = new Order(100,2000,Currency.UAH,"pen","Shop1",user1 );
        Order order10 = new Order(101,100,Currency.USD,"bag","Shop2",user2 );

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);
        orders.add(order7);
        orders.add(order8);
        orders.add(order9);
        orders.add(order10);
        System.out.println("List sorted by price from highest to lowest");
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o2.getPrice()-o1.getPrice();
            }
        });

        System.out.println(orders.toString());


        System.out.println("List sorted by price from lowest to highest and by city");
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                int result = o1.getPrice()-o2.getPrice();
                if(result !=0)return (int)(result/(Math.abs(result)));
                return o1.getUser().getCity().compareTo(o2.getUser().getCity());
            }
        });
        System.out.println(orders.toString());

        System.out.println("List sorted by itemName,ShopIdentificator and user's city");
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                int result = o1.getShopIdentificator().compareTo(o2.getShopIdentificator());
                if(result !=0)return (int)(result/(Math.abs(result)));
                result = (int)(o1.getId()-o2.getId());
                if(result!=0)return (int)(result/(Math.abs(result)));
                return o1.getUser().getCity().compareTo(o2.getUser().getCity());
            }
        });
        System.out.println(orders.toString());

        System.out.println("Delete duplicates");
        Set<Order> deleteDuplicates = new HashSet<Order>();
        deleteDuplicates.addAll(orders);
        System.out.println(deleteDuplicates);

        System.out.println("Delete items where price <1500");
        Set<Order> priceAbove1500 = new HashSet<Order>();
        for(Order o : orders){
            if (o.getPrice()>=1500) priceAbove1500.add(o);
        }
        System.out.println(priceAbove1500);

        System.out.println("list of orders with USD");
        List<Order> ordersUSD= new ArrayList<Order>();
        for(Order o : orders){
            if (o.getCurrency()== Currency.USD) ordersUSD.add(o);
        }
        System.out.println(ordersUSD);

        System.out.println("list of orders with UAH");
        List<Order> ordersUAH= new ArrayList<Order>();
        for(Order o : orders){
            if (o.getCurrency()== Currency.UAH) ordersUAH.add(o);
        }
        System.out.println(ordersUAH);



        System.out.println("list of orders with city Kiev");
        for(Order or:unique_city(orders,"Kiev") ){
            System.out.println(or);}

        System.out.println("list of orders with city Odessa");
        for(Order or:unique_city(orders,"Odessa") ){
            System.out.println(or);}

        System.out.println("list of orders with city Lviv");
        for(Order or:unique_city(orders,"Lviv") ){
            System.out.println(or);}

        System.out.println("list of orders with city Donezk");
        for(Order or:unique_city(orders,"Donezk") ){
            System.out.println(or);}

        /////////TASK3

        Set<Order> ordersTreeSet = new TreeSet<>();
        ordersTreeSet.add(order1);
        ordersTreeSet.add(order2);
        ordersTreeSet.add(order3);
        ordersTreeSet.add(order4);
        ordersTreeSet.add(order5);
        ordersTreeSet.add(order6);
        ordersTreeSet.add(order7);
        ordersTreeSet.add(order8);
        ordersTreeSet.add(order9);
        ordersTreeSet.add(order10);
        System.out.println("New TreeSet");
        System.out.println(ordersTreeSet);
        System.out.println("Check if set contains user Petrov");
        boolean flag = false;
        for(Order o: ordersTreeSet){
            if(o.getUser().getLastName().toString().equals("Petrov")==true)
                flag= true;
        }
        if(flag)System.out.println("Yes");
        else System.out.println("No");


        System.out.println(" Заказ с наибольшей ценой, исспользуя только один сет-метод - get: ");
        //  System.out.println(ordersTreeSet.last());

        Iterator<Order>iterator= ordersTreeSet.iterator();
        while(iterator.hasNext()){
            if(iterator.next().getCurrency().equals(Currency.USD)){
                iterator.remove();
            }
        }
        System.out.println("удалите заказы, где валюта доллар, используя Iterator");
        for(Order o: ordersTreeSet){
            System.out.println(o);
        }


    }
}
