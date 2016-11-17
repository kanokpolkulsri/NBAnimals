package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackGround {
	
	SpriteBatch batch;
	Texture bg1, bg2, bg3, bg4, bg5, bg6, bg7, bg8, bg9;
	BasGame basGame;
	private int timeForChangePictures = 0;
	
	public BackGround(BasGame basGame) {
		this.basGame = basGame;
		batch = basGame.batch;
		bg1 = new Texture("2.psd");
		bg2 = new Texture("2.psd");
		bg3 = new Texture("3.psd");
		bg4 = new Texture("4.psd");
		bg5 = new Texture("5.psd");
		bg6 = new Texture("6.psd");
		bg7 = new Texture("7.psd");
		bg8 = new Texture("8.psd");
		bg9 = new Texture("9.psd");
		
	}
	
	public void render() {
		timeForChangePictures++;
		changePictures(timeForChangePictures);
		if(timeForChangePictures == 159)
			timeForChangePictures=0;
	}
	
	public void changePictures(int timeForChangePictures) {
		switch (timeForChangePictures / 10) {
		case 16: batch.draw(bg2, 0, 0); break;
		case 15: batch.draw(bg3, 0, 0); break;
		case 14: batch.draw(bg4, 0, 0); break;
		case 13: batch.draw(bg5, 0, 0); break;
		case 12: batch.draw(bg6, 0, 0); break;
		case 11: batch.draw(bg7, 0, 0); break;
		case 10: batch.draw(bg8, 0, 0); break;
		case 9: batch.draw(bg9, 0, 0); break;
		case 8: batch.draw(bg8, 0, 0); break;
		case 7: batch.draw(bg7, 0, 0); break;
		case 6: batch.draw(bg6, 0, 0); break;
		case 5: batch.draw(bg5, 0, 0); break;
		case 4: batch.draw(bg4, 0, 0); break;
		case 3: batch.draw(bg3, 0, 0); break;
		case 2: batch.draw(bg2, 0, 0); break;
		case 1: batch.draw(bg2, 0, 0); break;
		case 0: batch.draw(bg1, 0, 0); break;
		}
	}
}
