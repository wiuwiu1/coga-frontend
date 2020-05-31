package engine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Render {

    List<AbstractComponent> components = new ArrayList<>();

    public void addComponent(AbstractComponent component){
        components.add(component);
        components.sort(new Comparator<AbstractComponent>() {
            @Override
            public int compare(AbstractComponent o1, AbstractComponent o2) {
                return new Float(o1.zLevel).compareTo(o2.zLevel);
            }
        });
    }

    public boolean removeComponent(AbstractComponent component){
        return components.remove(component);
    }

    public void render(){
            for(AbstractComponent component : components){
                component.render();
            }
    }

}
