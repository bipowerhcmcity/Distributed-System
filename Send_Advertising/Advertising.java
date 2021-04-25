
import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Latiude 7480
 */
public class Advertising implements Serializable{
    private float tv;
    private float radio;
    private float newspaper;
    private float sales;
    
    
    public Advertising(float tv, float radio, float newspaper, float sales){
        this.tv=tv;
        this.radio=radio;
        this.newspaper = newspaper;
        this.sales=sales;
    }
    public void getInfo(){
        System.out.println("Tv: "+tv+" radio: "+radio+"newspaper: "+newspaper+" sales: "+sales);
    }
    public String writeInfo(){
        return tv+","+radio+","+newspaper+","+sales+"\n";
    }
    
}
