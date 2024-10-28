package helpers;

import java.util.Locale;
import java.util.ResourceBundle;

public class InternationalizationManager {
    private ResourceBundle resourceBundle;
    private String basename;

    public InternationalizationManager(String basename) {
        this.basename = basename;
        resourceBundle = ResourceBundle.getBundle(basename, Locale.getDefault());
    }

    public void changeLanguage(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(basename, locale);
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

}
