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
            this.products = result.data.slice(0,9)
            console.log(this.products)

           
           
            }
        )
    },

    methods:{
    },
    
    computed: {
        
        limitedEdition(){
            this.productsLimitedEdition = this.products.filter(product => product.limitedEdition == true)
            this.productsLimitedEdition = this.productsLimitedEdition.slice(0,5)
        }


    }



    }).mount('#app') 