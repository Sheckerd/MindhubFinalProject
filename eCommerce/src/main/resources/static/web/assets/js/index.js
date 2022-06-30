Vue.createApp({
    data() {
        return {
            products: [],
            productsLimitedEdition: [],
            productsView: [],
            selected: '',
            products: [],
            showProduct: "",
            search: "",
            aux: [],
            storageCarrito: [],
            storageListID: [],
            subtotalCarrito: 0,
            storageLength: 0,
            subtotal: 0,
            nombreMsj:'',
            emailMsj:'',
            cuerpoMsj:'',
            clients:[]
        }
    },


    created() {
        // axios.get(`/api/products`)
        //     .then(result => {
        //         this.products = result.data
        //     })

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

        axios.get(`/api/products`)
            .then(result => {
                this.products = result.data
                // console.log(this.products)

                //console.log(this.products[0].clothesSize)

            })

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
            agregarProductoAlCarrito(this.productsLimitedEdition)
            // LE SUMAMOS LA CANTIDAD
            this.actualizarSubtotal()
            Swal.fire(
                'Hecho',
                'Producto agregado al carrito',
                'success'
            )
        },


        agregarProductos(producto) {
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
                        this.faltaStock(producto.productType);
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
                text: `No hay suficiente stock de ese ${tipo == 'CLOTHES' ? 'producto' : "cosplay"}!`,
            })

        },

        mensajeEnviado() {


            if(this.nombreMsj != "" || this.cuerpoMsj != '' || this.emailMsj != "" || this.emailMsj.includes("@") || this.emailMsj.includes(".com")){

                Swal.fire({
                    position: 'center',
                    icon: 'success',
                    title: 'Gracias por su mensaje!',
                    showConfirmButton: false,
                    timer: 1000
                })
                setTimeout(function () {
                window.location.href = './contact.html'
                }, 1500)
            }   else{

                Swal.fire({
                    position: 'center',
                    icon: 'error',
                    title: 'Faltan datos!',
                    showConfirmButton: false,
                    timer: 1000
                })
                setTimeout(function () {
                    window.location.href = './contact.html'
                    }, 1500)
            }
        },

    },

    computed: {

        limitedEdition() {
            this.productsLimitedEdition = this.products.filter(product => product.limitedEdition === true)
            this.productsLimitedEdition = this.productsLimitedEdition.slice(0, 8)
        },


        productSection() {
            this.productsView = this.products.slice(0, 12)
        },


    }


}).mount('#app')

var loader = document.getElementById("loader");

window.addEventListener("load", function () {

    setTimeout(() => {
        loader.style.display = "none";
    }, 2000);

})