package br.com.veiculos.model

import javax.persistence.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Entity
class Veiculo(
    @field:NotBlank val marca: String,
    @field:NotBlank val modelo: String,
    @field:Positive @field:Min(1990) val ano: Int,
    @field:Enumerated(EnumType.STRING)
    val diaDeRodizio: DiaDoRodizio,
    @field:NotNull @field:ManyToOne
    val usuario: Usuario
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
