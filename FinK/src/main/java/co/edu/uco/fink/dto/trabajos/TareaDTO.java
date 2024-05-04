package co.edu.uco.fink.dto.trabajos;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.dto.fincas.EmpleadoDTO;

public class TareaDTO {

    private int identificador;

    private String tareaID;

    private EmpleadoDTO empleadoAsignado;

    private TipoTrabajoDTO tipoTrabajo;

    private EstadoTareaDTO estado;

    public TareaDTO(){
        setTareaID(TextHelper.EMPTY);
        setEmpleadoAsignado(EmpleadoDTO.build());
        setTipoTrabajo(TipoTrabajoDTO.build());
        setEstado(EstadoTareaDTO.Build());
    }

    public TareaDTO(final int identificador, final String tareaID, final EmpleadoDTO empleadoAsignado, final TipoTrabajoDTO tipoTrabajo, final EstadoTareaDTO estado) {
        setIdentificador(identificador);
        setTareaID(tareaID);
        setEmpleadoAsignado(empleadoAsignado);
        setTipoTrabajo(tipoTrabajo);
        setEstado(estado);
    }

    public static final TareaDTO build(){
        return new TareaDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TareaDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getTareaID() {
        return tareaID;
    }

    public final TareaDTO setTareaID(final String tareaID) {
        this.tareaID = tareaID;
        return this;
    }

    public final EmpleadoDTO getEmpleadoAsignado(final EmpleadoDTO empleadoAsignado) {
        return empleadoAsignado;
    }

    public final TareaDTO setEmpleadoAsignado(final EmpleadoDTO empleadoAsignado) {
        this.empleadoAsignado = empleadoAsignado;
        return this;
    }

    public final TipoTrabajoDTO getTipoTrabajo() {
        return tipoTrabajo;
    }

    public final TareaDTO setTipoTrabajo(final TipoTrabajoDTO tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
        return this;
    }

    public final EstadoTareaDTO getEstado() {
        return estado;
    }

    public final TareaDTO setEstado(final EstadoTareaDTO estado) {
        this.estado = estado;
        return this;
    }
}
