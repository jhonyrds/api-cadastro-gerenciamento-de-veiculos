package br.com.veiculos.request

import br.com.veiculos.exception.CadastroException
import br.com.veiculos.model.DiaDoRodizio
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

        val ultimoNumeroDoAno = ultimoNumeroDoAno(ano)

        val diaDoRodizio = defineDiaDoRodizio(ultimoNumeroDoAno)

        val possivelUsuario = usuarioRepository.findById(usuarioId)

        if (possivelUsuario.isPresent) {
            return Veiculo(marca, modelo, ano, diaDoRodizio, possivelUsuario.get())
        }
        return throw CadastroException("Usuário não cadastrado")
    }

    private fun defineDiaDoRodizio(valor: Int): DiaDoRodizio {
        lateinit var diaDoRodizio: DiaDoRodizio
        when (valor) {
            0, 1 -> diaDoRodizio = DiaDoRodizio.SEGUNDA
            2, 3 -> diaDoRodizio = DiaDoRodizio.TERCA
            4, 5 -> diaDoRodizio = DiaDoRodizio.QUARTA
            6, 7 -> diaDoRodizio = DiaDoRodizio.QUINTA
            8, 9 -> diaDoRodizio = DiaDoRodizio.SEXTA
        }
        return diaDoRodizio
    }

    private fun ultimoNumeroDoAno(valor: Int): Int {
        val str: String = valor.toString()
        val n = str.substring(3)
        return n.toInt()
    }
}
