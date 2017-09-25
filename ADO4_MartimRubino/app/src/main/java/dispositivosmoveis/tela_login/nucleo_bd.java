package dispositivosmoveis.tela_login;

/**
 * Created by martim.srubino on 18/09/2017.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class nucleo_bd extends SQLiteOpenHelper{

                                                // pode ser qualquer nome e formato
    private static final String DATABASE_NAME = "AppData.db";
    private static final int DATABASE_VERSION = 1;

    // nome da tabela
    private static final String TABLES = "users";// este nome pois sera usada para usuarios de alguma aplicacao
    private static final String FIELDS = "'u_id' INTEGER PRIMARY KEY AUTOINCREMENT, 'u_username' TEXT, 'u_mail' TEXT, 'u_password' TEXT";

    public nucleo_bd(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // meu comando sql final
        String estrutura = "CREATE TABLE '" + TABLES + "' ("+FIELDS+")";
        // executando meu sql para criar minha database
        sqLiteDatabase.execSQL(estrutura);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String atualiza = "DROP TABLE '"+TABLES+"'";
        onCreate(sqLiteDatabase);
    }
}
