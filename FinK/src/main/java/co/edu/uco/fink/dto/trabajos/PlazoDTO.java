package co.edu.uco.fink.dto.trabajos;

import co.edu.uco.fink.crosscutting.helpers.DateHelper;

import java.time.LocalDateTime;

public class PlazoDTO {

    private int identificador;

    private TareaDTO tarea;

    private String fechaInicio;

    private String fechaFin;

    public PlazoDTO(){
        setTarea(TareaDTO.build());
        setFechaInicio(DateHelper.defaultDate);
        setFechaFin(DateHelper.defaultDate);
    }

    public PlazoDTO(final int identificador, final TareaDTO tarea, final String fechaInicio, final String fechaFin) {
        setIdentificador(identificador);
        setTarea(tarea);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final PlazoDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public TareaDTO getTarea() {
        return tarea;
    }

    public final PlazoDTO setTarea(final TareaDTO tarea) {
        this.tarea = tarea;
        return this;
    }

    public final String getFechaInicio() {
        return fechaInicio;
    }

    public final PlazoDTO setFechaInicio(final String fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    public final String  getFechaFin() {
        return fechaFin;
    }

    public final PlazoDTO setFechaFin(final String fechaFin) {
        this.fechaFin = fechaFin;
        return this;
    }
}
