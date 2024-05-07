package co.edu.uco.fink.entity.trabajos;

import co.edu.uco.fink.dto.trabajos.TareaDTO;
import co.edu.uco.fink.dto.almacenamiento.SuministroDTO;
import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;

public class SuministroRequeridoEntity {

    private int identificador;
    private TareaDTO tarea;
    private SuministroDTO suministro;
    private float cantidadRequerida;

    private SuministroRequeridoEntity(){
        setTarea(TareaDTO.build());
        setSuministro(SuministroDTO.build());
        setCantidadRequerida(NumericHelper.ZERO);
    }

    private SuministroRequeridoEntity(final int identificador, final TareaDTO tarea, final SuministroDTO suministro, final float cantidadRequerida) {
        setIdentificador(identificador);
        setTarea(tarea);
        setSuministro(suministro);
        setCantidadRequerida(cantidadRequerida);
    }

    public static final SuministroRequeridoEntity build(){
        return new SuministroRequeridoEntity();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final SuministroRequeridoEntity setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final TareaDTO getTarea() {
        return tarea;
    }

    public final SuministroRequeridoEntity setTarea(final TareaDTO tarea) {
        this.tarea = ObjectHelper.getObjectHelper().getDefault(tarea,TareaDTO.build());
        return this;
    }

    public final SuministroDTO getSuministro() {
        return suministro;
    }

    public final SuministroRequeridoEntity setSuministro(final SuministroDTO suministro) {
        this.suministro = ObjectHelper.getObjectHelper().getDefault(suministro, SuministroDTO.build());
        return this;
    }

    public final float getCantidadRequerida() {
        return cantidadRequerida;
    }

    public final SuministroRequeridoEntity setCantidadRequerida(final float cantidadRequerida) {
        this.cantidadRequerida = cantidadRequerida;
        return this;
    }
}
