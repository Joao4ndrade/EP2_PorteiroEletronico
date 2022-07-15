import java.util.*;

public class ManipulaEntrada {

    public static void liberaAcesso(){
        System.out.println("Acesso Liberado");
    }

    public static void bloqueiaAcesso(){
        System.out.println("Acesso Negado");
    }

    static List<Registro> Registros = new ArrayList<>();

    public  static boolean cadastraUsuário(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira o nome: ");
        String nome = scan.nextLine();
        System.out.println("Insira o CPF: ");
        String CPF = scan.nextLine();
        System.out.println("Insira 4 numeros como PIN: ");
        int PIN = scan.nextInt();
        Registro r = new Registro(nome, CPF, PIN);
        Registros.add(r);
    return true;
    }
    public static void checaUsuarioCadastrado() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira o nome: ");
        String nome = scan.nextLine();
        System.out.println("Insira o CPF: ");
        String CPF = scan.nextLine();
        for(Registro r : Registros){
            if (r.CPF.equals(CPF) && r.nome.equals(nome) ){
                System.out.println("Insira o PIN: ");
                int PIN = scan.nextInt();
                if (PIN == r.PIN) liberaAcesso();
                else bloqueiaAcesso();
            }

        }


    }

    public static void main(String[] args) {
        cadastraUsuário();

        checaUsuarioCadastrado();

    }
}
