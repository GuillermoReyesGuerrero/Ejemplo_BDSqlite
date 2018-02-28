package com.example.guillermo.ejemplo_sqlite;

/**
 * Created by guillermo on 27/02/18.
 */

public class Item {
    private String id,nombre,nocontrol;

    public Item(String id, String nombre, String nocontrol) {
        this.id = id;
        this.nombre = nombre;
        this.nocontrol = nocontrol;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNocontrol() {
        return nocontrol;
    }
}
