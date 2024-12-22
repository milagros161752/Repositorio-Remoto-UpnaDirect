import java.util.Scanner;

/**
 * Clase que representa la vista en la consola.
 */
public class ConsolaVista {
    private Presentador presentador;
    private Scanner scanner = new Scanner(System.in);

    public ConsolaVista(Presentador presentador) {
        this.presentador = presentador;
    }

    /**
     * Solicita los datos del cliente.
     * @return el cliente ingresado.
     */
    public Cliente solicitarDatosCliente() {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el año de nacimiento del cliente:");
        int anioNacimiento = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el salario del cliente:");
        double salario = Double.parseDouble(scanner.nextLine());
        return new Cliente(nombre, anioNacimiento, salario);
    }

    /**
     * Solicita los datos del bien.
     * @return el bien ingresado.
     */
    public Bien solicitarDatosBien() {
        System.out.println("Ingrese el tipo de bien (coche, vivienda):");
        String tipo = scanner.nextLine().toLowerCase(); // Convertir a minúsculas
        System.out.println("Ingrese el valor del bien:");
        double valor = Double.parseDouble(scanner.nextLine());
        return new Bien(tipo, valor);
    }

    /**
     * Muestra la mejor oferta obtenida.
     * @param oferta la oferta a mostrar.
     */
    public void mostrarOferta(Oferta oferta) {
        System.out.println(oferta.getAseguradora() + " | " + oferta.getPrima() + " | " + oferta.getDescuento());
    }
}
