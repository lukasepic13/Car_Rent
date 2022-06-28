Vue.createApp({
  data() {
    return {
      parking: {
        id: 0,
        address: "",
        city: ""
      },
      parkings: []
    }
  },
  methods: {
    onInputName(e){
      this.parking.name = e.target.value
    },
    writeParkingsToConsole(){
      console.log(this.parkings)
    },
    addParking(){
      axios
      .post("http://localhost:8080/Parking/createParking", this.parking)
      .catch(function (error) {
        console.log(error);
      });
      this.parkings.push(JSON.parse(JSON.stringify(this.parkings)));
    },
    deleteParking(pid){
      axios
      .delete("http://localhost:8080/Parking/deleteParking/"+pid)
      .catch(function (error) {
        console.log(error);
      });

      let i=0;
      while(i<this.parkings.length){
        if(this.parkings[i].id===pid){
          this.parkings.splice(i,1);
          break;
        }else{
          i++;
        }
      }
    },
   
    updateParkings(){
      axios
      .put("http://localhost:8080/UpdateParking/", this.parking)
      .catch(function (error) {
        console.log(error);
      });
      let i=0;
      while(i<this.parkings.length){
        if(this.parkings[i].id===this.parking.id){
          this.parkings[i] = this.parking;
          break;
        }else{
          i++;
        }
      }
      this.parking = {};
    }

  },
  mounted: function() {
    axios
    .get('http://localhost:8080/Parking/getAllParkings')
    .then(response => (this.parkings = response.data))
    .catch(function (error) {
      console.log(error);
    });
  }
}).mount("#parking")
