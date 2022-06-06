package com.herorickystudios.bancodedadossqlite;

//Programado Por HeroRickyGames

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            SQLiteDatabase bancoDados = openOrCreateDatabase( "app", MODE_PRIVATE, null );

            bancoDados.execSQL(" CREATE TABLE IF NOT EXISTS pessoas ( id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3) )");
            //bancoDados.execSQL("DROP TABLE pessoas");
            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Mario Aquele que te comeu atrás do armario', 18) ");
            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Mariana', 18) ");
            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Maria', 35) ");



            //bancoDados.execSQL("UPDATE pessoas SET idade = 19, nome = 'Mariana Silva' WHERE id = 3");
            //bancoDados.execSQL(" DELETE FROM pessoas WHERE id = 2 ");
            bancoDados.execSQL(" DELETE FROM pessoas");

            /*String consulta =
                    "SELECT nome, idade FROM pessoas " +
                    "WHERE nome = 'Ricky' AND idade = 20";
                    */

            /*String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            " WHERE idade >= 30 OR idade 18";*/

           /* String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            " WHERE idade BETWEEN 18 AND 35 ";*/


            //String filtro = "mar";
            /*String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            " WHERE nome LIKE '%"+ filtro  +"%' ";*/

           /* String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            " WHERE 1=1 ORDER BY idade ASC LIMIT 3";*/
            String consulta =
                    "SELECT * FROM pessoas " +
                            " WHERE 1=1";

            Cursor cursor = bancoDados.rawQuery(consulta, null);
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while (cursor != null){

                String id = cursor.getString(indiceId);
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);

                Log.i ("RESULTADO - id ",  id + " nome: " + nome + " / Idade: " + idade);
                cursor.moveToNext();
            }
        }catch (Exception e){

            e.printStackTrace();

        }

    }
}