package agh.cs;

import java.util.LinkedList;
import java.util.List;

public class OptionsParser {
    public static MoveDirection[] parse(String[] tab){
        List<MoveDirection> lista = new LinkedList<>();
        for (String i: tab ){
            if( i.equals("f") || i.equals("forward")){
                lista.add(MoveDirection.FORWARD);
            }
            if( i.equals("b") || i.equals("backward")){
                lista.add(MoveDirection.BACKWARD);
            }
            if( i.equals("l") || i.equals("left")){
                lista.add(MoveDirection.LEFT);
            }
            if( i.equals("r") || i.equals("right")){
                lista.add(MoveDirection.RIGHT);
            }
        }
        MoveDirection[] wynik = new MoveDirection[lista.size()];
        return lista.toArray(wynik);
    }
}
