Vue.createApp({
    data() {
        return {
            category: "",
            name: "",
            description:"",
            clothesType:"",
            anime:"",
            color:"",
            price:0,
            size:"",
            stock:0,
            image:"",
            edL:false
        }
    },

    created(){
        
    },

    methods:{
        createProduct (){
            if( this.category == "0"){
                axios.post('/api/products/clothes',{name:this.name,  colors:this.color,
                                                    description:this.description,
                                                    imageURL_front:this.image,  imageURL_back:this.image,
                                                    animeTheme:this.anime,  clothesType:this.clothesType, 
                                                    limitedEdition:this.edL,
                                                    productType:this.category,
                                                    size:this.size,   stock:this.stock,
                                                    price:this.price
                })
                .then(response => {
                        Swal.fire( {
                            icon: 'success',
                            text: 'Producto Creado'
                        })
                        .then(res=> window.location.href = "/web/manager/admin.html", 5000)
                })
                .catch (error => {
                    console.log(error)
                    // Swal.fire({
                    //     icon:'error',
                    //     text: error.response.data,
                    //     footer: '<a href="./admin-create.html">Volver a intentar</a>'
                    // })
                })
            }if (this.category == "1") {
                axios.post('/api/products/cosplay',{
                    name:this.name,  
                    description:this.description,
                    imageURL_front:this.image, 
                    animeTheme:this.anime, 
                    limitedEdition:this.edL,
                    productType:this.category,
                    size:this.size,   stock:this.stock,
                    price:this.price
                }
            )
                .then(response => {
                        Swal.fire( {
                            icon: 'success',
                            text: 'Producto Creado'
                        })
                        .then(res=> window.location.href = "/web/manager/admin.html", 5000)
                })
                .catch (error => {
                    console.log(error)
                    // Swal.fire({
                    //     icon:'error',
                    //     text: error.response.data,
                    //     footer: '<a href="./admin-create.html">Volver a intentar</a>'
                    // })
                })
            }
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
    computed : {
        sizesList (){
            if(this.size.includes(",")){
                this.size = this.size.split(",").map(String)
            }else {
                this.size = this.size.split().map(String)
            }
            
        },

        colorList (){
            if(this.color.includes(",")){
                this.color = this.color.split(",").map(String)
            }else {
                this.color = this.color.split().map(String)
            }
            
        },
    }

    }).mount('#app')