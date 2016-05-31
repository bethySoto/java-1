package proyecto;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class cine {
	
	public static int sala1[][][]={{{0,1,1,1,1,1,1},
									{1,1,1,1,1,1,1},
									{1,1,1,1,1,1,1},
									{1,1,1,1,1,1,0},
									{1,1,1,1,1,1,0},
									{1,1,1,1,1,1,0},
									{1,1,1,1,1,0,0},
									{1,1,1,1,1,0,0},
									{0,0,0,0,0,0,0}},
	
									{{0,1,1,1,1,1,1},
										{1,1,1,1,1,1,1},
										{1,1,1,1,1,1,1},
										{1,1,1,1,1,1,0},
										{1,1,1,1,1,1,0},
										{1,1,1,1,1,1,0},
										{1,1,1,1,1,0,0},
										{1,1,1,1,1,0,0},
										{0,0,0,0,0,0,0} }
	
								};
	public static int sala2[][][]={{{0,1,1,1,1,1,0},
									{0,1,1,1,1,1,0},
									{1,1,1,1,1,1,0},
									{1,1,1,1,1,1,0},
									{1,1,1,1,1,0,0},
									{1,1,1,1,1,0,0},
									{1,1,1,1,0,0,0},
									{1,1,1,1,0,0,0},
									{1,1,1,1,0,0,0}},
	
									{	{0,1,1,1,1,1,0},
										{0,1,1,1,1,1,0},
										{1,1,1,1,1,1,0},
										{1,1,1,1,1,1,0},
										{1,1,1,1,1,0,0},
										{1,1,1,1,1,0,0},
										{1,1,1,1,0,0,0},
										{1,1,1,1,0,0,0},
										{1,1,1,1,0,0,0}}
	
								};
	public static JFrame marcos[]= new JFrame[2];
	public static JPanel JP99=new JPanel();
	public static JPanel[][][] sill=new JPanel[2][9][7];
	public static JButton[] bs=new JButton[2];
	public static escucharBotones es1=new escucharBotones();
	public static JScrollBar barra[][]=new JScrollBar[2][2]; //2 BARRAS
	public static JPanel partes[][]=new JPanel [1][2]; //DOS PARTES DE LA IZQUIERDA
	public static JButton[][][] nums=new JButton[2][1][5]; //BOTONES DE ASIENTOS
	public static JTextArea contadores[]=new JTextArea[2]; //CONTADOR ASIENTOS
	public static JTextArea textosillas=new JTextArea(); //TEXTO SILLAS
	public static JTextArea sesion=new JTextArea(); //TEXTO SESIONES
	public static JComboBox comboSesion[]=new JComboBox[2]; //JCOMBO SESIONES
	public static String[] mt={"Mañana","Tarde"}; //ARRAY SESIONES
	public static JTextArea proyeccion[]=new JTextArea[2]; //TEXTO PROYECCION
	public String[] f1={"Reservar","Aceptar","Denegar"}; //BOTONES ABAJO
	public String[] f2={"En Curso","Siguiente"};
	public String[] f3={"Guardar","Cargar","Salir"};
	public static JButton [][][] f11= new JButton[2][1][3]; //ARRAY BOTONES ABAJO
	public static JButton [][][] f22= new JButton[2][1][2];
	public static JButton[][][] f33=new JButton[2][1][3];
	public static ImageIcon im1=new ImageIcon("sillaverde.png"); //IMAGEN SILLAS VERDES (IMPORTAR, DECLARAR, AÑADIR)
	public static ImageIcon im2=new ImageIcon("sillamarilla.jpg");
	public static ImageIcon im3=new ImageIcon("sillaroja.png");
	public static JPanel[] im=new JPanel[2];
	public static int npeli=0;
	public static ImageIcon[] pelis={new ImageIcon("Pelicula1.jpg"),
									new ImageIcon("Pelicula2.jpg"),
									new ImageIcon("Pelicula3.jpg"),
									new ImageIcon("Pelicula4.jpg"),
									new ImageIcon("Pelicula5.jpg"),
									};
	public static int[][] proyec={{0,0},{0,0}};
	public static int s;
	int x;
	public static int[][] asientosLibres={	{0,0},
											{0,0}};
	public static int[][] asientosReservados={	{0,0},
												{0,0}};
	public static double[][] euros={{0,0},
									{0,0}};
	public static int but1=1;
	public static int but2=1;
	public static int m,f,c;
	public static escucharCombo combosesiones=new escucharCombo();
	
	
	//------JPANEL DERECHA------
	public static void jp99(){
		for(int m=0;m<2;m++){
			marcos[m].add(JP99);
			marcos[m].setVisible(true);
			}	
	}
	public static void sesion(){
		sesion=new JTextArea();
		sesion.setBounds(400,151,50,20);
		sesion.setBackground(Color.cyan);
		sesion.setText("Sesion: ");
		marcos[m].add(sesion);
		
		if (m==0){
			comboSesion[m]=new JComboBox(mt);
			comboSesion[m].setBounds(450,150,100,20);
			marcos[0].add(comboSesion[m]);
			comboSesion[m].addActionListener(combosesiones);
		}
		if (m==1){
			comboSesion[m]=new JComboBox(mt);
			comboSesion[m].setBounds(450,150,100,20);
			marcos[1].add(comboSesion[m]);
			comboSesion[m].addActionListener(combosesiones);
			}
	}
	public static void comprobar1(){		
		for (int f=0;f<9;f++){
			for(int c=0;c<7;c++){
				if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==0){
					cine.sill[0][f][c]=new JPanel();
					cine.sill[0][f][c].setBounds(15+(c*40), 15+(f*30),35, 25);
					cine.marcos[0].add(cine.sill[0][f][c]);
				}else if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==1){
					cine.sill[0][f][c]=new JPanel();
					JLabel disponible=new JLabel(cine.im1);
					cine.sill[0][f][c].setBounds(15+(c*40), 15+(f*30),35, 25);
					cine.sill[0][f][c].add(disponible);
					cine.marcos[0].add(cine.sill[0][f][c]);
				}else if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==2){
					cine.sill[0][f][c]=new JPanel();
					JLabel posible=new JLabel(cine.im2);
					cine.sill[0][f][c].setBounds(15+(c*40), 15+(f*30),35, 25);
					cine.sill[0][f][c].add(posible);
					cine.marcos[0].add(cine.sill[0][f][c]);
				}else if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==3){
					cine.sill[0][f][c]=new JPanel();
					JLabel reservado=new JLabel(cine.im3);
					cine.sill[0][f][c].setBounds(15+(c*40), 15+(f*30),35, 25);
					cine.sill[0][f][c].add(reservado);
					cine.marcos[0].add(cine.sill[0][f][c]);
				}
			}
		}
	}
	public static void comprobar2(){
		for (int f=0;f<9;f++){
			for(int c=0;c<7;c++){
				if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==0){
					cine.sill[1][f][c]=new JPanel();
					cine.sill[1][f][c].setBounds(15+(c*40), 15+(f*30),35, 25);
					cine.marcos[1].add(cine.sill[1][f][c]);
				}else if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==1){
					cine.sill[1][f][c]=new JPanel();
					JLabel disponible=new JLabel(cine.im1);
					cine.sill[1][f][c].setBounds(15+(c*40), 15+(f*30),35, 25);
					cine.sill[1][f][c].add(disponible);
					cine.marcos[1].add(cine.sill[1][f][c]);
				}else if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==2){
					cine.sill[1][f][c]=new JPanel();
					JLabel posible=new JLabel(cine.im2);
					cine.sill[1][f][c].setBounds(15+(c*40), 15+(f*30),35, 25);
					cine.sill[1][f][c].add(posible);
					cine.marcos[1].add(cine.sill[1][f][c]);
				}else if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==3){
					cine.sill[1][f][c]=new JPanel();
					JLabel reservado=new JLabel(cine.im3);
					cine.sill[1][f][c].setBounds(15+(c*40), 15+(f*30),35, 25);
					cine.sill[1][f][c].add(reservado);
					cine.marcos[1].add(cine.sill[1][f][c]);
				}
			}
		}
	}
	public static void textoContadores(){
		for(int m=0;m<2;m++){
			cine.contadores[m].setText(cine.asientosReservados[m][cine.comboSesion[m].getSelectedIndex()]+" asientos comprados"+"\n"+ cine.asientosLibres[m][cine.comboSesion[m].getSelectedIndex()] +" asientos libres"+"\n"+cine.euros[m][cine.comboSesion[m].getSelectedIndex()]+" € cobrados");	
			
		}	
	}
	public static void proyeccion(){
		for(int m=0;m<2;m++){
			cine.proyeccion[m].setBackground(Color.cyan);
			cine.proyeccion[m].setText(cine.proyec[m][cine.comboSesion[m].getSelectedIndex()]+"º sesion");
		}
	}
	public static void contar(){
		int t=0;
		int l=0;
		double e = 0;
			for(int x=0;x<2;x++){
				for(int f=0;f<9;f++){
					for(int c=0;c<7;c++){
						if(cine.sala1[x][f][c]==1){
							t++;
						}else if(cine.sala1[x][f][c]==3){
							l++;
						}
					}
				}
				if(x==0){
					e=l*4.5;
				}else if(x==1){
					e=l*5.5;
				}
				cine.euros[0][x]=e;
				cine.asientosLibres[0][x]=t;
				cine.asientosReservados[0][x]=l;
				t=0;
				l=0;
				e=0;
		}
			for(int x=0;x<2;x++){
				for(int f=0;f<9;f++){
					for(int c=0;c<7;c++){
						if(cine.sala2[x][f][c]==1){
							t++;
						}else if(cine.sala2[x][f][c]==3){
							l++;
						}
					}
				}
				if(x==0){
					e=l*4.5;
				}else if(x==1){
					e=l*5.5;
				}
				cine.euros[1][x]=e;
				cine.asientosLibres[1][x]=t;
				cine.asientosReservados[1][x]=l;
				t=0;
				l=0;
				e=0;
		}		
	}
	public static int aleFila(){
		int ale=0;
		int min=0;
		int max=10;
		ale=(int) (Math.random()*(max-min-1)+min);
		return ale;
	}
	public static int aleCol(){
		int ale=0;
		int min=0;
		int max=8;
		ale=(int) (Math.random()*(max-min-1)+min);
		return ale;
	}
	public static void den1(){
		int c1=cine.aleCol();
		int f1=cine.aleFila();
		int cont=0;
		while(cont!=cine.but1){ 	
			if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f1][c1]==0){
				cine.sala1[cine.comboSesion[0].getSelectedIndex()][f1][c1]=0;
			}else if((cine.sala1[cine.comboSesion[0].getSelectedIndex()][f1][c1]==1)){
				cine.sala1[cine.comboSesion[0].getSelectedIndex()][f1][c1]=2;
				cont++;
			}
			c1=c1+1;
			if(c1==7){
				f1=f1+1;
				c1=0;
			}
			if((c1==6)&&(f1==8)){
				f1=0;
				c1=0;
			}
		}
	}
	public static void den2(){
		int c=cine.aleCol();
		int f=cine.aleFila();
		int cont=0;
		while(cont!=cine.but2){ 	
			if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==0){
				cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]=0;
			}else if((cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==1)){
				cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]=2;
				cont++;
			}
			c=c+1;
			if(c==7){
				f=f+1;
				c=0;
			}
			if((c==5)&&(f==8)){
				f=0;
				c=0;
			}
		}
	}
	public static void im1(){
		for(int f=0;f<9;f++){
			for(int c=0;c<7;c++){
				if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==2){
					cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]=1;
				}
			}
		}
	}
	public static void im2(){
		for(int f=0;f<9;f++){
			for(int c=0;c<7;c++){
				if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==2){
					cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]=1;
				}
			}
		}
	}
	public static int alePelis(){
		int x;
		int min=0;
		int max=5;
		x=(int) (Math.random()*(max-min)+min);
		return x;
	}
	public static void pelicu1(){
		m=0;
			im[m]=new JPanel();
			npeli=cine.alePelis();
			if(npeli==0){
				JLabel peli=new JLabel(pelis[npeli]);
				im[m].setBounds(715, 20, 150, 200);
				im[m].add(peli);
				im[m].setBackground(Color.cyan);
				marcos[m].add(im[m]);
			}else if(npeli==1){
				JLabel peli=new JLabel(pelis[npeli]);
				im[m].setBounds(715, 20, 150, 200);
				im[m].add(peli);
				im[m].setBackground(Color.cyan);
				marcos[m].add(im[m]);
			}else if(npeli==2){
				JLabel peli=new JLabel(pelis[npeli]);
				im[m].setBounds(715, 20, 150, 200);
				im[m].add(peli);
				im[m].setBackground(Color.cyan);
				marcos[m].add(im[m]);
			}else if(npeli==3){
				JLabel peli=new JLabel(pelis[npeli]);
				im[m].setBounds(715, 20, 150, 200);
				im[m].add(peli);
				im[m].setBackground(Color.cyan);
				marcos[m].add(im[m]);
			}else if(npeli==4){
				JLabel peli=new JLabel(pelis[npeli]);
				im[m].setBounds(715, 20, 150, 200);
				im[m].add(peli);
				im[m].setBackground(Color.cyan);
				marcos[m].add(im[m]);
			}
	}
	public static void pelicu2(){
		m=1;
			im[m]=new JPanel();
			npeli=cine.alePelis();
			if(npeli==0){
				JLabel peli=new JLabel(pelis[npeli]);
				im[m].setBounds(715, 20, 150, 200);
				im[m].add(peli);
				im[m].setBackground(Color.cyan);
				marcos[m].add(im[m]);
			}else if(npeli==1){
				JLabel peli=new JLabel(pelis[npeli]);
				im[m].setBounds(715, 20, 150, 200);
				im[m].add(peli);
				im[m].setBackground(Color.cyan);
				marcos[m].add(im[m]);
			}else if(npeli==2){
				JLabel peli=new JLabel(pelis[npeli]);
				im[m].setBounds(715, 20, 150, 200);
				im[m].add(peli);
				im[m].setBackground(Color.cyan);
				marcos[m].add(im[m]);
			}else if(npeli==3){
				JLabel peli=new JLabel(pelis[npeli]);
				im[m].setBounds(715, 20, 150, 200);
				im[m].add(peli);
				im[m].setBackground(Color.cyan);
				marcos[m].add(im[m]);
			}else if(npeli==4){
				JLabel peli=new JLabel(pelis[npeli]);
				im[m].setBounds(715, 20, 150, 200);
				im[m].add(peli);
				im[m].setBackground(Color.cyan);
				marcos[m].add(im[m]);
			}
	}
	public static void reset1(){
		for (int f=0;f<9;f++){
			for(int c=0;c<7;c++){
				if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==0){
					
				}else if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==1){
					
				}else if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==2){
					cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]=1;
				}else if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==3){
					cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]=1;
				}
			}
		}
			
				for(int c=0;c<2;c++){
					cine.asientosLibres[0][c]=0;
				}
			
			
				for(int c=0;c<2;c++){
					cine.asientosReservados[0][c]=0;
				}
		
		
				for(int c=0;c<2;c++){
					cine.euros[0][c]=0;
				}
			
	}
	public static void reset2(){
		for (int f=0;f<9;f++){
			for(int c=0;c<7;c++){
				if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==0){
					
				}else if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==1){
					
				}else if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==2){
					cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]=1;
				}else if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==3){
					cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]=1;
				}
			}
		}
		

		for(int c=0;c<2;c++){
			cine.asientosLibres[1][c]=0;
		}
	
	
		for(int c=0;c<2;c++){
			cine.asientosReservados[1][c]=0;
		}


		for(int c=0;c<2;c++){
			cine.euros[1][c]=0;
		}
	
		
	}
	public static void curso1(){
		for (int f=0;f<9;f++){
			for(int c=0;c<7;c++){
				if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==0){
					
				}else if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==1){
					cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]=3;
				}else if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==2){
					cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]=3;
				}else if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==3){
				}
			}
		}
	}
	public static void curso2(){
		for (int f=0;f<9;f++){
			for(int c=0;c<7;c++){
				if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==0){
					
				}else if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==1){
					cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]=3;
				}else if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==2){
					cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]=3;
				}else if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==3){
				}
			}
		}
	}
	public static void lim1(){
		if(cine.asientosLibres[0][cine.comboSesion[0].getSelectedIndex()]<cine.but1){
			cine.but1=cine.asientosLibres[0][cine.comboSesion[0].getSelectedIndex()];
		}
	}
	public static void lim2(){
		if(cine.asientosLibres[1][cine.comboSesion[1].getSelectedIndex()]<cine.but2){
			cine.but2=cine.asientosLibres[1][cine.comboSesion[1].getSelectedIndex()];
		}
	}
	public static void ses1(){
		cine.proyec[0][cine.comboSesion[0].getSelectedIndex()]=cine.proyec[0][cine.comboSesion[0].getSelectedIndex()]+1;
	}
	public static void ses2(){
		cine.proyec[1][cine.comboSesion[1].getSelectedIndex()]=cine.proyec[1][cine.comboSesion[1].getSelectedIndex()]+1;
	}
	public cine(){
		for (m=0;m<2;m++){
			//la N sirve para indicar el numero de sala en el titulo del marco
			int n;
			n=m;
			n=n+1;
			marcos[m]=new JFrame("SALA "+n);
			marcos[m].setBounds(150, 0+(m*350), 950, 350);
			barra[m][0]=new JScrollBar();
			barra[m][0].setOrientation(0); //0 (HORIZONTAL) Ó 1 (VERTICAL)
			barra[m][0].setValues(0, 0, 0, 6); //DONDE EMPIEZA, MAXIMO, MINIMO Y LAS POSICIONES VA A PODER TENER
			barra[m][0].setBounds(5, 290, 300, 20); //MEDIDAS
			barra[m][1]=new JScrollBar();
			barra[m][1].setOrientation(1); 
			barra[m][1].setValues(0, 0, 0, 8); 
			barra[m][1].setBounds(305, 5, 20, 290); //MEDIDAS
			marcos[m].add(barra[m][0]);
			marcos[m].add(barra[m][1]);
			
			//----AÑADIR SILLAS----
			
			//---ARRAY BOTONES---
			for(int f=0;f<1;f++){
				for(int c=0;c<5;c++){
					nums[m][f][c]= new JButton();
					nums[m][f][c].setBounds(345+(c*55),30+(f*35), 50, 30);
					x=c;
					x=x+1;
					nums[m][f][c].setText(""+x);
					marcos[m].add(nums[m][f][c]);
				}
			}
			
			//---ARRAY BOTONES ABAJO----
			for(int f=0;f<1;f++){
				for(int c=0;c<3;c++){
					f11[m][f][c]= new JButton();
					f11[m][f][c].setBounds(340+(c*95),220+(f*25), 90, 20);
					f11[m][f][c].setText(f1[c]);
					marcos[m].add(f11[m][f][c]);
				}
			}
			
			for(int f=0;f<1;f++){
				for(int c=0;c<2;c++){
					f22[m][f][c]= new JButton();
					f22[m][f][c].setBounds(390+(c*95),255+(f*25), 90, 20);
					f22[m][f][c].setText(f2[c]);
					marcos[m].add(f22[m][f][c]);
				}
			}
			
			for(int f=0;f<1;f++){
				for(int c=0;c<3;c++){
					f33[m][f][c]=new JButton();
					f33[m][f][c].setBounds(647+(c*95), 245+(f*25), 90, 20);
					f33[m][f][c].setText(f3[c]);
					marcos[m].add(f33[m][f][c]);
				}
			}
			
			f33[m][0][2].setActionCommand("a");
			f33[m][0][2].addActionListener(es1);
			
			im[m]=new JPanel();
			npeli=cine.alePelis();
			if(npeli==0){
				JLabel peli=new JLabel(pelis[npeli]);
				im[m].setBounds(715, 20, 150, 200);
				im[m].add(peli);
				im[m].setBackground(Color.cyan);
				marcos[m].add(im[m]);
			}else if(npeli==1){
				JLabel peli=new JLabel(pelis[npeli]);
				im[m].setBounds(715, 20, 150, 200);
				im[m].add(peli);
				im[m].setBackground(Color.cyan);
				marcos[m].add(im[m]);
			}else if(npeli==2){
				JLabel peli=new JLabel(pelis[npeli]);
				im[m].setBounds(715, 20, 150, 200);
				im[m].add(peli);
				im[m].setBackground(Color.cyan);
				marcos[m].add(im[m]);
			}else if(npeli==3){
				JLabel peli=new JLabel(pelis[npeli]);
				im[m].setBounds(715, 20, 150, 200);
				im[m].add(peli);
				im[m].setBackground(Color.cyan);
				marcos[m].add(im[m]);
			}else if(npeli==4){
				JLabel peli=new JLabel(pelis[npeli]);
				im[m].setBounds(715, 20, 150, 200);
				im[m].add(peli);
				im[m].setBackground(Color.cyan);
				marcos[m].add(im[m]);
			}
			
			cine.contar();
			
			cine.textosillas=new JTextArea();
			cine.textosillas.setBounds(340,5,100,20);
			cine.textosillas.setText("Nº Sillas");
			cine.textosillas.setBackground(Color.cyan);
			cine.marcos[m].add(textosillas);
			//---CONTADORES----
			cine.contadores[m]=new JTextArea();
			cine.contadores[m].setBounds(355,80,250,50);
			cine.contadores[m].setText(cine.asientosReservados[m][0]+" asientos comprados"+"\n"+ cine.asientosLibres[m][0] +" asientos libres"+"\n"+cine.euros[m][0]+" € cobrados");		
			cine.marcos[m].add(cine.contadores[m]);

			
			//---- SESION----
			
			cine.sesion();
			
			//----TEXTO PROYECCION----
	
			proyeccion[m]=new JTextArea();
			cine.proyeccion[m].setBounds(455,190,100,20);
			cine.proyeccion[m].setBackground(Color.cyan);
			cine.proyeccion[m].setText(cine.proyec[m][cine.comboSesion[m].getSelectedIndex()]+"º sesion");
			cine.marcos[m].add(cine.proyeccion[m]);
			
			//--JBUTTONS PELICULAS---
			for(int f=0;f<1;f++){
				for(int c=0;c<3;c++){
					f33[m][f][c]=new JButton();
					f33[m][f][c].setBounds(647+(c*95), 245+(f*25), 90, 20);
					f33[m][f][c].setText(f3[c]);
					marcos[m].add(f33[m][f][c]);
				}
			}
		
			
			//---JPANEL PELICULAS---
			im[m]=new JPanel();
			im[m].setBounds(715, 20, 150, 200);
			im[m].setBackground(Color.red);
			marcos[m].add(im[m]);
			
			
			//----DIVISIÓN PARTE IZQUIERDA---
			for(int f=0;f<1;f++){
				for(int c=0;c<2;c++){
					partes[f][c]=new JPanel();
					partes[f][c].setBounds(330+(c*310),0+(f*350),300,310);
					partes[f][c].setBackground(Color.cyan);
					marcos[m].add(partes[f][c]);
				}
			}
			
			
			
			
			for (int f=0;f<9;f++){
				for(int c=0;c<7;c++){
					if(m==0){
						cine.comprobar1();
					}else if(m==1){
						cine.comprobar2();
					}
				}
			}
			
			
			
			
		}
		cine.jp99();
		
		f11[0][0][0].setActionCommand("r1");
		f11[0][0][0].addActionListener(es1);
		f11[1][0][0].setActionCommand("r2");
		f11[1][0][0].addActionListener(es1);
		
		f22[0][0][0].setActionCommand("c1");
		f22[0][0][0].addActionListener(es1);
		f22[1][0][0].setActionCommand("c2");
		f22[1][0][0].addActionListener(es1);
		
		f22[0][0][1].setActionCommand("s1");
		f22[0][0][1].addActionListener(es1);
		f22[1][0][1].setActionCommand("s2");
		f22[1][0][1].addActionListener(es1);
		
		nums[0][0][0].setActionCommand("b1");
		nums[0][0][0].addActionListener(es1);
		nums[0][0][1].setActionCommand("b2");
		nums[0][0][1].addActionListener(es1);
		nums[0][0][2].setActionCommand("b3");
		nums[0][0][2].addActionListener(es1);
		nums[0][0][3].setActionCommand("b4");
		nums[0][0][3].addActionListener(es1);
		nums[0][0][4].setActionCommand("b5");
		nums[0][0][4].addActionListener(es1);
		
		nums[1][0][0].setActionCommand("b11");
		nums[1][0][0].addActionListener(es1);
		nums[1][0][1].setActionCommand("b22");
		nums[1][0][1].addActionListener(es1);
		nums[1][0][2].setActionCommand("b33");
		nums[1][0][2].addActionListener(es1);
		nums[1][0][3].setActionCommand("b4");
		nums[1][0][3].addActionListener(es1);
		nums[1][0][4].setActionCommand("b55");
		nums[1][0][4].addActionListener(es1);
		
		f11[0][0][1].setActionCommand("acep1");
		f11[0][0][1].addActionListener(es1);
		

		f11[1][0][1].setActionCommand("acep2");
		f11[1][0][1].addActionListener(es1);
		
		f11[0][0][2].setActionCommand("d1");
		f11[0][0][2].addActionListener(es1);
		
		f11[1][0][2].setActionCommand("d2");
		f11[1][0][2].addActionListener(es1);
	}

	public static void main(String[] args) {
		new cine();
	}
}
