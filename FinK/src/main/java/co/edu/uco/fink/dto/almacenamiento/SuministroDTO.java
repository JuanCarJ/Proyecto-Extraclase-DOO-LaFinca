package co.edu.uco.fink.dto.almacenamiento;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class SuministroDTO {

    private int ID;

    private String nombre;

    private float cantidad;

    private UnidadMedidaDTO unidadMedida;

    private TipoSuministroDTO tipo;

    private AlmacenDTO almacen;

    public SuministroDTO(){
        setNombre(TextHelper.EMPTY);
        setCantidad(NumericHelper.ZERO);
        setUnidadMedida(UnidadMedidaDTO.build());
        setTipo(TipoSuministroDTO.build());
        setAlmacen(AlmacenDTO.build());
    }

    public SuministroDTO(final int ID, final String nombre, final float cantidad, final UnidadMedidaDTO unidadMedida, final TipoSuministroDTO tipo, final AlmacenDTO almacen) {
        setID(ID);
        setNombre(nombre);
        setCantidad(cantidad);
        setUnidadMedida(unidadMedida);
        setTipo(tipo);
        setAlmacen(almacen);
    }

    public static final SuministroDTO build(){
        return new SuministroDTO();
    }

    public final int getID() {
        return ID;
    }

    public final SuministroDTO setID(final int ID) {
        this.ID = ID;
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final SuministroDTO setNombre(final String nombre) {
        this.nombre = nombre;
        return this;
    }

    public final float getCantidad() {
        return cantidad;
    }

    public final SuministroDTO setCantidad(final float cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public final UnidadMedidaDTO getUnidadMedida() {
        return unidadMedida;
    }

    public final SuministroDTO setUnidadMedida(final UnidadMedidaDTO unidadMedida) {
        this.unidadMedida = ObjectHelper.getObjectHelper().getDefault(unidadMedida, UnidadMedidaDTO.build());
        return this;
    }

    public final TipoSuministroDTO getTipo() {
        return tipo;
    }

    public final SuministroDTO setTipo(final TipoSuministroDTO tipo) {
        this.tipo = ObjectHelper.getObjectHelper().getDefault(tipo, TipoSuministroDTO.build());
        return this;
    }

    public final AlmacenDTO getAlmacen() {
        return almacen;
    }

    public final SuministroDTO setAlmacen(final AlmacenDTO almacen) {
        this.almacen = ObjectHelper.getObjectHelper().getDefault(almacen, AlmacenDTO.build());
        return this;
    }
}

