Vue.createApp({
    data() {
        return {
            product:[],

        }
    },


    created() {

        axios.get('/api/products/cosplay')
        .then(results =>{
            this.product = results.data
            console.log(this.product);
        })

    },

    methods: {

    

    },

    computed: {


        

    }




}).mount('#app')
