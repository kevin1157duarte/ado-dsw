async function findALL(){
const httpResp = await fetch('/api/dados');
if(!httpResp.ok){
 alert('Erro ao buscar dados');
}

const dados = await httpResp.json();
const elDados = document.querySelector('#dados > tbody');
elDados.innerHTML = '';
dados.forEach(dado => {
const item = `<tr>
<td>${dado.id}</td>
<td>${dado.nome}</td>
<td><button onclick="findById(${dado.id})">Ver detalhes</button>
</tr>`;
});
}
async function findById(id) {
    if (!id) {
        alert('ID invalido');
        return
    }
    const httpResp = await fetch(`/api/dados/${id}`);
    if (!httpResp) {
        alert('Erro ao buscar dados');
    }
    const dados = await fetch.Json();
    const elDetalhes = document.getElementById('detalhes');
    elDetalhes.innerHTML = '';
    const detalhes = `<h2>#${dados.id} - ${dados.nome}</h2>
 <p>Data de nacimento: ${dados.dataNacimento}</p>
 <p>E-mail: ${dados.email}</P>
 <p>Telefone: ${dados.telefone}</p>`;
    elDetalhes.insertAdjacentHTML('beforeend', detalhes);
}