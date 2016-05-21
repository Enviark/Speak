package co.enviark.speak

import org.bukkit.entity.Player
import java.util.*

class Translation(val key: String) {

    var locale = Speak.defaultLocale
    var arguments = HashMap<String, Any>()

    fun to(locale: Locale) : Translation {
        this.locale = locale
        return this
    }

    fun to(player: Player) : Translation {
        return to(player.currentLocale)
    }

    fun put(key: String, value: Any) : Translation {
        arguments.put(key, value)
        return this
    }

    fun get() : String {
        val output = Speak.strings.get(locale, key)
        return Speak.formatters.format(output, arguments)
    }

}