package com.github.obsidian.intellij_obsidian

import com.intellij.openapi.util.TextRange
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.editor.Caret
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project

class ObsidianObfuscationAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        // Get all the required data from data keys
        val editor: Editor = event.getRequiredData(CommonDataKeys.EDITOR)
        val project: Project = event.getRequiredData(CommonDataKeys.PROJECT)
        val document: Document = editor.getDocument()

        // Work off of the primary caret to get the selection info
        val primaryCaret: Caret = editor.getCaretModel().getPrimaryCaret()
        val start: Int = primaryCaret.getSelectionStart()
        val end: Int = primaryCaret.getSelectionEnd()

        // Get the selected text
        val range = TextRange(start, end)
        val selectedText = document.getText(range)

        // **Obsidian**
        try {
            val obs: String = ObsidianObfuscationService.obfuscate(selectedText)

            // Replace if successful obfuscation
            WriteCommandAction.runWriteCommandAction(
                project
            ) { document.replaceString(start, end, obs) }

        } catch (e: IllegalArgumentException) {
            println("Error obfuscating text: ${selectedText}")
            // TODO: Add error popup at bottom right
        }

        // De-select the text range that was just replaced
        primaryCaret.removeSelection()
    }
}
