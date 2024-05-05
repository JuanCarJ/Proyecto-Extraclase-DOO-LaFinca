package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import static co.edu.uco.fink.crosscutting.helpers.NumericHelper.ZERO;

public final class AlmacenEntity {

    private int identificador;
    private String serial;
    private LugarFincaEntity lugar;
    private TipoAlmacenEntity tipo;
    private String descripcion;

    private AlmacenEntity(final int identificador) {
        setIdentificador(identificador);
        setSerial(TextHelper.EMPTY);
        setLugar(LugarFincaEntity.build());
        setTipo(TipoAlmacenEntity.build());
        setDescripcion(TextHelper.EMPTY);
    }

    private AlmacenEntity(final int identificador, final String serial, final LugarFincaEntity lugar, final TipoAlmacenEntity tipo, final String descripcion) {
        setIdentificador(identificador);
        setSerial(serial);
        setLugar(lugar);
        setTipo(tipo);
        setDescripcion(descripcion);
    }

    public static final AlmacenEntity build(final int identificador){
        return new AlmacenEntity(identificador);
    }

    public static final AlmacenEntity build(final int identificador, final String serial, final LugarFincaEntity lugar, final TipoAlmacenEntity tipo, final String descripcion){
        return new AlmacenEntity(identificador, serial, lugar, tipo, descripcion);
    }

    protected static final AlmacenEntity build(){
        return new AlmacenEntity(ZERO);
    }

    public int getIdentificador() {
        return identificador;
    }

    private final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final String getSerial() {
        return serial;
    }

    private final void setSerial(final String serial) {

        this.serial = TextHelper.applyTrim(serial);
    }

    public final LugarFincaEntity getLugar() {
        return lugar;
    }

    private final void setLugar(final LugarFincaEntity lugar) {
        this.lugar = ObjectHelper.getObjectHelper().getDefault(lugar, LugarFincaEntity.build());
    }

    public final TipoAlmacenEntity getTipo() {
        return tipo;
    }

    private final void setTipo(final TipoAlmacenEntity tipo) {
        this.tipo = ObjectHelper.getObjectHelper().getDefault(tipo, TipoAlmacenEntity.build());
    }

    public final String getDescripcion() {
        return descripcion;
    }

    private final void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
}
