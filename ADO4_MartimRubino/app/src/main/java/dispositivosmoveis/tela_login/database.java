package dispositivosmoveis.tela_login;

/**
 * Created by martim.srubino on 18/09/2017.
 */

import android.content.Context;
// o cursor sera um agente que armazena todas as informaçoes especificadas de uma database para comparações (no caso de informações digitadas pelo usuario na hora do login).
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class database {
    // este sera meu verdadeiro banco de dados que recebera todas as informações da minha classe de database criada.
    private SQLiteDatabase db;

    // Context sao as informações do local que o usuario se encontra no momento
    public database(Context context){
        nucleo_bd configuracoes = new nucleo_bd(context);
        // estou CONFIGURANDO minha variavel db para seu configuravel tambem
        this.db = configuracoes.getWritableDatabase();
    }

    // o no query serve para ele nao me retornar nenhua informação quando envio uma a ele
    public void doNoQuery(String query){
        Log.d("AppLog", "Query: " + query);
        this.db.execSQL(query);
    }

    public String[][] doQuery(String query){
        Log.d("AppLog", "Query: " + query);
        Cursor queryResult = this.db.rawQuery(query, null);
        // isto passa a quantidade de colunas do meu database criado
        int colunas = queryResult.getColumnCount();
        // quantidade de registros do meu banco de dados
        int contador = queryResult.getCount();
        Log.d("AppLog", "Colunas: " + colunas + " | Linhas: " + contador);
        // agora vou criar uma matriz com as informações importadas do meu cursor
        String[][] resultado = new String[contador][colunas];
        for(int i = 0; i< contador; i++ ){
            String logLine = "";
            queryResult.moveToNext();
            for(int j = 0; j < colunas; j++){
                resultado[i][j] =  queryResult.getString(j);
                logLine += resultado[i][j] + " | ";
            }
            Log.d("AppLog", logLine);
        }
        return resultado;
    }
}
