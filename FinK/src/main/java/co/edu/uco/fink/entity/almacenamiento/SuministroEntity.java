package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import static co.edu.uco.fink.crosscutting.helpers.NumericHelper.ZERO;

public final class SuministroEntity {

    private int ID;
    private String nombre;
    private float cantidad;
    private UnidadMedidaEntity unidadMedida;
    private TipoSuministroEntity tipo;
    private AlmacenEntity almacen;

    private SuministroEntity(final int ID) {
        setID(ID);
        setNombre(TextHelper.EMPTY);
        setCantidad(ZERO);
        setUnidadMedida(UnidadMedidaEntity.build());
        setTipo(TipoSuministroEntity.build());
        setAlmacen(AlmacenEntity.build());
    }

    private SuministroEntity(final int ID, final String nombre, final float cantidad, final UnidadMedidaEntity unidadMedida, final TipoSuministroEntity tipo, final AlmacenEntity almacen) {
        setID(ID);
        setNombre(nombre);
        setCantidad(cantidad);
        setUnidadMedida(unidadMedida);
        setTipo(tipo);
        setAlmacen(almacen);
    }

    public static final SuministroEntity build(final int ID){
        return new SuministroEntity(ID);
    }

    public static final SuministroEntity build(final int ID, final String nombre, final float cantidad, final UnidadMedidaEntity unidadMedida, final TipoSuministroEntity tipo, final AlmacenEntity almacen){
        return new SuministroEntity(ID, nombre, cantidad, unidadMedida, tipo, almacen);
    }

    protected static final SuministroEntity build(){
        return new SuministroEntity(ZERO);
    }

    public int getID() {
        return ID;
    }

    private final void setID(final int ID) {
        this.ID = ID;
    }

    public final String getNombre() {
        return nombre;
    }

    private final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    public final float getCantidad() {
        return cantidad;
    }

    private final void setCantidad(final float cantidad) {
        this.cantidad = cantidad;
    }

    public final UnidadMedidaEntity getUnidadMedida() {
        return unidadMedida;
    }

    private final void setUnidadMedida(final UnidadMedidaEntity unidadMedida) {
        this.unidadMedida = ObjectHelper.getObjectHelper().getDefault(unidadMedida, UnidadMedidaEntity.build());
    }

    public final TipoSuministroEntity getTipo() {
        return tipo;
    }

    private final void setTipo(final TipoSuministroEntity tipo) {
        this.tipo = ObjectHelper.getObjectHelper().getDefault(tipo, TipoSuministroEntity.build());
    }

    public final AlmacenEntity getAlmacen() {
        return almacen;
    }

    private final void setAlmacen(final AlmacenEntity almacen) {
        this.almacen = ObjectHelper.getObjectHelper().getDefault(almacen, AlmacenEntity.build());
    }
}
