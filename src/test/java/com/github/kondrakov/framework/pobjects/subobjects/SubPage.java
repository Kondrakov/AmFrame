package com.github.kondrakov.framework.pobjects.subobjects;

import com.github.kondrakov.framework.BasePage;
import com.github.kondrakov.framework.ElementId;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class SubPage extends BasePage {

    Set<String> elements;

    public SubPage() {
        super();
        elements = new HashSet<>();
        setElementsDesc(elements);
    }

    public Set<String> getElementsDesc() {
        return elements;
    }

    public boolean contains(String id) {
        return getElementsDesc().contains(id);
    }

    public Set<String> setElementsDesc(Set<String> elements) {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ElementId.class)) {
                elements.add(field.getAnnotation(ElementId.class).id());
            }
        }
        return elements;
    }
}
