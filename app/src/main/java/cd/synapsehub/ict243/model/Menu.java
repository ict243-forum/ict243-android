package cd.synapsehub.ict243.model;

/**
 * Created by Michelo on 03/02/17.
 */

public class Menu {

    private String name;
    private String description;

    public Menu() {
    }

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
