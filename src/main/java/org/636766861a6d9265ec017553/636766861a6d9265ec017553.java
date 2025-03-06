import java.util.HashSet;
import java.util.Set;

public class Template {
    private Set<String> templateVariables;

    public Template() {
        this.templateVariables = new HashSet<>();
        // Initialize with some example template variables
        this.templateVariables.add("var1");
        this.templateVariables.add("var2");
        this.templateVariables.add("var3");
    }

    /**
     * Determina si una variable de plantilla es un miembro de esta plantilla.
     * @param name nombre La variable de plantilla.
     * @return true si la variable de plantilla es un miembro de la plantilla, de lo contrario false.
     */
    public final boolean isTemplateVariablePresent(String name) {
        return templateVariables.contains(name);
    }

    public static void main(String[] args) {
        Template template = new Template();
        System.out.println(template.isTemplateVariablePresent("var1")); // true
        System.out.println(template.isTemplateVariablePresent("var4")); // false
    }
}