package co.edu.uco.fink.entity.trabajos;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.dto.trabajos.TareaDTO;
import co.edu.uco.fink.dto.animales.AnimalDTO;
import co.edu.uco.fink.dto.trabajos.TipoTrabajoAnimalDTO;

public class TrabajoAnimalEntity {

    private int identificador;
    private TareaDTO tarea;
    private TipoTrabajoAnimalDTO tipoTrabajo;
    private AnimalDTO animal;
    private String descripcion;

    private TrabajoAnimalEntity(){
        setTarea(TareaDTO.build());
        setTipoTrabajo(TipoTrabajoAnimalDTO.build());
        setAnimal(AnimalDTO.build());
        setDescripcion(TextHelper.EMPTY);
    }

    private TrabajoAnimalEntity(final int identificador, final TareaDTO tarea, final TipoTrabajoAnimalDTO tipoTrabajo, final AnimalDTO animal, final String descripcion) {
        setIdentificador(identificador);
        setTarea(tarea);
        setTipoTrabajo(tipoTrabajo);
        setAnimal(animal);
        setDescripcion(descripcion);
    }

    public static final TrabajoAnimalEntity build(){
        return new TrabajoAnimalEntity();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TrabajoAnimalEntity setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final TareaDTO getTarea() {
        return tarea;
    }

    public final TrabajoAnimalEntity setTarea(final TareaDTO tarea) {
        this.tarea = ObjectHelper.getObjectHelper().getDefault(tarea, TareaDTO.build());
        return this;
    }

    public final TipoTrabajoAnimalDTO getTipoTrabajo() {
        return tipoTrabajo;
    }

    public final TrabajoAnimalEntity setTipoTrabajo(final TipoTrabajoAnimalDTO tipoTrabajo) {
        this.tipoTrabajo = ObjectHelper.getObjectHelper().getDefault(tipoTrabajo, TipoTrabajoAnimalDTO.build());
        return this;
    }

    public final AnimalDTO getAnimal() {
        return animal;
    }

    public final TrabajoAnimalEntity setAnimal(final AnimalDTO animal) {
        this.animal = ObjectHelper.getObjectHelper().getDefault(animal, AnimalDTO.build());
        return this;
    }

    public final String getDescripcion() {
        return descripcion;
    }

    public final TrabajoAnimalEntity setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
        return this;
    }
}
