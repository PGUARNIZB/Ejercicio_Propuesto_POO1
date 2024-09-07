 
package ejerciciopropuesto_class01_poo;

public class Arquitecto {
    private String codigo;
    private String nombres;
    private String condicionContrato; // Estable, Contratado
    private String especialidad; // Estructuras, Recursos Hídricos, Ingeniería Vial
    private String tipoSupervision; // Obras o Vías
    private String tipoSeguro; // Afp o Snp
    private int numeroObrasAsignadas;

    public Arquitecto(String codigo, String nombres, String condicionContrato, String especialidad, String tipoSupervision, String tipoSeguro, int numeroObrasAsignadas) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.condicionContrato = condicionContrato;
        this.especialidad = especialidad;
        this.tipoSupervision = tipoSupervision;
        this.tipoSeguro = tipoSeguro;
        this.numeroObrasAsignadas = numeroObrasAsignadas;
    }
    

    public double calcularSueldoBase() {
        double sueldoBase;
        if (tipoSupervision.equals("Obras")) {
            sueldoBase = condicionContrato.equals("Estable") ? 4000 : 2000;
        } else { 
            sueldoBase = condicionContrato.equals("Estable") ? 6000 : 4500;
        }
        return sueldoBase;
    }

    public double calcularBonificacion() {
        double porcentajeBonificacion;
        switch (especialidad) {
            case "Estructuras":
                porcentajeBonificacion = 0.16;
                break;
            case "Recursos Hídricos":
                porcentajeBonificacion = 0.18;
                break;
            case "Ingeniería Vial":
                porcentajeBonificacion = 0.22;
                break;
            default:
                porcentajeBonificacion = 0;
        }
        return porcentajeBonificacion;
    }

    public double calcularDescuentos() {
        if(tipoSeguro.equalsIgnoreCase("AFP"))
            return calcularSueldoBase() * 0.15;
        if(tipoSeguro.equalsIgnoreCase("SNP"))
            return calcularSueldoBase() * 0.08;           
      return 0;
    }

    public double calcularMovilidad() {
        return numeroObrasAsignadas >= 18 ? 600 : 300;
    }
    
    public double calcularSueldoBruto() {
        return calcularSueldoBase() + calcularBonificacion();
    }

    public double calcularSueldoNeto() {
        return calcularSueldoBruto() - calcularDescuentos() + calcularMovilidad();
    }

    @Override
    public String toString() {
        return "Arquitecto{" +
                "codigo='" + codigo + '\'' +
                ", nombres='" + nombres + '\'' +
                ", condicionContrato='" + condicionContrato + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", tipoSupervision='" + tipoSupervision + '\'' +
                ", numeroObrasAsignadas=" + numeroObrasAsignadas +
                ", sueldoNeto=" + calcularSueldoNeto() +
                '}';
    }
}
