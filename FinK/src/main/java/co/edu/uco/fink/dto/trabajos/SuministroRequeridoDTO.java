package co.edu.uco.fink.dto.trabajos;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.dto.almacenamiento.SuministroDTO;

public class SuministroRequeridoDTO {

    private int identificador;

    private TareaDTO tarea;

    private SuministroDTO suministro;

    private float cantidadRequerida;

    public SuministroRequeridoDTO(){
        setTarea(TareaDTO.build());
        setSuministro(SuministroDTO.build());
        setCantidadRequerida(NumericHelper.ZERO);
    }

    public SuministroRequeridoDTO(final int identificador, final TareaDTO tarea, final SuministroDTO suministro, final float cantidadRequerida) {
        setIdentificador(identificador);
        setTarea(tarea);
        setSuministro(suministro);
        setCantidadRequerida(cantidadRequerida);
    }

    public static final SuministroRequeridoDTO build(){
        return new SuministroRequeridoDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final SuministroRequeridoDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final TareaDTO getTarea() {
        return tarea;
    }

    public final SuministroRequeridoDTO setTarea(final TareaDTO tarea) {
        this.tarea = ObjectHelper.getObjectHelper().getDefault(tarea,TareaDTO.build());
        return this;
    }

    public final SuministroDTO getSuministro() {
        return suministro;
    }

    public final SuministroRequeridoDTO setSuministro(final SuministroDTO suministro) {
        this.suministro = ObjectHelper.getObjectHelper().getDefault(suministro, SuministroDTO.build());
        return this;
    }

    public final float getCantidadRequerida() {
        return cantidadRequerida;
    }

    public final SuministroRequeridoDTO setCantidadRequerida(final float cantidadRequerida) {
        this.cantidadRequerida = cantidadRequerida;
        return this;
    }
}
