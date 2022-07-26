//pegando das aulass no db
firebase.firestore().collection("aulas").get().then((snapshot) =>{
    const aula = snapshot.docs.map((doc) => ({...doc.data(), uid: doc.id}));
    
    mostraAula(aula);

}).catch(error =>{
        console.log("erro" , error);
})

//pegando o formAula de aula
const formAula = document.querySelector("[id=form-aula]");

//passando para a pagina de cadastro de aula
formAula.addEventListener('submit', (event)=>{

    event.preventDefault();

    let aula = formAula.aula.value, descAula = formAula.descricao-aula.value, date = formAula.date.value, lotacao = formAula.lotacao.value;
    uid = formAula.uid.value;
    
    
    const dados = {
        aula: aula,
        descAula: descAula,
        date: date,
        lotacao: lotacao,
        numeroInscritos: 0,
        inscritos: inscritos = {}
    }
    cadastraAula(dados, uid);
})

//Função para checar a data
function verificaData(){
    let date = new Date();
    let dataNova = ducument.getElementById('date').value;
    let dataAtual = date.toLocaleDateString();
    let dataExistente;

    firebase.firestore().collection("aulas").get().then((snapshot) =>{
        const aula = snapshot.docs.map((doc) => ({...doc.data(), uid: doc.id}));
        dataExistente = aula;
    })

    dataExistente.forEach(dataExist =>{
        
        if(dataNova == dataExist.data){
            console.log("data já está vaga");
        }
    })

    if(dataNova < dataAtual){
        console.log("esta data já passou");
    }
    
    
    console.log(date.toLocaleDateString());
}

//FUNÇÕES PARA CRIAR AS aula NO .BLOCO-aula
function mostraAula(aula, tipo){

    //temporario
    let date = new Date();
    console.log(date.toLocaleDateString());
    ////
    aula.forEach(aula => {
    
        let bloco = document.querySelector('.bloco-aula');
        let div = document.createElement('div');
        div.id = aula.uid;
        
        //criando os botões
        let btnAlterar = document.createElement('button');
        btnAlterar.innerHTML = "Alterar";

        let btnExcluir = document.createElement('button');
        btnExcluir.innerHTML = "Excluir";

        //nomeando os botões com classes
        div.classList.add('bloco-cont');
        btnExcluir.classList.add('btn-medio');
        btnAlterar.classList.add('btn-medio');

        //temporario
        let data = aula.date.split('-').reverse().join('/');
        //

        div.innerHTML = `
            <h1>${aula.aula}</h1>
            <h4>${data}</h4>
            <h2>${aula.lotacao}</h2>
        `
        bloco.append(div);
        div.appendChild(btnAlterar);
        div.appendChild(btnExcluir);

        if(date.toLocaleDateString() > data){
            div.style.background = "#808080";
            div.removeChild(btnAlterar);
            div.removeChild(btnExcluir);
        }
        

        //especificando o evento de click para o botão editar
        btnAlterar.addEventListener('click', () =>{
            document.getElementsByClassName("bloco-aula")[0].style.display = 'none';

            document.getElementById("div-form-aula").style.display = 'block';

            pegarDadoAula(aula.uid);
        });

        //Exclui a div-usuario
        btnExcluir.addEventListener('click', (event) =>{
            event.stopPropagation();

            confirmDelet(aula);
        });
    });

}

//Função para cadastra aula
function cadastraAula(dados, uid){
    if(uid == "null"){

        firebase.firestore().collection('aulas').add(dados).then(() =>{
            console.log("cadastrada");
            window.location.reload();
        }).catch(()=>{
            console.log("falhou1");
        });
    } else {
        firebase.firestore().collection('aulas').doc(uid).update(dados).then(() =>{
            console.log("atualizada");
            window.location.reload();
        }).catch(()=>{
            console.log("falhou2");
        });
    }
}

//Função para pegar os dado no db apartir do uid
function pegarDadoAula(uid){
    firebase.firestore().collection("aulas").doc(uid).get().then(doc =>{

        if(doc.exists){
            preencherAula(doc.data(), uid);
        }else{
            console.log("Não existe");
            window.location.href = "../../aula-instrutores.html";
        }
    }).catch(error =>{
            console.log("erro" , error);
    }
    )
}


//função para preenchimendo do formAula no caso de alteração
function preencherAula(dados, uid){
    document.getElementById("aula").value = dados.aula;
    document.getElementById("descAula").value = dados.descAula;
    document.getElementById("date").value = dados.date;
    document.getElementById("lotacao").value = dados.lotacao;
    document.getElementById("uid").value = uid;
}

//funções para deletar a aula selecionada
function removerAula(aula){
    firebase.firestore().collection('aulas').doc(aula.uid).delete().then(()=>{
        document.getElementById(aula.uid).remove();
        window.location.reload();
    })
}

//confirma o delete
function confirmDelet(dado){
    console.log(dado);
    const showRemover = confirm(`Deseja excluir o ${dado.aula}`);

    if(showRemover){
        removerAula(dado);
    }
}

//Evento do botão que leva para o formAula de adicionar no bd
document.getElementById("btn-novaAula").onclick = function() {
    let divaula = document.getElementsByClassName("bloco-aula");
    divaula[0].style.display = 'none';

    let divPrincipal = document.getElementById("div-form-aula");
    divPrincipal.style.display = 'block';
}