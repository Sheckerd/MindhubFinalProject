Vue.createApp({
    data() {
        return {

            products: [],
            aux:[],
            search:""

        }
    },


    created() {
        axios.get(`/api/products`)
            .then(result => {
                this.products = result.data
                console.log(this.products)

            })
    },

    methods: {

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
        orderById() {
            this.products.sort(function (a, b) {
                return a.id - b.id
            })
        },
        searchProduct() {
            this.aux = []
            if (this.search != '') {
                this.aux.push(...this.products.filter(product => product.name.toLowerCase().includes(this.search.trim().toLowerCase())))
                console.log(this.aux)
            } else {
                this.aux = this.products
            }
        },
    }

}).mount('#app')