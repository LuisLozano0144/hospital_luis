open class EmpleadoPlanilla(
    codigoEmpleado: Int,
    horasExtras: Int,
    fechaIngreso: String,
    area: String,
    cargo: String,
    val salarioMensual: Double,
    val porcentajeAdicionalHoraExtra: Double
) : Empleado(codigoEmpleado, horasExtras, fechaIngreso, area, cargo)