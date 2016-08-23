package android.ufabc.edu.br.goufabc.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.ufabc.edu.br.goufabc.Time;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by root on 18/08/16.
 */
public class TimeDAO implements DAO{

    private TimeBDDataSource dataSource;

    public TimeDAO(Context ctx){
        dataSource = new TimeBDDataSource(ctx, TimeBDDataSource.DB_NAME,null, TimeBDDataSource.DB_VERS);
    }

    @Override
    public void create(Object o) {
        try{
            Time time = (Time)o;
            SQLiteDatabase db = dataSource.getWritableDatabase();

            ContentValues cv = new ContentValues();
            cv.put("trainer", time.getTrainer());
            cv.put("numero", time.getNumero());
            cv.put("nome", time.getNome());
            cv.put("cp", time.getCP());
            cv.put("hp", time.getHP());

            db.insert(TimeBDDataSource.TBL_NAME, null, cv);

            db.close();
            Log.d("TIMEDAO.CREATE", "Registro inserido com sucesso!");

        }
        catch(Exception ex){
            Log.d("TIMEDAO.CREATE",ex.getMessage());
        }
    }

    public ArrayList<Time> readAll(){
        try{
            Log.d("TIMEDAO.READALL", "Iniciou");
            String colunas[] = {"numero","nome","cp","hp"};
            SQLiteDatabase db = dataSource.getReadableDatabase();

            Cursor cursor = db.query(false,                       // quero distinct?
                    TimeBDDataSource.TBL_NAME,  // nome da tabela
                    colunas,                     // quais colunas retornar?
                    null,                        // tem where?
                    null,                        // parametros do where
                    null,                        // groupby
                    null,                        // colunas do having
                    null,                        // order by
                    null);                       // limit

            Log.d("TIMEDAO.READALL", "Antes do IF");
            if (cursor.moveToFirst()){
                ArrayList<Time> resultSet = new ArrayList<Time>();
                do{
                    Time time = new Time();
                    /*time.setNumero(cursor.getString(0));*/
                    time.setNome(cursor.getString(1));
                    /*time.setCP(cursor.getString(2));
                    time.setHP(cursor.getString(3));*/
                    resultSet.add(time);
                } while (cursor.moveToNext());
                db.close();
                cursor.close();
                Log.d("TIMEDAO.READALL", "Antes do return");
                return resultSet;
            }

        }
        catch(Exception ex){
            Log.d("TIMEDAO.READALL", ex.getMessage());
        }
        return null;
    }

    @Override
    public Object read(Object o) {
        return null;
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }


}