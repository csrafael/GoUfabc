package android.ufabc.edu.br.goufabc;

/**
 * Created by root on 18/08/16.
 */
public class Time implements java.io.Serializable{
    private String trainer;
    private String numero;
    private String nome;
    private String CP;
    private String HP;

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getHP() {
        return HP;
    }

    public void setHP(String HP) {
        this.HP = HP;
    }

    public String toString(){
        return numero+" "+nome;
    }
}
