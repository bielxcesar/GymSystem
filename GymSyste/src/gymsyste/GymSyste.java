package gymsyste;

import java.util.*;

// Interface Command
interface Command {
    void executar();
}

// Classe para cadastrar usuários
class CadastrarUsuarioCommand implements Command {
    private List<String> usuarios;
    private String nome;
    
    public CadastrarUsuarioCommand(List<String> usuarios, String nome) {
        this.usuarios = usuarios;
        this.nome = nome;
    }
    
    public void executar() {
        usuarios.add(nome);
        System.out.println("Usuário cadastrado!");
    }
}

// Classe para remover usuários
class RemoverUsuarioCommand implements Command {
    private List<String> usuarios;
    private String nome;
    
    public RemoverUsuarioCommand(List<String> usuarios, String nome) {
        this.usuarios = usuarios;
        this.nome = nome;
    }
    
    public void executar() {
        if (usuarios.remove(nome)) {
            System.out.println("Usuário removido!");
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }
}

// Classe para listar usuários
class ListarUsuariosCommand implements Command {
    private List<String> usuarios;
    
    public ListarUsuariosCommand(List<String> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void executar() {
        System.out.println("Usuários cadastrados:");
        for (String u : usuarios) {
            System.out.println(u);
        }
    }
}

// Classe principal
public class GymSyste {
    private static List<String> usuarios = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Cadastrar usuário\n2. Remover usuário\n3. Listar usuários\n4. Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine(); 
            
            Command command = null;
            
            switch (escolha) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    command = new CadastrarUsuarioCommand(usuarios, nome);
                    break;
                
                case 2:
                    System.out.print("Nome do usuário a remover: ");
                    String nomeRemover = scanner.nextLine();
                    command = new RemoverUsuarioCommand(usuarios, nomeRemover);
                    break;
                
                case 3:
                    command = new ListarUsuariosCommand(usuarios);
                    break;
                
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Opção inválida!");
            }
            
            if (command != null) {
                command.executar();
            }
        }
    }
}
