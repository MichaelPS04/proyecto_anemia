import clases.*;

public class App {
    public static void main(String[] args) {

            Sistemanutricion nutricion = new Sistemanutricion();

        // 1. REGISTRO EXITOSO DE PACIENTES DE PRUEBA (Niños y Gestantes)
        try {
            System.out.println("--- Ejecutando registros válidos en el sistema ---");
            
            // Usando Constructor con hemoglobina directa para Niños (Edad en meses)
            Paciente nino1 = new Paciente("74521896", "pepe", 18, 1.2, "NIÑO");  // Anemia Moderada
            Paciente nino2 = new Paciente("61254789", "jose", 24, 12.1, "NIÑO"); // Normal

            // Usando Constructor con hemoglobina directa para Gestantes (Edad en años)
            Paciente gestante1 = new Paciente("45871239", "maria", 28, 6.5, "GESTANTE"); // Anemia Severa
            Paciente gestante2 = new Paciente("32145698", "lisa", 32, 10.5, "GESTANTE");  // Anemia Leve

            // Guardando en el gestor (Sistemanutricion)
            nutricion.registrarPaciente(nino1);
            nutricion.registrarPaciente(nino2);
            nutricion.registrarPaciente(gestante1);
            nutricion.registrarPaciente(gestante2);

        } catch (DatosInvalidosException e) {
            System.out.println("Error inesperado en datos iniciales: " + e.getMessage());
        }

        nutricion.listarPacientes();
        nutricion.generarAlertasCriticas();
        nutricion.mostrarRecomendaciones();
    } 
} 

   


