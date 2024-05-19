package co.edu.uco.fink.dto.almacenamiento;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class TipoSuministroDTO {

    private int ID;
    private String nombre;
    private UnidadMedidaDTO unidadMedida;

    public TipoSuministroDTO(){
        setNombre(TextHelper.EMPTY);
        setUnidadMedida(UnidadMedidaDTO.Build());
    }

    public TipoSuministroDTO(final int ID, final String nombre, final UnidadMedidaDTO unidadMedida) {
        setID(ID);
        setNombre(nombre);
        setUnidadMedida(unidadMedida);
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

    public final String getNombre() {
        return nombre;
    }

    public final TipoSuministroDTO setNombre(final String descripcion) {
        this.nombre = TextHelper.applyTrim(descripcion);
        return this;
    }

    public final UnidadMedidaDTO getUnidadMedida() {
        return unidadMedida;
    }

    public final TipoSuministroDTO setUnidadMedida(final UnidadMedidaDTO unidadMedida) {
        this.unidadMedida = ObjectHelper.getObjectHelper().getDefault(unidadMedida, UnidadMedidaDTO.Build());
        return this;
    }
}
