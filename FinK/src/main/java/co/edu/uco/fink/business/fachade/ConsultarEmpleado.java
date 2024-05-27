package co.edu.uco.fink.business.fachade;

import co.edu.uco.fink.business.domain.EmpleadoDomain;

import java.util.List;

public interface ConsultarEmpleado {

    List<EmpleadoDomain> execute(EmpleadoDomain empleado);

    List<EmpleadoDomain> ejecutar(EmpleadoDomain empleado);

}
