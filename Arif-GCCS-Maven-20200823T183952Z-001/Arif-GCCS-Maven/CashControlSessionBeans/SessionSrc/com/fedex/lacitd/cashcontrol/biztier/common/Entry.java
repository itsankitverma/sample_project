/*
 * Entry.java
 *
 * Created on 24 de enero de 2003, 12:14
 */

package com.fedex.lacitd.cashcontrol.biztier.common;

/**
 * @author ccardenas
 */
public class Entry implements java.io.Serializable {

    /**
     * Holds value of property key.
     */
    private Object key;

    /**
     * Holds value of property value.
     */
    private Object value;

    /**
     * Creates a new instance of Entry
     */
    public Entry() {
    }

    public Entry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Getter for property key.
     *
     * @return Value of property key.
     */
    public Object getKey() {
        return this.key;
    }

    /**
     * Setter for property key.
     *
     * @param key New value of property key.
     */
    public void setKey(Object key) {
        this.key = key;
    }

    /**
     * Getter for property value.
     *
     * @return Value of property value.
     */
    public Object getValue() {
        return this.value;
    }

    /**
     * Setter for property value.
     *
     * @param value New value of property value.
     */
    public void setValue(Object value) {
        this.value = value;
    }

}
