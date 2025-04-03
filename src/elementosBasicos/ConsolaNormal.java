package elementosBasicos;

import java.util.Scanner;

final public class ConsolaNormal implements Consola {//final porque no hay ninguna clase que herede de esta
    private Scanner scanner ;

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public ConsolaNormal() {
        this.scanner = new Scanner(System.in);
    }

    public void imprimir(String string){
        if(string!=null){
            System.out.println(string);
        }
    }
    public void imprimirSimple(String string){
        if(string!=null){
            System.out.print(string);
        }
    }

    public String leer(String mensaje){
        imprimir(mensaje);
        String string = scanner.nextLine();
        return string;
    }


}
