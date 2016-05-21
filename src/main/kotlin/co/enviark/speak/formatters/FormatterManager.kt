package co.enviark.speak.formatters

import java.util.*

class FormatterManager {

    val formatters = HashSet<MessageFormatter>()

    fun register(formatter: MessageFormatter) = formatters.add(formatter)
    fun unregister(formatter: MessageFormatter) = formatters.remove(formatter)

    fun format(text: String, args: Map<String, Any>) : String {
        var output = text
        formatters.forEach { output = it.format(output, args) }
        return output
    }

}