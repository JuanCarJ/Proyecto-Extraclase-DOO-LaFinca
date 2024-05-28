package co.edu.uco.fink.business.fachade;

import co.edu.uco.fink.business.domain.EmpleadoDomain;
import co.edu.uco.fink.dto.fincas.EmpleadoDTO;

import java.util.List;

public interface ConsultarEmpleadoFachada {

    List<EmpleadoDTO> execute(EmpleadoDTO empleado);

}
