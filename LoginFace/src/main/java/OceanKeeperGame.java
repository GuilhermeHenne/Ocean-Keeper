import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.border.Border;
import java.awt.Font;

public class OceanKeeperGame extends JFrame {
    private JTextArea textArea;
    private JButton simBotao;
    private JButton naoBotao;
    private JButton avancarBotao;

    private List<Carta> cartas;
    private int cartaAtualIndex;

    private int poluicao;
    private int biodiversidade;
    private int mudancasClimaticas;
    private int pesca;
    private int orcamento;

    public OceanKeeperGame() {
        cartas = new ArrayList<>();
        criarCartas();
        ImageIcon icon = new ImageIcon("C:/Users/MSI/Desktop/game/OceanKeeper.png");
        setIconImage(icon.getImage());

        initComponents();

        // Inicializar os parâmetros
        poluicao = 50;
        biodiversidade = 50;
        mudancasClimaticas = 50;
        pesca = 50;
        orcamento = 50;
    }

    private void initComponents() {
        setTitle("Ocean Keeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea(22, 35);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
       
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        Font fonteTexto = new Font("Arial", Font.PLAIN, 20);
        textArea.setFont(fonteTexto);

        

        JPanel buttonPanel = new JPanel();
        simBotao = new JButton("Sim");
        naoBotao = new JButton("Não");
        buttonPanel.setBackground(Color.WHITE);
        textArea.setBackground(Color.BLUE);  //Fundo Azul
        buttonPanel.setForeground(Color.WHITE); //Letras Brancas
        textArea.setForeground(Color.WHITE);

        int marge = 40;
        Border buttonMargin = BorderFactory.createEmptyBorder(marge, marge, marge, marge);
        for (Component button : buttonPanel.getComponents()) {
            if (button instanceof JButton) {
                ((JButton) button).setBorder(buttonMargin);
            }
        }

        textArea.setBorder(buttonMargin);
            

        buttonPanel.add(simBotao);
        buttonPanel.add(naoBotao);
        add(buttonPanel, BorderLayout.SOUTH);

        simBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processarResposta(true);
            }
        });

        naoBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                processarResposta(false);
            }
        });

        avancarBotao = new JButton("Certo!");
        buttonPanel.add(avancarBotao);

        avancarBotao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (cartaAtualIndex < cartas.size()) {
                    cartaAtualIndex++;
                    exibirCarta();
                }
            }
        });

        exibirIntroducao();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void exibirIntroducao() {
        String introducao = "Você é o responsável pela décima quarta ODS a vida na água, sua responsabilidade são com todo tipo de vida dos oceanos, você deverá controlar tudo o que acontece com o oceano, desaprovando ou aprovando propostas, lembrando que é muito importante controlar os parâmetros para ter um equilíbrio entre os interesses humanos e a vida marinha. Cada ação que você tomar afeta diretamente os cinco parâmetros que são: Poluição, Biodiversidade marinha, Mudanças climáticas, Pesca e Orçamento.\n\n";
        introducao += "Os parâmetros vão de 0 a 100, porém se um chegar a 0 ou a 100 você irá ser demitido por falta de competência, certo?\n\n";
        introducao += "Boa sorte!";
        
        textArea.setText(introducao);
        avancarBotao.setEnabled(true);
        simBotao.setVisible(false);
        naoBotao.setVisible(false);
        
        
    }

     
    private void criarCartas() {
        // Ano 2023   
        cartas.add(new Carta(".", 0, 0, 0, 0, 0));
        cartas.add(new Carta("2023 1º Bimestre\nDIRETOR DE UMA PETROLÍFERA\n\nPreciso que você libere para mim a autorização de mineração de petróleo em larga escala na costa brasileira.", 20, -10, 8, 0, 12));
        cartas.add(new Carta("2023 2º Bimestre\nPRESIDENTE DE UMA EMPRESA DE PESCA\n\nGostaríamos de expandir nossas operações de pesca e aumentar a captura de peixes no oceano Atlântico sul. Podemos contar com o seu apoio?", 0, -10, 0, 14, 4));
        cartas.add(new Carta("2023 3º Bimestre\nDIRETORA DE UMA EMPRESA DE COSMÉTICOS\n\nEstamos planejando lançar uma nova linha de produtos que contém ingredientes provenientes de organismos marinhos. Você concorda com essa abordagem?", 0, -10, 0, 5, 2));
        cartas.add(new Carta("2023 4º Bimestre\nDIRETOR DE UMA EMPRESA DE TRANSPORTE MARÍTIMO\n\nPrecisamos aumentar o número de navios em nossas rotas comerciais para atender à crescente demanda. Você aprova essa expansão?", 8, -9, 5, 0, 3));
        cartas.add(new Carta("2024 1º Bimestre\nPRESIDENTE DE UMA ONG AMBIENTAL\n\nEstamos organizando um protesto pacífico para conscientizar sobre a poluição dos oceanos. Podemos contar com o seu apoio para difundir a mensagem?", -7, 10, -5, -15, -10));
        cartas.add(new Carta("2024 2º Bimestre\nDIRETOR DE UMA EMPRESA DE ENERGIA RENOVÁVEL\n\nEstamos planejando construir uma fazenda de energia eólica offshore para reduzir a dependência de fontes não renováveis. Você apoia essa iniciativa?", -10, 5, 10, 0, -5));
        cartas.add(new Carta("2024 3º Bimestre\nDIRETOR DE UMA EMPRESA DE EMBALAGENS PLÁSTICAS\n\nEstamos lançando uma nova linha de produtos com embalagens plásticas. Podemos contar com o seu aval?", 10, -7, 7, 0, 9));
        cartas.add(new Carta("2024 4º Bimestre\nPRESIDENTE DE UMA ONG DE PROTEÇÃO MARINHA\n\nEstamos trabalhando para criar uma nova reserva marinha para proteger espécies ameaçadas. Você apoia essa iniciativa de conservação?", 0, 20, 0, -10, -5));
        cartas.add(new Carta("2025 1º Bimestre\nDIRETORA DE UMA EMPRESA DE TURISMO COSTEIRO\n\nEstamos planejando expandir nossas atividades turísticas costeiras, o que inclui passeios de barco e mergulho. Você apoia essa expansão?", 0, -8, 0, 0, 10));
        cartas.add(new Carta("2025 2º Bimestre\nPRESIDENTE DE UMA ONG DE EDUCAÇÃO AMBIENTAL\n\nEstamos organizando workshops educacionais sobre a importância da conservação dos oceanos. Podemos contar com o seu apoio para divulgar essas iniciativas?", 0, 4, 0, 0, -8));
        cartas.add(new Carta("2025 3º Bimestre\nDIRETOR DE UMA EMPRESA DE PRODUTOS QUÍMICOS\n\nPrecisamos descartar resíduos químicos no oceano como parte do nosso processo de fabricação. Você concorda com essa prática?", 10, -7, -10, -5, 5));
        cartas.add(new Carta("2025 4º Bimestre\nDIRETORA DE UMA EMPRESA DE TECNOLOGIA MARINHA\n\nEstamos desenvolvendo um novo dispositivo de coleta de lixo marinho. Você apoia essa inovação para combater a poluição dos oceanos?", -4, 0, -6, 0, -5));
        cartas.add(new Carta("2026 1º Bimestre\nPRESIDENTE DE UMA ONG DE RESTAURAÇÃO DE RECIFES DE CORAL\n\nEstamos realizando um projeto de restauração de recifes de coral. Podemos contar com o seu apoio para financiar essa iniciativa?", 0, 10, 0, 0, -5));
        cartas.add(new Carta("2026 2º Bimestre\nDIRETORA DE UMA EMPRESA DE TRANSPORTE DE CARGA MARÍTIMA\n\nEstamos planejando expandir nossas operações e aumentar a quantidade de cargas transportadas. Você concorda com essa expansão?", 6, -2, 0, 0, 5));
        cartas.add(new Carta("2026 3º Bimestre\nPRESIDENTE DE UMA ONG DE MONITORAMENTO MARINHO\n\nEstamos realizando pesquisas para monitorar a saúde dos oceanos e identificar áreas de preocupação. Podemos contar com o seu apoio para financiar esses estudos?", -5, 10, 0, -8, -15));
        cartas.add(new Carta("2026 4º Bimestre\nDIRETOR DE UMA EMPRESA DE AQUICULTURA\n\nEstamos planejando expandir nossas fazendas de criação de peixes. Você apoia essa expansão?", 0, -5, 0, 9, -5));
        cartas.add(new Carta("2027 1º Bimestre\nPRESIDENTE DE UMA ONG DE LIMPEZA DE PRAIAS\n\nEstamos organizando mutirões de limpeza de praias para combater a poluição. Podemos contar com o seu apoio?", -9, 0, 10, 0, 0));
        cartas.add(new Carta("2027 2º Bimestre\nDIRETOR DE UMA EMPRESA DE DESALINIZAÇÃO DE ÁGUA\n\nEstamos desenvolvendo tecnologias para obter água potável a partir da água do mar. Você apoia essa iniciativa?", 0, 5, -5, 0, -9));
        cartas.add(new Carta("2027 3º Bimestre\nDIRETORA DE UMA EMPRESA DE TURISMO DE OBSERVAÇÃO DE BALEIAS\n\nEstamos planejando realizar passeios para observação de baleias na região. Você apoia essa atividade?", 0, -3, 0, 0, 5));
        cartas.add(new Carta("2027 4º Bimestre\nPRESIDENTE DE UMA ONG DE PRESERVAÇÃO DE TARTARUGAS MARINHAS\n\nEstamos trabalhando para proteger as tartarugas marinhas e seus habitats. Podemos contar com o seu apoio nessa causa?", 0, 10, 0, 0, -8));
        cartas.add(new Carta("2028 1º Bimestre\nDIRETOR DE UMA EMPRESA DE AQUATURISMO\n\nEstamos planejando oferecer passeios de barco para exploração de recifes de coral. Você apoia essa iniciativa?", 0, -10, 0, 0, -5));
        cartas.add(new Carta("2028 2º Bimestre\nPRESIDENTE DE UMA ONG DE PESQUISA OCEANOGRÁFICA\n\nEstamos conduzindo pesquisas para entender melhor os ecossistemas marinhos. Podemos contar com o seu apoio para financiar essas pesquisas?", -5, 6, 0, 0, -10));
        cartas.add(new Carta("2028 3º Bimestre\nDIRETORA DE UMA EMPRESA DE AQUÁRIO\n\nEstamos planejando construir um aquário para exibir espécies marinhas. Você apoia essa iniciativa?", 0, 0, 0, 3, -8));
        cartas.add(new Carta("2028 4º Bimestre\nDIRETOR DE UMA EMPRESA DE DESPOLUIÇÃO DE RIOS\n\nEstamos desenvolvendo tecnologias para despoluir mangues e deltas e reduzir a poluição marinha. Você apoia essa iniciativa?", -12, 10, 10, 0, -11));
        cartas.add(new Carta("2029 1º Bimestre\nPRESIDENTE DE UMA ONG DE CONSCIENTIZAÇÃO SOBRE MUDANÇAS CLIMÁTICAS\n\nEstamos promovendo eventos com grandes empresas sobre as mudanças climáticas e seu impacto nos oceanos. Podemos contar com o seu apoio para divulgar essas informações?", -8, 0, -9, 0, 0));
        cartas.add(new Carta("2029 2º Bimestre\nDIRETOR DE UMA EMPRESA DE RECOLHIMENTO DE LIXO MARINHO\n\nEstamos desenvolvendo um projeto para recolher lixo marinho dos oceanos. Você apoia essa iniciativa?", -9, 0, -10, 0, -5));
        cartas.add(new Carta("2029 3º Bimestre\nPRESIDENTE DE UMA ONG DE CONSERVAÇÃO DE ÁREAS COSTEIRAS\n\nEstamos trabalhando para preservar áreas costeiras e seus ecossistemas. Podemos contar com o seu apoio nessa causa?", 0, 10, 0, -9, -5));
        cartas.add(new Carta("2029 4º Bimestre\nDIRETOR DE UMA EMPRESA DE AQUICULTURA\n\nEstamos planejando expandir nossa produção de peixes em cativeiro. Você apoia essa iniciativa?", 0, 7, 0, 0, 3));
    }

    private void exibirCarta() {
        if (cartaAtualIndex >= 0 && cartaAtualIndex < cartas.size()) {
            Carta carta = cartas.get(cartaAtualIndex);
            String pergunta = carta.getPergunta();
            int poluicaoImpacto = carta.getPoluicaoImpacto();
            int biodiversidadeImpacto = carta.getBiodiversidadeImpacto();
            int mudancasClimaticasImpacto = carta.getMudancasClimaticasImpacto();
            int pescaImpacto = carta.getPescaImpacto();
            int orcamentoImpacto = carta.getOrcamentoImpacto();
    
            String textoCarta = "Pergunta: " + pergunta + "\n\n";
            textoCarta += "Impacto na Poluição: " + poluicaoImpacto + "\n";
            textoCarta += "Impacto na Biodiversidade: " + biodiversidadeImpacto + "\n";
            textoCarta += "Impacto nas Mudanças Climáticas: " + mudancasClimaticasImpacto + "\n";
            textoCarta += "Impacto na Pesca: " + pescaImpacto + "\n";
            textoCarta += "Impacto no Orçamento: " + orcamentoImpacto + "\n\n";
            textoCarta += "Status dos Parâmetros:\n";
            textoCarta += "Poluição: " + poluicao + "\n";
            textoCarta += "Biodiversidade: " + biodiversidade + "\n";
            textoCarta += "Mudanças Climáticas: " + mudancasClimaticas + "\n";
            textoCarta += "Pesca: " + pesca + "\n";
            textoCarta += "Orçamento: " + orcamento + "\n";
    
            textArea.setText(textoCarta);
            simBotao.setEnabled(true);
            naoBotao.setEnabled(true);
            avancarBotao.setVisible(false);
            simBotao.setVisible(true);
            naoBotao.setVisible(true);
            
        } else {
            // Fim do jogo
            textArea.setText("Parabéns, conseguimos atingir nossas metas!");
            
        }
    }
    

    private void processarResposta(boolean resposta) {
        if (cartaAtualIndex >= 0 && cartaAtualIndex < cartas.size()) {
            Carta carta = cartas.get(cartaAtualIndex);
            int poluicaoImpacto = resposta ? carta.getPoluicaoImpacto() : 0;
            int biodiversidadeImpacto = resposta ? carta.getBiodiversidadeImpacto() : 0;
            int mudancasClimaticasImpacto = resposta ? carta.getMudancasClimaticasImpacto() : 0;
            int pescaImpacto = resposta ? carta.getPescaImpacto() : 0;
            int orcamentoImpacto = resposta ? carta.getOrcamentoImpacto() : 0;

            // Atualizar os parâmetros
            poluicao += poluicaoImpacto;
            biodiversidade += biodiversidadeImpacto;
            mudancasClimaticas += mudancasClimaticasImpacto;
            pesca += pescaImpacto;
            orcamento += orcamentoImpacto;

            // Verificar se algum parâmetro atingiu os limites
            if (poluicao <= 0 || poluicao >= 100 ||
                    biodiversidade <= 0 || biodiversidade >= 100 ||
                    mudancasClimaticas <= 0 || mudancasClimaticas >= 100 ||
                    pesca <= 0 || pesca >= 100 ||
                    orcamento <= 0 || orcamento >= 100) {
                // Fim do jogo
                exibirFimDoJogo();
            } else {
                // Continuar o jogo
                cartaAtualIndex++;
                exibirCarta();
            }
        }
    }

    private void exibirFimDoJogo() {
        StringBuilder mensagem = new StringBuilder("Infelizmente você não foi competente o suficiente para exercer a presidência da nossa ODS.\n\n");
    
        if (poluicao <= 0) {
            mensagem.append("- A poluição atingiu o valor mínimo. Apesar de ser uma conquista positiva, a falta de poluição pode indicar uma interrupção na atividade econômica relacionada aos oceanos, afetando negativamente a indústria e o sustento de muitas comunidades costeiras\n");
        } else if (poluicao >= 100) {
            mensagem.append("- Poluição atingiu o valor máximo. Os oceanos estão podres, não há como ter vida neles\n");
        }
    
        if (biodiversidade <= 0) {
            mensagem.append("- Biodiversidade marinha atingiu o valor mínimo. Não existe mais ecossitemas marinhos, isso indica uma grave perda de espécies, e isso infrige vários crimes ambientais\n");
        } else if (biodiversidade >= 100) {
            mensagem.append("- Biodiversidade marinha atingiu o valor máximo. Agora o oceano está cheio de vida, mas infelizmente os mares foram tomados por empresas de turismo e não há mais como recuperar nosso controle sobre isso\n");
        }
    
        if (mudancasClimaticas <= 0) {
            mensagem.append("- Mudanças climáticas atingiram o valor mínimo. Isso significa que não há mais industrias de qualquer tipo, o mundo não produz mais\n");
        } else if (mudancasClimaticas >= 100) {
            mensagem.append("- Mudanças climáticas atingiram o valor máximo. Os parâmetros para vida no oceano estão horríveis, nenhum ser vivo sobreviverá \n");
        }
    
        if (pesca <= 0) {
            mensagem.append("- Pesca atingiu o valor mínimo. Há muitos peixes no mar, o oceano está desiquilibrado\n");
        } else if (pesca >= 100) {
            mensagem.append("- Pesca atingiu o valor máximo. Não existe mais peixes no mar, os oceanos estão mortos.\n");
        }
    
        if (orcamento <= 0) {
            mensagem.append("- Orçamento atingiu o valor mínimo. Estamos falidos, acabou tudo.\n");
        } else if (orcamento >= 100) {
            mensagem.append("- Orçamento atingiu o valor máximo, há muito dinheiro, ninguém nos respeita, acham que nós somos egoístas e corruptos.\n");
        }

        textArea.setText(mensagem.toString());
    simBotao.setEnabled(false);
    naoBotao.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new OceanKeeperGame();
            }
        });
    }
}