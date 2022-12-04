package Principal;
import java.util.ArrayList;
import java.util.Random;
public class PPTLS {

    public static String jogada(){
        String j1 = "pedra";
        String j2 = "papel";
        String j3 = "tesoura";
        String j4 = "lagarto";
        String j5 = "spock";
        ArrayList<String> jogadas = new ArrayList<>();
        jogadas.add(j1);
        jogadas.add(j2);
        jogadas.add(j3);
        jogadas.add(j4);
        jogadas.add(j5);
        return jogadas.get(new Random().nextInt(5));
    }
    public static int rodada(String j1, String j2){
        if(j1.equals("pedra") && j2.equals("papel")){return 2;}
        if(j1.equals("papel") && j2.equals("pedra")){return 1;}
        if(j1.equals("pedra") && j2.equals("tesoura")){return 1;}
        if(j1.equals("tesoura") && j2.equals("pedra")){return 2;}
        if(j1.equals("papel") && j2.equals("tesoura")){return 2;}
        if(j1.equals("tesoura") && j2.equals("papel")){return 1;}
        if(j1.equals("pedra") && j2.equals("lagarto")){return 1;}
        if(j1.equals("lagarto") && j2.equals("pedra")){return 2;}
        if(j1.equals("pedra") && j2.equals("spock")){return 2;}
        if(j1.equals("spock") && j2.equals("pedra")){return 1;}
        if(j1.equals("papel") && j2.equals("lagarto")){return 2;}
        if(j1.equals("lagarto") && j2.equals("papel")){return 1;}
        if(j1.equals("papel") && j2.equals("spock")){return 1;}
        if(j1.equals("spock") && j2.equals("papel")){return 2;}
        if(j1.equals("tesoura") && j2.equals("lagarto")){return 1;}
        if(j1.equals("lagarto") && j2.equals("tesoura")){return 2;}
        if(j1.equals("tesoura") && j2.equals("spock")){return 2;}
        if(j1.equals("spock") && j2.equals("tesoura")){return 1;}
        if(j1.equals("lagarto") && j2.equals("spock")){return 1;}
        if(j1.equals("spock") && j2.equals("lagarto")){return 2;}
        else{return 0;}
    }
}