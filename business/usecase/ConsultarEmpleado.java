package co.edu.uco.fink.business.usecase;

import co.edu.uco.fink.business.domain.EmpleadoDomain;

import java.util.List;

public interface ConsultarEmpleado {

    List<EmpleadoDomain> ejecutar(EmpleadoDomain empleado);
}