var cpfGlobal;
firebase.auth().onAuthStateChanged(user =>{
    if(user){
        cpfGlobal = user;
        pegarInfoDB(cpfGlobal);  
    }
});


//pegando as informações do BD
function pegarInfoDB(email){

    firebase.firestore().collection("user").where("email", "==", email.email).get().then(snapshot =>{
        const users = snapshot.docs.map(doc => doc.data());

        //alterando o valor da variavel global para obter o cpf do usuario
        cpfGlobal = users[0].email;

    }).catch(error =>{
            console.log("erro" , error);
    })
}


//Motrando as aulas
firebase.firestore().collection("aulas").get().then((snapshot) =>{
    const aula = snapshot.docs.map((doc) => ({...doc.data(), uid: doc.id}));
    
    mostrarInscritas(aula);
}).catch(error =>{
        console.log("erro" , error);
})

function mostrarInscritas(aula){
    let cont = 1;
    let inscri;

    aula.forEach(aula => {
        inscri = aula.inscritos;

        if(inscri[cont] == cpfGlobal.email){
            let bloco = document.querySelector('.bloco-aula');
            let div = document.createElement('div');
            div.id = aula.uid;
            div.classList.add('bloco-cont');
        
            //criando os botões
            let btnCancelar= document.createElement('button');
            btnCancelar.innerHTML = "Cancelar";
            btnCancelar.classList.add('btn-medio');

            div.innerHTML = `
                <h1>${aula.aula}</h1>
                <h4>${aula.date}</h4>
                <h2>${aula.lotacao}</h2>
                `
            bloco.append(div);
            div.appendChild(btnCancelar);
        

            div.addEventListener('click', () =>{
                console.log("div clicada");
            })
            btnCancelar.addEventListener('click', () =>{
                cancelarAula(aula);
            });
        }
        cont++;
    });
    
}

function cancelarAula(aula){
    console.log(aula);
    let inscri = aula.inscritos;
    let cancelado = false;
    let numeroInscritos = aula.numeroInscritos-1;
    for(let i = 1; i <= aula.numeroInscritos; i++){
        if(inscri[i] == cpfGlobal){
            delete inscri[i];
            cancelado = true;
        }
    }

    if(cancelado == true){
        const dadosIn = {
            aula: aula.aula,
            descAula: aula.descAula,
            date: aula.date,
            numeroInscritos: numeroInscritos,
            lotacao: aula.lotacao,
            inscritos: inscri
    
        }
    
        firebase.firestore().collection("aulas").doc(aula.uid).update(dadosIn).then(() =>{
            console.log("removido");
            window.location.reload();
        }).catch(()=>{
            console.log("Falha ao remover");
        });
    }

}