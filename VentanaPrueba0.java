import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class VentanaPractica0 extends JFrame{
	
	public JPanel up;
	public JPanel down;
	public JButton ac;
	public JButton stop;
	public JButton der;
	public JButton izq;
	public Coche coche = new Coche(0,0,1,1,"");
	public JLabelGraficoAjustado car;
	
	
	public VentanaPractica0() {
		Container cp = this.getContentPane();
		cp.setLayout(null); //los paneles definen el layout
		
		
		
		up = new JPanel();
		up.setBackground(Color.WHITE);
		up.setSize(1200,550);
		up.setLocation(0, 0);
		up.setLayout(null);
		cp.add(up, BorderLayout.NORTH);
		
		down = new JPanel();
		down.setBackground(Color.WHITE);
		
		
		
		down.setSize(1200,200);
		down.setLocation(0,550);
		down.setLayout(new GridLayout());
		cp.add(down,  BorderLayout.SOUTH);
		
		
		
		
		//panel abajo // botones 4 opciones
		ac = new JButton("Acelerar");
		ac.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				coche.v=coche.v+1;
				
			}
			
		});
		
		stop = new JButton("Frenar");
		stop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(coche.v>=1) {
					coche.v=coche.v-1;
			}}
			
		});
		der= new JButton("Giro derecha");
		der.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				coche.a=coche.a+Math.toRadians(10);
			}
			
		});
		izq= new JButton("Giro izquierda");
		izq.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				coche.a=coche.a-Math.toRadians(10);
			}
			
		});
		
		down.add(ac);
		down.add(stop);
		down.add(der);
		down.add(izq);
		
		//panel arriba
		car = new JLabelGraficoAjustado("coche",100,100);
		car.setImagen("coche.png");
	
		up.add(car);
// HILO
		Thread t = new Thread() {
			
			public void run() {
				do {
					
					if(coche.x<=-30||coche.x>=1110) {
						coche.a=Math.PI-coche.a;
					}
					if(coche.y<=-30||coche.y>=480){
						coche.a=2*Math.PI-coche.a;
						
					}
					coche.x=(coche.x+((Math.cos(coche.a)*coche.v*0.3)));
					coche.y=(coche.y+((Math.sin(coche.a)*coche.v*0.3)));
					car.setRotacion(coche.a); // de la clase JLabelAjustado
					car.setLocation(coche.x,coche.y);
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
					}
				
				
				}while(this.isAlive());
			
			}
		
		};
		t.start();
	
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Coche rojo");
		this.setSize(1200,900);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("coche.png").getImage()); //icono junto al titulo
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new VentanaPractica0();
	
	}

}
