package br.com.veiculos.controller

import br.com.veiculos.repository.CadastroUsuarioRepository
import br.com.veiculos.repository.CadastroVeiculoRepository
import br.com.veiculos.request.NovoVeiculoRequest
import br.com.veiculos.response.CadastroVeiculoReponse
import br.com.veiculos.response.ListaVeiculoResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/veiculos")
class CadastroVeiculoController(
    val repository: CadastroVeiculoRepository,
    val usuarioRepository: CadastroUsuarioRepository,
) {
    val LOGGER = LoggerFactory.getLogger(CadastroVeiculoController::class.java)

    @PostMapping
    fun cadastra(@RequestBody @Valid request: NovoVeiculoRequest): ResponseEntity<CadastroVeiculoReponse> {

        val veiculo = request.toModel(usuarioRepository)

        LOGGER.info("Cadastrando novo veículo $request")

        repository.save(veiculo!!)

        return ResponseEntity.status(HttpStatus.CREATED).body(CadastroVeiculoReponse(veiculo))
    }

    @GetMapping("/{id}")
    fun listar(@PathVariable id: Long): ResponseEntity<List<ListaVeiculoResponse>>{

        val list = repository.findByUsuarioId(id)

        LOGGER.info("Listando os veículos para o usuário id: $id")

        val response = list.map { it -> ListaVeiculoResponse(it) }

        return ResponseEntity.ok(response)
    }
}