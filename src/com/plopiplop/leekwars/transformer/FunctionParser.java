package com.plopiplop.leekwars.transformer;

import com.plopiplop.leekwars.model.Function;
import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Map;

public class FunctionParser {

    private static final FunctionParser INSTANCE = new FunctionParser();

    private FunctionParser() {
    }

    public static FunctionParser getInstance() {
        return INSTANCE;
    }

    public Function parse(Element element) {
        Function function = new Function();

        function.name = element.select("h2 span.function-name").text();

        if (function.name.equals("include")) {
            return null; // For now we use our own includes
        }
        if (function.name.startsWith("WEAPON_") || function.name.startsWith("CHIP_")) {
            return null;
        } else if (element.select("div.content").isEmpty()) {
            function.isConstant = true;
            function.name = element.select("ul li").text();
        }

        function.description = html(element.select("div.content div.searchable"));

        parseMap(element.select(".content h3:contains(Param) + ul"), function.parameters);
        parseMap(element.select(".content h3:contains(Retour) + ul"), function.returns);

        return function;
    }

    private void parseMap(Elements elements, Map<String, String> map) {
        if (!elements.isEmpty()) {
            for (Element li : elements.first().select("> li")) {
                String paramName = li.text();
                if (paramName.indexOf(':') > 1) {
                    paramName = paramName.substring(0, paramName.indexOf(':') - 1);
                }
                map.put(paramName, html(li.select("span.searchable")));
            }
        }
    }

    private String html(Elements element) {
        return StringEscapeUtils.unescapeHtml(element.html()).replace("<br />", "\n").replace("<br>", "\n").replace("\n", "\n * ");
    }
}
