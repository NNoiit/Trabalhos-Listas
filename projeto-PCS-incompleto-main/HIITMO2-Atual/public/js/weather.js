let weather = {
    "apiKey": "99ce5aeac67e5fb92e75f90af790239d",
    fetchWeather: function (city){
        fetch(
            "https://api.openweathermap.org/data/2.5/weather?q="
            + city
            + "&units=metric&appid="
            + this.apiKey
            + "&lang=pt_br"

        ).then((response) => {
            if (!response.ok) {
                alert("Tempo não encontrado");
                throw new Error("Tempo não encontrado");
            }
            return response.json();
        })
            .then((data) => this.displayWeather(data));

    },
    displayWeather: function (data){
        const { name } = data;
        const { icon, description } = data.weather[0];
        const { temp, humidity } = data.main;
        const { speed } = data.wind;
        console.log(name,icon,description,temp,humidity,speed);
        document.querySelector(".city").innerHTML="Tempo em " + name;
        document.querySelector(".icon").src="https://openweathermap.org/img/wn/" + icon + ".png";
        document.querySelector(".description").innerText = description;
        document.querySelector(".temp").innerText = temp + "°C";
        document.querySelector(".humidity").innerText =
            "Humidade: " + humidity + "%";
        document.querySelector(".wind").innerText =
            "Velocidade do vento: " + speed + " km/h";
        document.querySelector(".weather").classList.remove("carregando");
    }
};
weather.fetchWeather("Rio de Janeiro");