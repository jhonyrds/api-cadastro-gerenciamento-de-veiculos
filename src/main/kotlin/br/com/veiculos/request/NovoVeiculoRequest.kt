package br.com.veiculos.request

import br.com.veiculos.exception.CadastroException
import br.com.veiculos.model.Veiculo
import br.com.veiculos.repository.CadastroUsuarioRepository
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class NovoVeiculoRequest(
    @field:NotBlank val marca: String,
    @field:NotBlank val modelo: String,
    @field:Positive @field:Min(1990) val ano: Int,
    @field:NotNull val usuarioId: Long
) {

    fun toModel(usuarioRepository: CadastroUsuarioRepository): Veiculo? {
        val possivelUsuario = usuarioRepository.findById(usuarioId)
        if (possivelUsuario.isPresent) {
            return Veiculo(marca, modelo, ano, possivelUsuario.get())
        }
        return throw CadastroException("Usuário não cadastrado")
    }

}
