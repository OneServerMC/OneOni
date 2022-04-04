package io.github.oneservermc.oneoni.game

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.scheduler.BukkitRunnable

class OniGame {

    val obj = object : BukkitRunnable() {

        var time = 0

        override fun run() {
            when (time) {
                0 -> {
                    Bukkit.getOnlinePlayers().forEach{player -> player.sendTitle(" - One鬼ごっこ スタート -", "") }
                }
            }
            time++
        }
    }
}