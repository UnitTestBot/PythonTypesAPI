package org.utpython.types

import org.utpython.types.general.FunctionType
import org.utpython.types.general.UtType


open class PythonDefinition(open val meta: org.utpython.types.PythonDefinitionDescription, open val type: UtType) {
    override fun toString(): String =
        "${meta.name}: ${type.pythonTypeRepresentation()}"
}

class PythonFunctionDefinition(
    override val meta: org.utpython.types.PythonFuncItemDescription,  // TODO: consider overloaded function
    override val type: FunctionType
): org.utpython.types.PythonDefinition(meta, type)

sealed class PythonDefinitionDescription(val name: String)

class PythonVariableDescription(
    name: String,
    val isProperty: Boolean = false,
    val isSelf: Boolean = false
): org.utpython.types.PythonDefinitionDescription(name)

sealed class PythonFunctionDescription(name: String): org.utpython.types.PythonDefinitionDescription(name)

class PythonFuncItemDescription(
    name: String,
    val args: List<org.utpython.types.PythonVariableDescription>
): org.utpython.types.PythonFunctionDescription(name)

class PythonOverloadedFuncDefDescription(
    name: String,
    val items: List<org.utpython.types.PythonDefinitionDescription>
): org.utpython.types.PythonFunctionDescription(name)