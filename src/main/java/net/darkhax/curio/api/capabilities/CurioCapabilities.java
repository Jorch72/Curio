package net.darkhax.curio.api.capabilities;

import net.darkhax.curio.api.curio.ICurio;
import net.darkhax.curio.api.type.ICurioType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class CurioCapabilities {

    /**
     * The capability for ICurio. Feel free to use this one, or make your own.
     */
    @CapabilityInject(ICurio.class)
    public static Capability<ICurio> CAPABILITY_CURIO = null;

    /**
     * This is the storage implementation for ICurio. It's used for read/write of capability
     * stuff to NBT. I prefer to let the devs handle syncing on their own so this is not
     * actually used, but it could be upon request.
     */
    public static class StorageCurio implements IStorage<ICurio> {

        @Override
        public NBTBase writeNBT (Capability<ICurio> capability, ICurio instance, EnumFacing side) {

            return null;
        }

        @Override
        public void readNBT (Capability<ICurio> capability, ICurio instance, EnumFacing side, NBTBase nbt) {

        }
    }

    /**
     * This is the default implementation of ICurio. Forge requires that capabilities provide a
     * default class which can be used to make default instances. There isn't really anything
     * special here, and you should not try to extend or use this class in your mods.
     */
    public static class CurioDefault implements ICurio {

        @Override
        public ICurioType getType (ItemStack stack) {

            // TODO no null
            return null;
        }
    }
}