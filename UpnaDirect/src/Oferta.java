public class Oferta {
    private String aseguradora;
    private double prima;
    private double descuento;

    public Oferta(String aseguradora, double prima, double descuento) {
        this.aseguradora = aseguradora;
        this.prima = prima;
        this.descuento = descuento;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public double getPrima() {
        return prima;
    }

    public double getDescuento() {
        return descuento;
    }
}
