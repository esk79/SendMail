import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * Created by EvanKing on 7/8/16.
 */
public class Config {
    Map<String, String> values;

    public Config() {
        Yaml yaml = new Yaml();
        try {
            values = (Map<String, String>) yaml
                    .load(new FileInputStream(new File("config.yaml")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getValues() {
        return values;
    }
}


