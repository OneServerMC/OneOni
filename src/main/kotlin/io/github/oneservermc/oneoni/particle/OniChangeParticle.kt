package io.github.oneservermc.oneoni.particle

import io.github.oneservermc.oneoni.OneOni.Companion.plugin
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.entity.Player


class OniChangeParticle {

    fun change(player: Player) {
        val points = 30
        val radius = 1.2
        val origin: Location = player.getLocation()

        val a = Bukkit.getScheduler()
        val task = a.scheduleSyncRepeatingTask(plugin, {
            for (player in Bukkit.getServer().onlinePlayers) {
                for (i in 0 until points) {
                    val angle = 2 * Math.PI * i / points
                    val point: Location = origin.clone().add(radius * Math.sin(angle), 0.0, radius * Math.cos(angle))
                    player.spawnParticle(Particle.REDSTONE, point, 6)
                }
            }
        }, 0, 1)
    }

}