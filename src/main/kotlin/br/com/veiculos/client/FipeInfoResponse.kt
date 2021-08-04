package br.com.veiculos.client

import com.fasterxml.jackson.annotation.JsonProperty

data class FipeInfoResponse(
    @field:JsonProperty("Valor") val valor: String,
    @field:JsonProperty("Marca") val marca: String,
    @field:JsonProperty("Modelo") val modelo: String,
    @field:JsonProperty("AnoModelo") val anoModelo: Int,
    @field:JsonProperty("Combustivel") val combustivel: String,
)
