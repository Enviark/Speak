package co.enviark.speak

import org.bukkit.plugin.java.JavaPlugin

class SpeakPlugin : JavaPlugin() {

    override fun onEnable() {
        Speak.initialize(this)
    }

}