package Principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor{
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Status Servidor: Aguardando Conexão");
        Socket s = ss.accept();
        System.out.println("Status Servidor: Cliente Conectado");
        PrintStream saida = new PrintStream(s.getOutputStream());
        saida.println("Servidor Conectado");
        InputStreamReader inputReader = new InputStreamReader(s.getInputStream());
        BufferedReader reader = new BufferedReader(inputReader);

        int rounds = 0;
        int vitoriasPython = 0;
        int vitoriasJava = 0;

        while(rounds < 15){
            String jogadorPython = reader.readLine();
            String jogadorJava = PPTLS.jogada();
            System.out.println("RODADA " + (rounds+1));
            System.out.println("Python = "+ jogadorPython);
            System.out.println("Java = "+ jogadorJava);
            int vencedor = PPTLS.rodada(jogadorPython , jogadorJava);
            if(vencedor == 0){System.out.println("Empate! Repetir rodada\n\n");}
            if(vencedor == 1){
                System.out.println("Python venceu a rodada!\n\n");
                rounds+=1;
                vitoriasPython+=1;
            }
            if(vencedor == 2){
                System.out.println("Java venceu a rodada!\n\n");
                rounds+=1;
                vitoriasJava+=1;
            }
            saida.println(rounds);
        }

        String s1 = "\nPlacar:\tPython " + vitoriasPython + " X " + vitoriasJava + " JAVA";

        if(vitoriasJava>vitoriasPython){
            String s2 = "\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\tJAVA FOI O VENCEDOR!" + "\n\n"+s1;
            System.out.println(s2);
            saida.println(s2);
        }
        if(vitoriasJava<vitoriasPython){
            String s2 = "\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\tPYTHON FOI O VENCEDOR!"+ "\n\n"+s1;
            System.out.println(s2);
            saida.println(s2);
        }
        Thread.sleep(1000);
        System.out.println("Status Servidor: Conexão Encerrada");
        ss.close();
   }
}