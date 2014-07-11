package com.plopiplop.leekwars.transformer;

import com.plopiplop.leekwars.model.Weapon;
import org.jsoup.nodes.Element;

public class WeaponParser extends AbstractItemParser<Weapon> {

    private static final WeaponParser INSTANCE = new WeaponParser();

    private WeaponParser() {
    }

    public static WeaponParser getInstance() {
        return INSTANCE;
    }

    public Weapon parse(Element element) {
        Weapon weapon = new Weapon();

        parse(weapon, element);

        weapon.price = element.select("div.buy-button span").text();

        return weapon;
    }
}
