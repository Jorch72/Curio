package net.darkhax.curio.api.event;

import net.darkhax.curio.api.curio.ICurio;
import net.darkhax.curio.api.type.CurioType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * This event is fired when a Curio has been equipped, or removed. It can not be canceled.
 */
public class CurioSlotUpdateEvent extends CurioSlotEvent {

    /**
     * Constructor for the CurioSlotUpdateEvent.
     *
     * @param entity The entity that triggered the event.
     * @param stack The stack the Curio is attached to.
     * @param curio The Curio itself.
     * @param type The type of Curio.
     * @param slot The slot being updated.
     * @param action The action being performed.
     */
    public CurioSlotUpdateEvent (EntityLivingBase entity, ItemStack stack, ICurio curio, CurioType type, Slot slot, Action action) {

        super(entity, stack, curio, type, slot, action);
    }
}