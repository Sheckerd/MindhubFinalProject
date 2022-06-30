const app =

Vue.createApp({
    data() {
        return {
            products: [],
            productsLimitedEdition: [],
            mail: "",
            password: "",


            nameRegister:"",
            lastNameRegister:"",
            emailRegister:"",
            passwordRegister:"",
            cellPhoneRegister:"",
            
            storageCarrito: [],
            storageListID: [],
            subtotalCarrito: 0,
            storageLength: 0,
            subtotal: 0,
            nombreMsj:'',
            emailMsj:'',
            cuerpoMsj:'',
        }
    },


    created(){
        
        let carrito
        carrito = JSON.parse(localStorage.getItem("cart"));
        // SI NO EXISTE CAMBIAMOS EL UNDEFINED POR UN ARRAY VACIO PARA PODER TRABAJAR CON EL CARRITO
        if (!carrito) {
            this.storageCarrito = []
        }
        // SI EXISTE LO ALMACENAMOS EN STORAGECARRITO
        else {
            this.storageCarrito = carrito;
        }
        // ITERAMOS EL CARRITO Y DEFINIMOS LA SUMA DE LOS SUBTOTALES
        let total = 0;
        this.storageCarrito.forEach(producto => {
            total += producto.subtotal
        });

        this.subtotalCarrito = total;
        this.storageLength = this.storageCarrito.length;
           
           
            
        
    },

    methods:{


        postLogin(){
            axios.post('/api/login',`email=${this.mail}&password=${this.password}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
            .then(response => {  
                if (response.status === 200) {
                    const Toast = Swal.mixin({
                        toast: true,
                        position: 'top-end',
                        showConfirmButton: false,
                        timer: 3000,
                        timerProgressBar: true,
                        didOpen: (toast) => {
                            toast.addEventListener('mouseenter', Swal.stopTimer)
                            toast.addEventListener('mouseleave', Swal.resumeTimer)
                        }
                    })
                    Toast.fire({
                        icon: 'success',
                        title: 'Logueado con éxito'
                    })
                    if (this.mail.includes("admin")){
                    setTimeout(function () {
                        window.location.href = "/web/manager/admin.html";
                    }, 2000)
                    } else {
                        setTimeout(function () {
                            window.location.href = "/web/checkout.html";
                        }, 2000)
                    }
                }
        }).catch(function (error) {
            if (error.response.status == 401) {
                Swal.fire({
                    position: 'center',
                    icon: 'error',
                    title: "Problema al autenticarse: email o password incorrectos",
                    showConfirmButton: true,
                })
            }
        })
        },


        postRegister(){
        axios.post('/api/clients',`name=${this.nameRegister}&lastName=${this.lastNameRegister}&email=${this.emailRegister}&password=${this.passwordRegister}&cellPhone=${this.cellPhoneRegister}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
        .then(response => {
            if (response.status === 201) {
                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Registrado con éxito. Ingresando',
                    showConfirmButton: false,
                    timer: 1500
                })
            }
        }).then(result =>{
            axios.post('/api/login',`email=${this.emailRegister}&password=${this.passwordRegister}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
            .then(response => {
                    if (this.mail.includes("admin")){
                    setTimeout(function () {
                        window.location.href = "/web/manager/admin.html";
                    }, 2000)
                    } else {
                        setTimeout(function () {
                            window.location.href = "/web/checkout.html";
                        }, 2000)
                } 
        })
        }).catch(function (error) {
            if (error.response.data == "Missing data: name is empty" && error.response.status == 403) {
                Swal.fire({
                    position: 'center',
                    icon: 'warning',
                    title: 'Error al registrarse: Falta ingresar el nombre',
                    showConfirmButton: true,
                })
            }
            if (error.response.data == "Missing data: last name is empty" && error.response.status == 403) {
                Swal.fire({
                    position: 'center',
                    icon: 'warning',
                    title: 'Error al registrarse: Falta ingresar el apellido',
                    showConfirmButton: true,
                })
            }
            if (error.response.data == "Missing data: email is empty" && error.response.status == 403) {
                Swal.fire({
                    position: 'center',
                    icon: 'warning',
                    title: 'Error al registrarse: Falta ingresar el email',
                    showConfirmButton: true,
                })
            }
            if (error.response.data == "Missing data: password is empty" && error.response.status == 403) {
                Swal.fire({
                    position: 'center',
                    icon: 'warning',
                    title: 'Error al registrarse: Falta ingresar la contraseña',
                    showConfirmButton: true,
                })
            }
            if (error.response.data == "Missing data: cell phone is empty" && error.response.status == 403) {
                Swal.fire({
                    position: 'center',
                    icon: 'warning',
                    title: 'Error al registrarse: Falta ingresar número de contacto',
                    showConfirmButton: true,
                })
            }
            if (error.response.data == "The email is not valid" && error.response.status == 403) {
                Swal.fire({
                    position: 'center',
                    icon: 'warning',
                    title: 'Error al registrarse: El mail no es válido',
                    showConfirmButton: true,
                })
            }
            if (error.response.data == "Name already in use" && error.response.status == 403) {
                Swal.fire({
                    position: 'center',
                    icon: 'warning',
                    title: 'Error al registrarse: El mail ya está en uso',
                    showConfirmButton: true,
                })
            }
            if (error.response.data == "Password to short: At least 6 characters" && error.response.status == 403) {
                Swal.fire({
                    position: 'center',
                    icon: 'warning',
                    title: 'Error al registrarse: La contraseña debe tener al menos 6 caracteres',
                    showConfirmButton: true,
                })
            }
            if (error.response.data == "Password to long: cannot be longer than 15 characters" && error.response.status == 403) {
                Swal.fire({
                    position: 'center',
                    icon: 'warning',
                    title: 'Error al registrarse: La contraseña no puede tener mas de 15 caracteres',
                    showConfirmButton: true,
                })
            }
            if (error.response.data == "The email is not valid" && error.response.status == 403) {
                Swal.fire({
                    position: 'center',
                    icon: 'warning',
                    title: 'Error al registrarse: El mail no es válido',
                    showConfirmButton: true,
                })
            }
        })
        
        },


        agregarProducto(producto) {
            // GUARDAMOS AL PRODUCTO QUE SE QUIERE AGREGAR EN LA VARIABLE NUEVOPRODUCTO
            let nuevoProducto = producto

            // GUARDAMOS TODOS LOS ID DE MI CARRITO DE LA BASE DE DATOS PARA COMPROBAR
            // SI YA EXISTE ALGUN PRODUCTO CON ESE ID EN NUESTRO CARRITO
            this.storageListID = this.storageCarrito.map(element => element.id)

            const agregarProductoAlCarrito = (array) => {

                if (!this.storageListID.includes(nuevoProducto.id)) {
                    // SI NO EXISTE:
                    // LE AGREGAMOS LA PROPIEDAD CANTIDAD 
                    nuevoProducto.cantidad = 1;
                    // LE QUITAMOS AL ARRAY STOCKS (EN EL ELEMENTO QUE CORRESPONDE) UNA UNIDAD
                    let productoIndex = this.buscarProductoEnArray(producto.id, array);
                    nuevoProducto.stock -= 1;
                    nuevoProducto.subtotal = nuevoProducto.cantidad * nuevoProducto.price;
                    // PUSHEAMOS EL NUEVO PRODUCTO AL ARRAY EN MI JS
                    this.storageCarrito.push(nuevoProducto);
                    // ACTUALIZAMOS EN LA BASE DE DATOS NUESTRO ARRAY
                    array[productoIndex].stock = nuevoProducto.stock;
                    localStorage.setItem("cart", JSON.stringify(this.storageCarrito));
                    this.actualizarSubtotal();
                } else {
                    // SI YA EXISTE, DEFINIMOS EL PRODUCTO EXISTENTE EN BASE AL ID DEL PRODUCTO TOCADO
                    // PERO USANDO EL PRODUCTO DE LA BASE DE DATOS

                    let productoExistente = this.storageCarrito[this.buscarProducto(nuevoProducto.id)]
                    // LE RESTAMOS EL STOCK Y LO ACTULIZAMOS EN LA BASE DE DATOS


                    let stockIndex = this.buscarProductoEnArray(producto.id, array);
                    console.log("Posicion en stock: " + stockIndex);
                    if (productoExistente.stock != 0) {
                        productoExistente.cantidad += 1;
                        productoExistente.stock -= 1;
                        productoExistente.subtotal = productoExistente.cantidad * productoExistente.price;
                        array[stockIndex].stock = productoExistente.stock;
                        localStorage.setItem("cart", JSON.stringify(this.storageCarrito));
                    } else {
                        this.faltaStock();
                    }
                }
            }
            agregarProductoAlCarrito(this.productsView)
            // LE SUMAMOS LA CANTIDAD
            this.actualizarSubtotal()
            Swal.fire(
                'Hecho',
                'Producto agregado al carrito',
                'success'
            )
        },


        actualizarSubtotal() {
            let total = 0;
            this.storageCarrito.forEach(producto => {
                total += producto.subtotal
            });
            this.subtotalCarrito = total;
            this.storageLength = this.storageCarrito.length;
            // console.log("length: " + this.storageLength);
        },

        // AL TOCAR VACIAR CARRITO SETEAMOS EL ARRAY EN []

        buscarProductoEnArray(id, array) {
            for (var i = 0; i < array.length; i++) {
                if (array[i].id == id) {
                    return i;
                }
            }
            return -1;
        },
        // ITERAMOS SOBRE EL ARRAY BUSCANDO LA POSICION EN LA QUE EL ID QUE LE PASAMOS COINCIDA CON
        //  ALGUN ID QUE HAYA EN EL CARRITO, SI ENCUENTRA DEVUELVE EL INDICE, SI NO UN -1

        buscarProducto(id) {
            for (var i = 0; i < this.storageCarrito.length; i++) {
                if (this.storageCarrito[i].id == id) {
                    return i;
                }
            }
            return -1;
        },

        faltaStock(tipo) {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: `No hay suficiente stock de ese ${tipo}!`,
            })

        },

    },

            
    computed: {
        
        


        }}).mount('#app') 