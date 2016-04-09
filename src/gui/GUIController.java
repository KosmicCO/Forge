package gui;

import graphics.Window3D;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GUIController {

    private static final Map<String, GUI> guis = new HashMap();

    public static void add(GUI... gui) {
        Arrays.asList(gui).forEach(g -> {
            guis.put(g.getName(), g);
        });
    }

    public static void remove(GUI g) {
        if (guis.containsValue(g)) {
            guis.remove(g.getName());
        }
    }

    public static void draw() {
        Window3D.guiProjection();
        guis.values().forEach(g -> {
            if (g.isOpen()) {
                g.draw();
            }
        });
        Window3D.resetProjection();
    }

    public static void update() {
        guis.values().forEach(g -> {
            g.update();
        });
    }

    public static Map<String, GUI> getGUIList() {
        return guis;
    }

}