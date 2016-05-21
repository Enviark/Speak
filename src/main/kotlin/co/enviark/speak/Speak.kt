package co.enviark.speak

import co.enviark.speak.formatters.ArgumentFormatter
import co.enviark.speak.formatters.ColorFormatter
import co.enviark.speak.formatters.FormatterManager
import co.enviark.speak.i18n.StringManager
import java.io.InputStream
import java.util.*

object Speak {

    lateinit var plugin: SpeakPlugin

    var defaultLocale = Locale.ENGLISH
    val strings = StringManager()
    val formatters = FormatterManager()

    fun initialize(plugin: SpeakPlugin) {
        this.plugin = plugin
        plugin.saveDefaultConfig()

        defaultLocale = Locale.forLanguageTag(plugin.config.getString("default"))

        // allow color codes with the '&' char
        formatters.register(ColorFormatter('&'))
        // allow #{variables} to be added with javascript
        formatters.register(ArgumentFormatter())
    }

    fun loadStrings(file: InputStream, locale: Locale) = strings.loadStrings(file, locale)

}