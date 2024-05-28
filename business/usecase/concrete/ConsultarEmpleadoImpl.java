package co.edu.uco.fink.business.usecase.concrete;

import co.edu.uco.fink.business.assembler.entity.concrete.EmpleadoEntityDomainAssembler;
import co.edu.uco.fink.business.domain.EmpleadoDomain;
import co.edu.uco.fink.business.fachade.ConsultarEmpleado;
import co.edu.uco.fink.data.dao.factory.DAOfactory;

import java.util.List;

public final class ConsultarEmpleadoImpl implements ConsultarEmpleado {
    
    private final DAOfactory factory;

    public ConsultarEmpleadoImpl(final DAOfactory factory) {
        this.factory = factory;
    }
    @Override
    public final List<EmpleadoDomain> ejecutar(final EmpleadoDomain empleado) {
        var EmpleadoEntity = EmpleadoEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(empleado);
        var resultados = factory.getEmpleadoDAO().consultar(EmpleadoEntity);

        return EmpleadoEntityDomainAssembler.obtenerInstancia().ensamblarListaDominios(resultados);
    }
    @Override
    public List<EmpleadoDomain> execute(EmpleadoDomain empleado) {
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

}
