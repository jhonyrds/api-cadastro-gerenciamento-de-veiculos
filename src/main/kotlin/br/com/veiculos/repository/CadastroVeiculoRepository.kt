package br.com.veiculos.repository

import br.com.veiculos.model.Veiculo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CadastroVeiculoRepository: JpaRepository<Veiculo, Long> {
    fun findByUsuarioId(id: Long): List<Veiculo>
}
