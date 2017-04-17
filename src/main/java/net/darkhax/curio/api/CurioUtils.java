package net.darkhax.curio.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import net.darkhax.curio.api.curio.ICurio;
import net.darkhax.curio.api.event.CurioSlotEvent;
import net.darkhax.curio.api.event.CurioSlotEvent.Action;
import net.darkhax.curio.api.event.CurioSlotPreEvent;
import net.darkhax.curio.api.type.CurioType;
import net.darkhax.curio.inventory.SlotCurio;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class CurioUtils {

    /**
     * The capability for ICurio. Feel free to use this one, or make your own.
     */
    @CapabilityInject(ICurio.class)
    public static Capability<ICurio> CAPABILITY_CURIO = null;

    public static boolean isCurio (@Nonnull ItemStack stack) {

        return !stack.isEmpty() && stack.hasCapability(CAPABILITY_CURIO, null);
    }

    public static List<ICurio> getCurioForStack (@Nonnull ItemStack stack, @Nonnull EntityLivingBase wearer) {

        return isCurio(stack) ? stack.getCapability(CAPABILITY_CURIO, null).getContainedCurio(stack, wearer) : new ArrayList<>();
    }

    public static boolean canEquip (EntityLivingBase entity, CurioType type, ItemStack stack, SlotCurio slot) {

        for (final ICurio curio : getCurioForStack(stack, entity)) {

            final CurioSlotEvent event = new CurioSlotPreEvent(entity, stack, curio, type, slot, Action.EQUIP);

            if (MinecraftForge.EVENT_BUS.post(event) || !type.canEquip(curio, stack, entity) || !curio.canEquip(stack, entity, type))
                return false;
        }

        return true;
    }

    public static boolean canRemove (EntityLivingBase entity, CurioType type, ItemStack stack, SlotCurio slot) {

        for (final ICurio curio : getCurioForStack(stack, entity)) {

            final CurioSlotEvent event = new CurioSlotPreEvent(entity, stack, curio, type, slot, Action.REMOVE);

            if (MinecraftForge.EVENT_BUS.post(event) || !type.canRemove(curio, stack, entity) || !curio.canRemove(stack, entity, type))
                return false;
        }

        return true;
    }

    public static void onCurioEquip (EntityLivingBase entity, CurioType type, ItemStack stack, SlotCurio slot) {

        for (final ICurio curio : getCurioForStack(stack, entity)) {

            MinecraftForge.EVENT_BUS.post(new CurioSlotPreEvent(entity, stack, curio, type, slot, Action.EQUIP));
            type.onEquip(curio, stack, entity);
            curio.onEquipped(stack, entity, type);
        }
    }

    public static void onCurioRemoved (EntityLivingBase entity, CurioType type, ItemStack stack, SlotCurio slot) {

        for (final ICurio curio : getCurioForStack(stack, entity)) {

            MinecraftForge.EVENT_BUS.post(new CurioSlotPreEvent(entity, stack, curio, type, slot, Action.REMOVE));
            type.onRemove(curio, stack, entity);
            curio.onRemoved(stack, entity, type);
        }
    }
}