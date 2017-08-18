package Daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mateus on 14/08/17.
 */
public class DataSourcePropriedade extends SQLiteOpenHelper {

    SQLiteDatabase db;


    public DataSourcePropriedade(Context context) {
        super(context, DataModelPropriedade.getDbName(), null, 2);

        db = this.getReadableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DataModelPropriedade.criaTabelaPropriedade());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVerson) {

        onCreate(db);
    }

    public void persist(ContentValues values, String tabela) {

        if (values.containsKey("id") && values.getAsInteger("id") != null && values.getAsInteger("id") != 0) {
            Integer id = values.getAsInteger("id");
            db.update(tabela, values, "id = " + id, null);
        } else {
            db.insert(tabela, null, values);
        }

    }
}
