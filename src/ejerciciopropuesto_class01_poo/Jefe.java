
package ejerciciopropuesto_class01_poo;

public class Jefe {
    private String nombres;
    private String sexo;
    private String dni;
    private String cargo; // Gerente, Subgerente
    private String area; // Contabilidad, Tecnologías de Información, Planificación
    private String tipoSeguro; // Afp o Snp
    private int anosAntiguedad;

    public Jefe(String nombres, String sexo, String dni, String cargo, String area, int anosAntiguedad) {
        this.nombres = nombres;
        this.sexo = sexo;
        this.dni = dni;
        this.cargo = cargo;
        this.area = area;
        this.anosAntiguedad = anosAntiguedad;
    }

    public double calcularSueldoBase() {
        double sueldoBase;
        switch (cargo) {
            case "Gerente":
                sueldoBase = area.equals("Tecnologías de Información") ? 8000 : (area.equals("Contabilidad") ? 6000 : 7000);
                break;
            case "Subgerente":
                sueldoBase = area.equals("Tecnologías de Información") ? 7000 : (area.equals("Contabilidad") ? 5000 : 6000);
                break;
            default:
                sueldoBase = 0;
        }
        return sueldoBase;
    }

    public double calcularBonificacion() {
        return 2000;
    }

    public double calcularDescuentos() {
        if(tipoSeguro.equalsIgnoreCase("AFP"))
            return calcularSueldoBase() * 0.15;
        if(tipoSeguro.equalsIgnoreCase("SNP"))
            return calcularSueldoBase() * 0.08;           
      return 0;
    }
    
    public double calcularMovilidad() {
        return cargo.equals("Gerente") ? 700 : 400;
    }

    public double calcularDescuentoAntiguedad() {
        return anosAntiguedad >= 8 ? 0.05 * calcularSueldoBase() : 0.04 * calcularSueldoBase();
    }
    
    public double calcularSueldoBruto() {
        return calcularSueldoBase() + calcularBonificacion();
    }

    public double calcularSueldoNeto() {
        return calcularSueldoBruto() - calcularDescuentos() + calcularMovilidad();
    }

    @Override
    public String toString() {
        return "Jefe{" +
                "nombres='" + nombres + '\'' +
                ", sexo='" + sexo + '\'' +
                ", dni='" + dni + '\'' +
                ", cargo='" + cargo + '\'' +
                ", area='" + area + '\'' +
                ", anosAntiguedad=" + anosAntiguedad +
                ", sueldoNeto=" + calcularSueldoNeto() +
                '}';
    }
}
