class adicionarSerie{
    constructor() {
        this.arraySerie = [];
        this.id=1;
    }

    salvar(){
        let serie = this.lerDados();
        if(this.validaCampos(serie)){
            this.adicionar(serie);
        }
        this.listarTabela();
        this.limpar();
    }

    listarTabela() {
        let tbody = document.getElementById('tbody');
        tbody.innerText='';

        for (let i = 0; i < this.arraySerie.length; i++) {
            let tr = tbody.insertRow();

            let td_serie = tr.insertCell();
            let td_quantidade = tr.insertCell();
            let td_repeticao = tr.insertCell();
            let td_acoes = tr.insertCell();

            td_serie.innerText = this.arraySerie[i].exercicio;
            td_quantidade.innerText = this.arraySerie[i].quantidade;
            td_repeticao.innerText = this.arraySerie[i].repeticoes;

            let imgExcluir = document.createElement('img');
            imgExcluir.src = 'img/excluir.png';
            imgExcluir.setAttribute("onclick","serieA.excluir("+this.arraySerie[i].id+")");


            td_acoes.appendChild(imgExcluir);
        }
    }
    adicionar(serie){
        this.arraySerie.push(serie);
        this.id++;
    }
    pegarSeries(){
        console.log(this.arraySerie);
        return this.arraySerie;
    }

    lerDados(){
        let serie = {}
        serie.id=this.id;
        serie.exercicio = document.getElementById('exercicio').value;
        serie.quantidade = document.getElementById('quantidade').value;
        serie.repeticoes = document.getElementById('repeticoes').value;
        return serie;
    }
    validaCampos(serie){
        let msg = '';
        if (serie.exercicio==''){
            msg += 'Campo exercicio esta vazio\n';
        }
        if (serie.quantidade==''){
            msg += 'Campo quantidade esta vazio\n';
        }
        if (serie.repeticoes==''){
            msg += 'Campo repetiçoes esta vazio\n';
        }
        if (msg!=''){
            alert(msg);
            return false;
        }
        return true;
    }
    limpar(){

        document.getElementById('exercicio').value='';
        document.getElementById('quantidade').value='';
        document.getElementById('repeticoes').value='';
    }
    excluir(id){
        let tbody = document.getElementById('tbody');
        for(let i = 0; i<this.arraySerie.length; i++){
            if (this.arraySerie[i].id==id){
                this.arraySerie.splice(i, 1);
                tbody.deleteRow(i);
            }
        }

    }


}
var serieA = new adicionarSerie();