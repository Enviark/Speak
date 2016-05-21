package co.enviark.speak.formatters

import org.bukkit.ChatColor

class ColorFormatter(val char: Char) : MessageFormatter {

    override fun format(text: String, args: Map<String, Any>) = ChatColor.translateAlternateColorCodes(char, text)

}
