package dam.pmdm.pmdmtarea02;

public class PjData {
    private final int image;
    private final int name;
    private final int description;
    private final int abilities;

    public PjData(int image, int name, int description, int abilities) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.abilities = abilities;
    }

    public int getImage() {
        return image;
    }

    public int getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }

    public int getAbilities() {
        return abilities;
    }
}
