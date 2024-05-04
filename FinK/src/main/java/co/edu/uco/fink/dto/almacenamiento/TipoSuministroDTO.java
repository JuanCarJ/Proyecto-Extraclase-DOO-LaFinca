package co.edu.uco.fink.dto.almacenamiento;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class TipoSuministroDTO {

    private int ID;

    private String descripcion;

    public TipoSuministroDTO(){
        setDescripcion(TextHelper.EMPTY);
    }

    public TipoSuministroDTO(final int ID, final String descripcion) {
        setID(ID);
        setDescripcion(descripcion);
    }

    public static final TipoSuministroDTO build(){
        return new TipoSuministroDTO();
    }

    public final int getID() {
        return ID;
    }

    public final TipoSuministroDTO setID(final int ID) {
        this.ID = ID;
        return this;
    }

    public final String getDescripcion() {
        return descripcion;
    }

    public final TipoSuministroDTO setDescripcion(final String descripcion) {
        this.descripcion = TextHelper.applyTrim(descripcion);
        return this;
    }
}
