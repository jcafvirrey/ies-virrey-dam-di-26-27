package model;

public class Circulo extends Figura implements Coloreable{
    private double radio;

    public Circulo(String nombre, double radio) {
        super(nombre); // reutiliza el constructor de Figura
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        System.out.println("Calculando área de círculo: π × radio²");
        return Math.PI * radio * radio;
    }

    @Override
    public void pintar(String color) {
        System.out.println(nombre + " (Círculo) pintado de color " + color);
    }

    @Override
    public String toString() {
        // super.toString() reutiliza el texto ya construido por Figura,
        // en vez de repetirlo desde cero.
        return super.toString() + " [Círculo, radio=" + radio + "]";
    }
}
