package com.mygdx.game;

import org.usb4java.Device;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;



public class GameScreen extends ScreenAdapter {
	
	public boolean sw;
	public int acceleroX;
	public int acceleroY;
	public int acceleroZ;
	public int acceleroExpoX;
	public int acceleroExpoY;
	public int acceleroExpoZ;
	public int sumOfAccelero;
	public int acceleroAverage;
	int count = 0;
    int check = 1;
    int acceleroAverage2 = 0;
    int acceleroAverage1 = 0;
    int deltaAcceleroAverage = 0;
    int acceleroX1 = 0;
    int acceleroX2 = 0;
    int deltaAcceleroX = 0;
    int acceleroY1 = 0;
    int acceleroY2 = 0;
    int deltaAcceleroY = 0;
    public Device[] devices;
	
	SpriteBatch batch;
	BasGame basGame;
	WorldRenderer worldRenderer;
//	public Hardware hardware;
	private McuWithPeriBoard peri;
	
	public GameScreen(BasGame basGame) {
		this.basGame = basGame;
		batch = basGame.batch;
		worldRenderer = new WorldRenderer(basGame);
		//hardware = new Hardware();
		//hardware.initHardware();
		System.out.println("1");
		McuBoard.initUsb();
		System.out.println("2");
		devices = McuBoard.findBoards();
		System.out.println("3");
		peri = new McuWithPeriBoard(devices[0]);
		System.out.format("** Practicum board found **\n");
        System.out.format("** Manufacturer: %s\n", peri.getManufacturer());
        System.out.format("** Product: %s\n", peri.getProduct());
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		worldRenderer.render();
		update();
//		hardware.update();
		batch.end();
	}
	
	public void update(){
//      Thread.sleep(50);
      //peri.setLedValue(count);
      sw = peri.getSwitch();
//     boolean sw_board2 = peri2.getSwitch();
//      int light = peri.getLight();
      //System.out.format("LED set to %d | Switch state: %s | Light: %d\n",count, sw, light);
     //System.out.format("Switch state: %s\n", sw);
      
      acceleroX = peri.getAcceleroX();
      acceleroY = peri.getAcceleroY();
      acceleroZ = peri.getAcceleroZ();
//      int acceleroX_board2 = peri2.getAcceleroX();
//      int acceleroY_board2 = peri2.getAcceleroY();
//      int acceleroZ_board2 = peri2.getAcceleroZ();
      
      acceleroExpoX = acceleroX * acceleroX;
      acceleroExpoY = acceleroY * acceleroY;
      acceleroExpoZ = acceleroZ * acceleroZ;
      sumOfAccelero = acceleroExpoX + acceleroExpoY + acceleroExpoZ;	
      acceleroAverage = (int) Math.sqrt(sumOfAccelero);
//      int acceleroExpoX_board2 = acceleroX_board2 * acceleroX_board2;
//      int acceleroExpoY_board2 = acceleroY_board2 * acceleroY_board2;
//      int acceleroExpoZ_board2 = acceleroZ_board2 * acceleroZ_board2;
//      int sumOfAccelero_board2 = acceleroExpoX_board2 + acceleroExpoY_board2 + acceleroExpoZ_board2;	
//      int acceleroAverage_board2 = (int) Math.sqrt(sumOfAccelero_board2);

      if (sw) {
      	System.out.println("Gooddddd");
      	if (check == 1) {
      		acceleroAverage1 = acceleroAverage;
      		acceleroX1 = acceleroX;
      		acceleroY1 = acceleroY;
      		System.out.println("Pressed");
      		check++;
//      		System.out.println("---------before---------");
//      		System.out.println("check: " + check);
//      		System.out.println("acceleroAverage1 = "+acceleroAverage1);
//      		System.out.println("AcceleroX1: "+ acceleroX1);
      	}
//      	System.out.println("AcceleroAverage: " + acceleroAverage);
      } else {
      	if (check == 2) {
      	acceleroAverage2 = acceleroAverage;
      	deltaAcceleroAverage = acceleroAverage2 - acceleroAverage1;
      	acceleroX2 = acceleroX;
      	deltaAcceleroX = acceleroX2 - acceleroX1;
      	acceleroY2 = acceleroY;
      	deltaAcceleroY = acceleroY2 - acceleroY1;
      	System.out.println("Unpressed ///////////////////////////////////////");
      	System.out.println("---------after---------");
      	check = 1;
//      	System.out.println("check: " + check);
      	debug(acceleroAverage1, acceleroAverage2, deltaAcceleroAverage, acceleroX1, acceleroX2, deltaAcceleroX, acceleroY1, acceleroY2, deltaAcceleroY);
      	}
      }
}

public static void debug(int acceleroAverage1, int acceleroAverage2, int deltaAcceleroAverage, int acceleroX1, int acceleroX2, int deltaAcceleroX, int acceleroY1, int acceleroY2, int deltaAcceleroY) {
  	System.out.println("...................................");
  	System.out.println("acceleroAverage1 = "+acceleroAverage1);
  	System.out.println("acceleroAverage2 = "+acceleroAverage2);
  	System.out.println("deltaAcceleroAverage = "+deltaAcceleroAverage);
  	System.out.println();
  	System.out.println("acceleroX1 = "+acceleroX1);
  	System.out.println("acceleroX2 = "+acceleroX2);
  	System.out.println("deltaAcceleroX = "+deltaAcceleroX);
  	System.out.println();
  	System.out.println("acceleroY1 = "+acceleroY1);
  	System.out.println("acceleroY2 = "+acceleroY2);
  	System.out.println("deltaAcceleroY = "+deltaAcceleroY);
  	System.out.println("...................................");
  }
  
  public static void debug_board2(int acceleroAverage1_board2, int acceleroAverage2_board2, int deltaAcceleroAverage_board2, int acceleroX1_board2, int acceleroX2_board2, int deltaAcceleroX_board2, int acceleroY1_board2, int acceleroY2_board2, int deltaAcceleroY_board2) {
  	System.out.println("======================================");
  	System.out.println("acceleroAverage1_board2 = "+acceleroAverage1_board2);
  	System.out.println("acceleroAverage2_board2 = "+acceleroAverage2_board2);
  	System.out.println("deltaAcceleroAverage_board2 = "+deltaAcceleroAverage_board2);
  	System.out.println();
  	System.out.println("acceleroX1_board2 = "+acceleroX1_board2);
  	System.out.println("acceleroX2_board2 = "+acceleroX2_board2);
  	System.out.println("deltaAcceleroX_board2 = "+deltaAcceleroX_board2);
  	System.out.println();
  	System.out.println("acceleroY1_board2 = "+acceleroY1_board2);
  	System.out.println("acceleroY2_board2 = "+acceleroY2_board2);
  	System.out.println("deltaAcceleroY_board2 = "+deltaAcceleroY_board2);
  	System.out.println("======================================");
  }
	
}
