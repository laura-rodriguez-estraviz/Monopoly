package elementosBasicos;
import Excepciones.AccionInvalida;
import elementosBasicos.casilla.*;
import juego.Juego;

import java.util.ArrayList;
import java.util.Scanner;

final public class Tablero {//final porque no hay ninguna clase que herede de esta
    private Casilla[] tablero;
    private float salida;
    private int numeroCasas;
    private int numeroHoteles;
    private int numeroPiscinas;
    private int numeroPistas;
    //private int idEdificio;
    private Grupo[] grupos;
    //getters
    public Casilla[] getTablero() {
        return tablero;
    }

    public float getSalida() {
        return salida;
    }

    public int getNumeroCasas() {
        return numeroCasas;
    }

    public int getNumeroHoteles() {
        return numeroHoteles;
    }

    public int getNumeroPiscinas() {
        return numeroPiscinas;
    }

    public int getNumeroPistas() {
        return numeroPistas;
    }

    //setters
    public void setSalida(float salida) {
        this.salida = salida;
    }
    //El setter de tablero no me hace falta ya que se generará
        //con el constructor y no se volverá a cambiar en su totalidad aunque las casillas que lo forman si se vean modificadas

    public void setNumeroCasas(int numeroCasas) {
        this.numeroCasas = numeroCasas;
    }

    public void setNumeroHoteles(int numeroHoteles) {
        this.numeroHoteles = numeroHoteles;
    }

    public void setNumeroPiscinas(int numeroPiscinas) {
        this.numeroPiscinas = numeroPiscinas;
    }

    public void setNumeroPistas(int numeroPistas) {
        this.numeroPistas = numeroPistas;
    }

