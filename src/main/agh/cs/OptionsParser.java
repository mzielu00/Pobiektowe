package agh.cs;

import java.util.LinkedList;
import java.util.List;

public class OptionsParser {
    public static MoveDirection[] parse(String[] tab) {
        List<MoveDirection> lista = new LinkedList<>();
        for (String i : tab) {
            try {
                if (i.equals("f") || i.equals("forward")) {
                    lista.add(MoveDirection.FORWARD);
                } else if (i.equals("b") || i.equals("backward")) {
                    lista.add(MoveDirection.BACKWARD);
                } else if (i.equals("l") || i.equals("left")) {
                    lista.add(MoveDirection.LEFT);
                } else if (i.equals("r") || i.equals("right")) {
                    lista.add(MoveDirection.RIGHT);
                } else {
                    throw new IllegalArgumentException(i + " is not legal move specification");
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
            MoveDirection[] wynik = new MoveDirection[lista.size()];
            return lista.toArray(wynik);
        }
    }
