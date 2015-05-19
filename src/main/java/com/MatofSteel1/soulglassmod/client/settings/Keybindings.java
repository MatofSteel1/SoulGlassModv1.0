package com.MatofSteel1.soulglassmod.client.settings;

import com.MatofSteel1.soulglassmod.reference.Names;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class Keybindings {
    public static KeyBinding charge = new KeyBinding(Names.Keys.CHARGE, Keyboard.KEY_C, Names.Keys.CATEGORY);
    public static KeyBinding release = new KeyBinding(Names.Keys.RELEASE, Keyboard.KEY_R, Names.Keys.CATEGORY);
    public static KeyBinding invisibility = new KeyBinding(Names.Keys.INVISIBILITY, Keyboard.KEY_I, Names.Keys.CATEGORY);
}
