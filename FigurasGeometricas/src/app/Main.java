package app;

import model.*;

public class Main {
    public static void main(String[] args) {
        // --- Caso 1: array con alguna figura coloreable ---
        System.out.println("=== CASO 1: array con figuras coloreables ===");
        Figura[] figuras = new Figura[4];
        figuras[0] = new Triangulo("Triángulo 1", 3, 8);   // no coloreable
        figuras[1] = new Triangulo("Triángulo 2", 5, 4);   // no coloreable
        figuras[2] = new Circulo("Círculo 1", 5);           // coloreable
        figuras[3] = new Rectangulo("Rectángulo 1", 4, 6);  // coloreable

        // El resultado se guarda en una variable de tipo Coloreable,
        // no de tipo Figura ni de tipo Circulo.
        Coloreable primeraColoreable = GestorFiguras.buscarPrimeraColoreable(figuras);

        if (primeraColoreable != null) {
            GestorFiguras.pintarSiEsPosible(primeraColoreable, "Verde");
        } else {
            System.out.println("No hay ninguna figura que pintar");
        }

        // --- Caso 2: array SIN ninguna figura coloreable ---
        System.out.println("\n=== CASO 2: array sin figuras coloreables ===");
        Figura[] soloTriangulos = new Figura[3];
        soloTriangulos[0] = new Triangulo("Triángulo A", 2, 3);
        soloTriangulos[1] = new Triangulo("Triángulo B", 6, 2);
        soloTriangulos[2] = new Triangulo("Triángulo C", 4, 4);

        Coloreable resultado = GestorFiguras.buscarPrimeraColoreable(soloTriangulos);

        if (resultado != null) {
            GestorFiguras.pintarSiEsPosible(resultado, "Rojo");
        } else {
            System.out.println("No hay ninguna figura que pintar");
        }

    }
}
