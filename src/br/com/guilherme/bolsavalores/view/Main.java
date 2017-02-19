package br.com.guilherme.bolsavalores.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.guilherme.bolsavalores.controller.EmpresaController;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtInicial;
	private JTextField txtFinal;
	private JLabel lblDataInicial;
	private JLabel lblDataFinal;
	private JLabel lblDdmmyyyy;
	private JLabel label;
	private JComboBox<String> cbAcao;
	private JLabel lblEmpresa;
	private JButton btnBuscar;
	
	private EmpresaController empresaController;
	private Map<String, String> empresas;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblDataInicial = new JLabel("Data Inicial:");
		lblDataInicial.setBounds(12, 13, 83, 16);
		contentPane.add(lblDataInicial);
		
		lblDataFinal = new JLabel("Data Final:");
		lblDataFinal.setBounds(12, 42, 83, 16);
		contentPane.add(lblDataFinal);
		
		txtInicial = new JTextField();
		txtInicial.setBounds(107, 13, 116, 22);
		contentPane.add(txtInicial);
		txtInicial.setColumns(10);
		
		txtFinal = new JTextField();
		txtFinal.setBounds(107, 42, 116, 22);
		contentPane.add(txtFinal);
		txtFinal.setColumns(10);
		
		lblDdmmyyyy = new JLabel("dd/mm/yyyy");
		lblDdmmyyyy.setBounds(235, 13, 83, 16);
		contentPane.add(lblDdmmyyyy);
		
		label = new JLabel("dd/mm/yyyy");
		label.setBounds(235, 42, 83, 16);
		contentPane.add(label);
		
		cbAcao = new JComboBox<String>();
		cbAcao.setBounds(107, 77, 116, 22);
		contentPane.add(cbAcao);
		
		lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(12, 80, 56, 16);
		contentPane.add(lblEmpresa);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO
			}
		});
		btnBuscar.setBounds(235, 76, 97, 25);
		contentPane.add(btnBuscar);
		setLocationRelativeTo(null);
		iniciarComponentes();
		
	}
	
	private void iniciarComponentes(){
		empresaController = new EmpresaController();
		empresas = empresaController.getEmpresas();
		
		for(String key : empresas.keySet()){
			cbAcao.addItem(key + " - " + empresas.get(key));
		}
	}
	
}
