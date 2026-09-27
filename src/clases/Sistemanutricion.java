package clases;
import java.util.ArrayList;
import java.util.List;

public class Sistemanutricion {

    // Uso de la colección List/ArrayList 
    private List<Paciente> listaPacientes;

    public Sistemanutricion() {
        this.listaPacientes = new ArrayList<>();
    }

    // Método para registrar pacientes aplicando Excepciones
    public void registrarPaciente(Paciente paciente) throws DatosInvalidosException {

        if (paciente.getDni().length() != 8) {
            throw new DatosInvalidosException("El DNI del paciente " + paciente.getNombre() + " debe tener exactamente 8 dígitos");
        }
        
        if (paciente.getNivelhemoglobina() < 0 || paciente.getNivelhemoglobina() > 25) {
            throw new DatosInvalidosException("El valor de hemoglobina ingresado (" + paciente.getNivelhemoglobina() + ") no es válido");
        }

        // Validación diferenciada de edad según el tipo de paciente
        if (paciente.getTipoPaciente().equals("GESTANTE")) {
            if (paciente.getEdadmeses() < 10 || paciente.getEdadmeses() > 60) {
                throw new DatosInvalidosException("La edad de la gestante " + paciente.getNombre() + " debe estar en el rango de 10 a 60 años");
            }
        } else {
            // Regla por defecto para niños
            if (paciente.getEdadmeses() <= 0 || paciente.getEdadmeses() > 36) {
                throw new DatosInvalidosException("El sistema solo procesa niños menores de 36 meses");
            }
        }
        
        listaPacientes.add(paciente);
        System.out.println("Paciente: " + paciente.getNombre() + " [" + paciente.getTipoPaciente() + "] registrado correctamente en el sistema");
    }

    // Muestra todos los pacientes registrados
    public void listarPacientes() {
        System.out.println("--- REPORTE GENERAL DE PACIENTES  ---");
        for (Paciente p : listaPacientes) {
            // Cambia la unidad de la edad dinámicamente en el reporte
            String unidadEdad = p.getTipoPaciente().equals("GESTANTE") ? " años" : " meses";
            System.out.println("Tipo: " + p.getTipoPaciente() + " | DNI: " + p.getDni() + " | Nombre: " + p.getNombre() + 
                               " | Edad: " + p.getEdadmeses() + unidadEdad + " | Hemoglobina: " + p.getNivelhemoglobina() + 
                               "  -> Diagnóstico: " + p.EvaluarEstadoAnemia());
        }
    }

    // Segmentación inteligente: Alertas automáticas de pacientes críticos
    public void generarAlertasCriticas() {
        System.out.println("--- ALERTAS DE PACIENTES CRÍTICOS (INTERVENCIÓN INMEDIATA) ---");
        boolean hayCriticos = false;
        for (Paciente p : listaPacientes) {
            String estado = p.EvaluarEstadoAnemia();
            if (estado.contains("Severa") || estado.contains("Moderada")) {
                // Adapta el sujeto de la alerta
                String sujeto = p.getTipoPaciente().equals("GESTANTE") ? "La gestante " : "El menor ";
                System.out.println("[ALERTA CRÍTICA] " + sujeto + p.getNombre() + " (DNI: " + p.getDni() + 
                                   ") presenta " + estado + ". Requiere visita domiciliaria urgente.");
                hayCriticos = true;
            }
        }
        if (!hayCriticos) {
            System.out.println("No se detectaron pacientes en estado crítico moderado o severo.");
        }
    }
}
