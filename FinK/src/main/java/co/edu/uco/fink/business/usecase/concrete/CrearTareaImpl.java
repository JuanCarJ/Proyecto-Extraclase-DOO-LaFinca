package co.edu.uco.fink.business.usecase.concrete;

import co.edu.uco.fink.business.assembler.entity.concrete.TareaFincaEntityDomainAssembler;
import co.edu.uco.fink.business.domain.TareaFincaDomain;
import co.edu.uco.fink.business.usecase.CrearTarea;
import co.edu.uco.fink.crosscutting.exception.Enums.Lugar;
import co.edu.uco.fink.crosscutting.exception.FinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.data.dao.factory.DAOfactory;
import co.edu.uco.fink.entity.EmpleadoEntity;
import co.edu.uco.fink.entity.LugarFincaEntity;
import co.edu.uco.fink.entity.TareaFincaEntity;
import co.edu.uco.fink.entity.TipoTareaFincaEntity;

import java.util.List;
import java.util.Objects;

public class CrearTareaImpl implements CrearTarea {

    private final DAOfactory factory;

    public CrearTareaImpl(final DAOfactory factory){ this.factory = factory; }

    public final int validarTipoCodigo(final TareaFincaEntity tarea){
        List<TareaFincaEntity> resultado = factory.getTareaFincaDAO().consultar(tarea);

        int codigo = 1;

        if (!resultado.isEmpty()) {
            for (TareaFincaEntity ignored : resultado) {
                codigo += 1;
            }
        }

        return codigo;
    }

    public final String validarEmpleado(TareaFincaEntity tarea){
        List<EmpleadoEntity> resultado = factory.getEmpleadoDAO().consultar(tarea.getEmpleadoAsignado());

        String finca = "";

        for (EmpleadoEntity empleado : resultado) {
            if (tarea.getEmpleadoAsignado().getDocumento() == empleado.getDocumento()) {
                finca = empleado.getFinca().getNombre();
            }
        }

        return finca;
    }

    public final void validate(TareaFincaEntity tarea){
        List<EmpleadoEntity> resultado = factory.getEmpleadoDAO().consultar(tarea.getEmpleadoAsignado());

        if (tarea.getEmpleadoAsignado().getDocumento() == 0){
            String mensajeUsuario = "La tarea que se intenta registrar no tiene empleado";
            String mensajeTecnico = "Se ha intentado crear una tarea sin un empleado asignado";

            throw new FinKException(mensajeTecnico, mensajeUsuario, Lugar.BUSINESS);
        } else {

            boolean existe = false;

            for (EmpleadoEntity empleado : resultado) {
                if (tarea.getEmpleadoAsignado().getDocumento() == empleado.getDocumento()) {
                    if (Objects.equals(tarea.getLugar().getFinca().getNombre(), empleado.getFinca().getNombre())) {
                        existe = true;
                        break;
                    }
                }
            }

            if (!existe){
                String mensajeUsuario = "El empleado que se está asignando no existe en la finca actual";
                String mensajeTecnico = "Se ha intentado asignar un empleado que no existe dentro de la finca actual";

                throw new FinKException(mensajeTecnico, mensajeUsuario, Lugar.BUSINESS);
            }

        }


        for (EmpleadoEntity entidad : resultado) {
            if (entidad.getDocumento() == tarea.getEmpleadoAsignado().getDocumento()){
                if (Objects.equals(entidad.getEstado(), "inactivo")){
                    String mensajeUsuario = "El empleado que se está asignando está inactivo";
                    String mensajeTecnico = "Se ha intentado asignar un empleado que no está activo";

                    throw new FinKException(mensajeTecnico, mensajeUsuario, Lugar.BUSINESS);
                }
            }
        }

        if (tarea.getTipoTrabajo().getTipo() != null){

            boolean existe = false;

            List<TipoTareaFincaEntity> result = factory.getTipoTareaFincaDAO().consultar(tarea.getTipoTrabajo());

            for (TipoTareaFincaEntity entidad : result){
                if (Objects.equals(entidad.getTipo(), tarea.getTipoTrabajo().getTipo())){
                    existe = true;
                }
            }

            if (!existe){
                String mensajeUsuario = "El tipo de tarea que se intentó ingresar no es valido";
                String mensajeTecnico = "Se ha intentado asignar un tipo de tarea que no es valido";

                throw new FinKException(mensajeTecnico, mensajeUsuario, Lugar.BUSINESS);
            }
        }


    }

    public final int validarLugar(TareaFincaEntity tarea){


        List<LugarFincaEntity> resultado = factory.getLugarFincaDAO().consultar(tarea.getLugar());

        int id = 0;

        if (!resultado.isEmpty()) {
            for (LugarFincaEntity entidad : resultado) {
                if (Objects.equals(entidad.getFinca().getNombre(), tarea.getLugar().getFinca().getNombre())){
                    if (Objects.equals(entidad.getUbicacion(), tarea.getLugar().getUbicacion())){
                        if (Objects.equals(entidad.getNomenclatura(), tarea.getLugar().getNomenclatura())){
                            id = entidad.getIdentificador();
                        }
                    }
                }
            }
        }


        if (id == 0){
            String mensajeUsuario = "El lugar ingresado no existe en la finca";
            String mensajeTecnico = "Se ha intentado asignar un lugar que no existe dentro de la finca actual";

            throw new FinKException(mensajeTecnico, mensajeUsuario, Lugar.BUSINESS);
        }

        return id;
    }

    public final void ejecutar(TareaFincaDomain tarea) {
        try{
            TareaFincaEntity tareaEntity = TareaFincaEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(tarea);

            var finca = validarEmpleado(tareaEntity);
            tareaEntity.getEmpleadoAsignado().getFinca().setNombre(finca);

            var newcodigo = validarTipoCodigo(tareaEntity);
            tareaEntity.setCodigo(newcodigo);

            var id = validarLugar(tareaEntity);
            tareaEntity.getLugar().setIdentificador(id);

            validate(tareaEntity);

            factory.getTareaFincaDAO().crear(tareaEntity);
        } catch (FinKException e){
            throw e;
        }
    }
}


// POL 01: No debe haber una tarea con el mismo codigo que otra tarea si las dos tareas son del mismo tipo
// POL 02: Los datos deben cumplir con reglas de obligatoriedad longitud y rango
// POL 03: Una tarea debe tener un empleado asignado
// POL 04: El empleado asignado debe estar activo
