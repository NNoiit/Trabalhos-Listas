//pegando as series no db
firebase.firestore().collection("series").get().then((snapshot) =>{
    const serie = snapshot.docs.map((doc) => ({...doc.data(), uid: doc.id}));
    
    mostraSerie(serie);

}).catch(error =>{
        console.log("erro" , error);
})

//pegando o form de serie
const form = document.querySelector("[id=form-serie]");

//passando para a pagina de cadastro de serie
function verificaSerie(series){

    let cpf = form.cpf.value, serie = form.serie.value,
    uid = form.uid.value, exercicio, quantidade, repeticoes, ficha = {}, cont = 0;

    console.log(cpf, serie, uid);
    series.forEach(series => {
        exercicio = series.exercicio, quantidade = series.quantidade, repeticoes = series.repeticoes;

        ficha[cont] = {exercicio, quantidade, repeticoes};
        cont++;
    })
    if(cpf != "" || serie != ""){
        if(uid == "null"){
            const dados = {
                cpf: cpf,
                serie: serie,
                ficha: ficha
            }
            cadastraSerie(dados, uid);
        } else {
            const dados = {
            serie: serie,
            ficha: ficha
            }
            cadastraSerie(dados, uid);
        }
    } else{
        alert("Preencha todos os campos");
    }
}

//mostra a series
function mostraSerie(serie, tipo){
    
    let linha;
    serie.forEach(fichas => {

        let bloco = document.querySelector('.bloco-serie');
        let div = document.createElement('div');
        div.id = serie.uid;
        
        //criando os botões
        let btnAlterar = document.createElement('button');
        btnAlterar.innerHTML = "Alterar";

        let btnExcluir = document.createElement('button');
        btnExcluir.innerHTML = "Excluir";

        div.classList.add('bloco-cont');
        btnExcluir.classList.add('btn-medio');
        btnAlterar.classList.add('btn-medio');
        

        div.innerHTML = `
            <h1>${fichas.serie}</h1>
            <h1>${fichas.cpf}</h1>
        `
        
        bloco.append(div);
        div.appendChild(btnAlterar);
        div.appendChild(btnExcluir);
        

        //especificando o evento de click para o botão editar
        btnAlterar.addEventListener('click', () =>{
            document.getElementsByClassName("bloco-serie")[0].style.display = 'none';

            document.getElementById("div-form-serie").style.display = 'block';

            pegarDadoSerie(serie.uid);
        });

        //Exclui a div-usuario
        btnExcluir.addEventListener('click', (event) =>{
            event.stopPropagation();

            confirmDelet(serie);
        });
    
    });

}

//checa se o cpf existe e cadastra serie
function cadastraSerie(dados, uid){
    
    firebase.firestore().collection('user').where('cpf', '==', cpf.value).get().then((snapshot) =>{
        const user = snapshot.docs.map((doc) => doc.data());
        if(user.length > 0){

            if(uid == "null"){

                firebase.firestore().collection('series').add(dados).then(() =>{
                    console.log("nava serie cadastrada");
                    window.location.reload();
                }).catch(()=>{
                    console.log("falha ao cadastrar nova serie");
                });
            } else {
                firebase.firestore().collection('series').doc(uid).update(dados).then(() =>{
                    console.log("seire atualizada");
                    window.location.reload();
                }).catch(()=>{
                    console.log("falha ao atualizar serie");
                });
            }

        }else{
            console.log("cpf não cadastrado");
            return true;
        }
    })

}

//função para pegar os dados no db apartir do uid
function pegarDadoSerie(uid){

    firebase.firestore().collection("series").doc(uid).get().then(doc =>{

        if(doc.exists){
            preencherSerie(doc.data(), uid);
        }else{
            console.log("Não existe");
            window.location.href = "../../serie-instrutores.html";
        }
    }).catch(error =>{
            console.log("erro" , error);
    }
    )
}

//funções de preenchimento de form
function preencherSerie(dados, uid){
    document.getElementById("cpf").value = dados.cpf;
    document.getElementById("cpf").disabled = true;
    document.getElementById("serie").value = dados.serie;
    document.getElementById("uid").value = uid;

    let tbody = document.getElementById('tbody');
    tbody.innerText='';
    let info = dados.ficha;
    let i = 0;

        info.forEach(arraySerie =>{
            let tr = tbody.insertRow();

        let td_serie = tr.insertCell();
        let td_quantidade = tr.insertCell();
        let td_repeticao = tr.insertCell();
        let td_acoes = tr.insertCell();

        td_serie.innerText = arraySerie.exercicio;
        td_quantidade.innerText = arraySerie.quantidade;
        td_repeticao.innerText = arraySerie.repeticoes;

        let imgExcluir = document.createElement('img');
        imgExcluir.src = 'img/excluir.png';
        imgExcluir.setAttribute("onclick","serieA.excluir("+delete arraySerie+")");
        
        td_acoes.appendChild(imgExcluir);
        i++
        })
    


}
//funções para deletar a serie selecionada
function removerSerie(serie){
    firebase.firestore().collection('series').doc(serie.uid).delete().then(()=>{
        document.getElementById(serie.uid).remove();
        window.location.reload();
    })
}

//confirma o delete
function confirmDelet(dado){
    console.log(dado);
    const showRemover = confirm(`Deseja excluir o ${dado.serie}`);

    if(showRemover){
        removerSerie(dado);

    }
}

//EVENTOS DO BOTOES DE SERIES/AULAS
document.getElementById("btn-novaSerie").onclick = function() {
    let divSerie = document.getElementsByClassName("bloco-serie");
    divSerie[0].style.display = 'none';

    let divPrincipal = document.getElementById("div-form-serie");
    divPrincipal.style.display = 'block';
}

//document.getElementById().onclick = cadastrarSerie();