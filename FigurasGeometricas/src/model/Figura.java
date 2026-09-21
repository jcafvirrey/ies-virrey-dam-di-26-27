package model;

abstract public class Figura {
    // Atributo protected: accesible desde las subclases, pero no desde fuera
    // del paquete. Es la base del ENCAPSULAMIENTO.
    protected String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    // Método abstracto: cada subclase decide CÓMO calcula su área.
    // No tiene cuerpo, así que Figura no puede instanciarse directamente.
    public abstract double calcularArea();

    // Método normal, heredado tal cual por todas las subclases (no se
    // sobrescribe). Reutiliza calcularArea(): aquí ya se produce POLIMORFISMO,
    // aunque el método esté escrito una sola vez en la clase padre.

    public void mostrarInfo() {
        System.out.println("Mostrando información de la figura...");
        System.out.println(this + " - Área: " + calcularArea());
    }

    // Sobrescritura de toString(), heredado de Object.
    // Las subclases lo sobrescribirán a su vez, añadiendo más detalle.
    @Override
    public String toString() {
        return "Figura: " + nombre;
    }
}
