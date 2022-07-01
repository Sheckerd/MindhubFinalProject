Vue.createApp({
    data() {
        return{

        }

    },

    created(){

        


    },

    methods: {
        pdfGenerate(){
            axios.get("/api/invoices/createPDF",{'responseType':'blob'})
            .then((response) => {
              const url = window.URL.createObjectURL(new Blob([response.data]));
              const link = document.createElement('a');
              link.href = url;
              link.setAttribute('download', "Origami_Invoice.pdf"); //or any other extension
              document.body.appendChild(link);
              link.click();
            })
        }

    }, 
    
    computed: {

    }

    }).mount('#app')
    var loader = document.getElementById("loader");

window.addEventListener("load", function () {

    setTimeout(() => {
        loader.style.display = "none";
    }, 30);

})