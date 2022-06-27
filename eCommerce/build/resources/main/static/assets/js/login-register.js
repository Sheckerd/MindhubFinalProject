const app =

Vue.createApp({
    data() {
        return {
            products: [],
            productsLimitedEdition: [],
            mail: "",
            password: "",


            nameRegister:"",
            lastNameRegister:"",
            emailRegister:"",
            passwordRegister:"",
            cellPhoneRegister:"",
        }
    },


    created(){
        

           
           
            
        
    },

    methods:{
        postLogin(){
            console.log(this.mail),
            console.log(this.password),
            axios.post('/api/login',`email=${this.mail}&password=${this.password}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
            .then(response => {
                

            window.location.href = '/web/shop.html'
            console.log('signed in!!!')
        })

        },
        postRegister(){
        axios.post('/api/clients',`name=${this.nameRegister}&lastName=${this.lastNameRegister}&email=${this.emailRegister}&password=${this.passwordRegister}&cellPhone=${this.cellPhoneRegister}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
         .then(response => {
                

            axios.post('/api/login',`email=${this.emailRegister}&password=${this.passwordRegister}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
            .then(response => {
                

            window.location.href = '/web/my-account.html'
            console.log('signed in!!!')  })})
        
        }
    },

            
    computed: {
        
        limitedEdition(){
           this.productsLimitedEdition = this.products.filter(product => product.limitedEdition == true)
            this.productsLimitedEdition = this.productsLimitedEdition.slice(0,5)
        },


        }}).mount('#app') 