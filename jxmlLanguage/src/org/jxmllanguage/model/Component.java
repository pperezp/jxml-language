/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jxmllanguage.model;

/**
 *
 * @author pato
 */
public class Component implements Comparable{
    private String id;
    private String value;

    public Component(String id, String value) {
        this.id = id;
        this.value = value;
    }
    
    public Component(String id) {
        this.id = id;
        this.value = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        Component c = (Component) o;
        return (c.getId().toLowerCase().compareTo(this.getId().toLowerCase())) *-1;
    }
}
