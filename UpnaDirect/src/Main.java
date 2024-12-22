/**
 * Clase principal para ejecutar la aplicación.
 */
public class Main {
    public static void main(String[] args) {
        // Crear la vista y el presentador.
        ConsolaVista vista = new ConsolaVista(null);
        Presentador presentador = new Presentador(vista);
        vista = new ConsolaVista(presentador);  // Vinculamos la vista con el presentador.

        // Procesar la solicitud.
        presentador.procesarSolicitud();
    }
}
