package com.riskflow

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RiskFlowApplication

fun main(args: Array<String>) {
	runApplication<RiskFlowApplication>(*args)
}
