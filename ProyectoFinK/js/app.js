const { createApp } = Vue;

function createVueApp(dataFunction) {
    return createApp({
        data: dataFunction,
        methods: {
            enviarFormulario() {
                if (this.validarFormulario()) {
                    const url = 'http://localhost:8080/api/v1/tareaFinca'; 
                    const data = {
                        empleadoAsignado: {
                            documento: parseInt(this.tarea.idEmpleado.replace(/\./g, ''))
                        },
                        tipoTrabajo: {
                            tipo: this.tarea.tipoTrabajoFinca
                        },
                        lugar: {
                            finca: this.tarea.finca,
                            ubicacion: this.tarea.ubicacion,
                            nomenclatura: this.tarea.nomenclatura
                        },
                        descripcion: this.tarea.descripcion
                    };

                    fetch(url, {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify(data) 
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
                        this.restablecerFormulario(); 
                    })
                    .catch(error => {
                        console.error('Error:', error);
                        alert('Hubo un error al crear la tarea.');
                    });
                }
            },
            validarFormulario() {
                if (!this.tarea.idEmpleado || !this.tarea.tipoTrabajoFinca || !this.tarea.finca || !this.tarea.ubicacion || !this.tarea.nomenclatura) {
                    alert("Todos los campos excepto descripción son obligatorios.");
                    return false;
                }
                return true;
            },
            cambiarTipoTarea() {
                this.tarea.tipoTrabajoFinca = '';
                this.tarea.finca = '';
                this.tarea.ubicacion = '';
                this.tarea.nomenclatura = '';
                this.tarea.descripcion = '';
            },
            formatearCedula() {
                let cedula = this.tarea.idEmpleado.replace(/\D/g, '');
                cedula = cedula.replace(/\B(?=(\d{3})+(?!\d))/g, '.');
                this.tarea.idEmpleado = cedula;
            },
            cargarDatos() {
                fetch('../data/datos.json')
                    .then(response => response.json())
                    .then(data => {
                        this.fincas = data.fincas;
                    })
                    .catch(error => {
                        console.error('Hubo un error al cargar los datos de los lugares finca', error);
                    });
            },
            actualizarUbicaciones() {
                this.ubicaciones = this.fincas[this.tarea.finca].ubicaciones || {};
                this.tarea.ubicacion = '';
                this.tarea.nomenclatura = '';
            },
            actualizarNomenclaturas() {
                this.nomenclaturas = this.ubicaciones[this.tarea.ubicacion] || [];
                this.tarea.nomenclatura = '';
            },
            restablecerFormulario() {
                this.tarea.idEmpleado = '';
                this.tarea.tipoTrabajoFinca = '';
                this.tarea.finca = '';
                this.tarea.ubicacion = '';
                this.tarea.nomenclatura = '';
                this.tarea.descripcion = '';
            }
        },
        mounted() {
            this.cargarDatos();
        }
    });
}

const appData = () => ({
    tarea: {
        idEmpleado: '',
        tipoTrabajoFinca: '',
        finca: '',
        ubicacion: '',
        nomenclatura: '',
        descripcion: ''
    },
    fincas: {},
    ubicaciones: {},
    nomenclaturas: []
});

const app = createVueApp(appData);
app.mount('#app');
