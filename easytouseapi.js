const apikey="yourapikey"
const axios=require("axios");
const query = process.argv.slice(2).join(" ");
axios.get("http://www.omdbapi.com",{params:{
    apikey:apikey,
    s:query
}}).then(function (response) {
    //console.log(response.data);
    const movies=response.data.Search;
    if(movies==undefined){
        console.log("Nothing is found");
        return;
    }
    for(var i in movies){
       let  movie=movies[i]
       console.log(movie.Title);
       console.log(movie.Poster);
       console.log(movie.Year);
       console.log("*********");
    }
}).catch(function(error){
    console.log(error); //Can't return error. Nearly always return 200
    //Can't return 4??
})