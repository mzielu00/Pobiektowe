package agh.cs.lab1;
public class World {
    public static void main(String[] args) {
        System.out.print("start\n");
        Direction[] tab= {Direction.f, Direction.l, Direction.b, Direction.r};
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

