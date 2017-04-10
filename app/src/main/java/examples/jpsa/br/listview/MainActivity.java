package examples.jpsa.br.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pessoa> listaPessoas;
    private ListView listaSimples;
    private EditText editTextNome;
    private EditText editTextTelefone;
    private EditText editTextEmail;
    private Button buttonAdicionar;
    private Integer posicaoLista;
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


        if(savedInstanceState == null || !savedInstanceState.containsKey("key")) {
            listaPessoas = new ArrayList<Pessoa>();
        }else {
            listaPessoas = savedInstanceState.getParcelableArrayList("key");
        }



        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (posicaoLista != null){
                    Pessoa p = new Pessoa(editTextNome.getText().toString(),editTextEmail.getText().toString(),editTextTelefone.getText().toString());
                    listaPessoas.get(posicaoLista).setNome(p.getNome());
                    listaPessoas.get(posicaoLista).setEmail(p.getEmail());
                    listaPessoas.get(posicaoLista).setTelefone(p.getTelefone());
                    posicaoLista = null;
                    buttonAdicionar.setText("ADICIONAR PESSOA");
                }else{
                    listaPessoas.add(new Pessoa(editTextNome.getText().toString(),editTextEmail.getText().toString(),editTextTelefone.getText().toString()));
                }
                customAdapter = new ListaSimplesAdapater(getApplicationContext(), listaPessoas);
                listaSimples.setAdapter(customAdapter);
            }
        });

        customAdapter = new ListaSimplesAdapater(getApplicationContext(), listaPessoas);

        listaSimples.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                Pessoa p = (Pessoa) customAdapter.getItem(position);
                editTextNome.setText(String.valueOf(p.getNome()));
                editTextTelefone.setText(String.valueOf(p.getTelefone()));
                editTextEmail.setText(String.valueOf(p.getEmail()));
                posicaoLista = position;
                Log.v("PEssoa","Nome: "+p.getNome());
                buttonAdicionar.setText("Salvar edição");

            }

        });

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("key", listaPessoas);
        super.onSaveInstanceState(outState);
    }
}
