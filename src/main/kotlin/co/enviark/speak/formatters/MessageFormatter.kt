package co.enviark.speak.formatters

interface MessageFormatter {

    fun format(text: String, args: Map<String, Any>) : String

}