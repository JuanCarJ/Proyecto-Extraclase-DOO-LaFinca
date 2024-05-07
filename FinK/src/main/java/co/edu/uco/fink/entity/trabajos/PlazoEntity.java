package co.edu.uco.fink.entity.trabajos;

import co.edu.uco.fink.dto.trabajos.TareaDTO;
import co.edu.uco.fink.crosscutting.helpers.DateHelper;

public class PlazoEntity {

    private int identificador;
    private TareaDTO tarea;
    private String fechaInicio;
    private String fechaFin;

    private PlazoEntity(){
        setTarea(TareaDTO.build());
        setFechaInicio(DateHelper.getDefaultDate());
        setFechaFin(DateHelper.getDefaultDate());
    }

    private PlazoEntity(final int identificador, final TareaDTO tarea, final String fechaInicio, final String fechaFin) {
        setIdentificador(identificador);
        setTarea(tarea);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final PlazoEntity setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public TareaDTO getTarea() {
        return tarea;
    }

    public final PlazoEntity setTarea(final TareaDTO tarea) {
        this.tarea = tarea;
        return this;
    }

    public final String getFechaInicio() {
        return fechaInicio;
    }

    public final PlazoEntity setFechaInicio(final String fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    public final String getFechaFin() {
        return fechaFin;
    }

    public final PlazoEntity setFechaFin(final String fechaFin) {
        this.fechaFin = fechaFin;
        return this;
    }
}
