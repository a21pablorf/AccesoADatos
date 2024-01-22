package org.example.vista;

import org.example.controlador.IControladorChiste;
import org.example.vista.IVistaChiste;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaChisteSwing extends JFrame implements IVistaChiste {
    private final JTextArea txtChiste;
    private final JButton btnConsulta;

    private IControladorChiste controlador;

    @Override
    public void setChiste(String chiste) {
        txtChiste.setText(chiste);
    }

    @Override
    public void setController(IControladorChiste controller) {
        this.controlador=controller;
    }

    public VistaChisteSwing() throws HeadlessException {
        btnConsulta=new JButton("Consultar Chiste");
        txtChiste=new JTextArea();

        btnConsulta.addActionListener(e -> {
            String chiste= controlador.getRandomJoke();
            txtChiste.setText(chiste);
        });

        JPanel panelsuperior=new JPanel();
        panelsuperior.add(btnConsulta);
        add(panelsuperior, BorderLayout.PAGE_START);
        add(txtChiste);

        setSize(500,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }



}
