package co.edu.uco.fink.business.usecase.concrete;

import co.edu.uco.fink.business.assembler.entity.concrete.TareaFincaEntityDomainAssembler;
import co.edu.uco.fink.business.domain.TareaFincaDomain;
import co.edu.uco.fink.business.usecase.CrearTarea;
import co.edu.uco.fink.crosscutting.exception.Enums.Lugar;
import co.edu.uco.fink.crosscutting.exception.FinKException;
import co.edu.uco.fink.data.dao.factory.DAOfactory;
import co.edu.uco.fink.entity.EmpleadoEntity;
import co.edu.uco.fink.entity.TareaFincaEntity;

import java.util.List;
import java.util.Objects;

public class CrearTareaImpl implements CrearTarea {

    private final DAOfactory factory;

    public CrearTareaImpl(final DAOfactory factory){ this.factory = factory; }

    public final int validarTipoCodigo(final TareaFincaEntity tarea){
        List<TareaFincaEntity> resultado = factory.getTareaFincaDAO().consultar(tarea);

        int codigo = tarea.getCodigo();

        for (TareaFincaEntity entidad : resultado) {
            if (Objects.equals(entidad.getTipoTrabajo().getTipo(), tarea.getTipoTrabajo().getTipo())) {
                if (entidad.getCodigo() == tarea.getCodigo()) {
                    codigo += 1;
                }
            }
        }

        return codigo;
    }

    public final void validate(TareaFincaEntity tarea){
        if (tarea.getEmpleadoAsignado() == null){
            String mensajeUsuario = "La tarea que se intenta registrar no tiene empleado";
            String mensajeTecnico = "Se ha intentado crear una tarea sin un empleado asignado";

            throw new FinKException(mensajeTecnico, mensajeUsuario, Lugar.BUSINESS);
        }

        List<EmpleadoEntity> resultado = factory.getEmpleadoDAO().consultar(tarea.getEmpleadoAsignado());
        for (EmpleadoEntity entidad : resultado) {
            if (entidad.getDocumento() == tarea.getEmpleadoAsignado().getDocumento()){
                if (Objects.equals(entidad.getEstado(), "inactivo")){
                    String mensajeUsuario = "El empleado que se está asignando está inactivo";
                    String mensajeTecnico = "Se ha intentado asignar un empleado que no está activo";

                    throw new FinKException(mensajeTecnico, mensajeUsuario, Lugar.BUSINESS);
                }
            }
        }
    }

    public final void ejecutar(TareaFincaDomain tarea) {

        TareaFincaEntity tareaEntity = TareaFincaEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(tarea);
        tareaEntity.setCodigo(validarTipoCodigo(tareaEntity));

        validate(tareaEntity);

        factory.getTareaFincaDAO().crear(tareaEntity);
    }
}

// POL 01: No debe haber una tarea con el mismo codigo que otra tarea si las dos tareas son del mismo tipo
// POL 02: Los datos deben cumplir con reglas de obligatoriedad longitud y rango
// POL 03: Una tarea debe tener un empleado asignado
// POL 04: El empleado asignado debe estar activo
