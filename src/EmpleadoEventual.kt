class EmpleadoEventual(
    codigoEmpleado: Int,
    horasExtras: Int,
    fechaIngreso: String,
    area: String,
    cargo: String,
    val honorariosPorHora: Double,
    val horasTotales: Int,
    val fechaTerminoContrato: String
) : Empleado(codigoEmpleado, horasExtras, fechaIngreso, area, cargo)