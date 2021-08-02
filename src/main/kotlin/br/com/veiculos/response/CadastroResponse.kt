package br.com.veiculos.response

import br.com.veiculos.model.Usuario

class CadastroResponse(novoUsuario: Usuario) {
    val id = novoUsuario.id
}
