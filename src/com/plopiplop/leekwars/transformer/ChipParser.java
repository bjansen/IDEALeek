package com.plopiplop.leekwars.transformer;

import com.plopiplop.leekwars.model.Chip;
import org.jsoup.nodes.Element;

public class ChipParser extends AbstractItemParser<Chip> {

    private static final ChipParser INSTANCE = new ChipParser();

    private ChipParser() {
    }

    public static ChipParser getInstance() {
        return INSTANCE;
    }

    @Override
    public Chip parse(Element element) {
        Chip chip = new Chip();

        parse(chip, element.child(0));

        chip.price = element.select("div.buy-button span").text();

        return chip;
    }
}
