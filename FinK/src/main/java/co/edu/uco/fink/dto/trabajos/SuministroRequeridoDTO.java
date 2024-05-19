package co.edu.uco.fink.dto.trabajos;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.dto.almacenamiento.TipoSuministroDTO;

public class SuministroRequeridoDTO {

    private int identificador;
    private TareaFincaDTO tarea;
    private TipoSuministroDTO suministro;
    private int cantidad;

    private float cantidadRequerida;

    public SuministroRequeridoDTO(){
        setTarea(TareaFincaDTO.Build());
        setSuministro(TipoSuministroDTO.build());
        setCantidad(NumericHelper.ZERO);
    }

    public SuministroRequeridoDTO(final int identificador, final TareaFincaDTO tarea, final TipoSuministroDTO suministro, final int cantidad) {
        setIdentificador(identificador);
        setTarea(tarea);
        setSuministro(suministro);
        setCantidad(cantidad);
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

    public final TareaFincaDTO getTarea() {
        return tarea;
    }

    public final SuministroRequeridoDTO setTarea(final TareaFincaDTO tarea) {
        this.tarea = ObjectHelper.getObjectHelper().getDefault(tarea, TareaFincaDTO.Build());
        return this;
    }

    public final TipoSuministroDTO getSuministro() {
        return suministro;
    }

    public final SuministroRequeridoDTO setSuministro(final TipoSuministroDTO suministro) {
        this.suministro = ObjectHelper.getObjectHelper().getDefault(suministro, TipoSuministroDTO.build());
        return this;
    }

    public final float getCantidadRequerida() {
        return cantidadRequerida;
    }

    public final SuministroRequeridoDTO setCantidad(final int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

}
