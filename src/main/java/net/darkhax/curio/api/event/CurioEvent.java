package net.darkhax.curio.api.event;

import javax.annotation.Nonnull;

import net.darkhax.curio.api.curio.ICurio;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * This class is used as the base for all of the events related to a Curio. This event is never
 * actually posted, and only used to share code with sub events.
 */
public class CurioEvent extends Event {

    /**
     * The entity that triggered the event.
     */
    private final EntityLivingBase entity;

    /**
     * The item the Curio is attached to.
     */
    private final ItemStack stack;

    /**
     * The Curio itself.
     */
    private final ICurio curio;

    /**
     * Base constructor for a Curio event. All events related to this should pass to this
     * constructor.
     *
     * @param entity The entity that triggered the event.
     * @param stack The stack the Curio is attached to.
     * @param curio The Curio itself.
     */
    public CurioEvent (@Nonnull EntityLivingBase entity, @Nonnull ItemStack stack, @Nonnull ICurio curio) {

        this.entity = entity;
        this.stack = stack;
        this.curio = curio;
    }

    /**
     * Gets the entity that triggered the event.
     *
     * @return The entity that triggered the event.
     */
    public EntityLivingBase getEntity () {

        return this.entity;
    }

    /**
     * Gets the stack that the Curio is attached to.
     *
     * @return The stack that the Curio is attatched to.
     */
    public ItemStack getStack () {

        return this.stack;
    }

    /**
     * Gets the Curio itself.
     *
     * @return The Curio itself.
     */
    public ICurio getCurio () {

        return this.curio;
    }
}