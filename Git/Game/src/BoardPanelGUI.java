import java.awt.*;
import javax.swing.*;

public class BoardPanelGUI extends JPanel{

	public BoardPanelGUI() {
		
		this.setSize(new Dimension(1000,1000));
	}
	
	
	public void paint(Graphics g) {
		
		int index=1;
		
		for(int i=10;i<1500;i+=100) {
			for(int j=100;j<1450;j+=150) {
				if(index % 9 ==0) {
					g.setColor(Color.RED);
				}
				else if(index % 20 ==0) {
					g.setColor(Color.orange);
				}
				else if(index % 14 ==0) {
					g.setColor(Color.green);				
				}
				else if(index % 5 ==0) {
					g.setColor(Color.blue);
				}
				else {
					g.setColor(Color.white);
				}
				
				index++;
				if((i-10) % 200 != 0) {
					g.fillOval(1400-j, i,80,80);
				}
				else {
					g.fillOval(j, i,80,80);
				}
				
				
				if(j != 1300 && i!=510) {
					g.setColor(Color.lightGray);
					g.fillRect(j+80,30+i,70,20);
				}
				else if(j==1300){
					if((i-10) % 200 ==0) {
						
						g.setColor(Color.white);
						g.drawArc(j+45,i+40,100,100,-105,210);
					}
					else {
						g.setColor(Color.white);
						g.drawArc(50,40+i,100,100,270,-180);
					}
					
				}
				if(index>46 && j!=100) {
					g.setColor(Color.lightGray);
					g.fillRect(j+380,30+i,70,20);
				}
				
				
				if(index==52) break;
			}
			
			if(index==52) break;
		}
		

	}
}
