package android.ufabc.edu.br.goufabc.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by root on 18/08/16.
 */

public class TimeBDDataSource extends SQLiteOpenHelper {
    public static final String DB_NAME  = "Time_DB";
    public static final String TBL_NAME = "tblTime";
    public static final int    DB_VERS  = 1;

    public TimeBDDataSource(Context ctx, String name, SQLiteDatabase.CursorFactory cursor, int version){
        super(ctx, name, cursor, version);
    }

    public void onCreate(SQLiteDatabase db){
        String SQL = "CREATE TABLE "+TBL_NAME+ " ( " +
                "     trainer  varchar(100)," +
                "     numero   varchar(100)," +
                "     nome  varchar(100)," +
                "     cp    varchar(100), " +
                "     hp    varchar (100))";

        db.execSQL(SQL);

        Log.d("TimeBDDataSource","Base de dados criada com sucesso!");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS" + TBL_NAME);
        onCreate(db);
    }

}
