package Day1;

import java.util.ArrayList;
import java.util.List;

public class Bar {
    public static void main(String[] args) {
        Beer beer = new Beer(8.6, "Harnaś");
        System.out.println(beer.isAllowedToDrink(17));
        System.out.println(beer.isAllowedToDrink(18));
        System.out.println(beer.isAllowedToDrink(19));

        List<Beer> menu = new ArrayList<>();
        menu.add(beer);
        menu.add(new Beer(4.3, "Tyskie"));
        menu.add(new Beer(5.3, "Królewskie"));
        menu.add(new Beer(6.3, "Carlsberg"));

        for (Beer b : menu) {
            System.out.println(b);
        }

        IPA ipa = new IPA(8.0, "Crazy Mike", 100);
        Beer ipa2 = new IPA(3.0, "Tatra", 0);
        System.out.println(ipa);
        System.out.println(ipa2);

        menu.add(ipa);
        menu.add(ipa2);



/*
        System.out.println(menu.get(1));

        menu.remove(0);
        System.out.println(menu.get(1));
*/

    }
}
