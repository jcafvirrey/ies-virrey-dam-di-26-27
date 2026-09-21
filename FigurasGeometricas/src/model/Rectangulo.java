package model;

public class Rectangulo extends Figura implements Coloreable{
    private double base;
    private double altura;

    public Rectangulo(String nombre, double base, double altura) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        System.out.println("Calculando área de rectángulo: base × altura");
        return base * altura;
    }

    @Override
    public void pintar(String color) {
        System.out.println(nombre + " (Rectángulo) pintado de color " + color);
    }

    @Override
    public String toString() {
        return super.toString() + " [Rectángulo, base=" + base + ", altura=" + altura + "]";
    }
}
