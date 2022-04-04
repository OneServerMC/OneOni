package io.github.oneservermc.oneoni.listeners

import io.github.oneservermc.oneoni.OneOni
import io.github.oneservermc.oneoni.particle.OniChangeParticle
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.metadata.FixedMetadataValue

class ChangeOni(private val plugin: OneOni) : Listener {

    init {
        plugin.server.pluginManager.registerEvents(this, plugin)
    }

    @EventHandler
    fun changeOni(event: EntityDamageByEntityEvent) {
        var damager = event.damager // 攻撃したほう
        var player: Entity = event.entity // 攻撃受けたほう

        if (!(damager is Player && player is Player)) return
        if (damager.getMetadata("oni")[0].value() as Boolean) {
            player.setMetadata("oni", FixedMetadataValue(plugin, true))
            damager.setMetadata("oni", FixedMetadataValue(plugin, false))

            OniChangeParticle().change(player)
            player.world.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1f, 1f)
            Bukkit.broadcastMessage("${player.name}さんが${damager.name}さんにつかまりました")
        }
    }

    fun checkOni(): Array<String> {
        var nowOni = emptyArray<String>()
        Bukkit.getOnlinePlayers().forEach{player ->
            if (player.getMetadata("oni") as Boolean) {
                nowOni += player.name
            }
        }
        return nowOni
    }
}