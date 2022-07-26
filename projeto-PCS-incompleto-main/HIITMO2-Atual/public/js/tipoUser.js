function tipoUser(tipo){
    navUser(tipo);
}


function navUser(tipo){
    const barraNav = document.querySelector('#barra-nav');
    
    //Mostra o menu para gerente
    if(tipo == 'gerente'){
    
        barraNav.innerHTML = `
            <ul>
                <div class="gerente">
                    <li><img src="./img/icone-barra.png" alt="logo">
                    <li><a href="inicio.html">Inicio</a>
                    <li><a href="instrutores.html">Instrutores</a>
                    <li><a href="aluno.html">Alunos</a>
                    <li><a href="perfil.html">Perfil</a>
                </div>
            </ul>
        `
    }

    //Mostra o menu para instrutor
    if(tipo == 'instrutor'){

        barraNav.innerHTML = `
            <ul>
                <div class="instrutor">
                    <li><img src="./img/icone-barra.png" alt="logo">
                    <li><a href="inicio.html">Inicio</a>
                    <li><a href="serie-instrutor.html">Series</a>
                    <li><a href="aulas-instrutor.html">Aulas</a>
                    <li><a href="perfil.html">Perfil</a>
                </div>
            </ul>
        `
    }

    //Motra o menu para aluno
    if(tipo == 'aluno'){
        
        barraNav.innerHTML = `
            <ul>
                <div class="aluno">
                    <li><img src="./img/icone-barra.png" alt="logo">
                    <li><a href="inicio.html">Inicio</a>
                    <li><a href="serie-aluno.html">Series</a>
                    <li><a href="aulas-aluno.html">Aulas</a>
                    <li><a href="perfil.html">Perfil</a>
                </div>
            </ul>
        `
    }
}
