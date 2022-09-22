package com.github.minigdx.imgui.commands

import com.github.minigdx.imgui.ImGui
import com.github.minigdx.imgui.atlas.WidgetAtlas
import com.github.minigdx.imgui.internal.Cursor
import com.github.minigdx.imgui.internal.PrimitivesOrder
import com.github.minigdx.imgui.internal.Quad

class CheckBox(private val checked: Boolean) : Command, Primitive {

    override fun addInto(primitivesOrder: PrimitivesOrder) {
        primitivesOrder.add(this)
    }

    override fun advance(cursor: Cursor) {
        cursor.advance(WIDTH, 0f)
    }

    override val texture: Any = ImGui.atlas

    override val quads: List<Quad> = createQuads()

    private fun createQuads(): List<Quad> {
        val uvs = if (checked) {
            WidgetAtlas.DEFAULT.checkboxChecked
        } else {
            WidgetAtlas.DEFAULT.checkboxUnchecked
        }

        return listOf(Quad().append(0f, 0f, WIDTH, 10f, uvs))
    }

    companion object {
        private const val WIDTH = 8f
    }
}
