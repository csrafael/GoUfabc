package android.ufabc.edu.br.goufabc.dao;
import android.content.ContentValues;
import android.content.Context;
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
            cv.put("idUser", user.getId());
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