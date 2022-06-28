Vue.createApp({
  data() {
    return {
      owner: {
        id: 0,
        name: "",
        lastname: ""
      },
      owners: []
    }
  },
  methods: {
    onInputName(e){
      this.owner.name = e.target.value
    },
    writeOwnersToConsole(){
      console.log(this.owners)
    },
    addOwner(){
      axios
      .post("http://localhost:8080/Owner/createOwner", this.owner)
      .catch(function (error) {
        console.log(error);
      });
      this.owners.push(JSON.parse(JSON.stringify(this.owners)));
    },
    deleteOwner(pid){
      axios
      .delete("http://localhost:8080/Owner/deleteOwner/"+pid)
      .catch(function (error) {
        console.log(error);
      });

      let i=0;
      while(i<this.owners.length){
        if(this.owners[i].id===pid){
          this.owners.splice(i,1);
          break;
        }else{
          i++;
        }
      }
    },
      populateRow(c){
      this.owner = JSON.parse(JSON.stringify(c));
    },
    updateOwners(){
      axios
      .put("http://localhost:8080/Owner/UpdateOwner/", this.owner)
      .catch(function (error) {
        console.log(error);
      });
      let i=0;
      while(i<this.owners.length){
        if(this.owners[i].id===this.owner.id){
          this.owners[i] = this.owner;
          break;
        }else{
          i++;
        }
      }
      this.owner = {};
    }

  },
  mounted: function() {
    axios
    .get('http://localhost:8080/Owner/getAllOwners')
    .then(response => (this.owners = response.data))
    .catch(function (error) {
      console.log(error);
    });
  }
}).mount("#owner")

