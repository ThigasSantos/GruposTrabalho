package io.github.thigassantos.grupostrabalho.util;

import java.util.Locale;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyOrderStrategy;

/**
 *
 * @author Tygsv
 */
public class Util {
    
    public static String toJson(Object object){
        JsonbConfig config = new JsonbConfig()
                .withFormatting(true)
                .withDateFormat("dd/MM/yyyy hh:mm:ss", Locale.forLanguageTag("pt_BR"))
                .withPropertyOrderStrategy(PropertyOrderStrategy.LEXICOGRAPHICAL);
        
        return JsonbBuilder.create(config).toJson(object);
    }
    
}
