package br.com.veiculos.controller

import br.com.veiculos.repository.CadastroUsuarioRepository
import br.com.veiculos.request.NovoUsuarioRequest
import br.com.veiculos.response.CadastroResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/usuarios")
class CadastroUsuarioController(val repository: CadastroUsuarioRepository) {

    val LOGGER = LoggerFactory.getLogger(CadastroUsuarioController::class.java)

    @PostMapping
    fun cadastra(@RequestBody @Valid request: NovoUsuarioRequest): ResponseEntity<Any> {

        val novoUsuario = request.toModel(repository)

        LOGGER.info("Cadastrando novo usuário: $request")

        repository.save(novoUsuario)

        return ResponseEntity.status(HttpStatus.CREATED).body(CadastroResponse(novoUsuario))
    }
}