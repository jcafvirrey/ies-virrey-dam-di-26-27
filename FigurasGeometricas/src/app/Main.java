package app;

import model.*;

public class Main {
    public static void main(String[] args) {

        // 1) Array de tipo Figura con al menos dos tipos distintos.
        System.out.println("=== Creando figuras ===");
        Figura[] figuras = new Figura[4];
        figuras[0] = new Circulo("Círculo 1", 5);
        figuras[1] = new Rectangulo("Rectángulo 1", 4, 6);
        figuras[2] = new Triangulo("Triángulo 1", 3, 8);
        figuras[3] = new Circulo("Círculo 2", 2.5);

        // 2) Recorrido llamando a mostrarInfo(): aquí se ve el POLIMORFISMO.
        // 'f' está declarada como Figura, pero cada llamada a calcularArea()
        // (dentro de mostrarInfo()) ejecuta la versión real de la subclase.
        System.out.println("\n=== Mostrando información de cada figura ===");
        for (Figura f : figuras) {
            f.mostrarInfo();
        }

        // 3) Comprobación de Coloreable con instanceof + cast.
        System.out.println("\n=== Intentando pintar cada figura ===");
        for (Figura f : figuras) {
            if (f instanceof Coloreable) {
                Coloreable coloreable = (Coloreable) f;
                coloreable.pintar("Azul");
            } else {
                System.out.println(f + " no se puede pintar (no implementa Coloreable)");
            }
        }

        // 4) toString() de las 4 figuras.
        System.out.println("\n=== Listado final ===");
        for (Figura f : figuras) {
            System.out.println(f);
        }
    }
}
