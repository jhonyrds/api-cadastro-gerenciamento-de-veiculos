package br.com.veiculos.request

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

class ConsultaFipeRequest(
    @field:NotBlank val marca: Marca,
    @field:NotBlank val modelo: Modelo,
    @field:Positive @field:Min(1990) val ano: Int,
) {
    fun toModel(): Consulta {
        return Consulta(codigoMarca(marca), codigoModelo(modelo), ano.toString())
    }
}

class Consulta(
    val marca: String,
    val modelo: String,
    val ano: String
)

enum class Marca {
    CHEVROLET,
    FIAT,
    FORD,
    HONDA,
    HYUNDAI,
    TOYOTA,
    VOLKSWAGEN,
}

fun codigoMarca(marca: Marca) =
    when (marca) {
        Marca.CHEVROLET -> "23"
        Marca.FIAT -> "21"
        Marca.FORD -> "22"
        Marca.HONDA -> "25"
        Marca.HYUNDAI -> "26"
        Marca.TOYOTA -> "56"
        Marca.VOLKSWAGEN -> "59"
    }

enum class Modelo {
    CRUZE,
    PUNTO,
    FIESTA,
    CIVIC,
    I30,
    COROLLA,
    JETTA,
}

fun codigoModelo(modelo: Modelo) =
    when (modelo) {
        Modelo.CRUZE -> "8574" //2019-1
        Modelo.PUNTO -> "5295" //2012-1
        Modelo.FIESTA -> "7754" //2017-1
        Modelo.CIVIC -> "4090" //2007-1
        Modelo.I30 -> "5071" // 2010-1/2011-1/2012-1
        Modelo.COROLLA -> "2219" //1999-1/1998-1/1997-1
        Modelo.JETTA -> "5514" //2011-1 a 2018-1
    }


