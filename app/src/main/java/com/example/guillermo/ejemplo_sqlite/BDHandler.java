package com.example.guillermo.ejemplo_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by guillermo on 27/02/18.
 */

public class BDHandler extends SQLiteOpenHelper {

    private static final String database = "Database.db";
    private SQLiteDatabase db;
    private final Context context;


    public BDHandler(Context context) {
        super(context, database, null, 1);
        db = getWritableDatabase();
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Alumnos (idAlumno INT PRIMARY KEY,Nombre VARCHAR(50),Nocontrol VARCHAR(50))");
        sqLiteDatabase.execSQL("INSERT INTO Alumnos VALUES (1,'Guillermo Reyes','14400996')");
        sqLiteDatabase.execSQL("INSERT INTO Alumnos VALUES (2,'Ernesto Gonzalez','14400996')");
        sqLiteDatabase.execSQL("INSERT INTO Alumnos VALUES (3,'Juan Gil','14400996')");
        sqLiteDatabase.execSQL("INSERT INTO Alumnos VALUES (4,'Hector Garay','14400996')");
        sqLiteDatabase.execSQL("INSERT INTO Alumnos VALUES (5,'Guillermo Zamorano','14400996')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Alumnos");
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Item> consulta() {
        ArrayList<Item> lista = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM Alumnos", null);
        while (c.moveToNext()) {
            lista.add(new Item(c.getString(0), c.getString(1), c.getString(2)));
        }
        c.close();
        return lista;
    }
}


