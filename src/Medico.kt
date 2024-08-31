class Medico(
    codigoEmpleado: Int,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    direccion: String,
    ciudadProcedencia: String,
    val especialidad: String,
    val servicio: String,
    val numeroConsultorio: Int,
    fechaIngreso: String
) : EmpleadoPlanilla(codigoEmpleado, 0, fechaIngreso, "Salud", "Médico", 0.0, 0.0)