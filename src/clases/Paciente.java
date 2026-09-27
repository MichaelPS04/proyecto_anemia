package clases;

public class Paciente {

    private String dni;
    private String nombre;
    private int edadmeses; // Para niños representará meses; para gestantes representará su edad en años.
    private double nivelhemoglobina;
    private String tipoPaciente; // "NINO" o "GESTANTE"

    // constructor para registrar al paciente antes del examen
    public Paciente(String dni, String nombre, int edadmeses, String tipoPaciente) {
        this.dni = dni;
        this.nombre = nombre;
        this.edadmeses = edadmeses;
        this.tipoPaciente = tipoPaciente.toUpperCase(); // Asegura guardar en mayúsculas
        this.nivelhemoglobina = 0.0;
    }

    // constructor sobrecargado para registrar al paciente despues del examen
    public Paciente(String dni, String nombre, int edadmeses, double nivelhemoglobina, String tipoPaciente) {
        this.dni = dni;
        this.nombre = nombre;
        this.edadmeses = edadmeses;
        this.nivelhemoglobina = nivelhemoglobina;
        this.tipoPaciente = tipoPaciente.toUpperCase();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdadmeses() {
        return edadmeses;
    }

    public void setEdadmeses(int edadmeses) {
        this.edadmeses = edadmeses;
    }

    public double getNivelhemoglobina() {
        return nivelhemoglobina;
    }

    public void setNivelhemoglobina(double nivelhemoglobina) {
        this.nivelhemoglobina = nivelhemoglobina;
    }

    public String getTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(String tipoPaciente) {
        this.tipoPaciente = tipoPaciente.toUpperCase();
    }

    public String EvaluarEstadoAnemia() {
        if (nivelhemoglobina == 0.0)
            return "sin control registrado";
        return ClasificarAnemia(this.nivelhemoglobina);
    }

    public String EvaluarEstadoAnemia(double nuevoNivel) {
        return ClasificarAnemia(nuevoNivel);
    }

    private String ClasificarAnemia(double hemoglobina) {

        // Validación y rangos diferenciados según MINSA/OMS
        if (this.tipoPaciente.equals("GESTANTE")) {
            if (hemoglobina < 7.0)
                return "Anemia Severa (Gestante)";
            if (hemoglobina < 10.0)
                return "Anemia Moderada (Gestante)";
            if (hemoglobina < 11.0)
                return "Anemia Leve (Gestante)";
        } else {
            // Rangos por defecto para niño
            if (hemoglobina < 7.0)
                return "Anemia Severa (niño)";
            if (hemoglobina < 10.0)
                return "Anemia Moderada (niño)";
            if (hemoglobina < 11.0)
                return "Anemia Leve (niño)";
        }

        return "Normal / Sano  (Sigue así)";
    }
}


