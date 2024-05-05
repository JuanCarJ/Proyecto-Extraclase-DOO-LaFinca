package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import static co.edu.uco.fink.crosscutting.helpers.NumericHelper.ZERO;

public final class TipoSuministroEntity {

    private int ID;
    private String descripcion;

    private TipoSuministroEntity(final int ID) {
        setID(ID);
        setDescripcion(TextHelper.EMPTY);
    }

    private TipoSuministroEntity(final int ID, final String descripcion) {
        setID(ID);
        setDescripcion(descripcion);
    }

    public static final TipoSuministroEntity build(final int ID){
        return new TipoSuministroEntity(ID);
    }

    public static final TipoSuministroEntity build(final int ID, final String descripcion){
        return new TipoSuministroEntity(ID, descripcion);
    }

    protected static final TipoSuministroEntity build(){
        return new TipoSuministroEntity(ZERO);
    }

    public int getID() {
        return ID;
    }

    private final void setID(final int ID) {
        this.ID = ID;
    }

    public final String getDescripcion() {
        return descripcion;
    }

    private final void setDescripcion(final String descripcion) {
        this.descripcion = TextHelper.applyTrim(descripcion);
    }
}
