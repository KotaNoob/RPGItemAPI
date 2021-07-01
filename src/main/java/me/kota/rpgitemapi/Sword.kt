package me.kota.rpgitemapi

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Sword(val name : String, val material : Material, val lore : List<String>, val ability: Ability?=null, val stats: Stats, val Rarity : Rarity){

    val itemStack: ItemStack = ItemStack(material)

    init {
        //test
        val meta = itemStack.itemMeta!!
        meta.setDisplayName(name)

        val lore = mutableListOf<String>()
        if(stats.Health > 0) {
            lore.add("§a❤ 体力: +${stats.Health}")
        }
        if(stats.Defense > 0) {
            lore.add("§a✼ 防水力: +${stats.Defense}")
        }
        if(stats.MP > 0) {
            lore.add("§a❖ マナポイント: +${stats.MP}")
        }
        if(stats.Damage > 0) {
            lore.add("§c⚔ 攻撃力: +${stats.Crit_Chance}")
        }
        if(stats.Crit_Chance > 0) {
            lore.add("§c✦ クリティカルチャンス: +${stats.Crit_Chance}")
        }
        if(stats.Crit_Damage > 0) {
            lore.add("§c❁ クリティカルダメージ: +${stats.Crit_Damage}")
        }
        lore.add("")
        if(ability != null) {
            lore.add("§b§l能力 ${ability.name}")
            ability.lore.forEach{
                lore.add("§7${it}")
            }

            var index = ""

            ability.commands.forEach{
                lore.add("§8${it.value}: ${it.key}")
            }
            if(ability.cost != null) {
                index+="コスト: ${ability.cost} "
            }
            if(ability.showCooldown) {
                index+="クールダウン: ${ability.cooldown}秒"
            }
            lore.add("§8${index}")
            lore.add("")
        }
        lore.add("${Rarity.displayName}剣")
    }

}