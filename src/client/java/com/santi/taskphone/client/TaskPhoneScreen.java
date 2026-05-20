package com.santi.taskphone.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import com.santi.taskphone.model.Task;
import com.santi.taskphone.model.TaskManager;

public class TaskPhoneScreen extends Screen {

    private static TaskManager taskManager = new TaskManager();
    private TextFieldWidget textField;

    public TaskPhoneScreen() {
        super(Text.literal("Task Phone"));
    }

    @Override
    protected void init() {
        super.init();

        // Text field where the player types the task
        textField = new TextFieldWidget(this.textRenderer, this.width / 2 - 100, 50, 200, 20, Text.literal(""));
        textField.setMaxLength(100);
        this.addDrawableChild(textField);

        // Add button
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Add Task"), button -> {
            String goal = textField.getText();
            if (!goal.isEmpty()) {
                taskManager.addTask(goal);
                textField.setText("");
                this.clearAndInit();
            }
        }).dimensions(this.width / 2 - 100, 80, 95, 20).build());

        // Clear completed button
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Clear Done"), button -> {
            for (int i = taskManager.getTasks().size() - 1; i >= 0; i--) {
                if (taskManager.getTasks().get(i).getIsComplete()) {
                    taskManager.removeTask(taskManager.getTasks().get(i).getId());
                }
            }
            this.clearAndInit();
        }).dimensions(this.width / 2 + 5, 80, 95, 20).build());

        // Create buttons for each task
        int y = 110;
        for (int i = 0; i < taskManager.getTasks().size(); i++) {
            Task task = taskManager.getTasks().get(i);
            int taskId = task.getId();
            String label = task.getIsComplete() ? "[DONE] " + task.getGoal() : "[ ] " + task.getGoal();
            int color = task.getIsComplete() ? 0x55FF55 : 0xFFFFFF;

            this.addDrawableChild(ButtonWidget.builder(Text.literal(label), button -> {
                Task t = null;
                for (int j = 0; j < taskManager.getTasks().size(); j++) {
                    if (taskManager.getTasks().get(j).getId() == taskId) {
                        t = taskManager.getTasks().get(j);
                        break;
                    }
                }
                if (t != null) {
                    t.setIsComplete(!t.getIsComplete());
                    this.clearAndInit();
                }
            }).dimensions(this.width / 2 - 100, y, 200, 20).build());

            y += 24;
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        // Title
        context.drawCenteredTextWithShadow(this.textRenderer, "Task Phone", this.width / 2, 20, 0x55FFFF);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}