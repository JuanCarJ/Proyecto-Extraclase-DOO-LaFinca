package co.edu.uco.fink.entity.trabajos;

import co.edu.uco.fink.dto.trabajos.TareaDTO;
import co.edu.uco.fink.dto.trabajos.TipoTrabajoDTO;
import co.edu.uco.fink.dto.trabajos.EstadoTareaDTO;
import co.edu.uco.fink.dto.fincas.EmpleadoDTO;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class TareaEntity {

    private int identificador;
    private String tareaID;
    private EmpleadoDTO empleadoAsignado;
    private TipoTrabajoDTO tipoTrabajo;
    private EstadoTareaDTO estado;

    private TareaEntity(){
        setTareaID(TextHelper.EMPTY);
        setEmpleadoAsignado(EmpleadoDTO.build());
        setTipoTrabajo(TipoTrabajoDTO.build());
        setEstado(EstadoTareaDTO.Build());
    }

    private TareaEntity(final int identificador, final String tareaID, final EmpleadoDTO empleadoAsignado, final TipoTrabajoDTO tipoTrabajo, final EstadoTareaDTO estado) {
        setIdentificador(identificador);
        setTareaID(tareaID);
        setEmpleadoAsignado(empleadoAsignado);
        setTipoTrabajo(tipoTrabajo);
        setEstado(estado);
    }

    public static final TareaEntity build(){
        return new TareaEntity();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TareaEntity setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getTareaID() {
        return tareaID;
    }

    public final TareaEntity setTareaID(final String tareaID) {
        this.tareaID = tareaID;
        return this;
    }

    public final EmpleadoDTO getEmpleadoAsignado() {
        return empleadoAsignado;
    }

    public final TareaEntity setEmpleadoAsignado(final EmpleadoDTO empleadoAsignado) {
        this.empleadoAsignado = empleadoAsignado;
        return this;
    }

    public final TipoTrabajoDTO getTipoTrabajo() {
        return tipoTrabajo;
    }

    public final TareaEntity setTipoTrabajo(final TipoTrabajoDTO tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
        return this;
    }

    public final EstadoTareaDTO getEstado() {
        return estado;
    }

    public final TareaEntity setEstado(final EstadoTareaDTO estado) {
        this.estado = estado;
        return this;
    }
}
