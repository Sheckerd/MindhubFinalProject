Vue.createApp({
    data() {
        return {
            products: [],
            productsLimitedEdition: [],
            productsView: []
        }
    },


    created(){
        axios.get(`/api/products`)
        .then(result =>{
            this.products = result.data
            })

        axios.get(``)    
    },

    methods:{
        productSection(){
            this.productsView = this.products.slice(0,13)
        }

        

    },
    
    computed: {
        
        limitedEdition(){
            this.productsLimitedEdition = this.products.filter(product => product.limitedEdition == true)
            this.productsLimitedEdition = this.productsLimitedEdition.slice(0,5)
        }


    }



    }).mount('#app') 