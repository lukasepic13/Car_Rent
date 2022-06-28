Vue.createApp({
  data() {
    return {
      car: {
        id: 0,
        brand: "",
        model: "",
        registration: "",
        o:{},
        p:{},
      },
      o: [],
      p: [],
      cars: []
    }
  },
  methods: {
    readCars(){
      axios
      .get('http://localhost:8080/Cars/getAllCars')
      .then(response => (this.car = response.data))
      .catch(function (error) {
        console.log(error);
      });
    },
    addCar(){
      axios
      .post("http://localhost:8080/Cars/createCars", this.car)
      .catch(function (error) {
        console.log(error);
      });
      this.car.push(JSON.parse(JSON.stringify(this.car)));
    }
  },
    populateRow(car){
      this.p = JSON.parse(JSON.stringify(car));
    },
  mounted: function() {
    axios
    .get('http://localhost:8080/Parking/getAllParkings')
    .then(response => (this.p = response.data))
    .catch(function (error) {
      console.log(error);
    });
  }   
}).mount("#car")

