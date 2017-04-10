package examples.jpsa.br.listview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aluno on 10/04/17.
 */

public class Pessoa implements Parcelable {


    private String nome;
    private String email;
    private String telefone;

    public Pessoa(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    private Pessoa(Parcel in) {
        nome = in.readString();
        email = in.readString();
        telefone = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return nome + ": " + email+" :"+telefone;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(nome);
        out.writeString(email);
        out.writeString(telefone);
    }

    public static final Parcelable.Creator<Pessoa> CREATOR = new Parcelable.Creator<Pessoa>() {
        public Pessoa createFromParcel(Parcel in) {
            return new Pessoa(in);
        }

        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