    public Tablero() {
        this.salida=(float)13013.265;
        this.tablero= new Casilla[40];
        this.grupos=new Grupo[8];
        new ArrayList<>();
        grupos[0]=new Grupo("marron");
        grupos[1]=new Grupo("azul claro");
        grupos[2]=new Grupo("rosa");
        grupos[3]=new Grupo("naranja");
        grupos[4]=new Grupo("rojo");
        grupos[5]=new Grupo("amarillo");
        grupos[6]=new Grupo("verde");
        grupos[7]=new Grupo("azul oscuro");

        tablero[0]=new Especial("Salida",(float)13013.265,"\u001B[0m",0);



        tablero[1]=new Solar("Ancares","\033[38;5;94m","Banca",
                6000,6000,600,3600,3600,2400,7500,1,grupos[0]);
        grupos[0].getPropiedades().add((Propiedad)tablero[1]);


        tablero[2]=new AccionCajaComunidad("Caja",null,"\u001B[0m",2);



        tablero[3]=new Solar("Valdeorras","\033[38;5;94m","Banca",
                6000,6000,600,3600,3600,2400,7500,
                3,grupos[0]);
        grupos[0].getPropiedades().add((Propiedad)tablero[3]);


        tablero[4]=new Impuesto("Impuestos1",4,(float)13013.265);



        tablero[5]=new Transporte("Banca",(float)13013.285,(float)13013.285,(float)13013.285,"Puertos","\u001B[0m",5);



        tablero[6]=new Solar("Lugo","\033[38;5;81m","Banca",
                5200,5200,520,3120,3120,2080,6500,
                6,grupos[1]);
        grupos[1].getPropiedades().add((Propiedad)tablero[6]);


        tablero[7]=new AccionSuerte("Suerte",null,"\u001B[0m",7);



        tablero[8]=new Solar("Terra Cha","\033[38;5;81m","Banca",
                5200,5200,520,3120,3120,2080,6500,
                8,grupos[1]);
        grupos[1].getPropiedades().add((Propiedad)tablero[8]);


        tablero[9]=new Solar("Fonsagrada","\033[38;5;81m","Banca",
                5200,5200,520,3120,3120,2080,6500,
                9,grupos[1]);
        grupos[1].getPropiedades().add((Propiedad)tablero[9]);


        tablero[10]=new Especial("Carcel",(float)13013.265/4,"\u001B[0m",10);



        tablero[11]=new Solar("Ourense","\033[38;5;13m","Banca",
                6760,6760,676,4056,4056,2704,8450,
                11,grupos[2]);
        grupos[2].getPropiedades().add((Propiedad)tablero[11]);


        tablero[12]=new Servicio("Banca",(float)9759.69375,(float)65.066325,(float)65.066325,
                "Telecomunicaciones","\u001B[0m",12);



        tablero[13]=new Solar("Celanova","\033[38;5;13m","Banca",
                6760,6760,676,4056,4056,2704,8450,
                13,grupos[2]);
        grupos[2].getPropiedades().add((Propiedad)tablero[13]);


        tablero[14]=new Solar("Allariz","\033[38;5;13m","Banca",
                6760,6760,676,4056,4056,2704,8450,
                14,grupos[2]);
        grupos[2].getPropiedades().add((Propiedad)tablero[14]);


        tablero[15]=new Transporte("Banca",(float)13013.285,(float)13013.285,(float)13013.285,
                "Aeropuertos","\u001B[0m",15);



        tablero[16]=new Solar("Verin","\033[38;5;202m","Banca",
                8788,8788,(float)878.8,(float)5272.8,(float)5272.8,(float)3515.2,10985,
                16,grupos[3]);
        grupos[3].getPropiedades().add((Propiedad)tablero[16]);


        tablero[17]=new AccionCajaComunidad("Caja",null,"\u001B[0m",17);



        tablero[18]=new Solar("A Limia","\033[38;5;202m","Banca",
                8788,8788,(float)878.8,(float)5272.8,(float)5272.8,(float)3515.2,10985,
                18,grupos[3]);
        grupos[3].getPropiedades().add((Propiedad)tablero[18]);


        tablero[19]=new Solar("Viana","\033[38;5;202m","Banca",
                8788,8788,(float)878.8,(float)5272.8,(float)5272.8,(float)3515.2,10985,
                19,grupos[3]);
        grupos[3].getPropiedades().add((Propiedad)tablero[19]);


        tablero[20]=new Especial("Parking",0,"\u001B[0m",20);



        tablero[21]=new Solar("A Coruña","\033[38;5;124m","Banca",
                (float)11424.4,(float)11424.4,(float)1142.44,(float)11424.4,(float)11424.4,(float)4569.76,(float)14280.5,
                21,grupos[4]);
        grupos[4].getPropiedades().add((Propiedad)tablero[21]);


        tablero[22]=new AccionSuerte("Suerte",null,"\u001B[0m",22);



        tablero[23]=new Solar("Betanzos","\033[38;5;124m","Banca",
                (float)11424.4,(float)11424.4,(float)1142.44,(float)11424.4,(float)11424.4,(float)4569.76,(float)14280.5,
                23,grupos[4]);
        grupos[4].getPropiedades().add((Propiedad)tablero[23]);


        tablero[24]=new Solar("Ferrol","\033[38;5;124m","Banca",
                (float)11424.4,(float)11424.4,(float)1142.44,(float)11424.4,(float)11424.4,(float)4569.76,(float)14280.5,
                24,grupos[4]);
        grupos[4].getPropiedades().add((Propiedad)tablero[24]);


        tablero[25]=new Transporte("Banca",(float)13013.285,(float)13013.285,(float)13013.285,
                "Ferrocarriles","\u001B[0m",25);



        tablero[26]=new Solar("Finisterre","\033[38;5;227m","Banca",
                (float)14851.72,(float)14851.72,(float)1485.172,(float)8911.032,(float)8911.032,(float)5940.688,(float)18564.6875,
                26, grupos[5]);
        grupos[5].getPropiedades().add((Propiedad)tablero[26]);


        tablero[27]=new Solar("Muros","\033[38;5;227m","Banca",
                (float)14851.72,(float)14851.72,(float)1485.172,(float)8911.032,(float)8911.032,(float)5940.688,(float)18564.6875,
                27, grupos[5]);
        grupos[5].getPropiedades().add((Propiedad)tablero[27]);


        tablero[28]=new Servicio("Banca",(float)9759.69375,(float)9759.69375,(float)65.066325,
                "Electricidad","\u001B[0m",28);



        tablero[29]=new Solar("Noya","\033[38;5;227m","Banca",
                (float)14851.72,(float)14851.72,(float)1485.172,(float)8911.032,(float)8911.032,(float)5940.688,(float)18564.6875,
                29, grupos[5]);
        grupos[5].getPropiedades().add((Propiedad)tablero[29]);


        tablero[30]=new Especial("IrCarcel",0,"\u001B[0m",30);



        tablero[31]=new Solar("Santiago","\033[38;5;22m","Banca",
                (float)19307.236,(float)19307.236,(float)1930.7236,(float)11584.3416,(float)11584.3416,(float)7722.8944,(float)24134.045,
                31, grupos[6]);
        grupos[6].getPropiedades().add((Propiedad)tablero[31]);


        tablero[32]=new Solar("Ordes","\033[38;5;22m","Banca",
                (float)19307.236,(float)19307.236,(float)1930.7236,(float)11584.3416,(float)11584.3416,(float)7722.8944,(float)24134.045,
                32, grupos[6]);
        grupos[6].getPropiedades().add((Propiedad)tablero[32]);


        tablero[33]=new AccionCajaComunidad("Caja",null,"\u001B[0m",33);



        tablero[34]=new Solar("Arzua","\033[38;5;22m","Banca",
                (float)19307.236,(float)19307.236,(float)1930.7236,(float)11584.3416,(float)11584.3416,(float)7722.8944,(float)24134.045,
                34, grupos[6]);
        grupos[6].getPropiedades().add((Propiedad)tablero[34]);


        tablero[35]=new Transporte("Banca",(float)13013.285,(float)13013.285,(float)13013.285,
                "NavesEspaciales","\u001B[0m",35);



        tablero[36]=new AccionSuerte("Suerte",null,"\u001B[0m",36);



        tablero[37]=new Solar("Vigo","\033[38;5;17m","Banca",
                (float)37649.1102,(float)37649.1102,(float)3764.91102,(float)22589.46612,(float)22589.46612,(float)15059.64408,(float)47061.38775,
                37, grupos[7]);
        grupos[7].getPropiedades().add((Propiedad)tablero[37]);


        tablero[38]=new Impuesto("Impuestos2",38,(float)6506.6325);



        tablero[39]=new Solar("Pontevedra","\033[38;5;17m","Banca",
                (float)37649.1102,(float)37649.1102,(float)3764.91102,(float)22589.46612,(float)22589.46612,(float)15059.64408,(float)47061.38775,
                39, grupos[7]);
        grupos[7].getPropiedades().add((Propiedad)tablero[39]);
    }

