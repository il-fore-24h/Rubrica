/******************************************************************************

 Welcome to GDB Online.
 GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
 C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
 Code, Compile, Run and Debug online from anywhere in world.

 *******************************************************************************/
import java.util.Scanner;
public class Main
{
    public static String[][] rubrica = new String[3][10]; //primo nome, secondo cognome, terzo numero
    public static int nContatti = 0;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("#### RUBRICA ####");
        int input;
        boolean done = false;
        while(!done){
            System.out.print("1. Registra un nuovo contatto\n2. Elimina contatto\n3. Stampa rubrica\n4. Modifica contatto\n5. Esci\n");
            System.out.print("Scegli: ");
            input = sc.nextInt();
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
                    stampaRubrica();
                    delete_entry(
                            selector()
                    );
                    break;
                case 3:
                    stampaRubrica();
                    break;
                case 4:
                    stampaRubrica();
                    modify_entry(
                            selector(),
                            {
                                
                            },
                            "non",
                            "parlare"
                    );
                    break;
                case 5:
                    done=true;
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

    public static void modify_entry(int index, String nome, String cognome, String numero){
        rubrica[0][index] = nome;
        rubrica[1][index] = cognome;
        rubrica[2][index] = numero;
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
        return val;
    }

    public static int selector(){
        int input;

        do{
            System.out.print("Inserisci numero da 1 a " + rubrica[0].length + ": ");
            input = sc.nextInt() - 1;
        }while (input < 0 || input>rubrica[0].length);
        return input;
    }
}
