Vue.createApp({
    data() {
        return {
        MYPARAM :"",
        product: {},
        products:[],
        relProducts:[]
        }
    },

    created(){
        const URLPARAMS = new URLSearchParams(window.location.search)
        const MYPARAM= URLPARAMS.get(`id`)
        axios.get("/api/products/"+ MYPARAM)
        .then(result =>{
            this.product = result.data
            // console.log(this.product)

        })
        axios.get("/api/products")
        .then(result =>{
            this.products = result.data
            this.relProducts = this.products.filter(product =>this.product.animeTheme == product.animeTheme ).slice(0,10)
            console.log(this.relProducts)
        })
    },

    methods: {
        // relatedProducts(){
        //     // axios.get("/api/products")
        //     // .then(result =>{
        //     //     this.products = result.data
        //     // })
        //     // this.relProducts.push(...this.products.filter(product =>this.product.animeTheme == product.animeTheme ))
        //     // this.products.filter(product => {
        //         // this.product.animeTheme == product.animeTheme
        //         console.log(this.relProducts)
            
        // }
    }, 

    computed: {

    }

    }).mount('#app')