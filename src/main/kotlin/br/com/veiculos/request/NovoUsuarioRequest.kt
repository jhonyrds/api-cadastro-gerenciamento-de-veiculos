package br.com.veiculos.request

import br.com.veiculos.exception.CadastroException
import br.com.veiculos.model.Usuario
import br.com.veiculos.repository.CadastroUsuarioRepository
import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.validator.constraints.br.CPF
import java.time.LocalDate
import javax.persistence.Column
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class NovoUsuarioRequest(
    @field:NotBlank val nome: String,
    @field:NotBlank @field:Email @field:Column(unique = true, nullable = false) val email: String,
    @field:NotBlank @field:CPF @field:Column(unique = true, nullable = false) val cpf: String,
    @field:NotNull @field:JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "dd/MM/yyyy"
    ) val dtNascimento: LocalDate
) {
    fun toModel(repository: CadastroUsuarioRepository): Usuario {

        val possivelCpf = repository.findByCpf(cpf)
        val possivelEmail = repository.findByEmail(email)

        if (possivelCpf.isPresent) {
            throw CadastroException("Cpf cadastrado")
        }

        if (possivelEmail.isPresent) {
            throw CadastroException("Email Cadastrado")
        }

        return Usuario(nome, email, cpf, dtNascimento)
    }

}
