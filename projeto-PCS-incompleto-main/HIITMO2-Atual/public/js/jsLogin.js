firebase.auth().onAuthStateChanged(function(user){
    if(user){
        window.location.href = "../inicio.html";
    }
})

function login() {
    //obtendo os valores dos campos de login
    let email = document.querySelector("#login");
    let password = document.querySelector("#senhaLogin");

    //conferindo se o usuario existe no firebase
    firebase.auth().signInWithEmailAndPassword(email.value, password.value).then((userCredential) => {
        // logando se ele existe
        const user = userCredential.user;
        window.location.href = "../inicio.html";
        // ...
    })
    .catch((error) => {
        //alertando um erro se não
        alert("Erro");
        console.log("falho", error.code);
    });
}

//função para tratamento de erros
function erroLogin(error) {
    if(error.code == "auth/user-not-found"){
        return "Usuario não encontrado";
    }

    if(error.code == "auth/wrong-password"){
        return "Senha incorreta";
    }
    return error.message;
}


 