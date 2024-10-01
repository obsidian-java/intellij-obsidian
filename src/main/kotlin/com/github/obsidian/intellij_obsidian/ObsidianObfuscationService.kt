package com.github.obsidian.intellij_obsidian

import obsidian.lang.java.scalangj.Parser.parseNonEmptyCompilationUnit
import obsidian.lang.java.scalangj.Syntax.CompilationUnit
import scala.util.Either
import scala.util.Left
import scala.util.Right
import obsidian.lang.java.Obsidian

/*
* Service class interacting with Obsidian
* */
class ObsidianObfuscationService {
    companion object {
        fun obfuscate(code: String): String {
            val result: Either<String, CompilationUnit> = parseNonEmptyCompilationUnit(code)

            when (result) {
                is Left -> {
                    val errorMessage: String = result.value()
                    throw IllegalArgumentException("Error parsing CompilationUnit: $errorMessage")
                }

                is Right -> {
                    val eCU: CompilationUnit = result.value()
                    try {
                        val obfuscatedCode: String = Obsidian.generateObfuscatedCode(eCU)
                        return obfuscatedCode
                    } catch (e: Exception) {
                        throw IllegalArgumentException("Error obfuscating")
                    }
                }
                else -> throw IllegalArgumentException("Unexpected Error occurred")
            }
        }
    }
}
