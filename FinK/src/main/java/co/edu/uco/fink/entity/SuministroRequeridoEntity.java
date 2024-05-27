package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.dto.almacenamiento.TipoSuministroDTO;
import co.edu.uco.fink.dto.trabajos.SuministroRequeridoDTO;
import co.edu.uco.fink.dto.trabajos.TareaFincaDTO;

public class SuministroRequeridoEntity {
    private int identificador;
    private TareaFincaEntity tarea;
    private TipoSuministroEntity suministro;
    private int cantidad;

    public SuministroRequeridoEntity(final int identificador){
        setIdentificador(identificador);
        setTarea(TareaFincaEntity.build());
        setSuministro(TipoSuministroEntity.build());
        setCantidad(NumericHelper.ZERO);
    }

    public SuministroRequeridoEntity(final int identificador, final TareaFincaEntity tarea, final TipoSuministroEntity suministro, final int cantidad) {
        setIdentificador(identificador);
        setTarea(tarea);
        setSuministro(suministro);
        setCantidad(cantidad);
    }

    public static final SuministroRequeridoEntity build(final int identificador){
        return new SuministroRequeridoEntity(identificador);
    }

    public static final SuministroRequeridoEntity build(final int identificador, final TareaFincaEntity tarea, final TipoSuministroEntity suministro, final int cantidad){
        return new SuministroRequeridoEntity(identificador, tarea, suministro, cantidad);
    }

    protected static final SuministroRequeridoEntity build() {
        return new SuministroRequeridoEntity(NumericHelper.ZERO);
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

    public final TipoSuministroEntity getSuministro() {
        return suministro;
    }

    public final void setSuministro(final TipoSuministroEntity suministro) {
        this.suministro = ObjectHelper.getObjectHelper().getDefault(suministro, TipoSuministroEntity.build());
    }

    public final int getCantidad() {
        return cantidad;
    }

    public final void setCantidad(final int cantidad) {
        this.cantidad = cantidad;
    }
}
