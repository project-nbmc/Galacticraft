/*
 * Copyright (c) 2019-2023 Team Galacticraft
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.galacticraft.mod.screen;

import dev.galacticraft.machinelib.api.screen.RecipeMachineMenu;
import dev.galacticraft.mod.content.block.entity.CompressorBlockEntity;
import dev.galacticraft.mod.recipe.CompressingRecipe;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.DataSlot;

/**
 * @author <a href="https://github.com/TeamGalacticraft">TeamGalacticraft</a>
 */
public class CompressorMenu extends RecipeMachineMenu<Container, CompressingRecipe, CompressorBlockEntity> {
    public final DataSlot fuelTime = new DataSlot() {
        @Override
        public int get() {
            return CompressorMenu.this.machine.fuelTime;
        }

        @Override
        public void set(int value) {
            CompressorMenu.this.machine.fuelTime = value;
        }
    };

    public final DataSlot fuelLength = new DataSlot() {
        @Override
        public int get() {
            return CompressorMenu.this.machine.fuelLength;
        }

        @Override
        public void set(int value) {
            CompressorMenu.this.machine.fuelLength = value;
        }
    };

    public CompressorMenu(int syncId, Player player, CompressorBlockEntity machine) {
        super(syncId, player, machine, GCMenuTypes.COMPRESSOR_HANDLER, 8, 85);
        this.addDataSlot(this.fuelTime);
        this.addDataSlot(this.fuelLength);
    }

    public CompressorMenu(int syncId, Inventory inv, FriendlyByteBuf buf) {
        this(syncId, inv.player, (CompressorBlockEntity) inv.player.level.getBlockEntity(buf.readBlockPos()));
    }
}
