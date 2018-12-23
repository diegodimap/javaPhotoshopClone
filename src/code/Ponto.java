/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code;

/**
 *
 * @author bosco
 */
public class Ponto {

    private int cordenada_x;
    private int cordenada_y;

    public Ponto() {
    }

    public Ponto(int cordenada_x, int cordenada_y) {
        this.cordenada_x = cordenada_x;
        this.cordenada_y = cordenada_y;
    }

    public String toString(){
        return "("+this.cordenada_x +","+ this.cordenada_y + ")";
    }

    public int getCordenada_x() {
        return cordenada_x;
    }

    public void setCordenada_x(int cordenada_x) {
        this.cordenada_x = cordenada_x;
    }

    public int getCordenada_y() {
        return cordenada_y;
    }

    public void setCordenada_y(int cordenada_y) {
        this.cordenada_y = cordenada_y;
    }


}
