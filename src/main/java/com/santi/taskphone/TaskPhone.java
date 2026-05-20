package com.santi.taskphone;

// Imports de Fabric
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

// Imports de Minecraft
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

// Import de nuestra clase
import com.santi.taskphone.item.TaskPhoneItem;

// Clase principal del mod
public class TaskPhone implements ModInitializer {

    // El nombre de nuestro mod
    public static final String MOD_ID = "taskphone";

    // Este método se ejecuta cuando el mod se carga
    @Override
    public void onInitialize() {
        // Creamos la dirección del item
        Identifier itemId = Identifier.of(MOD_ID, "task_phone");

        // Creamos la llave de registro (nuevo en 1.21+)
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, itemId);

        // Creamos el teléfono con su llave y regla: máximo 1 por stack
        TaskPhoneItem TASK_PHONE = new TaskPhoneItem(new Item.Settings().registryKey(itemKey).maxCount(1));

        // Registramos el teléfono en Minecraft
        Registry.register(Registries.ITEM, itemKey, TASK_PHONE);

        // Agregamos el teléfono al creative tab de "Tools"
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(TASK_PHONE);
        });
    }
}