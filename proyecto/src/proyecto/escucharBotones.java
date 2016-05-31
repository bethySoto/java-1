package proyecto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class escucharBotones implements ActionListener{
	
	public void actionPerformed(ActionEvent a){
		if(a.getActionCommand().equals("a")){
			System.exit(0);
		}
		if(a.getActionCommand().equals("s")){
			System.exit(0);
		}
		if(a.getActionCommand().equals("b1")){
			cine.but1=1;
		}
		if(a.getActionCommand().equals("b2")){
			cine.but1=2;	
		}
		if(a.getActionCommand().equals("b3")){
			cine.but1=3;	
		}
		if(a.getActionCommand().equals("b4")){
			cine.but1=4;	
		}
		if(a.getActionCommand().equals("b5")){
			cine.but1=5;	
		}
		
		if(a.getActionCommand().equals("b11")){
			cine.but2=1;
		}
		if(a.getActionCommand().equals("b22")){
			cine.but2=2;	
		}
		if(a.getActionCommand().equals("b33")){
			cine.but2=3;	
		}
		if(a.getActionCommand().equals("b44")){
			cine.but2=4;	
		}
		if(a.getActionCommand().equals("b55")){
			cine.but2=5;	
		}
		if(a.getActionCommand().equals("acep1")){
			for(int f=0;f<9;f++){
				for(int c=0;c<7;c++){
					if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==2){
						cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]=3;
					}
				}
			}
			cine.contar();
			cine.lim1();
			cine.textoContadores();
			cine.comprobar1();
			cine.jp99();
		}
		if(a.getActionCommand().equals("acep2")){
			for(int f=0;f<9;f++){
				for(int c=0;c<7;c++){
					if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==2){
						cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]=3;
					}
				}
			}
			cine.contar();
			cine.lim2();
			cine.textoContadores();
			cine.comprobar2();
			cine.jp99();
		}
		if(a.getActionCommand().equals("r1")){
			cine.im1();
			if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][cine.barra[0][1].getValue()][cine.barra[0][0].getValue()]==0){
				cine.sala1[cine.comboSesion[0].getSelectedIndex()][cine.barra[0][1].getValue()][cine.barra[0][0].getValue()]=0;
			}else{
				cine.contar();
				cine.lim1();
				if((cine.asientosLibres[0][cine.comboSesion[0].getSelectedIndex()]==0)){

				}else{	
				int c=cine.barra[0][0].getValue();
				int f=cine.barra[0][1].getValue();
				int cont=0;
				while(cont!=cine.but1){ 	
					if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==0){
						cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]=0;
					}else if((cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==1)){
						cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]=2;
						cont++;
					}else if((cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==2)){
						cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]=2;
					}
					else if((cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==3)){
						
					}
					c=c+1;
					if(c==7){
						f=f+1;
						c=0;
					}
					if((c==6)&&(f==8)){
						f=0;
						c=0;
					}
				}
				}
			}
			cine.textoContadores();
			cine.comprobar1();	
			cine.jp99();
			}
		if(a.getActionCommand().equals("r2")){
			cine.im2();
			if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][cine.barra[1][1].getValue()][cine.barra[1][0].getValue()]==0){
				cine.sala2[cine.comboSesion[1].getSelectedIndex()][cine.barra[1][1].getValue()][cine.barra[1][0].getValue()]=0;
			}else{
				cine.contar();
				cine.lim2();
				if((cine.asientosLibres[1][cine.comboSesion[1].getSelectedIndex()]==0)){
				}else{
				int c=cine.barra[1][0].getValue();
				int f=cine.barra[1][1].getValue();
				int cont=0;
				while(cont!=cine.but2){ 	
					if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==0){
						cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]=0;
					}else if((cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==1)){
						cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]=2;
						cont++;
					}else if((cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==2)){
						cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]=2;
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
			}
			cine.textoContadores();
			cine.comprobar2();
			cine.jp99();
		}
		if(a.getActionCommand().equals("d1")){
			cine.contar();
			if((cine.asientosLibres[0][cine.comboSesion[0].getSelectedIndex()]==0)){
			}else{
				for(int f=0;f<9;f++){
					for(int c=0;c<7;c++){
						if(cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]==2){
							cine.sala1[cine.comboSesion[0].getSelectedIndex()][f][c]=1;
						}
					}
			}
			cine.den1();
			cine.contar();
			cine.textoContadores();
			cine.comprobar1();
			cine.jp99();
			}
			
			
		}
		if(a.getActionCommand().equals("d2")){
			cine.contar();
			if((cine.asientosLibres[1][cine.comboSesion[1].getSelectedIndex()]==0)){
			}else{
			for(int f=0;f<9;f++){
				for(int c=0;c<7;c++){
					if(cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]==2){
						cine.sala2[cine.comboSesion[1].getSelectedIndex()][f][c]=1;
					}
				}
			}
			cine.den2();
			cine.contar();
			cine.textoContadores();
			cine.comprobar2();
			cine.jp99();
			}
		}
		if(a.getActionCommand().equals("s1")){
			cine.ses1();
			cine.proyeccion();
			cine.pelicu1();
			cine.reset1();
			cine.comprobar1();
			cine.contar();
			cine.textoContadores();
			cine.jp99();
		}
		if(a.getActionCommand().equals("s2")){
			cine.ses2();
			cine.proyeccion();
			cine.pelicu2();
			cine.reset2();
			cine.contar();
			cine.comprobar2();
			cine.textoContadores();
			cine.jp99();
		}
		if(a.getActionCommand().equals("c1")){
			cine.curso1();
			cine.contar();
			cine.comprobar1();
			cine.textoContadores();
			cine.jp99();
		}
		if(a.getActionCommand().equals("c2")){
			cine.curso2();
			cine.contar();
			cine.comprobar2();
			cine.textoContadores();
			cine.jp99();
		}
	}
}


