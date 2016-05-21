# :speaker: Speak

A (work-in-progress) localisation API for Strukkit plugins.

## Usage
```xml
<dependency>
    <groupId>co.enviark</groupId>
    <artifactId>speak</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

```yml
myplugin:
    enabled: "Plugin enabled!"
teleport:
    # javascript inside of strings!
    countdown: "&cTeleporting in #{time} second#{time == 1 ? '' : 's'}..."
```

```kotlin
class MyPlugin : JavaPlugin {
    override fun onEnable() {
        // register as many languages as you support
        Speak.loadStrings(getResource("en.yml"), Locale.ENGLISH)

        val output = Translation("myplugin.enabled").to(Locale.ENGLISH).get()
        // => Plugin enabled!
        val message = Translation("teleport.countdown").to(player).put("time", 5).get()
        // => Teleporting in 5 seconds...
    }
}
```