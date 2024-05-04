package co.edu.uco.fink.dto.trabajos;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.dto.fincas.LugarFincaDTO;

public class TrabajoFincaDTO {

    private int identificador;

    private TareaDTO tarea;

    private TipoTrabajoFincaDTO tipoTrabajo;

    private LugarFincaDTO lugar;

    private String descripcion;

    public TrabajoFincaDTO(){
        setTarea(TareaDTO.build());
        setTipoTrabajo(TipoTrabajoFincaDTO.build());
        setLugar(LugarFincaDTO.build());
        setDescripcion(TextHelper.EMPTY);
    }

    public TrabajoFincaDTO(final int identificador, final TareaDTO tarea, final TipoTrabajoFincaDTO tipoTrabajo, final LugarFincaDTO lugar, final String descripcion) {
        setIdentificador(identificador);
        setTarea(tarea);
        setTipoTrabajo(tipoTrabajo);
        setLugar(lugar);
        setDescripcion(descripcion);
    }

    public static final TrabajoFincaDTO build(){
        return new TrabajoFincaDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TrabajoFincaDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final TareaDTO getTarea() {
        return tarea;
    }

    public final TrabajoFincaDTO setTarea(final TareaDTO tarea) {
        this.tarea = ObjectHelper.getObjectHelper().getDefault(tarea, TareaDTO.build());
        return this;
    }

    public final TipoTrabajoFincaDTO getTipoTrabajo() {
        return tipoTrabajo;
    }

    public final TrabajoFincaDTO setTipoTrabajo(final TipoTrabajoFincaDTO tipoTrabajo) {
        this.tipoTrabajo = ObjectHelper.getObjectHelper().getDefault(tipoTrabajo, TipoTrabajoFincaDTO.build());
        return this;
    }

    public final LugarFincaDTO getLugar() {
        return lugar;
    }

    public final TrabajoFincaDTO setLugar(final LugarFincaDTO lugar) {
        this.lugar = ObjectHelper.getObjectHelper().getDefault(lugar, LugarFincaDTO.build());
        return this;
    }

    public final String getDescripcion() {
        return descripcion;
    }

    public final TrabajoFincaDTO setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
        return this;
    }
}
