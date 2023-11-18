package calculadora_java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class engine implements ActionListener {

	private JFrame ventana;
	private JPanel contentPanel;
	private JPanel displayPanel;
	private JPanel buttonPanel;
	private JTextField display;
	private JButton n1;
	private JButton n2;
	private JButton n3;
	private JButton subtract;
	private JButton n4;
	private JButton n5;
	private JButton n6;
	private JButton divide;
	private JButton n7;
	private JButton n8;
	private JButton n9;
	private JButton multiply;
	private JButton n0;
	private JButton reset;
	private JButton equal;
	private JButton add;
	private enum ButtonType {
		REGULAR, OPERATOR
	}
	private int num1, num2, result;
	private String operation;

	// CONSTRUCTOR
	public engine() {

		this.ventana = new JFrame("CALCULADOR PARA INTERFAZ");
		// Panel general que ocupa toda la ventana
		this.contentPanel = new JPanel();
		// Panel norte que contiene el display
		this.displayPanel = new JPanel();
		// Panel sur que contiene los botones
		this.buttonPanel = new JPanel();
		// Display
		this.display = new JTextField();
		// Botones
		this.n1 = new JButton("1");
		this.n2 = new JButton("2");
		this.n3 = new JButton("3");
		this.subtract = new JButton("-");
		this.n4 = new JButton("4");
		this.n5 = new JButton("5");
		this.n6 = new JButton("6");
		this.divide = new JButton("/");
		this.n7 = new JButton("7");
		this.n8 = new JButton("8");
		this.n9 = new JButton("9");
		this.multiply = new JButton("*");
		this.n0 = new JButton("0");
		this.reset = new JButton("R");
		this.equal = new JButton("=");
		this.add = new JButton("+");
		// AÑADIR LOS PANELES A LA VENTANA
		contentPanel.setLayout(new BorderLayout());
		// LLAMADA METODO
		addActionevent();
		setsettings();

	}

	public void setsettings() {
		// PANELES DEL DISPLAY Y BOTON
		this.displayPanel.setLayout(new GridLayout(0, 1));
		this.displayPanel.add(display);
		this.buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
		this.buttonPanel.setBackground(Color.MAGENTA);

		// TIPO DE BOTON REGULAR
		setFeaturesButton(n0, ButtonType.REGULAR);
		setFeaturesButton(n1, ButtonType.REGULAR);
		setFeaturesButton(n2, ButtonType.REGULAR);
		setFeaturesButton(n3, ButtonType.REGULAR);
		setFeaturesButton(n4, ButtonType.REGULAR);
		setFeaturesButton(n5, ButtonType.REGULAR);
		setFeaturesButton(n6, ButtonType.REGULAR);
		setFeaturesButton(n7, ButtonType.REGULAR);
		setFeaturesButton(n8, ButtonType.REGULAR);
		setFeaturesButton(n9, ButtonType.REGULAR);
		// TIPO DE BOTON OPERATOR
		setFeaturesButton(subtract, ButtonType.OPERATOR);
		setFeaturesButton(divide, ButtonType.OPERATOR);
		setFeaturesButton(multiply, ButtonType.OPERATOR);
		setFeaturesButton(reset, ButtonType.OPERATOR);
		setFeaturesButton(equal, ButtonType.OPERATOR);
		setFeaturesButton(add, ButtonType.OPERATOR);

		// AÑADIR COMPONENTES
		this.buttonPanel.add(n1);
		this.buttonPanel.add(n2);
		this.buttonPanel.add(n3);
		this.buttonPanel.add(subtract);
		this.buttonPanel.add(n4);
		this.buttonPanel.add(n5);
		this.buttonPanel.add(n6);
		this.buttonPanel.add(divide);
		this.buttonPanel.add(n7);
		this.buttonPanel.add(n8);
		this.buttonPanel.add(n9);
		this.buttonPanel.add(multiply);
		this.buttonPanel.add(n0);
		this.buttonPanel.add(reset);
		this.buttonPanel.add(equal);
		this.buttonPanel.add(add);

		// EL DISPLAY
		this.contentPanel.add(displayPanel, BorderLayout.NORTH);
		// EL PANEL DE LOS BOTONES
		this.contentPanel.add(buttonPanel, BorderLayout.CENTER);

		// ESTO ES PARA QUE SE VEA LA VENTANA
		this.ventana.add(contentPanel);
		this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.ventana.setSize(500, 500);
		this.ventana.setVisible(true);
	}

	public void setFeaturesButton(JButton _button, ButtonType _type) {

		// Aqui un if else que si es de un tipo lo pinta de un un color y si no de otro

		if (_type == ButtonType.REGULAR) {
			_button.setBackground(Color.YELLOW);
		} else if (_type == ButtonType.OPERATOR) {
			_button.setBackground(Color.RED);
		}
	}

	public void addActionevent() {

		//Agregar objetos que implementan el action listener a los componentes n1,n2,n3
		this.n1.addActionListener(this);
		this.n2.addActionListener(this);
		this.n3.addActionListener(this);
		this.n4.addActionListener(this);
		this.n5.addActionListener(this);
		this.n6.addActionListener(this);
		this.n7.addActionListener(this);
		this.n8.addActionListener(this);
		this.n9.addActionListener(this);
		this.n0.addActionListener(this);
		this.add.addActionListener(this);
		this.subtract.addActionListener(this);
		this.multiply.addActionListener(this);
		this.divide.addActionListener(this);
		this.reset.addActionListener(this);
		this.equal.addActionListener(this);
	}

	public void operation() {

		String numeroselecionado;
		try {
			//Comprueba que operation es
			//Hace la operacion, suma, resta, multiplicacion, division y lo guarda en result
			//Luego pongo en el display el resultado, le doy formato, %d por que es un int, si fuese un float seria %f 
			if (operation == "+") {
				result = num1 + num2;
				numeroselecionado = String.format("%d", result);
				display.setText(numeroselecionado);
			} else if (operation == "-") {
				result = num1 - num2;
				numeroselecionado = String.format("%d", result);
				display.setText(numeroselecionado);
			} else if (operation == "/") {
				if (num2 == 0) {
					display.setText("Error division por 0");
				}
				result = num1 / num2;
				numeroselecionado = String.format("%d", result);
				display.setText(numeroselecionado);
			} else if (operation == "*") {
				result = num1 * num2;
				numeroselecionado = String.format("%d", result);
				display.setText(numeroselecionado);
			}
		} catch (ArithmeticException e) {
			display.setText("Error no se puede dividir por 0");
		}

	}

	public void actionPerformed(ActionEvent e) {
		// Cuando utilizo cualquier boton este es el texto del boton
		String inputext = e.getActionCommand();

		// Comprueba el valor de inputext, y pues cuando se cumple añade el valor, en
		// este caso 1 al display, así con todos.
		if (inputext == "1") {
			display.setText(display.getText() + "1");
		} else if (inputext == "2") {
			display.setText(display.getText() + "2");
		} else if (inputext == "3") {
			display.setText(display.getText() + "3");
		} else if (inputext == "4") {
			display.setText(display.getText() + "4");
		} else if (inputext == "5") {
			display.setText(display.getText() + "5");
		} else if (inputext == "6") {
			display.setText(display.getText() + "6");
		} else if (inputext == "7") {
			display.setText(display.getText() + "7");
		} else if (inputext == "8") {
			display.setText(display.getText() + "8");
		} else if (inputext == "9") {
			display.setText(display.getText() + "9");
		} else if (inputext == "0") {
			display.setText(display.getText() + "0");
		} else
		// Pa que te acuerdes
		// Primero compruebo si inputext es igual a el simbolo de restar, luego verifica
		// si display no esta vacio, empty devuelve true si esta vacio

		if ("-".equals(inputext)) {
			// Si no esta vacio el campo ejecuta esto
			if (!display.getText().isEmpty()) {
				num1 = Integer.parseInt(display.getText());
				operation = "-";
				display.setText("");
			}
			// Si esta vacio el campo display pues añade un simbolo de restar
			else {
				display.setText("-");
			}
		} else
		// Comprueba el inputext si es asi pues hace la condicion
		// Convierte el display a un numero entero y lo asigna a la variable num1
		// Y asi con operation tmb tipo si es division lo asigna /
		// Y pues pongo una cadena vacia para el siguiente numero
		if (inputext == "/") {
			num1 = Integer.parseInt(display.getText());
			operation = "/";
			display.setText("");
		} else if (inputext == "+") {
			num1 = Integer.parseInt(display.getText());
			operation = "+";
			display.setText("");
		} else if (inputext == "*") {
			num1 = Integer.parseInt(display.getText());
			operation = "*";
			display.setText("");
		} else
		// Limpia el display de numeros cuando lo pulsas
		if (inputext == "R") {
			display.setText("");

		} else
		//// Comprueba el inputext si es asi pues hace la condicion
		// Convierte el display a un numero entero y lo asigna a la variable num2
		// Luego llama al metodo operation
		if (inputext == "=") {
			num2 = Integer.parseInt(display.getText());
			this.operation();
		}
	}
}
