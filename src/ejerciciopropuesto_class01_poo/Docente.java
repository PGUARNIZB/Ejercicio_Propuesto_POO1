
package ejerciciopropuesto_class01_poo;

public class Docente {
    private String codigo;
    private String nombres;
    private String categoria; // Principal, Asociado, Auxiliar
    private String estudiosPostgrado; // Ninguno, Maestría, Doctorado, Ambas
    private String tipoSeguro; // Afp o EsSalud
    private int anosAntiguedad;
    private int horasClase;
    private double montoAFP;
    private double montoSeguroSalud;
    private double sueldoBruto;

    public Docente(String codigo, String nombres, String categoria, String estudiosPostgrado, String tipoSeguro, int anosAntiguedad, int horasClase, double montoAFP, double montoSeguroSalud, double sueldoBruto) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.categoria = categoria;
        this.estudiosPostgrado = estudiosPostgrado;
        this.tipoSeguro = tipoSeguro;
        this.anosAntiguedad = anosAntiguedad;
        this.horasClase = horasClase;
        this.montoAFP = montoAFP;
        this.montoSeguroSalud = montoSeguroSalud;
        this.sueldoBruto = sueldoBruto;
    }

    private double calcularPagoPorHora() {
        double pagoPorHora;
        switch (categoria) {
            case "Principal":
                pagoPorHora = 25.00;
                break;
            case "Asociado":
                pagoPorHora = 18.00;
                break;
            case "Auxiliar":
                pagoPorHora = 15.00;
                break;
            default:
                pagoPorHora = 0;
        }
        return pagoPorHora;
    }

    public double pagoParcial() {
        return horasClase * calcularPagoPorHora();
    } 
    
    private double calcularBonificacionesPostgrado() {
        double bonificacionPostgrado = 0;
        if (estudiosPostgrado.equals("Doctorado")) {
            bonificacionPostgrado = (categoria.equals("Principal") ? 0.20 : categoria.equals("Asociado") ? 0.15 : 0.12);
        } else if (estudiosPostgrado.equals("Maestría")) {
            bonificacionPostgrado = (categoria.equals("Principal") ? 0.17 : categoria.equals("Asociado") ? 0.10 : 0.08);
        } else if (estudiosPostgrado.equals("Ambas")) {
            bonificacionPostgrado = (categoria.equals("Principal") ? 0.25 : categoria.equals("Asociado") ? 0.20 : 0.17);
        } else if (estudiosPostgrado.equals("Ninguno")) {
            bonificacionPostgrado = 0;
        }
        return bonificacionPostgrado;
    }
    
    private double calcularBonificacionesAntiguedad() {
        double bonificacionAntiguedad = 0;
    if (anosAntiguedad >= 8) {
            bonificacionAntiguedad = (categoria.equals("Principal") ? 0.07 : categoria.equals("Asociado") ? 0.06 : 0.05);
        } else {
            bonificacionAntiguedad = (categoria.equals("Principal") ? 0.05 : categoria.equals("Asociado") ? 0.04 : 0.02);
        }
        return bonificacionAntiguedad;
    }
        
    
    public double calcularSueldoBruto() {
        return pagoParcial() + calcularBonificacionesPostgrado() + calcularBonificacionesAntiguedad();
    }
    
    public double calcularDescuentos() {
        if(tipoSeguro.equalsIgnoreCase("AFP"))
            return calcularSueldoBruto() * 0.13;
        if(tipoSeguro.equalsIgnoreCase("EsSalud"))
            return calcularSueldoBruto() * 0.05;           
      return 0;
    }

    public double calcularSueldoNeto() {
        return calcularSueldoBruto() - calcularDescuentos();
    }

    @Override
    public String toString() {
        return "Docente{" +
                "codigo='" + codigo + '\'' +
                ", nombres='" + nombres + '\'' +
                ", categoria='" + categoria + '\'' +
                ", estudiosPostgrado='" + estudiosPostgrado + '\'' +
                ", anosAntiguedad=" + anosAntiguedad +
                ", horasClase=" + horasClase +
                ", sueldoNeto=" + calcularSueldoNeto() +
                '}';
    }
}