    private String stravatares(int j){
        if (this.tablero[j].getJugadoresCasilla().isEmpty())
            return "";
        else{
            int i;
            String str="&";
            for (i=0;i<this.tablero[j].getJugadoresCasilla().size();i++)
                str+=this.tablero[j].getJugadoresCasilla().get(i).getAvatar().getAvatar();
            return str;
        }
    }

    public String toString(){
        int i;
        String s=" ",s2="\u001B[0m",s3="";
        for (i=0;i<11;i++)
            s+="\u001B[4m"+" ".repeat(27)+"\u001B[0m ";
        for (i=0;i<9;i++)
            s2+=" ".repeat(27);
        s2+=" ".repeat(8);
        for (i=0;i<8;i++)
            s3+="\u001B[4m"+" ".repeat(27)+"\u001B[0m ";
        s3+="\u001B[4m"+" ".repeat(27);
        return
                //linea 1
                s+"\n|\u001B[4m%-20s%7s".formatted(this.tablero[20].getNombreCasilla(),this.stravatares(20))+"\u001B[0m|"+
                        this.tablero[21].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[21].getNombreCasilla(),this.stravatares(21))+"\u001B[0m|"+
                        this.tablero[22].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[22].getNombreCasilla(),this.stravatares(22))+"\u001B[0m|"+
                        this.tablero[23].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[23].getNombreCasilla(),this.stravatares(23))+"\u001B[0m|"+
                        this.tablero[24].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[24].getNombreCasilla(),this.stravatares(24))+"\u001B[0m|"+
                        this.tablero[25].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[25].getNombreCasilla(),this.stravatares(25))+"\u001B[0m|"+
                        this.tablero[26].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[26].getNombreCasilla(),this.stravatares(26))+"\u001B[0m|"+
                        this.tablero[27].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[27].getNombreCasilla(),this.stravatares(27))+"\u001B[0m|"+
                        this.tablero[28].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[28].getNombreCasilla(),this.stravatares(28))+"\u001B[0m|"+
                        this.tablero[29].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[29].getNombreCasilla(),this.stravatares(29))+"\u001B[0m|"+
                        this.tablero[30].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[30].getNombreCasilla(),this.stravatares(30))+"\u001B[0m|\n"+

                        //linea 2
                        "|"+this.tablero[19].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[19].getNombreCasilla(),this.stravatares(19))+"\u001B[0m|"+s2+
                        "|"+this.tablero[31].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[31].getNombreCasilla(),this.stravatares(31))+"\u001B[0m|\n"+

                        //linea 3
                        "|"+this.tablero[18].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[18].getNombreCasilla(),this.stravatares(18))+"\u001B[0m|"+s2+
                        "|"+this.tablero[32].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[32].getNombreCasilla(),this.stravatares(32))+"\u001B[0m|\n"+

                        //linea 4
                        "|"+this.tablero[17].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[17].getNombreCasilla(),this.stravatares(17))+"\u001B[0m|"+s2+
                        "|"+this.tablero[33].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[33].getNombreCasilla(),this.stravatares(33))+"\u001B[0m|\n"+

                        //linea 5
                        "|"+this.tablero[16].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[16].getNombreCasilla(),this.stravatares(16))+"\u001B[0m|"+s2+
                        "|"+this.tablero[34].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[34].getNombreCasilla(),this.stravatares(34))+"\u001B[0m|\n"+

                        //linea 6
                        "|"+this.tablero[15].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[15].getNombreCasilla(),this.stravatares(15))+"\u001B[0m|"+s2+
                        "|"+this.tablero[35].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[35].getNombreCasilla(),this.stravatares(35))+"\u001B[0m|\n"+

                        //linea 7
                        "|"+this.tablero[14].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[14].getNombreCasilla(),this.stravatares(14))+"\u001B[0m|"+s2+
                        "|"+this.tablero[36].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[36].getNombreCasilla(),this.stravatares(36))+"\u001B[0m|\n"+

                        //linea 8
                        "|"+this.tablero[13].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[13].getNombreCasilla(),this.stravatares(13))+"\u001B[0m|"+s2+
                        "|"+this.tablero[37].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[37].getNombreCasilla(),this.stravatares(37))+"\u001B[0m|\n"+

                        //linea 9
                        "|"+this.tablero[12].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[12].getNombreCasilla(),this.stravatares(12))+"\u001B[0m|"+s2+
                        "|"+this.tablero[38].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[38].getNombreCasilla(),this.stravatares(38))+"\u001B[0m|\n"+

                        //linea 10
                        "|"+this.tablero[11].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[11].getNombreCasilla(),this.stravatares(11))+"\u001B[0m|"+s3+
                        "\u001B[0m|"+this.tablero[39].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[39].getNombreCasilla(),this.stravatares(39))+"\u001B[0m|\n"+

                        //linea 11
                        "|\u001B[4m%-20s%7s".formatted(this.tablero[10].getNombreCasilla(),this.stravatares(10))+"\u001B[0m|"+
                        this.tablero[9].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[9].getNombreCasilla(),this.stravatares(9))+"\u001B[0m|"+
                        this.tablero[8].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[8].getNombreCasilla(),this.stravatares(8))+"\u001B[0m|"+
                        this.tablero[7].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[7].getNombreCasilla(),this.stravatares(7))+"\u001B[0m|"+
                        this.tablero[6].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[6].getNombreCasilla(),this.stravatares(6))+"\u001B[0m|"+
                        this.tablero[5].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[5].getNombreCasilla(),this.stravatares(5))+"\u001B[0m|"+
                        this.tablero[4].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[4].getNombreCasilla(),this.stravatares(4))+"\u001B[0m|"+
                        this.tablero[3].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[3].getNombreCasilla(),this.stravatares(3))+"\u001B[0m|"+
                        this.tablero[2].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[2].getNombreCasilla(),this.stravatares(2))+"\u001B[0m|"+
                        this.tablero[1].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[1].getNombreCasilla(),this.stravatares(1))+"\u001B[0m|"+
                        this.tablero[0].getCodigoColor()+"\u001B[4m%-20s%7s".formatted(this.tablero[0].getNombreCasilla(),this.stravatares(0))+"\u001B[0m|\n"
                ;

    }

    private float mediaTablero(){
        int i;
        float result=0;
        for (i=0;i<40;i++){
            if (this.tablero[i].getClass().getSimpleName().equals("Solar"))
                result+=((Solar)this.tablero[i]).getValor();
        }
        return result/22;
    }

    public void cuatroVueltas(){
        int i;
        for (i=0;i<40;i++){
            if (this.tablero[i].getClass().getSimpleName().equals("Solar")){
                if (((Solar)this.tablero[i]).getPropietario().equals("Banca"))
                    ((Solar)this.tablero[i]).setValor((float) (((Solar)this.tablero[i]).getValor() * 1.05));
            }
        }
        this.salida=mediaTablero();
        //impuestos
        ((Impuesto)this.tablero[4]).setValor(salida);
        ((Impuesto)this.tablero[38]).setValor(salida/2);
        //transporte
        ((Transporte)this.tablero[5]).setAlquiler(salida);
        ((Transporte)this.tablero[15]).setAlquiler(salida);
        ((Transporte)this.tablero[25]).setAlquiler(salida);
        ((Transporte)this.tablero[35]).setAlquiler(salida);
        //carcel
        ((Especial)this.tablero[10]).setValor((float)(salida*0.25));
        //factor de servicio
        ((Servicio)this.tablero[12]).setAlquiler(salida/200);
        ((Servicio)this.tablero[28]).setAlquiler(salida/200);
    }

    public void describirCasilla(String nombre) throws Exception{
        int i=0;
        while (!this.tablero[i].getNombreCasilla().equals(nombre)&&i<39) {
            i++;
        }
        if(this.tablero[i].getNombreCasilla().equals(nombre)) {
            Juego.consola.imprimir(this.tablero[i].toString());
        }
        else {
            throw new Exception("La casilla no existe.");
            //Juego.consola.imprimir("La casilla no existe\n");
        }
    }





    public void venderEdificio(Juego juego) throws Exception{   //PENSAR EN FACER A LINEA DE NO TIENES TANTAS CASAS UNHA EXCEPCIÓN ESPECIAL
        String nombre;
        int i=0,aux,j=0, edificiosEliminados=0;
        nombre=Juego.consola.leer("De que casilla son los edificios que quiere vender?");
        while (!this.tablero[i].getNombreCasilla().equals(nombre)&&i<39)
            i++;
        if(this.tablero[i].getNombreCasilla().equals(nombre)) {
            if (this.tablero[i].getClass().getSimpleName().equals("Solar")) {
                if (((Propiedad)this.tablero[i]).getPropietario().equals(juego.getListaJugadores().get(juego.getTurno()).getNombre())) {
                    if (!((Propiedad)this.tablero[i]).isHipotecado()) {
                        Juego.consola.imprimir("En este solar hay "+((Solar)this.tablero[i]).getCasas()+" casa(s), "+((Solar)this.tablero[i]).getHoteles()+" hotel(es), "+((Solar)this.tablero[i]).getPistasDeporte()+" pista(s) de deporte y "+((Solar)this.tablero[i]).getPiscinas()+" piscina(s).");
                        nombre=Juego.consola.leer("Que tipo de edificio desea vender? (casa, hotel, pista de deporte o piscina)");
                        if (nombre.equals("casa")){
                            aux= Integer.parseInt(Juego.consola.leer("Cuantas casas desea vender?"));
                            if (aux<=((Solar)this.tablero[i]).getCasas()){
                                if (aux>=0){
                                    while (edificiosEliminados<aux){
                                        if (((Solar)this.tablero[i]).getEdificios().get(j).getClass().getSimpleName().equals("Casa")){
                                            ((Solar)this.tablero[i]).getEdificios().remove(j);
                                            j--;
                                            edificiosEliminados++;
                                        }
                                        j++;
                                    }
                                    ((Solar)this.tablero[i]).setCasas(((Solar)this.tablero[i]).getCasas()-aux);
                                    Juego.consola.imprimir("Se han vendido "+aux+" casas en "+this.tablero[i].getNombreCasilla()+" por el valor de "+aux*((Solar)this.tablero[i]).getValorCasa()/2+". En la propiedad quedan "+((Solar)this.tablero[i]).getCasas()+" casas.");
                                    juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero()+aux*((Solar)this.tablero[i]).getValorCasa()/2);
                                }else throw new AccionInvalida("Valor no válido.", juego);//Juego.consola.imprimir("Valor no válido");

                            }
                            else Juego.consola.imprimir("No hay tantas casas en el solar!. Solo se podría vender "+((Solar)this.tablero[i]).getCasas()+" casas, recibiendo un total de "+((Solar)this.tablero[i]).getCasas()*((Solar)this.tablero[i]).getValorCasa()/2);

                        }
                        else if (nombre.equals("hotel")){
                            aux= Integer.parseInt(Juego.consola.leer("Cuantos hoteles desea vender?"));
                            if (aux<=((Solar)this.tablero[i]).getHoteles()){
                                if (aux>=0){
                                    while (edificiosEliminados<aux){
                                        if (((Solar)this.tablero[i]).getEdificios().get(j).getClass().getSimpleName().equals("Hotel")){
                                            ((Solar)this.tablero[i]).getEdificios().remove(j);
                                            j--;
                                            edificiosEliminados++;
                                        }
                                        j++;
                                    }
                                    ((Solar)this.tablero[i]).setHoteles(((Solar)this.tablero[i]).getHoteles()-aux);
                                    Juego.consola.imprimir("Se han vendido "+aux+" hoteles en "+this.tablero[i].getNombreCasilla()+" por el valor de "+aux*((Solar)this.tablero[i]).getValorHotel()/2+". En la propiedad quedan "+((Solar)this.tablero[i]).getHoteles()+" hoteles.");

                                    juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero()+aux*((Solar)this.tablero[i]).getValorHotel()/2);

                                }else throw new AccionInvalida("Valor no válido.", juego);//Juego.consola.imprimir("Valor no válido");

                            }
                            else Juego.consola.imprimir("No hay tantos hoteles en el solar!. Solo se podría vender "+((Solar)this.tablero[i]).getHoteles()+" hoteles, recibiendo un total de "+((Solar)this.tablero[i]).getHoteles()*((Solar)this.tablero[i]).getValorHotel()/2);

                        }
                        else if (nombre.equals("pista de deporte")){
                            aux= Integer.parseInt(Juego.consola.leer("Cuantas pistas de deporte desea vender?"));
                            if (aux<=((Solar)this.tablero[i]).getPistasDeporte()){
                                if (aux>=0){
                                    while (edificiosEliminados<aux){
                                        if (((Solar)this.tablero[i]).getEdificios().get(j).getClass().getSimpleName().equals("PistaDeporte")){
                                            ((Solar)this.tablero[i]).getEdificios().remove(j);
                                            j--;
                                            edificiosEliminados++;
                                        }
                                        j++;
                                    }
                                    ((Solar)this.tablero[i]).setPistasDeporte(((Solar)this.tablero[i]).getPistasDeporte()-aux);
                                    Juego.consola.imprimir("Se han vendido "+aux+" pistas de deporte en "+this.tablero[i].getNombreCasilla()+" por el valor de "+aux*((Solar)this.tablero[i]).getValorPistaDeporte()/2+". En la propiedad quedan "+((Solar)this.tablero[i]).getPistasDeporte()+" pistas de deporte.");
                                    juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero()+aux*((Solar)this.tablero[i]).getValorPistaDeporte()/2);
                                }else throw new AccionInvalida("Valor no válido.", juego);//Juego.consola.imprimir("Valor no válido");

                            }
                            else Juego.consola.imprimir("No hay tantas pistas de deporte en el solar!. Solo se podría vender "+((Solar)this.tablero[i]).getPistasDeporte()+" pistas de deporte, recibiendo un total de "+((Solar)this.tablero[i]).getPistasDeporte()*((Solar)this.tablero[i]).getValorPistaDeporte()/2);

                        }
                        else if (nombre.equals("piscina")){
                            aux= Integer.parseInt(Juego.consola.leer("Cuantas piscinas desea vender?"));
                            if (aux<=((Solar)this.tablero[i]).getPiscinas()){
                                if (aux>=0){
                                    while (edificiosEliminados<aux){
                                        if (((Solar)this.tablero[i]).getEdificios().get(j).getClass().getSimpleName().equals("Piscina")){
                                            ((Solar)this.tablero[i]).getEdificios().remove(j);
                                            j--;
                                            edificiosEliminados++;
                                        }
                                        j++;
                                    }
                                    ((Solar)this.tablero[i]).setPiscinas(((Solar)this.tablero[i]).getPiscinas()-aux);
                                    Juego.consola.imprimir("Se han vendido "+aux+" piscinas en "+this.tablero[i].getNombreCasilla()+" por el valor de "+aux*((Solar)this.tablero[i]).getValorPiscina()/2+". En la propiedad quedan "+((Solar)this.tablero[i]).getPiscinas()+" piscinas.");
                                    juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero()+aux*((Solar)this.tablero[i]).getValorPiscina()/2);
                                }else throw new AccionInvalida("Valor no válido.", juego);//Juego.consola.imprimir("Valor no válido");

                            }
                            else Juego.consola.imprimir("No hay tantas piscinas en el solar!. Solo se podría vender "+((Solar)this.tablero[i]).getPiscinas()+" piscinas, recibiendo un total de "+((Solar)this.tablero[i]).getPiscinas()*((Solar)this.tablero[i]).getValorPiscina()/2);


                        }else throw new AccionInvalida("Tipo de edificio no válido.", juego);//Juego.consola.imprimir("Tipo de edificio no válido");
                    } else throw new AccionInvalida("Esta propiedad está hipotecada! No hay edificios que vender aqui.", juego);//Juego.consola.imprimir("Esta propiedad está hipotecada! No hay edificios que vender aqui." );
                } else throw new AccionInvalida("Usted no es propietario de este solar!", juego);//Juego.consola.imprimir("Usted no es propietario de este solar!");
            }else throw new AccionInvalida("Esta casilla no es un solar! No hay edificios que vender aqui.", juego);//Juego.consola.imprimir("Esta casilla no es un solar! No hay edificios que vender aqui.");
        }
        else
            throw new AccionInvalida("La casilla no existe.", juego);//Juego.consola.imprimir("La casilla no existe");

    }

    public void hipotecar(Juego juego) throws Exception{
        String nombre;
        int i=0;
        nombre=Juego.consola.leer("Que casilla desea hipotecar?");
        while (!this.tablero[i].getNombreCasilla().equals(nombre)&&i<39)
            i++;
        if(this.tablero[i].getNombreCasilla().equals(nombre)){
            if (this.tablero[i] instanceof Propiedad) {
                if (juego.getListaJugadores().get(juego.getTurno()).getNombre().equals(((Propiedad)this.tablero[i]).getPropietario())) {
                    if (this.tablero[i].getClass().getSimpleName().equals("Solar")) {
                        if (((Solar) this.tablero[i]).getEdificios().size() > 0) {
                            Juego.consola.imprimir("Debes vender los edificios del solar antes de hipotecarlo!");
                            return;
                        }
                    }
                    if (!((Propiedad)this.tablero[i]).isHipotecado()) {
                        ((Propiedad)this.tablero[i]).setHipotecado(true);
                        juego.getListaJugadores().get(juego.getTurno()).getPropiedades().remove(this.tablero[i]);
                        juego.getListaJugadores().get(juego.getTurno()).getHipotecas().add(this.tablero[i]);
                        juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero()+((Propiedad)this.tablero[i]).getValorInicial()/2);
                        if (this.tablero[i].getClass().getSimpleName().equals("Solar"))
                            Juego.consola.imprimir(juego.getListaJugadores().get(juego.getTurno()).getNombre()+" recibe "+((Propiedad)this.tablero[i]).getValorInicial()/2+"€ por la hipoteca de "+this.tablero[i].getNombreCasilla()+". No podra recibir el alquiler ni edificar en la casilla "+((Solar)this.tablero[i]).getGrupo().getGrupoCasilla()+".");
                        else Juego.consola.imprimir(juego.getListaJugadores().get(juego.getTurno()).getNombre()+" recibe "+((Propiedad)this.tablero[i]).getValorInicial()/2+"€ por la hipoteca de "+this.tablero[i].getNombreCasilla()+".");

                    } else throw new AccionInvalida("Esta propiedad ya está hipotecada", juego);//Juego.consola.imprimir("Esta propiedad ya esta hipotecada!");
                } else throw new AccionInvalida("Esta propiedad no es suya!", juego);//Juego.consola.imprimir("Esta propiedad no es suya!");
            } else throw new AccionInvalida("Esta casilla no es una propiedad", juego);//Juego.consola.imprimir("Esta casilla no es una propiedad!");
        } else throw new AccionInvalida("La casilla no existe", juego);//Juego.consola.imprimir("La casilla no existe");
    }

    public void deshipotecar(Juego juego) throws Exception{
        String nombre;
        int i=0;
        nombre=Juego.consola.leer("Que casilla desea deshipotecar?");
        while (!this.tablero[i].getNombreCasilla().equals(nombre)&&i<39)
            i++;
        if(this.tablero[i].getNombreCasilla().equals(nombre)){
            if (this.tablero[i] instanceof Propiedad) {
                if (juego.getListaJugadores().get(juego.getTurno()).getNombre().equals(((Propiedad)this.tablero[i]).getPropietario())) {
                    if (((Propiedad)this.tablero[i]).isHipotecado()) {
                        if (juego.getListaJugadores().get(juego.getTurno()).getDinero()>((Propiedad)this.tablero[i]).getValorInicial()/2*(float)1.1) {
                            ((Propiedad)this.tablero[i]).setHipotecado(false);
                            juego.getListaJugadores().get(juego.getTurno()).getPropiedades().add(this.tablero[i]);
                            juego.getListaJugadores().get(juego.getTurno()).getHipotecas().remove(this.tablero[i]);
                            juego.getListaJugadores().get(juego.getTurno()).setDinero(juego.getListaJugadores().get(juego.getTurno()).getDinero() - ((Propiedad)this.tablero[i]).getValorInicial()/2 * (float) 1.1);
                            if (this.tablero[i].getClass().getSimpleName().equals("Solar"))
                                Juego.consola.imprimir(juego.getListaJugadores().get(juego.getTurno()).getNombre() + " paga " + ((Propiedad)this.tablero[i]).getValorInicial()/2 * (float) 1.1 + "€ por deshipotecar " + this.tablero[i].getNombreCasilla() + ". Ahora puede recibir el alquler y edificar la casilla " + ((Solar)this.tablero[i]).getGrupo().getGrupoCasilla() + ".");
                            else
                                Juego.consola.imprimir(juego.getListaJugadores().get(juego.getTurno()).getNombre() + " paga " + ((Propiedad)this.tablero[i]).getValorInicial()/2 * (float) 1.1 + "€ por deshipotecar " + this.tablero[i].getNombreCasilla() + ".");
                        }else throw new AccionInvalida("No tiene suficiente dinero deshipotecar esta propiedad!", juego);//Juego.consola.imprimir("No tiene suficiente dinero deshipotecar esta propiedad!");
                    } else throw new AccionInvalida("Esta propiedad no está hipotecada", juego);//Juego.consola.imprimir("Esta propiedad no esta hipotecada!");
                } else throw new AccionInvalida("Esta propiedad no es suya", juego);//Juego.consola.imprimir("Esta propiedad no es suya!");
            } else throw new AccionInvalida("Esta casilla no es una propiedad", juego);//Juego.consola.imprimir("Esta casilla no es una propiedad!");
        } else throw new AccionInvalida("La casilla no existe", juego);//Juego.consola.imprimir("La casilla no existe\n");
    }

    public void listar_edificios(){
        int i,j;
        for (i=0;i<40;i++){
            if (tablero[i].getClass().getSimpleName().equals("Solar")) {
                for (j = 0; j < ((Solar)tablero[i]).getEdificios().size(); j++) {
                    Juego.consola.imprimir(((Solar)tablero[i]).getEdificios().get(j).toString());
                }
            }
        }
    }

    public void listar_edificios_grupo(String grupo) {
        String aux[] = new String[4];
        aux[0] = "";
        aux[1] = "";
        aux[2] = "";
        aux[3] = "";
        int i, j = 0, m;
        boolean bool = false;
        while (bool != true && j < grupos.length) {
            if (grupos[j].getGrupoCasilla().equals(grupo)) {
                bool = true;
            }
            j++;
        }
        j--;
        if (bool) {
            for (i=0;i<grupos[j].getPropiedades().size();i++) {
                for (m = 0; m < ((Solar)grupos[j].getPropiedades().get(i)).getEdificios().size(); m++) {
                    if (((Solar)grupos[j].getPropiedades().get(i)).getEdificios().get(m).getClass().getSimpleName().equals("Casa"))
                        aux[0] += " " + ((Solar)grupos[j].getPropiedades().get(i)).getEdificios().get(m).getId();
                    else if (((Solar)grupos[j].getPropiedades().get(i)).getEdificios().get(m).getClass().getSimpleName().equals("Hotel"))
                        aux[1] += " " + ((Solar)grupos[j].getPropiedades().get(i)).getEdificios().get(m).getId();
                    else if (((Solar)grupos[j].getPropiedades().get(i)).getEdificios().get(m).getClass().getSimpleName().equals("Piscina"))
                        aux[2] += " " + ((Solar)grupos[j].getPropiedades().get(i)).getEdificios().get(m).getId();
                    else if (((Solar)grupos[j].getPropiedades().get(i)).getEdificios().get(m).getClass().getSimpleName().equals("PistaDeporte"))
                        aux[3] += " " + ((Solar)grupos[j].getPropiedades().get(i)).getEdificios().get(m).getId();

                }
                Juego.consola.imprimir("{\n" +
                        "propiedad: " + grupos[j].getPropiedades().get(i).getNombreCasilla() + "\n" +
                        "casas: " + aux[0] + "\n" +
                        "hoteles: " + aux[1] + "\n" +
                        "piscinas: " + aux[2] + "\n" +
                        "pistasDeDeporte: " + aux[3] + "\n" +
                        "alquiler: " + ((Solar) grupos[j].getPropiedades().get(i)).alquiler() + "\n" +
                        "}");

            }
        }
        else Juego.consola.imprimir("Ese grupo no existe!");


    }
}


