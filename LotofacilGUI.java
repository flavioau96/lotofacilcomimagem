import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LotofacilGUI extends JFrame {
    private JPanel painel = new JPanel();
    private JButton jButtonAposta1 = new JButton("Apostar de 0 a 100");
    private JButton jButtonAposta2 = new JButton("Apostar de A a Z");
    private JButton jButtonAposta3 = new JButton("Apostar par ou ímpar");
    private JLabel jLabelMensagem = new JLabel("Exemplo de Simples Janela");

    public LotofacilGUI() {
        this.setTitle("Lotofácil - Interface Gráfica");
        this.setSize(600, 400); // Aumente o tamanho da janela para acomodar a imagem
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255, 255, 255));

        // Carregue a imagem
        ImageIcon imagem = new ImageIcon("D:\\Downloads\\aaa\\123.jpg"); // Substitua pelo caminho da sua imagem

        // Crie um JLabel para exibir a imagem
        JLabel jLabelImagem = new JLabel(imagem);

        painel.add(jButtonAposta1);
        painel.add(jButtonAposta2);
        painel.add(jButtonAposta3);
        painel.add(jLabelImagem); // Adicione o JLabel com a imagem ao painel

        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        // Adicione um ActionListener para jButtonAposta1
        jButtonAposta1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numeroEscolhido;
                try {
                    numeroEscolhido = Integer.parseInt(JOptionPane.showInputDialog("Digite um número de 0 a 100:"));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite um número válido de 0 a 100.");
                    return;
                }

                // Gere um número aleatório de 0 a 100
                int numeroSorteado = (int) (Math.random() * 101);

                if (numeroEscolhido == numeroSorteado) {
                    JOptionPane.showMessageDialog(null, "Você ganhou 100 pila!");
                } else {
                    JOptionPane.showMessageDialog(null, "Você não ganhou. O número sorteado foi: " + numeroSorteado);
                }
            }
        });

        // Adicione um ActionListener para jButtonAposta2
        jButtonAposta2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String letraEscolhida = JOptionPane.showInputDialog("Digite uma letra de A a Z:");
                if (letraEscolhida != null && letraEscolhida.length() == 1 && Character.isLetter(letraEscolhida.charAt(0))) {
                    char letraSorteada = 'F';

                    if (Character.toUpperCase(letraEscolhida.charAt(0)) == letraSorteada) {
                        JOptionPane.showMessageDialog(null, "Você ganhou milzão papai!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Você não ganhou. A letra sorteada foi: " + letraSorteada);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Digite uma letra válida de A a Z.");
                }
            }
        });

        // Adicione um ActionListener para jButtonAposta3
        jButtonAposta3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numeroEscolhido;
                try {
                    numeroEscolhido = Integer.parseInt(JOptionPane.showInputDialog("Digite um número:"));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite um número válido.");
                    return;
                }

                if (numeroEscolhido % 2 == 0) {
                    JOptionPane.showMessageDialog(null, "Você ganhou R$ 100,00 reais.");
                } else {
                    JOptionPane.showMessageDialog(null, "Que pena! O número digitado é ímpar e a premiação foi para números pares.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new LotofacilGUI();
    }
}
