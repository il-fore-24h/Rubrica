/******************************************************************************

Rubrica rustica e Casereccia fatta da Utopia (aka ForTheFire)

 *******************************************************************************/
import java.util.Scanner;
public class Main
{
    public static String[][] rubrica = new String[3][100]; //primo nome, secondo cognome, terzo numero
    public static int nContatti = 0;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("#### RUBRICA ####");
        int input;
        boolean done = false;
        while(!done){
            System.out.print("1. Registra un nuovo contatto\n2. Elimina contatto\n3. Stampa rubrica\n4. Modifica contatto\n5. Esci\n");
            System.out.print("Scegli: ");

            input = sc.nextInt(); // Vorrei implementare try per catch un errore e darlo per non valido

            switch(input){
                case 1:
                    System.out.print("Inserisci nome: ");
                    String nome = sc.next();
                    System.out.print("Inserisci cognome: ");
                    String cognome = sc.next();
                    System.out.print("Inserisci numero: ");
                    String numero = sc.next();
                    register_entry(nome, cognome, numero);
                    break;
                case 2:
                    delete_entry(
                            selector(stampaRubrica())
                    );
                    break;
                case 3:
                    stampaRubrica();
                    break;
                case 4:
                    modify_entry(
                            selector(stampaRubrica())
                    );
                    break;
                case 5:
                    done=true;
                    break;
                case 6:
                    stampArr(cercaIniziale(String.valueOf(sc.next().charAt(0))));
                    break;
                default:
                    break;
            }
        }
    }

    public static void register_entry(String nome, String cognome, String numero){
        rubrica[0][nContatti] = nome;
        rubrica[1][nContatti] = cognome;
        rubrica[2][nContatti] = numero;
        nContatti++;
    }

    public static void delete_entry(int index){
        for (int i = 0; i<3; i++){
            rubrica[i][index] = null;
        }
        for (int i = index; i<rubrica[0].length-1; i++){
            for (int z = 0; z<3; z++){
                rubrica[z][i] = rubrica[z][i+1];
            }
        }
        nContatti--;
    }

    public static int stampaRubrica() {
        int val = 0;
        for (int i = 0; i<nContatti; i++){
            if (rubrica[0][0]==null){
                return val;
            } else if(rubrica[0][i]==null){
                break;
            }
            System.out.print((i+1) + ". ");
            System.out.print(rubrica[0][i] + " ");
            System.out.print(rubrica[1][i] + " ");
            System.out.println(rubrica[2][i]);
            val++;
        }
        System.out.println();
        System.out.println();
        return val;
    }

    public static int selector(int lunghezza){
        int input;

        do{
            System.out.print("Inserisci numero da 1 a " + lunghezza + ": ");
            input = sc.nextInt() - 1;
        }while (input < 0 || input>rubrica[0].length);

        return input;
    }

    public static void modify_entry(int index){
        String[] dati = asker(index);

        System.out.println("Contatto numero: " + index);
        System.out.println("Nome = " + rubrica[0][index]);
        System.out.println("Cognome = " + rubrica[1][index]);
        System.out.println("Numero = " + rubrica[2][index]);
        System.out.println();

        rubrica[0][index] = dati[0];
        rubrica[1][index] = dati[1];
        rubrica[2][index] = dati[2];
    }

    public static String[] asker(int ind){
        String[] dati = new String[3];
        boolean done = false;
        while (!done) {
            System.out.print("Scegli tra: \n1. Nome\n2. Cognome\n3. Numero\n4. Esci\n\nScelta: ");
            switch (sc.nextInt()) {
                case 1:
                    System.out.print("Inserisci nome: ");
                    dati[0] = sc.next();
                    break;
                case 2:
                    System.out.print("Inserisci cognome: ");
                    dati[1] = sc.next();
                    break;
                case 3:
                    System.out.print("Inserisci numero: ");
                    dati[2] = sc.next();
                    break;
                case 4:
                    done = true;
                default:
                    break;
            }
        }
        return  dati;
    }

    public static int[] cercaIniziale(String sel){
        int nRisultati = 0;
        Integer[] risultati = new Integer[nContatti * 2];
        // Nome
        for (int i = 0; i < nContatti; i++){
            if (rubrica[0][i].startsWith(sel)){
                risultati[nRisultati] = i;
                nRisultati++;
            }
        }
        // Cognome
        for (int i = 0; i < nContatti; i++){
            if (rubrica[1][i].startsWith(sel)){
                risultati[nRisultati] = i;
                nRisultati++;
            }
        }

        return polisher(risultati);
    }
    public static int[] polisher(Integer[] input){
        int lenght = 0;
        for (Integer integer : input) {
            if (integer != null) {
                lenght++;
            }
        }

        int[] polished = new int[lenght];
        for (int i = 0; i<polished.length; i++){
            polished[i] = input[i];
        }
        return polished;
    }
    public static void stampArr(int[] arr){
        for (int j : arr) {
            System.out.println(rubrica[0][j]);
            System.out.println(rubrica[1][j]);
            System.out.println(rubrica[2][j]);
        }
        System.out.println();
    }
}
