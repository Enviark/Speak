package co.enviark.speak.formatters

import java.util.regex.Pattern
import javax.script.ScriptContext
import javax.script.ScriptEngineManager

class ArgumentFormatter : MessageFormatter {

    val engine = ScriptEngineManager().getEngineByName("nashorn")
    val regex = Pattern.compile("/\\{(.+?)\\}/g")

    override fun format(text: String, args: Map<String, Any>): String {
        engine.setBindings(engine.createBindings(), ScriptContext.ENGINE_SCOPE)
        args.entries.forEach { engine.put(it.key, it.value) }

        val match = regex.matcher(text)
        val sb = StringBuffer()
        while (match.find()) {
            val output = engine.eval(match.group(1))
            match.appendReplacement(sb, output.toString())
        }
        match.appendTail(sb)
        return sb.toString()
    }

}
