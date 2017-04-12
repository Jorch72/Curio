package net.darkhax.curio.api.capabilities;

import net.darkhax.curio.api.curio.ICurio;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

/**
 * This is the storage implementation for ICurio. It's used for read/write of capability stuff
 * to NBT. I prefer to let the devs handle syncing on their own so this is not actually used,
 * but it could be upon request.
 */
public class StorageCurio implements IStorage<ICurio> {

    @Override
    public NBTBase writeNBT (Capability<ICurio> capability, ICurio instance, EnumFacing side) {

        return null;
    }

    @Override
    public void readNBT (Capability<ICurio> capability, ICurio instance, EnumFacing side, NBTBase nbt) {

    }
}