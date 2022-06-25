Vue.createApp({
    data() {
        return {
            products: [],
            showProduct: "",
            search:"",
            sort:"",
            aux:[]
           
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

        // showProductsSelect(){

        //     console.log(this.showProduct)

        //     // if(this.showProducts == 8){
        //     //     this.products.slice(0,9)
        //     // }if(this.showProducts == 12){
        //     //     this.products.slice(0,13)
        //     // }if(this.showProducts == 16){
        //     //     this.products.slice(0,21)
        //     // }else{
        //     //     this.products.slice(0,21)
        //     // }
        // },

        searchProduct(){
           this.aux = []
        //    this.products = result.data
            if(this.search != ''){
                // this.products.filter(product =>  product.description.toLowerCase().includes(this.search.trim().toLowerCase()))
                this.aux.push(...this.products.filter(product => product.description.toLowerCase().includes(this.search.trim().toLowerCase())))
                console.log(this.aux)
                // console.log(this.aux)
                // console.log(this.products)
                console.log(this.search.trim())
            }else{
                this.aux = this.products
            }
        },

        //  sortBy(){

        //     console.log(this.sort)

        // //     // let aux = []
        // //     if(this.sort != ""){
        // //         if(this.sort == "minPrice"){
        // //             this.products.sort(function(a,b) {return a.price - b.price})
        // //         }if(this.sort == "maxPrice"){
        // //             this.products.sort(function(a,b) {return b.price - a.price})
        // //         }if(this.sort == "minStock"){
        // //             this.products.sort(function(a,b) {return a.stock - b.stock})
        // //         }if(this.sort == "maxStock"){
        // //             this.products.sort(function(a,b) {return a.stock - b.stock})
        // //         }
        // //     }
        // }


    }



    }).mount('#app') 