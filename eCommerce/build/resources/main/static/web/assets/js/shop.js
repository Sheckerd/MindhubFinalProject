Vue.createApp({
    data() {
        return {
            selected: '',
            products: [],
            showProduct: "",
            search:"",
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
            if(this.search != ''){
                this.aux.push(...this.products.filter(product => product.description.toLowerCase().includes(this.search.trim().toLowerCase())))
                console.log(this.aux)
                console.log(this.search.trim())
                console.log(this.selected)
                if(this.selected != ""){
                    if(this.selected == "Menor precio"){
                        this.aux.sort(function(a,b) {return a.price - b.price})
                    }if(this.selected == "Mayor precio"){
                        this.aux.sort(function(a,b) {return b.price - a.price})
                    }if(this.selected == "Menor stock"){
                        this.aux.sort(function(a,b) {return a.stock - b.stock})
                    }if(this.selected == "Mayor stock"){
                        this.aux.sort(function(a,b) {return b.stock - a.stock})
                    }
                }
            }else{
                this.aux = this.products
                if(this.selected != ""){
                    if(this.selected == "Menor precio"){
                        this.aux.sort(function(a,b) {return a.price - b.price})
                    }if(this.selected == "Mayor precio"){
                        this.aux.sort(function(a,b) {return b.price - a.price})
                    }if(this.selected == "Menor stock"){
                        this.aux.sort(function(a,b) {return a.stock - b.stock})
                    }if(this.selected == "Mayor stock"){
                        this.aux.sort(function(a,b) {return b.stock - a.stock})
                    }
                }
            }
            console.log(this.aux)
        },

       


    }



    }).mount('#app') 