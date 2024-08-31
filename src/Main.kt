fun main() {
    val sistema = SistemaHospital()

    while (true) {
        println("=== Menú del Sistema de Hospital ===")
        println("1. Registrar Empleado")
        println("2. Registrar Médico")
        println("3. Registrar Paciente")
        println("4. Registrar Cita Médica")
        println("5. Listar Médicos por Especialidad")
        println("6. Listar Pacientes por Médico")
        println("7. Salir")

        print("Seleccione una opción: ")
        when (readLine()?.toInt()) {
            1 -> registrarEmpleadoEnSistema(sistema)
            2 -> registrarMedicoEnSistema(sistema)
            3 -> registrarPacienteEnSistema(sistema)
            4 -> registrarCitaEnSistema(sistema)
            5 -> listarMedicosPorEspecialidadEnSistema(sistema)
            6 -> listarPacientesPorMedicoEnSistema(sistema)
            7 -> {
                println("Saliendo del programa...")
                return
            }
            else -> println("Opción no válida. Inténtelo de nuevo.")
        }
    }
}

fun registrarEmpleadoEnSistema(sistema: SistemaHospital) {
    println("=== Registro de Empleado ===")
    println("1. Empleado por Planilla")
    println("2. Empleado Eventual")
    print("Seleccione el tipo de empleado: ")
    when (readLine()?.toInt()) {
        1 -> {
            print("Ingrese código de empleado: ")
            val codigo = readLine()?.toInt() ?: return
            print("Ingrese número de horas extras: ")
            val horasExtras = readLine()?.toInt() ?: return
            print("Ingrese fecha de ingreso (YYYY-MM-DD): ")
            val fechaIngreso = readLine() ?: return
            print("Ingrese área: ")
            val area = readLine() ?: return
            print("Ingrese cargo: ")
            val cargo = readLine() ?: return
            print("Ingrese salario mensual: ")
            val salarioMensual = readLine()?.toDouble() ?: return
            print("Ingrese porcentaje adicional por hora extra: ")
            val porcentajeAdicional = readLine()?.toDouble() ?: return
            sistema.registrarEmpleado(EmpleadoPlanilla(codigo, horasExtras, fechaIngreso, area, cargo, salarioMensual, porcentajeAdicional))
        }
        2 -> {
            print("Ingrese código de empleado: ")
            val codigo = readLine()?.toInt() ?: return
            print("Ingrese número de horas extras: ")
            val horasExtras = readLine()?.toInt() ?: return
            print("Ingrese fecha de ingreso (YYYY-MM-DD): ")
            val fechaIngreso = readLine() ?: return
            print("Ingrese área: ")
            val area = readLine() ?: return
            print("Ingrese cargo: ")
            val cargo = readLine() ?: return
            print("Ingrese honorarios por hora: ")
            val honorariosPorHora = readLine()?.toDouble() ?: return
            print("Ingrese número de horas totales (normales + extras): ")
            val horasTotales = readLine()?.toInt() ?: return
            print("Ingrese fecha de término del contrato (YYYY-MM-DD): ")
            val fechaTermino = readLine() ?: return
            sistema.registrarEmpleado(EmpleadoEventual(codigo, horasExtras, fechaIngreso, area, cargo, honorariosPorHora, horasTotales, fechaTermino))
        }
        else -> println("Opción no válida.")
    }
}

fun registrarMedicoEnSistema(sistema: SistemaHospital) {
    println("=== Registro de Médico ===")
    print("Ingrese código de empleado: ")
    val codigo = readLine()?.toInt() ?: return
    print("Ingrese nombre: ")
    val nombre = readLine() ?: return
    print("Ingrese apellido: ")
    val apellido = readLine() ?: return
    print("Ingrese fecha de nacimiento (YYYY-MM-DD): ")
    val fechaNacimiento = readLine() ?: return
    print("Ingrese dirección: ")
    val direccion = readLine() ?: return
    print("Ingrese ciudad de procedencia: ")
    val ciudad = readLine() ?: return
    print("Ingrese especialidad: ")
    val especialidad = readLine() ?: return
    print("Ingrese servicio: ")
    val servicio = readLine() ?: return
    print("Ingrese número de consultorio: ")
    val numeroConsultorio = readLine()?.toInt() ?: return
    print("Ingrese fecha de ingreso (YYYY-MM-DD): ")
    val fechaIngreso = readLine() ?: return

    val medico = Medico(codigo, nombre, apellido, fechaNacimiento, direccion, ciudad, especialidad, servicio, numeroConsultorio, fechaIngreso)
    sistema.registrarMedico(medico)
}

fun registrarPacienteEnSistema(sistema: SistemaHospital) {
    println("=== Registro de Paciente ===")
    print("Ingrese DNI: ")
    val dni = readLine() ?: return
    print("Ingrese nombre: ")
    val nombre = readLine() ?: return
    print("Ingrese apellido: ")
    val apellido = readLine() ?: return
    print("Ingrese fecha de nacimiento (YYYY-MM-DD): ")
    val fechaNacimiento = readLine() ?: return
    print("Ingrese dirección: ")
    val direccion = readLine() ?: return
    print("Ingrese ciudad de procedencia: ")
    val ciudad = readLine() ?: return
    print("Ingrese número de historia clínica: ")
    val numeroHistoriaClinica = readLine()?.toInt() ?: return
    print("Ingrese sexo (M/F): ")
    val sexo = readLine() ?: return
    print("Ingrese grupo sanguíneo: ")
    val grupoSanguineo = readLine() ?: return
    print("Ingrese lista de medicamentos a los que es alérgico (separados por coma): ")
    val alergias = readLine()?.split(",")?.map { it.trim() } ?: return

    val paciente = Paciente(dni, nombre, apellido, fechaNacimiento, direccion, ciudad, numeroHistoriaClinica, sexo, grupoSanguineo, alergias)
    sistema.registrarPaciente(paciente)
}

fun registrarCitaEnSistema(sistema: SistemaHospital) {
    println("=== Registro de Cita Médica ===")
    print("Ingrese código del médico: ")
    val codigoMedico = readLine()?.toInt() ?: return
    print("Ingrese número de historia clínica del paciente: ")
    val numeroHistoriaClinica = readLine()?.toInt() ?: return
    print("Ingrese fecha de la cita (YYYY-MM-DD): ")
    val fecha = readLine() ?: return
    print("Ingrese hora de la cita (HH:MM): ")
    val hora = readLine() ?: return

    sistema.registrarCita(codigoMedico, numeroHistoriaClinica, fecha, hora)
}

fun listarMedicosPorEspecialidadEnSistema(sistema: SistemaHospital) {
    print("Ingrese especialidad: ")
    val especialidad = readLine() ?: return
    sistema.listarMedicosPorEspecialidad(especialidad)
}

fun listarPacientesPorMedicoEnSistema(sistema: SistemaHospital) {
    print("Ingrese código del médico: ")
    val codigoMedico = readLine()?.toInt() ?: return
    sistema.listarPacientesPorMedico(codigoMedico)
}