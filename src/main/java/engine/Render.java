package engine;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Render {

    private List<AbstractComponent> components = new ArrayList<>();

    public void addComponent(AbstractComponent component){
        components.add(component);
        components.sort((o1, o2) -> Float.compare(o1.zLevel, o2.zLevel));

    }

    public boolean removeComponent(AbstractComponent component){
        return components.remove(component);
    }

    public void render(){
            for(AbstractComponent component : components){
                component.render();
            }
    }

    public void mousePickingRender(){
        for(int i = 0; i < components.size(); i++){
            int r = (i & 0x000000FF) >>  0;
            int g = (i & 0x0000FF00) >>  8;
            int b = (i & 0x00FF0000) >> 16;
            components.get(i).mousePickingRender(new Color(r,g,b));
        }
    }

}
