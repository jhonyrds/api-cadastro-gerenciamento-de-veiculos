package br.com.veiculos.repository

import br.com.veiculos.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CadastroUsuarioRepository: JpaRepository<Usuario, Long> {
    fun findByEmail(email: String): Optional<String>
    fun findByCpf(cpf: String): Optional<String>
}
