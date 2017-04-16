package net.darkhax.curio.api.event;

import net.darkhax.curio.api.curio.ICurio;
import net.darkhax.curio.api.type.CurioType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * This class is used to share code for slot based events related to Curio. This is never
 * actually posted, and only used to share code with sub events.
 */
public class CurioSlotEvent extends CurioEvent {

    /**
     * The type of Curio.
     */
    private final CurioType type;

    /**
     * The slot being updated.
     */
    private final Slot slot;

    /**
     * The action being performed.
     */
    private final Action action;

    /**
     * Constructor for the CurioSlotEvent.
     *
     * @param entity The entity that triggered the event.
     * @param stack The stack the Curio is attached to.
     * @param curio The Curio itself.
     * @param type The type of Curio.
     * @param slot The slot being updated.
     * @param action The action being performed.
     */
    public CurioSlotEvent (EntityLivingBase entity, ItemStack stack, ICurio curio, CurioType type, Slot slot, Action action) {

        super(entity, stack, curio);
        this.type = type;
        this.slot = slot;
        this.action = action;
    }

    /**
     * Gets the type of Curio.
     *
     * @return The type of Curio.
     */
    public CurioType getType () {

        return this.type;
    }

    /**
     * Gets the slot being updated.
     *
     * @return The slot being updated.
     */
    public Slot getSlot () {

        return this.slot;
    }

    /**
     * Gets the action being performed.
     *
     * @return The action being performed.
     */
    public Action getAction () {

        return this.action;
    }

    /**
     * This enum is used to describe the different slot actions.
     */
    public enum Action {

        /**
         * This action is used when the Curio is being equipped.
         */
        EQUIP,

        /**
         * This action is used when the Curio is being removed.
         */
        REMOVE
    }
}