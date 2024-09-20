import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz implements ActionListener {
    
    JButton botonRegistrar;
    JButton botonSiguiente;
    JLabel etiqueta;
    JTextField entradaProfesor, entradaHoras;
    JTextField entradaSalon, entradaMateria;
    
    public Interfaz() {
        JFrame frame = new JFrame("Algoritmos Evolutivos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		
		etiqueta = new JLabel("Muestra y generaciones");
		etiqueta.setBounds(180, 10, 300, 30);
		etiqueta.setName("titulo");
		etiqueta.setVisible(true);
		panel1.add(etiqueta);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
        
        etiqueta = new JLabel();
        etiqueta.setBounds(200, 10, 300, 30);
        etiqueta.setText("Horarios");
        etiqueta.setName("etiquetaHorario");
        etiqueta.setVisible(true);
        panel2.add(etiqueta);
        
        etiqueta = new JLabel("Profesor");
        etiqueta.setName("etiquetaProfesor");
        etiqueta.setBounds(80, 50, 300, 30);
        etiqueta.setVisible(true);
        panel2.add(etiqueta);
        
        entradaProfesor = new JTextField();
        entradaProfesor.setBounds(150, 50, 200, 30);
        entradaProfesor.setName("entradaProfesor");
        entradaProfesor.setText("");
        entradaProfesor.setVisible(true);
        panel2.add(entradaProfesor);
        
        etiqueta = new JLabel("Materia");
        etiqueta.setName("etiquetaMateria");
        etiqueta.setBounds(80, 90, 300, 30);
        etiqueta.setVisible(true);
        panel2.add(etiqueta);
        
        entradaMateria = new JTextField();
        entradaMateria.setBounds(150, 90, 200, 30);
        entradaMateria.setName("entradaMateria");
        entradaMateria.setText("");
        entradaMateria.setVisible(true);
        panel2.add(entradaMateria);
        
        etiqueta = new JLabel("Salon");
        etiqueta.setName("etiquetaSalon");
        etiqueta.setBounds(80, 130, 300, 30);
        etiqueta.setVisible(true);
        panel2.add(etiqueta);
        
        entradaSalon = new JTextField();
        entradaSalon.setBounds(150, 130, 200, 30);
        entradaSalon.setName("entradaSalon");
        entradaSalon.setText("");
        entradaSalon.setVisible(true);
        panel2.add(entradaSalon);
        
        etiqueta = new JLabel("Horas");
        etiqueta.setName("etiquetaHoras");
        etiqueta.setBounds(80, 170, 300, 30);
        etiqueta.setVisible(true);
        panel2.add(etiqueta);
        
        entradaHoras = new JTextField();
        entradaHoras.setBounds(150, 170, 200, 30);
        entradaHoras.setName("entradaHoras");
        entradaHoras.setText("");
        entradaHoras.setVisible(true);
        panel2.add(entradaHoras);
        
        botonRegistrar = new JButton();
        botonRegistrar.setBounds(130, 210, 100, 30);
        botonRegistrar.setText("Registrar");
        botonRegistrar.setName("botonRegistrar");
        botonRegistrar.setVisible(true);
        botonRegistrar.addActionListener(this);
        panel2.add(botonRegistrar);
        
		botonSiguiente=new JButton();
		botonSiguiente.setBounds(250, 210, 100, 30);
		botonSiguiente.setText("Siguiente");
		botonSiguiente.setName("botonSiguiente");
		botonSiguiente.setVisible(true);
		botonSiguiente.addActionListener(this);
		panel2.add(botonSiguiente);
		
		tabbedPane.addTab("Generaciones", panel1);
		tabbedPane.addTab("Horarios", panel2);
		
		frame.add(tabbedPane);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Acciones a realizar cuando se presione el botón "Registrar"
        if (e.getSource() == botonRegistrar) {
            // Aquí puedes manejar la lógica de registro
            System.out.println("Botón Registrar presionado.");
        }
    }
}
