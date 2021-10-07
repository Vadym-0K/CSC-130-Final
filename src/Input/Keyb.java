package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keyb implements KeyListener{
	private boolean[] keys;
	private int _inputCode;
	
	public Keyb(){
		keys = new boolean[256];
		for(int i = 0; i < keys.length; i++)	keys[i] = false;
		_inputCode = -1;
	}
	
	public boolean isKeyDown(int keyCode){
		boolean temp = keys[keyCode];
		return temp;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;	
		return;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//keys[e.getKeyCode()] = true;
	}
	
	/* Return input code */
	public int getInputCode(){
		keybPoll();
		return _inputCode;
	}
	
	/* Return new input code */
	public char getInputCodeX(){
		return keybPollX();
	}
	
	/* Reset the input code */
	public void resetCode(){
		_inputCode = -1;
	}
	
	/* Keyboard polling...*/
	private void keybPoll(){
		if(isKeyDown(KeyEvent.VK_LEFT))
		{
			_inputCode = 27000;
		} 
		else if(isKeyDown(KeyEvent.VK_RIGHT))
		{
			_inputCode = 9000;
		}
		else if(isKeyDown(KeyEvent.VK_UP))
		{
			_inputCode = 1000;
		}
		else if(isKeyDown(KeyEvent.VK_DOWN))
		{
			_inputCode = 18000;
		}
	}
	
	/* New Keyboard polling...*/
	private char keybPollX(){
		if(isKeyDown(KeyEvent.VK_0))						return '0';
		else if(isKeyDown(KeyEvent.VK_1))					return '1';
		else if(isKeyDown(KeyEvent.VK_2))					return '2';
		else if(isKeyDown(KeyEvent.VK_3))					return '3';
		else if(isKeyDown(KeyEvent.VK_4))					return '4';
		else if(isKeyDown(KeyEvent.VK_5))					return '5';
		else if(isKeyDown(KeyEvent.VK_6))					return '6';
		else if(isKeyDown(KeyEvent.VK_7))					return '7';
		else if(isKeyDown(KeyEvent.VK_8))					return '8';
		else if(isKeyDown(KeyEvent.VK_9))					return '9';
		else if(isKeyDown(KeyEvent.VK_A))					return 'a';
		else if(isKeyDown(KeyEvent.VK_B))					return 'b';
		else if(isKeyDown(KeyEvent.VK_C))					return 'c';
		else if(isKeyDown(KeyEvent.VK_D))					return 'd';
		else if(isKeyDown(KeyEvent.VK_E))					return 'e';
		else if(isKeyDown(KeyEvent.VK_F))					return 'f';
		else if(isKeyDown(KeyEvent.VK_G))					return 'g';
		else if(isKeyDown(KeyEvent.VK_H))					return 'h';
		else if(isKeyDown(KeyEvent.VK_I))					return 'i';
		else if(isKeyDown(KeyEvent.VK_J))					return 'j';
		else if(isKeyDown(KeyEvent.VK_K))					return 'k';
		else if(isKeyDown(KeyEvent.VK_L))					return 'l';
		else if(isKeyDown(KeyEvent.VK_M))					return 'm';
		else if(isKeyDown(KeyEvent.VK_N))					return 'n';
		else if(isKeyDown(KeyEvent.VK_O))					return 'o';
		else if(isKeyDown(KeyEvent.VK_P))					return 'p';
		else if(isKeyDown(KeyEvent.VK_Q))					return 'q';
		else if(isKeyDown(KeyEvent.VK_R))					return 'r';
		else if(isKeyDown(KeyEvent.VK_S))					return 's';
		else if(isKeyDown(KeyEvent.VK_T))					return 't';
		else if(isKeyDown(KeyEvent.VK_U))					return 'u';
		else if(isKeyDown(KeyEvent.VK_V))					return 'v';
		else if(isKeyDown(KeyEvent.VK_W))					return 'w';
		else if(isKeyDown(KeyEvent.VK_X))					return 'x';
		else if(isKeyDown(KeyEvent.VK_Y))					return 'y';
		else if(isKeyDown(KeyEvent.VK_Z))					return 'z';
		else if(isKeyDown(KeyEvent.VK_PERIOD))				return '.';
		else if(isKeyDown(KeyEvent.VK_BACK_SPACE))			return '*';
		else if(isKeyDown(KeyEvent.VK_ENTER))				return '=';
		else if(isKeyDown(KeyEvent.VK_SUBTRACT))			return '-';
		else if(isKeyDown(KeyEvent.VK_MINUS))				return '-';
		else if(isKeyDown(KeyEvent.VK_ADD))					return '+';
		else if(isKeyDown(KeyEvent.VK_ESCAPE))				return '%';
		else if(isKeyDown(KeyEvent.VK_SPACE))				return '$';
		return ' ';						// return empty space
	}
}