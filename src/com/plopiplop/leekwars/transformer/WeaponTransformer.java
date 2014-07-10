package com.plopiplop.leekwars.transformer;

import com.plopiplop.leekwars.model.Chip;
import com.plopiplop.leekwars.model.ModelManager;
import com.plopiplop.leekwars.model.Weapon;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class WeaponTransformer {

    private static final WeaponTransformer INSTANCE = new WeaponTransformer();

    private Configuration config;

    private WeaponTransformer() {
        config = new Configuration();
        config.setObjectWrapper(new DefaultObjectWrapper());
        config.setTemplateLoader(new ClassTemplateLoader(WeaponTransformer.class, "/templates"));
    }

    public static WeaponTransformer getInstance() {
        return INSTANCE;
    }

    public void transformToLeekScript(ModelManager manager, OutputStream out) throws IOException {
        Template ftl = config.getTemplate("leekscript-api.ftl");

        Map<String, Object> root = new HashMap<>();

        OutputStreamWriter writer = new OutputStreamWriter(out);

        try {
            root.put("weapons", manager.getWeapons());
            root.put("chips", manager.getChips());
            ftl.process(root, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
