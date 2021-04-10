package ink.ptms.chemdah.core.quest.objective.bukkit

import ink.ptms.chemdah.core.quest.objective.Dependency
import ink.ptms.chemdah.core.quest.objective.ObjectiveCountable
import io.izzel.taboolib.common.event.PlayerJumpEvent
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityCombustByEntityEvent
import org.bukkit.event.entity.EntityRegainHealthEvent
import org.bukkit.event.entity.EntityTameEvent

/**
 * Chemdah
 * ink.ptms.chemdah.core.quest.objective.bukkit.IEntityCombust
 *
 * @author sky
 * @since 2021/3/2 5:09 下午
 */
@Dependency("minecraft")
object IEntityCombust : ObjectiveCountable<EntityCombustByEntityEvent>() {

    override val name = "entity tame"
    override val event = EntityCombustByEntityEvent::class

    init {
        handler {
            combuster as? Player
        }
        addCondition("position") { e ->
            toPosition().inside(e.entity.location)
        }
        addCondition("entity") { e ->
            toInferEntity().isEntity(e.entity)
        }
    }
}