package co.edu.uco.fink.dto.almacenamiento;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.dto.fincas.LugarFincaDTO;

public class AlmacenDTO {

    private int identificador;

    private String serial;

    private LugarFincaDTO lugar;

    private  TipoAlmacenDTO tipo;

    private String descripcion;

    public AlmacenDTO(){
        setSerial(TextHelper.EMPTY);
        setLugar(LugarFincaDTO.build());
        setTipo(TipoAlmacenDTO.build());
        setDescripcion(TextHelper.EMPTY);
    }

    public AlmacenDTO(final int identificador, final String serial, final LugarFincaDTO lugar, final TipoAlmacenDTO tipo, final String descripcion) {
        setIdentificador(identificador);
        setSerial(serial);
        setLugar(lugar);
        setTipo(tipo);
        setDescripcion(descripcion);
    }

    public static final AlmacenDTO build(){
        return new AlmacenDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final AlmacenDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getSerial() {
        return serial;
    }

    public final AlmacenDTO setSerial(final String serial) {
        this.serial = TextHelper.applyTrim(serial);
        return this;
    }

    public final LugarFincaDTO getLugar() {
        return lugar;
    }

    public final AlmacenDTO setLugar(final LugarFincaDTO lugar) {
        this.lugar = ObjectHelper.getObjectHelper().getDefault(lugar, LugarFincaDTO.build());
        return this;
    }

    public final TipoAlmacenDTO getTipo() {
        return tipo;
    }

    public final AlmacenDTO setTipo(final TipoAlmacenDTO tipo) {
        this.tipo = ObjectHelper.getObjectHelper().getDefault(tipo, TipoAlmacenDTO.build());
        return this;
    }

    public final String getDescripcion() {
        return descripcion;
    }

    public final AlmacenDTO setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
        return this;
    }
}
