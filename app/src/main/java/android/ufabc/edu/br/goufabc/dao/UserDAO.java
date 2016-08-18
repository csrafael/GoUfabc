package android.ufabc.edu.br.goufabc.dao;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.ufabc.edu.br.goufabc.User;
import android.util.Log;

public class UserDAO implements DAO{

    private UserBDDataSource dataSource;

    public UserDAO(Context ctx){
        dataSource = new UserBDDataSource(ctx, UserBDDataSource.DB_NAME,null, UserBDDataSource.DB_VERS);
    }

    @Override
    public void create(Object o) {
        try{
            User user = (User)o;
            SQLiteDatabase db = dataSource.getWritableDatabase();

            ContentValues cv = new ContentValues();
            cv.put("name", user.getName());
            cv.put("user", user.getUser());
            cv.put("pwd", user.getPwd());
            cv.put("team", user.getTeam());

            db.insert(UserBDDataSource.TBL_NAME, null, cv);

            db.close();
            Log.d("USERDAO.CREATE", "Registro inserido com sucesso!");

        }
        catch(Exception ex){
            Log.d("USERDAO.CREATE",ex.getMessage());
        }
    }

    /*public String[][] readAll(){
        try{
            String colunas[] = {"name","pwd"};
            SQLiteDatabase rdb = dataSource.getReadableDatabase();

            Cursor cursor = rdb.query(false,                       // quero distinct?
                    UserBDDataSource.TBL_NAME,  // nome da tabela
                    colunas,                     // quais colunas retornar?
                    null,                        // tem where?
                    null,                        // parametros do where
                    null,                        // groupby
                    null,                        // colunas do having
                    null,                        // order by
                    null);                       // limit

            if (cursor.moveToFirst()){
                String[][] resultSet = new String[][];
                int i = 0;
                do{
                    resultSet[i][0] = cursor.getString(0);
                    resultSet[i][1] = String.valueOf(cursor.getInt(1));
                    *//*User user = new User();
                    // popular o objeto com os valres do cursor
                    user.setUser(cursor.getString(0));
                    user.setPwd(cursor.getInt(1));

                    resultSet.add(user);*//*
                    i++;
                } while (cursor.moveToNext());
                db.close();
                cursor.close();
                return resultSet;
            }

        }
        catch(Exception ex){
            Log.d("USERDAO.READALL", ex.getMessage());
        }
        return null;
    }*/

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