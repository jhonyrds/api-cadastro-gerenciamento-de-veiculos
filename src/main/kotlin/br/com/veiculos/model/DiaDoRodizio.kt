package br.com.veiculos.model

enum class DiaDoRodizio {
    SEGUNDA,
    TERCA,
    QUARTA,
    QUINTA,
    SEXTA;
}

fun converte(dia: DiaDoRodizio) =
    when (dia) {
        DiaDoRodizio.SEGUNDA -> "MONDAY"
        DiaDoRodizio.TERCA -> "TUESDAY"
        DiaDoRodizio.QUARTA -> "WEDNESDAY"
        DiaDoRodizio.QUINTA -> "THURSDAY"
        DiaDoRodizio.SEXTA -> "FRIDAY"
    }
