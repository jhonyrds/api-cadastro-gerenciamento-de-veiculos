package br.com.veiculos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients


@EnableFeignClients
@SpringBootApplication
class VeiculosApplication

fun main(args: Array<String>) {
    runApplication<VeiculosApplication>(*args)
}