Vue.createApp({
    data() {
        return {
            products: [],
            showProducts: 8,
           
        }
    },


    created(){
        axios.get(`/api/products`)
        .then(result =>{
            this.products = result.data
            console.log(this.products)

            //console.log(this.products[0].clothesSize)
           
            }
        )
    },

    methods:{
    },
    
    computed: {

        showProductsSelect(){
            if(this.showProducts == 8){
                this.products.slice(0,9)
            }if(this.showProducts ==12){
                this.products.slice(0,13)
            }if(this.showProducts ==16){
                this.products.slice(0,21)
            }els{
                this.products.slice(0,21)
            }
        }


    }



    }).mount('#app') 