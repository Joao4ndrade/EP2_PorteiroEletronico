import java.util.*;

public class ManipulaEntrada {

    public static void liberaAcesso(){
        System.out.println("\nAcesso Liberado");
    }

    public static void bloqueiaAcesso(){
        System.out.println("\nAcesso Negado");
    }

    static List<Registro> Registros = new ArrayList<>();

    public  static boolean cadastraUsuario(){
        Scanner scan = new Scanner(System.in);
        String nome = "";
        String CPF = "";
        int PIN = 0;
        boolean go = false;
        while (!go){
            System.out.println("Insira o nome: ");
            nome = scan.nextLine();
            if(nome.length()>20){
                System.out.println("Nome invalido: diminua o numero de caracteres\n");
                continue;
            }
            go = true;
        }

        go = false;
        while (!go){
            System.out.println("Insira o CPF: ");
            CPF = scan.nextLine();
            if(CPF.length()>14){
                System.out.println("CPF invalido\n");
                continue;
            }
            go = true;
        }

        go = false;
        String p = "12345";
        while (!go){
            System.out.println("Insira 4 numeros como PIN: ");
            PIN = scan.nextInt();
            p = String.valueOf(PIN);
            if(p.length()!=4){
                System.out.println("PIN invalido: precisa ter 4 digitos exatos\n");
                continue;
            }
            go = true;
        }

        Registro r = new Registro(nome, CPF, PIN);
        Registros.add(r);
        System.out.println("Usuario cadastrado com sucesso!\n");
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
        cadastraUsuario();

        checaUsuarioCadastrado();

    }
}