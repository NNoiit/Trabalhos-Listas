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
        
        tipoUser(users[0].tipo);

        //alterando o valor da variavel global para obter o cpf do usuario
        cpfGlobal = users[0].email;

    }).catch(error =>{
            console.log("erro" , error);
    })
}


//Motrando as aulas
firebase.firestore().collection("aulas").get().then((snapshot) =>{
    const aula = snapshot.docs.map((doc) => ({...doc.data(), uid: doc.id}));
    
    mostraAula(aula);
}).catch(error =>{
        console.log("erro" , error);
})

function mostraAula(aula){

    //recurso temporario para testes
    let date = new Date();
    //fim
    aula.forEach(aula => {
    
        let bloco = document.querySelector('.bloco-inicio');
        let blocoLado = document.querySelector('.bloco-inicio-lado');
        let div = document.createElement('div');
        div.id = aula.uid;
        
        //criando os botões
        let btnInscrever= document.createElement('button');
        btnInscrever.innerHTML = "Inscrever";
        div.classList.add('bloco-cont');
        btnInscrever.classList.add('btn-medio');
        
        //recurso temporario
        let dataAtual = date.toLocaleDateString();
        let data = aula.date.split('-').reverse().join('/');
        //fim
        div.innerHTML = `
            <h1>${aula.aula}</h1>
            <h4>${data}</h4>
            <h2>${aula.lotacao}</h2>
        `

        if(data > dataAtual){
            bloco.append(div);
            div.appendChild(btnInscrever);
        } else if(data < dataAtual){
            blocoLado.append(div);
            
        }

        div.addEventListener('click', () =>{
            console.log("div clicada");
        })

        //
        btnInscrever.addEventListener('click', () =>{
            inscreverAula(aula);
        })
    });
}

function inscreverAula(aula){
    let inscricao = aula.inscritos;
    let maximo = aula.lotacao;
    let numeroInscritos = aula.numeroInscritos+1;

    if(maximo > numeroInscritos){
        let checkCPF = false;
        for(let i = 1; i <= numeroInscritos; i++){
            if(inscricao[i] == cpfGlobal){
                alert("Você já está inscrito nessa aula");
                checkCPF = true;
            }
        }
        if(checkCPF == false){
            inscricao[numeroInscritos] = cpfGlobal;

            console.log(inscricao);

            const dadosIn = {
                aula: aula.aula,
                descAula: aula.descAula,
                date: aula.date,
                numeroInscritos: numeroInscritos,
                lotacao: aula.lotacao,
                inscritos: inscricao

            }

        firebase.firestore().collection("aulas").doc(aula.uid).update(dadosIn).then(() =>{
            console.log("Inscrito");
        }).catch(()=>{
            console.log("Falha ao inscrever");
        });
        }
    }
}