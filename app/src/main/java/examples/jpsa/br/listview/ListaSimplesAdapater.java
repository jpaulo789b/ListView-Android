package examples.jpsa.br.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aluno on 03/04/17.
 */

public class ListaSimplesAdapater extends BaseAdapter {
    Context context;
    ArrayList<Pessoa> listaPessoas;

    LayoutInflater inflter;

    public ListaSimplesAdapater(Context applicationContext, ArrayList<Pessoa> listaPessoas) {
        this.context = context;
        this.listaPessoas = listaPessoas;

        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return listaPessoas.size();
    }

    @Override
    public Object getItem(int i) {
        return listaPessoas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_list, null);
        TextView nome = (TextView)  view.findViewById(R.id.textNome);
        TextView telefone = (TextView)  view.findViewById(R.id.textTelefone);
        TextView email = (TextView)  view.findViewById(R.id.textEmail);
        nome.setText(String.valueOf(listaPessoas.get(i).getNome()));
        telefone.setText(String.valueOf(listaPessoas.get(i).getTelefone()));
        email.setText(String.valueOf(listaPessoas.get(i).getEmail()));
        return view;
    }
}
