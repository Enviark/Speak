package co.enviark.speak.i18n

import co.enviark.speak.Speak
import org.bukkit.configuration.file.YamlConfiguration
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

class StringManager {

    val strings = HashMap<Locale, HashMap<String, String>>()

    fun loadStrings(file: InputStream, locale: Locale) {
        val reader = InputStreamReader(file)
        val yaml = YamlConfiguration.loadConfiguration(reader)

        yaml.getKeys(true).forEach { put(locale, it, yaml.getString(it)) }
    }

    fun put(locale: Locale, key: String, value: String) {
        if (!strings.containsKey(locale)) strings[locale] = HashMap()
        strings[locale]!!.put(key, value)
    }

    fun get(locale: Locale, key: String) : String {
        return strings[locale]?.get(key) ?: strings[Speak.defaultLocale]?.get(key) ?: key
    }

}