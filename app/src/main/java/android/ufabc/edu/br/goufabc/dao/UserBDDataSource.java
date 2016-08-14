package android.ufabc.edu.br.goufabc.dao;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserBDDataSource extends SQLiteOpenHelper{
    public static final String DB_NAME  = "User_DB";
    public static final String TBL_NAME = "tblUser";
    public static final int    DB_VERS  = 1;

    public UserBDDataSource(Context ctx, String name, SQLiteDatabase.CursorFactory cursor, int version){
        super(ctx, name, cursor, version);
    }

    public void onCreate(SQLiteDatabase db){
        String SQL = "CREATE TABLE "+TBL_NAME+ " ( " +
                "     idUser int," +
                "     name  varchar(100)," +
                "     user   varchar(100)," +
                "     pwd  int," +
                "     team varchar(100) )";

        db.execSQL(SQL);

        Log.d("UserBDDataSource","Base de dados criada com sucesso!");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS" + TBL_NAME);
        onCreate(db);
    }

}
