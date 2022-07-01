Vue.createApp({
    data() {
        return {
            MYPARAM: "",
            product: {},
            disabledbutton: true,
            category: "",
            newStock:"",

        }
    },

    created() {
        const URLPARAMS = new URLSearchParams(window.location.search)
        const MYPARAM = URLPARAMS.get(`id`)
        axios.get("/api/products/" + MYPARAM)
            .then(result => {
                this.product = result.data
                // console.log(this.product)

            })

    },

    methods: {
        ableEditButton() {
            this.disabledbutton = false
        },
        deleteProduct() {

            console.log(this.product.id)

            Swal.fire({
                title: `Estas seguro de eliminar el producto ${this.product.name} Codigo: ${this.product.id} ?`,
                icon: 'warning',
                showDenyButton: true,
                confirmButtonText: 'Eliminar',
                denyButtonText: `Cancelar`,
            }).then((result) => {

                if (result.isConfirmed) {
                    axios.patch('/api/products/status', `id=${this.product.id}`)
                        .then(res => {
                            Swal.fire(`Producto ${this.product.name}, codigo: ${this.product.id} Eliminado`, '', 'success')
                                .then(res => window.location.href = "/web/manager/admin.html", 5000)
                        })
                        .catch (error => {
                            Swal.fire(error.response.data)
                            // if(error.response.data == "Only administrators have permission" && error.response.status == 403 ) {
                            //     Swal.fire({
                            //         position: 'center',
                            //         icon: 'error',
                            //         title: "Erorr: Solo el administrador puede acceder",
                            //         showConfirmButton: false,
                            //     })
                            //     setTimeout(function () {
                            //         window.location.href = 'web/manager/admin.html'
                            //     }, 2000)
                            // }
                            // if(error.response.data == "Error: product doesn't exist" && error.response.status == 403 ) {
                            //     Swal.fire({
                            //         position: 'center',
                            //         icon: 'error',
                            //         title: "Erorr: El producto no existe",
                            //         showConfirmButton: false,
                            //     })
                            //     setTimeout(function () {
                            //         window.location.href = 'web/manager/admin.html'
                            //     }, 2000)
                            // }
                            // if(error.response.data == "Error: product is already disabled" && error.response.status == 403 ) {
                            //     Swal.fire({
                            //         position: 'center',
                            //         icon: 'error',
                            //         title: "Erorr: El producto ya se encuentra deshabilitado",
                            //         showConfirmButton: false,
                            //     })
                            //     setTimeout(function () {
                            //         window.location.href = 'web/manager/admin.html'
                            //     }, 2000)
                            // }
                     })
                } else if (result.isDenied) {
                    Swal.fire('Producto no eliminado', '', 'error')
                        .then(res => window.location.href = "#", 5000)
                }
            })
        },
        updateProduct(){
            Swal.fire({
                title: `Estas seguro de guardar lo cambios en el producto ${this.product.name} Codigo: ${this.product.id} ?`,
                icon: 'warning',
                showDenyButton: true,
                confirmButtonText: 'Guardar',
                denyButtonText: `Cancelar`,
            }).then((result) => {

                if (result.isConfirmed) {
                    axios.patch('/api/products/stock', `id=${this.product.id}&stock=${this.newStock}`)
                        .then(res => {
                            Swal.fire(`Producto ${this.product.name}, codigo: ${this.product.id} guardado`, '', 'success')
                                .then(res => window.location.href = "/web/manager/admin.html", 5000)
                        })
                        .catch (error => {
                            console.log(error)
                            Swal.fire(error.response.data)
                    })
                } else if (result.isDenied) {
                    Swal.fire('Cambios no guardados', '', 'error')
                        .then(res => window.location.href = "#", 5000)
                }
            })
        },

        logOut() {
            axios.post('/api/logout').then(response => {
                if (response.status === 200) {
                    const Toast = Swal.mixin({
                        toast: true,
                        position: 'top-end',
                        showConfirmButton: false,
                        timer: 2000,
                        timerProgressBar: true,
                        didOpen: (toast) => {
                            toast.addEventListener('mouseenter', Swal.stopTimer)
                            toast.addEventListener('mouseleave', Swal.resumeTimer)
                        }
                    })

                    Toast.fire({
                        icon: 'success',
                        title: 'Deslogueado con éxito'
                    })
                    setTimeout(function () {
                        window.location.href = "/web/index.html";
                    }, 2000)
                }
            })
        },

    },

    computed: {

    }

}).mount('#app')