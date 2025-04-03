package elementosBasicos.cartas;

import java.util.Random;


abstract public class Cartas {//porque siempre instanciaremos sus derivados

    private int[] numeros = {1, 2, 3, 4, 5, 6};

    public int[] getNumeros() {
        return numeros;
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }
    //Realmente necesitamos set e get numeros en plan solo os barajamos aqui XD


    public void barajar() {


        // Generar una instancia de Random :)
        Random random = new Random();

        // Barajar los números generando índices aleatorios
        for (int i = numeros.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            //Juego.consola.imprimir(j);
            // Intercambiar elementos
            int temp = numeros[i];
            numeros[i] = numeros[j];
            numeros[j] = temp;
        }

        // Imprimir el vector reordenado
        /*for(int i=0;i<6;i++){
            juego.Juego.consola.imprimir(""+numeros[i]);
        }*/

    }











}