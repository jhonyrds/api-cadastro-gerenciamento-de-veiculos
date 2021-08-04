package br.com.veiculos.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    url = "https://parallelum.com.br/fipe/api/v1/carros/",
    name = "fipe"
)
interface FipeClient {
    @GetMapping("marcas/{marca}/modelos/{modelo}/anos/{ano}")
    fun pegaFipe(@PathVariable marca: String, @PathVariable modelo: String, @PathVariable ano: String): FipeInfoResponse
}