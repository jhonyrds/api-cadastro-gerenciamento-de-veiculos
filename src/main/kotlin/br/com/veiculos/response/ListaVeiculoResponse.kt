package br.com.veiculos.response

import br.com.veiculos.model.Veiculo
import br.com.veiculos.model.converte
import java.time.LocalDate

class ListaVeiculoResponse(veiculo: Veiculo) {
    val proprietarioId = veiculo.id
    val marca = veiculo.marca
    val modelo = veiculo.modelo
    val ano = veiculo.ano
    val rodizio = veiculo.diaDeRodizio
    val rodizioAtivo: Boolean = verificaRodizioAtivo(converte(rodizio))

    private fun verificaRodizioAtivo(dia: String): Boolean {
        val d = LocalDate.now().dayOfWeek.toString()
        if (d == dia) {
            return true
        }
        return false
    }
}
