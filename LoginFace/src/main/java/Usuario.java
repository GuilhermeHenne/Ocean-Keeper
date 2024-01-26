import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Usuario {
    private String nome;
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean autenticar(String login, String senha) {
        String caminho = "usuarios.txt";
        Path path = Paths.get(caminho);
        try {
            List<String> linhas = Files.readAllLines(path);
            for (String linha : linhas) {
                String[] partes = linha.split(";");
                if (partes[0].equals(login) && partes[1].equals(senha)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void inserir() {
        String caminho = "usuarios.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminho, true))) {
            writer.println(nome + ";" + senha);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
