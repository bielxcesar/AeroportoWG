package com.wgAeroporto.view.jframe;
import com.wgAeroporto.model.entity.VooEntity;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AtualizarVooFrame extends JFrame {

    private JTextField horaIdaField, horaVoltaField, diaIdaField, diaVoltaField;
    private final long vooId;

    public AtualizarVooFrame(long id, String horaIda, String horaVolta, Date diaIda, Date diaVolta, String saida, String destino) {
        this.vooId = id;
        setTitle("Remarcar Voo");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Campos bloqueados
        add(new JLabel("ID:"));
        add(new JLabel(String.valueOf(vooId)));
        add(new JLabel("Saída:"));
        add(new JLabel(saida));
        add(new JLabel("Destino:"));
        add(new JLabel(destino));

        // Campos editáveis
        add(new JLabel("Hora Ida:"));
        horaIdaField = new JTextField(horaIda);
        add(horaIdaField);
        add(new JLabel("Hora Volta:"));
        horaVoltaField = new JTextField(horaVolta);
        add(horaVoltaField);
        add(new JLabel("Dia Ida:"));
        diaIdaField = new JTextField(diaIda.toString()); // Convertendo `Date` para String
        add(diaIdaField);
        add(new JLabel("Dia Volta:"));
        diaVoltaField = new JTextField(diaVolta.toString()); // Convertendo `Date` para String
        add(diaVoltaField);
        // Botões
        JButton confirmarBtn = new JButton("✅ Confirmar");
        confirmarBtn.addActionListener(e -> confirmarAtualizacao());

        JButton voltarBtn = new JButton("🔙 Voltar");
        voltarBtn.addActionListener(e -> dispose());

        add(confirmarBtn);
        add(voltarBtn);

        setVisible(true);
    }

    private void confirmarAtualizacao() {
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente remarcar este voo?", "Confirmação", JOptionPane.YES_NO_OPTION);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (opcao == JOptionPane.YES_OPTION) {
            try {
                Date diaIdaConvertido = dateFormat.parse(diaIdaField.getText());
                Date diaVoltaConvertido = dateFormat.parse(diaVoltaField.getText());

                // Criando objeto atualizado corretamente
                VooEntity atualizarVoo = new VooEntity();
                atualizarVoo.setId(vooId);
                atualizarVoo.setHoraIda(horaIdaField.getText());
                atualizarVoo.setHoraVolta(horaVoltaField.getText());
                atualizarVoo.setDiaIda(diaIdaConvertido);
                atualizarVoo.setDiaVolta(diaVoltaConvertido);

                JOptionPane.showMessageDialog(this, "Voo atualizado com sucesso!");
                dispose();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao converter a data!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
