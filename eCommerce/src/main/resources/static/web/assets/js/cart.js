Vue.createApp({
    data() {
        return {
            selected: '',
            products: [],
            showProduct: "",
            search: "",
            aux: [],
            storageCarrito: [],
            storageListID: [],
            subtotalCarrito: 0,
            storageLength: 0,
            subtotal:0,
            precioTotal:0,




        }
    },

    created() {


        // ALMACENAMOS EL ARRAY DEL CARRITO DE LA BASE DE DATOS EN MI JS
        let carrito
        carrito = JSON.parse(localStorage.getItem("cart"));
        // console.log(carrito);
        // SI NO EXISTE CAMBIAMOS EL UNDEFINED POR UN ARRAY VACIO PARA PODER TRABAJAR CON EL CARRITO
        if (!carrito) {
            this.storageCarrito = []
        }
        // SI EXISTE LO ALMACENAMOS EN STORAGECARRITO
        else {
            this.storageCarrito = carrito;
            // console.log(this.storageCarrito);
        }
        // ITERAMOS EL CARRITO Y DEFINIMOS LA SUMA DE LOS SUBTOTALES
        let total = 0;
        this.storageCarrito.forEach(producto => {
            total += producto.subtotal
            // console.log(total);
        });

        this.subtotalCarrito = total;
        // console.log(this.subtotalCarrito);
        this.storageLength = this.storageCarrito.length;
        console.log(this.subtotalCarrito);


        axios.get(`/api/products`)
            .then(result => {
                this.products = result.data
                // console.log(this.products)

                //console.log(this.products[0].clothesSize)

            })

        this.precioTotal = this.subtotalCarrito;
        console.log(this.precioTotal);

    },

    methods: {

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
                    console.log(nuevoProducto.subtotal);
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
                        this.faltaStock(producto.productType);
                    }
                }
            }
            agregarProductoAlCarrito(this.products)
            // LE SUMAMOS LA CANTIDAD
            this.actualizarSubtotal()
            // console.log(nuevoProducto.subtotal);
        },


        restarProducto(producto) {
            // GUARDAMOS AL PRODUCTO QUE SE QUIERE RESTAR UNA UNIDAD EN LA VARIABLE NUEVOPRODUCTO
            let nuevoProducto = producto;

            // LE SUMAMOS UNO AL STOCK Y ACTUALIZAMOS

            // SI HAY UN SOLO ELEMENTO EN EL CARRITO LLAMAMOS A LA FUNCION DE ELIMINAR PRODUCTO
            if (this.storageCarrito[this.storageCarrito.indexOf(nuevoProducto)].cantidad == 1) {
                this.eliminarProducto(nuevoProducto);
            }
            // SINO, LE RESTAMOS UNO A LA CANTIDAD, CALCULAMOS EL SUBTOTAL Y ACTUALIZAMOS EN LA BASE DE DATOS
            else {
                this.storageCarrito[this.storageCarrito.indexOf(nuevoProducto)].cantidad -= 1;
                this.storageCarrito[this.storageCarrito.indexOf(nuevoProducto)].subtotal = this.storageCarrito[this.storageCarrito.indexOf(nuevoProducto)].cantidad * this.storageCarrito[this.storageCarrito.indexOf(nuevoProducto)].price;
                this.storageCarrito[this.storageCarrito.indexOf(nuevoProducto)].stock += 1;

                const sacarProducto = (array) => {
                    let stockIndex = this.buscarProductoEnArray(producto.id, array);
                    array[stockIndex].stock = this.storageCarrito[this.storageCarrito.indexOf(nuevoProducto)].stock;
                }

                sacarProducto(this.products)


                localStorage.setItem("cart", JSON.stringify(this.storageCarrito));
            }
            this.actualizarSubtotal()
            // console.log(this.storageCarrito[this.storageCarrito.indexOf(nuevoProducto)].subtotal);

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
                text: `No hay suficiente stock de ese ${tipo == 'CLOTHES' ? 'producto' : "cosplay"}!`,
            })

        },

        eliminarProducto(producto) {
            // UTILIZAMOS SWEET ALERT PARA VERIFICAR SI ESTA SEGURO
            Swal.fire({
                title: 'Estas seguro?',
                text: "Se eliminara permanentemente!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Si, borralo!'
            }).then((result) => {

                // SI ES ASI PROCEDEMOS A ELIMINAR EL PRODUCTO CON EL SPLICE 
                if (result.isConfirmed) {

                    const eliminarProductoDelCarrito = (arrayOriginal) => {
                        let stockIndex = this.buscarProductoEnArray(producto.id, arrayOriginal);
                        arrayOriginal[stockIndex].stock += 1;
                    }
                    eliminarProductoDelCarrito(this.products)

                    this.storageCarrito.splice(this.storageCarrito.indexOf(producto), 1);
                    localStorage.setItem("cart", JSON.stringify(this.storageCarrito));
                    Swal.fire(
                        'Eliminado!',
                        'Su producto fue removido con exito',
                        'success'
                    )
                    this.actualizarSubtotal()
                    
                }
            })



        },

        redirigirse(){
            Swal.fire({
                text: "Para comprar debe logearse/registrarse",
                icon: 'warning',
                showDenyButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Ir a Login/Register',
                denyButtonText: "Ya ingresé"
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "/web/login-register.html";
                }
                else if(result.isDenied){
                    window.location.href = "/web/checkout.html"
                }
            })
        },



    },

    computed: {

        precioTotalCarrito(){
            this.precioTotal = this.subtotalCarrito;
            return this.precioTotal   
        }
    },








}).mount('#app')
var loader = document.getElementById("loader");

window.addEventListener("load", function () {

    setTimeout(() => {
        loader.style.display = "none";
    }, 30);

})