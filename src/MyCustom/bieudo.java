package MyCustom;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Color;

public class bieudo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bieudo frame = new bieudo();
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
	public bieudo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Biểu đồ ");
		lblNewLabel.setBounds(26, 11, 254, 21);
		panel.add(lblNewLabel);
		
		JPanel Jplbd = new JPanel();
		Jplbd.setBackground(new Color(128, 128, 255));
		Jplbd.setBounds(0, 43, 424, 208);
		panel.add(Jplbd);
		Jplbd.setLayout(null);
		
		JFreeChart chart= ChartFactory.createPieChart("Biểu đồ doanh thu theo quý",taoBieudo(), true,true,true);
		ChartPanel tkdt= new ChartPanel(chart);
		tkdt.setSize(350,170);
		tkdt.setLocation(22,36);
		Jplbd.add(tkdt);
	
	}
	public PieDataset taoBieudo() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Qúy 1",10.0);
		dataset.setValue("Qúy 2",5.0);
		dataset.setValue("Qúy 3",70.0);
		dataset.setValue("Qúy 4",15.0);
		return dataset;
		
	}
}
