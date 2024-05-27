package co.edu.uco.fink.business.fachade.concrete;

import co.edu.uco.fink.business.assembler.dto.concrete.EmpleadoDTODomainAssembler;
import co.edu.uco.fink.business.fachade.ConsultarEmpleadoFachada;
import co.edu.uco.fink.data.dao.factory.DAOfactory;
import co.edu.uco.fink.dto.fincas.EmpleadoDTO;
import co.edu.uco.fink.business.usecase.concrete.ConsultarEmpleadoImpl;
import co.edu.uco.fink.crosscutting.exception.FinKException;
import co.edu.uco.fink.crosscutting.exception.custom.BusinessFinkException;
import co.edu.uco.fink.data.dao.factory.enums.Factory;

import java.util.List;

public class ConsultarEmpleadoFachadaImpl implements ConsultarEmpleadoFachada{

    private DAOfactory factory;

    public ConsultarEmpleadoFachadaImpl(){
        factory = DAOfactory.getFactory(Factory.AZURE_SQL);
    }

    @Override
    public final List<EmpleadoDTO> execute(final EmpleadoDTO empledao) {
        try {
            var empleadoDomain = EmpleadoDTODomainAssembler.obtenerInstancia().ensamblarDominio(empledao);

            final ConsultarEmpleadoImpl useCase = new ConsultarEmpleadoImpl(factory);
            var resultados = useCase.ejecutar(empleadoDomain);
            return EmpleadoDTODomainAssembler.obtenerInstancia()
                    .ensamblarListaDTO(resultados);

        }catch (FinKException exception){
            throw exception;
        }catch (Exception exception){
            var mensajeUsuario = "Se ha presentado un problema tratando de consultar la informacion del empleado";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar la informacion del empleado";

            throw new BusinessFinkException(mensajeTecnico, mensajeUsuario);
        } finally {
            factory.cerrarConexion();
        }
    }
}
