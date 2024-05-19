package co.edu.uco.fink.dto.trabajos;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;

import java.time.LocalDateTime;

public class RegistroEstadoTareaDTO {

    private int identificador;
    private TareaFincaDTO tarea;
    private TipoEstadoDTO estado;
    private LocalDateTime fechaActualizacion;

    public RegistroEstadoTareaDTO(){
        setTarea(TareaFincaDTO.Build());
        setEstado(TipoEstadoDTO.Build());
        setFechaActualizacion();
    }

    public RegistroEstadoTareaDTO(final int identificador, final TareaFincaDTO tarea, final TipoEstadoDTO estado) {
        setIdentificador(identificador);
        setTarea(tarea);
        setEstado(estado);
        setFechaActualizacion();
    }

    public static final RegistroEstadoTareaDTO Build(){
        return new RegistroEstadoTareaDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final RegistroEstadoTareaDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final TareaFincaDTO getTarea() {
        return tarea;
    }

    public final RegistroEstadoTareaDTO setTarea(final TareaFincaDTO tarea) {
        this.tarea = ObjectHelper.getObjectHelper().getDefault(tarea, TareaFincaDTO.Build());
        return this;
    }

    public final TipoEstadoDTO getEstado() {
        return estado;
    }

    public final RegistroEstadoTareaDTO setEstado(final TipoEstadoDTO estado) {
        this.estado = ObjectHelper.getObjectHelper().getDefault(estado, TipoEstadoDTO.Build());
        return this;
    }

    public final LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public final RegistroEstadoTareaDTO setFechaActualizacion() {
        this.fechaActualizacion = LocalDateTime.now();
        return this;
    }
}
