package co.edu.uco.fink.dto.trabajos;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.dto.animales.AnimalDTO;
import co.edu.uco.fink.dto.fincas.LugarFincaDTO;

public class TrabajoAnimalDTO {

    private int identificador;

    private TareaDTO tarea;

    private TipoTrabajoAnimalDTO tipoTrabajo;

    private AnimalDTO animal;

    private String descripcion;

    public TrabajoAnimalDTO(){
        setTarea(TareaDTO.build());
        setTipoTrabajo(TipoTrabajoAnimalDTO.build());
        setAnimal(AnimalDTO.build());
        setDescripcion(TextHelper.EMPTY);
    }

    public TrabajoAnimalDTO(final int identificador, final TareaDTO tarea, final TipoTrabajoAnimalDTO tipoTrabajo, final AnimalDTO animal, final String descripcion) {
        setIdentificador(identificador);
        setTarea(tarea);
        setTipoTrabajo(tipoTrabajo);
        setAnimal(animal);
        setDescripcion(descripcion);
    }

    public static final TrabajoAnimalDTO build(){
        return new TrabajoAnimalDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TrabajoAnimalDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final TareaDTO getTarea() {
        return tarea;
    }

    public final TrabajoAnimalDTO setTarea(final TareaDTO tarea) {
        this.tarea = ObjectHelper.getObjectHelper().getDefault(tarea, TareaDTO.build());
        return this;
    }

    public final TipoTrabajoAnimalDTO getTipoTrabajo() {
        return tipoTrabajo;
    }

    public final TrabajoAnimalDTO setTipoTrabajo(final TipoTrabajoAnimalDTO tipoTrabajo) {
        this.tipoTrabajo = ObjectHelper.getObjectHelper().getDefault(tipoTrabajo, TipoTrabajoAnimalDTO.build());
        return this;
    }

    public final AnimalDTO getLugar() {
        return animal;
    }

    public final TrabajoAnimalDTO setAnimal(final AnimalDTO animal) {
        this.animal = ObjectHelper.getObjectHelper().getDefault(animal, AnimalDTO.build());
        return this;
    }

    public final String getDescripcion() {
        return descripcion;
    }

    public final TrabajoAnimalDTO setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
        return this;
    }
}
