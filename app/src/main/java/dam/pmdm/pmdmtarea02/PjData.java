package dam.pmdm.pmdmtarea02;

/**
 * Clase que representa los datos de un personaje.
 * Contiene información como la imagen, el nombre, la descripción y las habilidades del personaje.
 */

public class PjData {
    // Identificador de recurso para la imagen del personaje
    private final int image;
    // Identificador de recurso para el nombre del personaje
    private final int name;
    // Identificador de recurso para la descripción del personaje
    private final int description;
    // Identificador de recurso para las habilidades del personaje
    private final int abilities;

    /**
     * Constructor de la clase PjData.
     * Inicializa los datos del personaje con los valores proporcionados.
     * Todos son int porque leerá directamente desde string.xml
     *
     * @param image       ID del recurso de la imagen del personaje.
     * @param name        ID del recurso del nombre del personaje.
     * @param description ID del recurso de la descripción del personaje.
     * @param abilities   ID del recurso de las habilidades del personaje.
     */
    public PjData(int image, int name, int description, int abilities) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.abilities = abilities;
    }

    /**
     * Obtiene el ID del recurso de la imagen del personaje.
     *
     * @return ID del recurso de la imagen.
     */
    public int getImage() {
        return image;
    }
    /**
     * Obtiene el ID del recurso del nombre del personaje.
     *
     * @return ID del recurso del nombre.
     */
    public int getName() {
        return name;
    }
    /**
     * Obtiene el ID del recurso de la descripción del personaje.
     *
     * @return ID del recurso de la descripción.
     */
    public int getDescription() {
        return description;
    }
    /**
     * Obtiene el ID del recurso de las habilidades del personaje.
     *
     * @return ID del recurso de las habilidades.
     */

    public int getAbilities() {
        return abilities;
    }
}
