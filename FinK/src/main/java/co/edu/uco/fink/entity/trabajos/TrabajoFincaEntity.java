package co.edu.uco.fink.entity.trabajos;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.entity.fincas.LugarFincaEntity;
import co.edu.uco.fink.entity.trabajos.TareaEntity;
import co.edu.uco.fink.entity.trabajos.TipoTrabajoFincaEntity;

public class TrabajoFincaEntity {

    private int identificador;
    private TareaEntity tarea;
    private TipoTrabajoFincaEntity tipoTrabajo;
    private LugarFincaEntity lugar;
    private String descripcion;

    private TrabajoFincaEntity(){
        setTarea(TareaEntity.build());
        setTipoTrabajo(TipoTrabajoFincaEntity.build());
        setLugar(LugarFincaEntity.build());
        setDescripcion(TextHelper.EMPTY);
    }

    private TrabajoFincaEntity(final int identificador, final TareaEntity tarea, final TipoTrabajoFincaEntity tipoTrabajo, final LugarFincaEntity lugar, final String descripcion) {
        setIdentificador(identificador);
        setTarea(tarea);
        setTipoTrabajo(tipoTrabajo);
        setLugar(lugar);
        setDescripcion(descripcion);
    }

    public static final TrabajoFincaEntity build(){
        return new TrabajoFincaEntity();
    }

    public static final TrabajoFincaEntity build(final int identificador, final TareaEntity tarea, final TipoTrabajoFincaEntity tipoTrabajo, final LugarFincaEntity lugar, final String descripcion){
        return new TrabajoFincaEntity(identificador, tarea, tipoTrabajo, lugar, descripcion);
    }

    public final int getIdentificador() {
        return identificador;
    }

    private final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final TareaEntity getTarea() {
        return tarea;
    }

    private final void setTarea(final TareaEntity tarea) {
        this.tarea = ObjectHelper.getObjectHelper().getDefault(tarea, TareaEntity.build());
    }

    public final TipoTrabajoFincaEntity getTipoTrabajo() {
        return tipoTrabajo;
    }

    private final void setTipoTrabajo(final TipoTrabajoFincaEntity tipoTrabajo) {
        this.tipoTrabajo = ObjectHelper.getObjectHelper().getDefault(tipoTrabajo, TipoTrabajoFincaEntity.build());
    }

    public final LugarFincaEntity getLugar() {
        return lugar;
    }

    private final void setLugar(final LugarFincaEntity lugar) {
        this.lugar = ObjectHelper.getObjectHelper().getDefault(lugar, LugarFincaEntity.build());
    }

    public final String getDescripcion() {
        return descripcion;
    }

    private final void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
}
