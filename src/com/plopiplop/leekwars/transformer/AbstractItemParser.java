package com.plopiplop.leekwars.transformer;

import com.plopiplop.leekwars.model.AbstractItem;
import org.jsoup.nodes.Element;

public abstract class AbstractItemParser<T extends AbstractItem> {

    public void parse(AbstractItem item, Element element) {
        item.id = element.select("div.constant").text();
        item.name = element.select("div.header h2.name").text();
        item.level = element.select("div.header div.level").text();
        item.description = element.select("div.desc").text();
        item.value = element.parent().select("div.buy-button").first().id();
    }

    public abstract T parse(Element element);
}
