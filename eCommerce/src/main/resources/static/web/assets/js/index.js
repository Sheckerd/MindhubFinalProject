Vue.createApp({
    data() {
        return {
            products: [],
            productsLimitedEdition: [],
        }
    },


    created(){
        axios.get(`/api/products`)
        .then(result =>{
            this.products = result.data
            console.log(this.products)

            // console.log(this.products[0].clothesSize)
           
            }
        )
    },

    methods:{
        limitedEdition(){
            this.productsLimitedEdition = this.products.filter(){
                
            }
        }
    },

    computed: {



    }



    }).mount('#app') 