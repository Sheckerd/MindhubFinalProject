const app =

Vue.createApp({
    data() {
        return {
           
        }
    },


    created(){
           
        
    },

    methods:{
        

        logOut(){
            axios.post('/api/logout').then(response =>{
                window.location.href = '/web/index.html'
                console.log("DESLOGEAR")
            })
        }

    },

            
    computed: {
        

        }}).mount('#app') 