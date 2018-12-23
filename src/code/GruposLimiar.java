package code;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Vector;

public class GruposLimiar {

    private Vector<Integer> valores = new Vector<Integer>();
    private int cor;
    private int soma = 0;
    private int media = 0;

    public GruposLimiar() {
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }


    public Vector<Integer> getValores() {
        return valores;
    }

   public void addValor(int valor){
       valores.addElement(valor);
   }

   public void zerar(){
       valores.clear();
       soma = 0;
   }
   public int media(){
       if(valores.size() != 0)
        media = this.somatorio()/valores.size();
       return Integer.parseInt(new DecimalFormat("#00").format(media));
   }

   private int somatorio(){
       for (Iterator<Integer> it = valores.iterator(); it.hasNext();) {
           Integer integer = it.next();
           soma += integer;
       }
       return soma;
   }

}
