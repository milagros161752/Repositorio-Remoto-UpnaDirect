import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene la lógica de negocio para obtener la mejor oferta.
 * Añadir la lógica de cálculo y comparación de ofertas.
 */
public class ServicioAseguradora {
    /**
     * Obtiene la mejor oferta para el cliente y el bien.
     * @param cliente el cliente.
     * @param bien el bien.
     * @return la mejor oferta obtenida.
     */
    public Oferta obtenerMejorOferta(Cliente cliente, Bien bien) {
        List<Oferta> ofertas = new ArrayList<>();
        int anioActual = 2024; // Suponiendo el año actual es 2024
        int edadCliente = anioActual - cliente.getNacimiento(); // Calcula la edad del cliente

        // Generar ofertas de cada aseguradora
        ofertas.add(calcularOfertaMafro(cliente, bien, edadCliente));
        ofertas.add(calcularOfertaLineaIndirecta(cliente, bien, edadCliente));
        ofertas.add(calcularOfertaAdasles(cliente, bien, edadCliente));

        // Buscar la mejor oferta (la más barata)
        Oferta mejorOferta = ofertas.get(0);
        for (Oferta oferta : ofertas) {
            if (oferta.getPrima() < mejorOferta.getPrima() || 
                (oferta.getPrima() == mejorOferta.getPrima() && oferta.getDescuento() > mejorOferta.getDescuento())) {
                mejorOferta = oferta;
            }
        }

        return mejorOferta;
    }

    /**
     * Calcula la oferta de Mafro.
     * @param cliente el cliente.
     * @param bien el bien.
     * @param edadCliente la edad del cliente.
     * @return la oferta de Mafro.
     */
    private Oferta calcularOfertaMafro(Cliente cliente, Bien bien, int edadCliente) {
        double prima = 0.03 * bien.getValor();
        if (bien.getTipo().equals("vehículo") && edadCliente < 20) {
            prima = 0.05 * bien.getValor();
        } else if (bien.getTipo().equals("vivienda") && bien.getValor() > 200000 && cliente.getSalario() < 20000) {
            prima = 0.02 * bien.getValor();
        }

        double comision = calcularComision(prima, 3);
        return new Oferta("Mafro", prima, comision);
    }

    /**
     * Calcula la oferta de Línea Indirecta.
     * @param cliente el cliente.
     * @param bien el bien.
     * @param edadCliente la edad del cliente.
     * @return la oferta de Línea Indirecta.
     */
    private Oferta calcularOfertaLineaIndirecta(Cliente cliente, Bien bien, int edadCliente) {
        double prima = 0.03 * bien.getValor();
        if ((bien.getTipo().equals("vehículo") && bien.getValor() < 20000) || 
            (bien.getTipo().equals("vivienda") && bien.getValor() < 150000)) {
            prima = 0.04 * bien.getValor();
        } else if (bien.getTipo().equals("vehículo") && bien.getValor() >= 20000 && edadCliente > 60) {
            prima = 0.06 * bien.getValor();
        }

        double comision = calcularComision(prima, 4);
        return new Oferta("Línea Indirecta", prima, comision);
    }

    /**
     * Calcula la oferta de Adasles.
     * @param cliente el cliente.
     * @param bien el bien.
     * @param edadCliente la edad del cliente.
     * @return la oferta de Adasles.
     */
    private Oferta calcularOfertaAdasles(Cliente cliente, Bien bien, int edadCliente) {
        double prima = 0.02 * bien.getValor();
        if (bien.getTipo().equals("vehículo") && (edadCliente < 20 || edadCliente > 60)) {
            prima = 0.06 * bien.getValor();
        }

        double comision = calcularComision(prima, 5);
        return new Oferta("Adasles", prima, comision);
    }

    /**
     * Calcula la comisión de una oferta.
     * @param prima el importe del seguro.
     * @param porcentaje el porcentaje de comisión.
     * @return la comisión calculada.
     */
    private double calcularComision(double prima, int porcentaje) {
        if (prima <= 1000) {
            return Math.floor(0.01 * prima);
        }
        return Math.floor((porcentaje / 100.0) * prima);
    }
}
