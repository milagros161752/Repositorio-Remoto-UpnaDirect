/**
 * Clase que actúa como intermediario entre la vista y el modelo.
 */
public class Presentador {
    private ConsolaVista vista;
    private ServicioAseguradora servicioAseguradora;

    public Presentador(ConsolaVista vista) {
        this.vista = vista;
        this.servicioAseguradora = new ServicioAseguradora();
    }

    /**
     * Procesa la solicitud del cliente.
     */
    public void procesarSolicitud() {
        Cliente cliente = vista.solicitarDatosCliente();
        if (validarCliente(cliente)) {
            Bien bien = vista.solicitarDatosBien();
            if (validarBien(bien)) {
                Oferta mejorOferta = servicioAseguradora.obtenerMejorOferta(cliente, bien);
                vista.mostrarOferta(mejorOferta);
            } else {
                System.out.println("Bien no válido. Por favor, registre el bien nuevamente.");
            }
        } else {
            System.out.println("Cliente no válido. Por favor, registre el cliente nuevamente.");
        }
    }

    /**
     * Valida los datos del cliente.
     * @param cliente el cliente a validar.
     * @return true si el cliente es válido, false de lo contrario.
     */
    private boolean validarCliente(Cliente cliente) {
        int anioActual = 2024; // Suponiendo el año actual es 2024
        int edadCliente = anioActual - cliente.getNacimiento();
        return cliente.getNacimiento() > 1900 && cliente.getNacimiento() <= anioActual && cliente.getSalario() > 0 && edadCliente > 0;
    }

    /**
     * Valida los datos del bien.
     * @param bien el bien a validar.
     * @return true si el bien es válido, false de lo contrario.
     */
    private boolean validarBien(Bien bien) {
        String tipo = bien.getTipo().toLowerCase(); // Normalizar a minúsculas
        if (tipo.equals("coche")) {
            return bien.getValor() > 0 && bien.getValor() <= 50000;
        } else if (tipo.equals("vivienda")) {
            return bien.getValor() >= 50000;
        }
        return false;
    }
}
