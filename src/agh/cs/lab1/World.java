package agh.cs.lab1;
public class World {
    public static void main(String[] args) {
        System.out.print("start\n");
        Direction[] tab= new Direction[args.length];
        int i = 0;
        while(i < args.length){
            switch(args[i]){
                case "f":
                    tab[i] = Direction.f;
                    break;
                case "b":
                    tab[i] = Direction.b;
                    break;
                case "l":
                    tab[i] = Direction.l;
                    break;
                case "r":
                    tab[i] = Direction.r;
                    break;
            }
            i ++;
        }
        run(tab);
        System.out.print("koniec");
    }
    public static void run(Direction[] Directiontab){
        for(Direction Dir : Directiontab){
            switch(Dir){
                case f:
                    System.out.print("zwierzak idzie do przodu\n");
                    break;
                case b:
                    System.out.print("zwierzak idzie do tyłu\n");
                    break;
                case l:
                    System.out.print("zwierzak idzie w lewo\n");
                    break;
                case r:
                    System.out.print("zwierzak idzie w prawo\n");
                    break;
            }
        }
    }
}

