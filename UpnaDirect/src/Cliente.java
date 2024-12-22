/**
 * Clase que representa a un cliente.
 */
public class Cliente {
    private String nombre;
    private int anioNacimiento;
    private double salario;

    public Cliente(String nombre, int anioNacimiento, double salario) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
        this.salario = salario;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getNacimiento() {
        return anioNacimiento;
    }

    public double getSalario() {
        return salario;
    }
}
