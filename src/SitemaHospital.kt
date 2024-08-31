class SistemaHospital {
    private val empleados = mutableListOf<Empleado>()
    private val medicos = mutableListOf<Medico>()
    private val pacientes = mutableListOf<Paciente>()
    private val citas = mutableListOf<Cita>()

    fun registrarEmpleado(empleado: Empleado) {
        empleados.add(empleado)
    }

    fun registrarMedico(medico: Medico) {
        medicos.add(medico)
    }

    fun registrarPaciente(paciente: Paciente) {
        pacientes.add(paciente)
    }

    fun registrarCita(codigoMedico: Int, numeroHistoriaClinica: Int, fecha: String, hora: String) {
        val medico = medicos.find { it.codigoEmpleado == codigoMedico } ?: return
        val paciente = pacientes.find { it.numeroHistoriaClinica == numeroHistoriaClinica } ?: return
        citas.add(Cita(medico, paciente, fecha, hora))
    }

    fun listarMedicosPorEspecialidad(especialidad: String) {
        medicos.filter { it.especialidad == especialidad }
            .forEach { println("${it.nombre} ${it.apellido}, Consultorio: ${it.numeroConsultorio}") }
    }

    fun listarPacientesPorMedico(codigoMedico: Int) {
        val pacientesAtendidos = citas.filter { it.medico.codigoEmpleado == codigoMedico }
            .map { it.paciente }
        pacientesAtendidos.forEach { println("${it.nombre} ${it.apellido}") }
    }
}

data class Cita(val medico: Medico, val paciente: Paciente, val fecha: String, val hora: String)
