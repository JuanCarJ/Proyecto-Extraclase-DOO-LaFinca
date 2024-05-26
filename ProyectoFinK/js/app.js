const { createApp } = Vue;

function createVueApp(dataFunction) {
    return createApp({
        data: dataFunction,
        methods: {
            enviarFormulario() {
                if (this.validarFormulario()) {
                    //const url = 'http://localhost:3000/tareas';
                    //Quita los puntos de la cedula para que sea un número entero y enviarlo al servidor
                    const data = { ...this.tarea, idEmpleado: this.tarea.idEmpleado.replace(/\./g, '') }; 

                    fetch(url, {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(data) // Convierte el objeto a una cadena JSON
                    })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error('Error en la solicitud: ' + response.statusText);
                        }
                        return response.json();
                    })
                    .then(data => {
                        console.log('Éxito:', data);
                        alert('Tarea creada con éxito.');
                    })
                    .catch(error => {
                        console.error('Error:', error);
                        alert('Hubo un error al crear la tarea.');
                    });
                }
            },
            validarFormulario() {
                if (!this.tarea.idEmpleado || !this.tarea.tipoTrabajoFinca || !this.tarea.lugarFinca) {
                    alert("Todos los campos excepto descripción son obligatorios.");
                    return false;
                }
                if (!/^\d+$/.test(this.tarea.idEmpleado.replace(/\./g, ''))) {
                    alert("La cédula del empleado debe ser un número entero.");
                    return false;
                }
                const nombres = this.tarea.suministrosRequeridos.map(s => s.nombre);
                if (new Set(nombres).size !== nombres.length) {
                    alert("No se puede seleccionar el mismo suministro más de una vez.");
                    return false;
                }
                for (let suministro of this.tarea.suministrosRequeridos) {
                    if (!suministro.cantidad || suministro.cantidad <= 0) {
                        alert("Si selecciona un suministro, debe especificar una cantidad mayor a 0.");
                        return false;
                    }
                }
                return true;
            },
            cambiarTipoTarea() {
                this.tarea.tipoTrabajoFinca = '';
                this.tarea.lugarFinca = '';
                this.tarea.descripcion = '';
                this.tarea.suministrosRequeridos = [];
            },
            agregarSuministro() {
                this.tarea.suministrosRequeridos.push({ nombre: '', cantidad: 0 });
            },
            eliminarSuministro(index) {
                this.tarea.suministrosRequeridos.splice(index, 1);
            },
            formatearCedula() {
                let cedula = this.tarea.idEmpleado.replace(/\D/g, '');
                //Agrega los puntos a la cédula para que sea mas legible
                cedula = cedula.replace(/\B(?=(\d{3})+(?!\d))/g, '.');
                this.tarea.idEmpleado = cedula;
            }
        },
        mounted() {

            this.lugaresFinca = [
                'Pesebrera-A-Finca Vaquita Feliz',
                'Gallinero-A-Finca Vaquita Feliz',
                'Pastizal-A-Finca Vaquita Feliz',
                'Pocilga-A-Finca Vaquita Feliz',
                'Bodega-A-Finca Vaquita Feliz',
                'Bodega-B-Finca Vaquita Feliz',
                'Bodega-C-Finca Vaquita Feliz',
                'Bodega-D-Finca Vaquita Feliz'

            ];
            this.suministros = [
                'Maiz para Gallinas-gramo',
                'Acetaminofen-gramo',
                'Maiz para Gallinas-gramo',
                'Heno para vaca-gramo',
                'Valde-unidad',
                'Trapera-unidad',
                'Tramadol-mililitro',
                'Jeringa-unidad',
                'Barredora-unidad',
            ];
        }
    });
}

const appData = () => ({
    tarea: {
        idEmpleado: '',
        tipoTrabajoFinca: '',
        lugarFinca: '',
        descripcion: '',
        suministrosRequeridos: []
    },
    lugaresFinca: [],
    suministros: []
});

const app = createVueApp(appData);
app.mount('#app');

