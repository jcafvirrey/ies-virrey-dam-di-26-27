package model;

public class Triangulo extends Figura{
    private double base;
    private double altura;

    public Triangulo(String nombre, double base, double altura) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        System.out.println("Calculando área de triángulo: (base × altura) / 2");
        return (base * altura) / 2;
    }

    @Override
    public String toString() {
        return super.toString() + " [Triángulo, base=" + base + ", altura=" + altura + "]";
    }
}
