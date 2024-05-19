package co.edu.uco.fink.entity.almacenamiento;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.dto.almacenamiento.TipoSuministroDTO;
import co.edu.uco.fink.dto.almacenamiento.UnidadMedidaDTO;

public class TipoSuministroEntity {
    private int ID;
    private String nombre;
    private UnidadMedidaEntity unidadMedida;

    public TipoSuministroEntity(final int ID){
        setID(ID);
        setNombre(TextHelper.EMPTY);
        setUnidadMedida(UnidadMedidaEntity.build());
    }

    public TipoSuministroEntity(final int ID, final String nombre, final UnidadMedidaEntity unidadMedida) {
        setID(ID);
        setNombre(nombre);
        setUnidadMedida(unidadMedida);
    }

    public static final TipoSuministroEntity build(final int ID){
        return new TipoSuministroEntity(ID);
    }

    public static final TipoSuministroEntity build(final int ID, final String nombre, final UnidadMedidaEntity unidadMedida) {
        return new TipoSuministroEntity(ID, nombre, unidadMedida);
    }

    protected static final TipoSuministroEntity build() { return new TipoSuministroEntity(NumericHelper.ZERO); }

    public final int getID() {
        return ID;
    }

    public final void setID(final int ID) {
        this.ID = ID;
    }

    public final String getNombre() {
        return nombre;
    }

    public final void setNombre(final String descripcion) {
        this.nombre = TextHelper.applyTrim(descripcion);
    }

    public final UnidadMedidaEntity getUnidadMedida() {
        return unidadMedida;
    }

    public final void setUnidadMedida(final UnidadMedidaEntity unidadMedida) {
        this.unidadMedida = ObjectHelper.getObjectHelper().getDefault(unidadMedida, UnidadMedidaEntity.build());
    }
}
