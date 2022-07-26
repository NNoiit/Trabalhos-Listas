//Pegadno os dados do tipo ALUNO no firestore
firebase.firestore().collection("user").where('tipo', '==', 'aluno').get().then((snapshot) =>{
    const users = snapshot.docs.map((doc) => ({...doc.data(), uid: doc.id}));

    mostraAlunos(users);
    
}).catch(error =>{
        console.log("erro" , error);
})

//função para criar as divs dos alunos no firestore
function mostraAlunos(aluno){

    aluno.forEach(aluno => {
        let bloco = document.querySelector('#alunos');
    
        let div = document.createElement('div');
        div.classList.add('bloco-cont');
        div.id = aluno.uid;

        //criando os botões
        let btnAlterar = document.createElement('button');
        btnAlterar.innerHTML = "Alterar";

        let btnExcluir = document.createElement('button');
        btnExcluir.innerHTML = "Excluir";

        btnExcluir.classList.add('btn-medio');
        btnAlterar.classList.add('btn-medio');

        div.innerHTML = `
            <h1>${aluno.nome}</h1>
            <h4>${aluno.email}</h4>
            <h4>${aluno.cpf}</h4>
        `
        div.appendChild(btnAlterar);
        div.appendChild(btnExcluir);

        bloco.append(div);

        //especificando o evento de click para o botão editar
        btnAlterar.addEventListener('click', () =>{
            window.location.href = "../cadastro.html?uid=" + aluno.uid;
        });

        //Exclui a div-usuario
        btnExcluir.addEventListener('click', (event) =>{
            event.stopPropagation();

            confirmDelet(aluno);
        });
    });

}

//função para deletar o aluno
function removerAluno(aluno){
    firebase.firestore().collection('user').doc(aluno.uid).delete().then(()=>{
        document.getElementById(aluno.uid).remove();
    })
}

//confirma o delete
function confirmDelet(aluno){
    const showRemover = confirm(`Deseja excluir o ${aluno.nome}`);

    if(showRemover){
        removerAluno(aluno);
    }
}
