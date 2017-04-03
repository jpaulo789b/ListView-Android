package examples.jpsa.br.listview;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by aluno on 03/04/17.
 */

public class Pessoa implements Parcelable {

    private String nome;
    private String email;
    private String telefone;

    protected Pessoa(Parcel in) {
        nome = in.readString();
        email = in.readString();
        telefone = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(email);
        dest.writeString(telefone);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pessoa> CREATOR = new Creator<Pessoa>() {
        @Override
        public Pessoa createFromParcel(Parcel in) {
            return new Pessoa(in);
        }

        @Override
        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return nome + ": " + telefone+": "+email;
    }




}
