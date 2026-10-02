package clases;

public class Tratamiento {
    private String dni;
    private int mesesTratamiento;
    private  boolean recibeHierro;

    public Tratamiento(String dni, int mesesTratamiento, boolean recibeHierro) {
        this.dni = dni;
        this.mesesTratamiento = mesesTratamiento;
        this.recibeHierro = recibeHierro;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getMesesTratamiento() {
        return mesesTratamiento;
    }

    public void setMesesTratamiento(int mesesTratamiento) {
        this.mesesTratamiento = mesesTratamiento;
    }

    public boolean isRecibeHierro() {
        return recibeHierro;
    }

    public void setRecibeHierro(boolean recibeHierro) {
        this.recibeHierro = recibeHierro;
    }

    public boolean tratamientoCompleto(){
        return mesesTratamiento >=6;
    }

    public String estadoTratamiento() {
        if(tratamientoCompleto()) {
            return "Tratamiento completado";
        }
        return "Tratamiento en proceso";
    }
    



}
