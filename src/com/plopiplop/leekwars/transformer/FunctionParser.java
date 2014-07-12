package com.plopiplop.leekwars.transformer;

import com.plopiplop.leekwars.model.Function;
import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

        if (function.name.startsWith("WEAPON_") || function.name.startsWith("CHIP_")) {
            return null;
        } else if (element.select("div.content").isEmpty()) {
            function.isConstant = true;
            function.name = element.select("ul li").text();
        }

        function.description = StringEscapeUtils.unescapeHtml(element.select("div.content div.searchable").html()).replace("<br />", "\n").replace("\n", "\n * ");

        Elements ulList = element.select(".content > ul");

        if (ulList.size() > 1) {
            for (Element li : ulList.first().select("li")) {
                String paramName = li.text();
                if (paramName.contains(":")) {
                    paramName = paramName.substring(0, paramName.indexOf(':') - 1);
                }
                function.parameters.put(paramName, li.select("span.searchable").text());
            }
        }

        return function;
    }
}
