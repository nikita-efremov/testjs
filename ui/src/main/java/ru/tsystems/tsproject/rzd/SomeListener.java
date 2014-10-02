package ru.tsystems.tsproject.rzd;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Created by Марина on 02.10.14.
 */
public class SomeListener implements ServletRequestAttributeListener {

    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        //
    }

    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("Listener said, that new attribute was added. "
                + "Name is "
                + servletRequestAttributeEvent.getName()
                + " Value is " + servletRequestAttributeEvent.getValue());
    }

    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        //
    }
}
