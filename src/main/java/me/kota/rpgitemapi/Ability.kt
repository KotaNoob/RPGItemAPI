package me.kota.rpgitemapi

import org.bukkit.event.block.Action

class Ability(val name : String,val commands: Map<Action, String>,val lore : List<String>, val cost : Int?, val cooldown : Double, val showCooldown : Boolean) {
}