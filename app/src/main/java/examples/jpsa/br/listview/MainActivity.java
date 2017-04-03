package examples.jpsa.br.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pessoa> listaPessoas;
    private ListView listaSimples;
    private EditText editTextNome;
    private EditText editTextTelefone;
    private EditText editTextEmail;
    private Button buttonAdicionar;
    private ListaSimplesAdapater customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        setContentView(R.layout.activity_main);
        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        listaSimples = (ListView) findViewById(R.id.simpleListView);
        buttonAdicionar = (Button) findViewById(R.id.buttonAdicionar);

        if (listaPessoas == null){

            for (int i = 0; i < 4; i++){

//                listaPessoas.add();
            }
        }

        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pessoa p = new Pessoa();
                p.setNome(editTextNome.getText().toString());
                p.setTelefone(editTextTelefone.getText().toString());
                p.setEmail(editTextEmail.getText().toString());
                listaPessoas.add(p);
                customAdapter = new ListaSimplesAdapater(getApplicationContext(), listaPessoas);
                listaSimples.setAdapter(customAdapter);
            }
        });
        customAdapter = new ListaSimplesAdapater(getApplicationContext(), listaPessoas);
        listaSimples.setAdapter(customAdapter);

    }
    @Override
    public void onSaveInstanceState(Bundle savedState) {

        super.onSaveInstanceState(savedState);



    }
}
