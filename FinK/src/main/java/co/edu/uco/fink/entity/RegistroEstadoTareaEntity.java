package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.DateHelper;
import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.dto.trabajos.RegistroEstadoTareaDTO;
import co.edu.uco.fink.dto.trabajos.TareaFincaDTO;
import co.edu.uco.fink.dto.trabajos.TipoEstadoDTO;

import java.time.LocalDateTime;

public class RegistroEstadoTareaEntity {
    private int identificador;
    private TareaFincaEntity tarea;
    private TipoEstadoEntity estado;
    private LocalDateTime fechaActualizacion;

    public RegistroEstadoTareaEntity(final int identificador){
        setTarea(TareaFincaEntity.build());
        setEstado(TipoEstadoEntity.build());
        setFechaActualizacion(LocalDateTime.now());
    }

    public RegistroEstadoTareaEntity(final int identificador, final TareaFincaEntity tarea, final TipoEstadoEntity estado, final LocalDateTime fechaActualizacion) {
        setIdentificador(identificador);
        setTarea(tarea);
        setEstado(estado);
        setFechaActualizacion(fechaActualizacion);
    }

    public static final RegistroEstadoTareaEntity Build(final int identificador){
        return new RegistroEstadoTareaEntity(identificador);
    }

    public static final RegistroEstadoTareaEntity build(final int identificador, final TareaFincaEntity tarea, final TipoEstadoEntity estado, final LocalDateTime fechaActualizacion){
        return new RegistroEstadoTareaEntity(identificador, tarea, estado, fechaActualizacion);
    }

    protected static final RegistroEstadoTareaEntity build(){
        return new RegistroEstadoTareaEntity(NumericHelper.ZERO);
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final TareaFincaEntity getTarea() {
        return tarea;
    }

    public final void setTarea(final TareaFincaEntity tarea) {
        this.tarea = ObjectHelper.getObjectHelper().getDefault(tarea, TareaFincaEntity.build());
    }

    public final TipoEstadoEntity getEstado() {
        return estado;
    }

    public final void setEstado(final TipoEstadoEntity estado) {
        this.estado = ObjectHelper.getObjectHelper().getDefault(estado, TipoEstadoEntity.build());
    }

    public final LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public final void setFechaActualizacion(final LocalDateTime fechaActualizacion) {
        DateHelper.getDate(fechaActualizacion);
    }
}
