
const { createApp } = Vue;

function createVueApp(dataFunction) {
    return createApp({
        data: dataFunction,
        methods: {
            cargarEmpleados() {
              
                fetch('../data/empleados.json')
                    .then(response => response.json())
                    .then(data => {
                        this.empleados = data.empleados;
                    })
                    .catch(error => {
                        console.error('Hubo un error al cargar los datos de los empleados:', error);
                        this.empleados = [];
                    });
            },
            enviarFormulario() {
                console.log(this.tarea);
            },
            cambiarTipoTarea() {
                this.tarea.tipoCuidadoAnimal = '';
                this.tarea.animal = '';
                this.tarea.descripcion = '';
                this.tarea.tipoTrabajoFinca = '';
                this.tarea.lugarFinca = '';
                this.tarea.descripcionFinca = '';
            }
        },
        mounted() {
            this.cargarEmpleados();
        }
    });
}
