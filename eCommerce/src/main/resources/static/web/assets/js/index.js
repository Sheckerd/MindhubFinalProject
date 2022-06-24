Vue.createApp({
    data() {
        return {
            products: [],
            productsLimitedEdition: []
        }
    },


    created(){
        axios.get(`/api/products`)
        .then(result =>{
            this.products = result.data.slice(0,10)
            console.log(this.products)

            //console.log(this.products[0].clothesSize)
           
            }
        )
    },

    methods:{
    },
    
    computed: {
        
        limitedEdition(){
            this.productsLimitedEdition = this.products.filter(product => product.limitedEdition).slice(0,6)
        }


    }



    }).mount('#app') 