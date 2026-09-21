package model;

public class GestorFiguras {
    // El parámetro es de tipo Coloreable, NUNCA Circulo ni Rectangulo.
    // Esto obliga a que cualquier llamada a este método le pase un objeto
    // que sepa pintar()se, sin que al método le importe de qué subclase es.
    public static void pintarSiEsPosible(Coloreable figura, String color) {
        System.out.println("Intentando pintar una figura coloreable...");
        figura.pintar(color);
    }

    // El valor de retorno es de tipo Coloreable, no Figura.
    // Quien llame a este método recibe directamente algo "ya filtrado":
    // no tiene que volver a comprobar si es coloreable.
    public static Coloreable buscarPrimeraColoreable(Figura[] figuras) {
        System.out.println("Buscando la primera figura coloreable del array...");

        for (Figura f : figuras) {
            // El instanceof + cast ocurre UNA SOLA VEZ, aquí dentro,
            // no cada vez que alguien quiera usar el resultado.
            if (f instanceof Coloreable) {
                System.out.println("Encontrada: " + f);
                return (Coloreable) f;
            }
        }

        System.out.println("Ninguna figura del array es coloreable");
        return null;
    }
}
