package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BasLeft {
	
	SpriteBatch batch;
	BasGame basGame;
	Texture ball;
	LeftPlayer leftPlayer;
	int x = 0, y = 0;
	boolean shootBall = false;
	int positionY = 0;
	int scoreBallLeft = 0;
	BitmapFont font;
	
	public BasLeft(BasGame basGame, LeftPlayer leftPlayer) {
		this.basGame = basGame;
		this.leftPlayer = leftPlayer;
		batch = basGame.batch;
		ball = new Texture("ballBlue.png");
		font = new BitmapFont();
	}
	
	public void render() {
		batch.draw(ball, x, y);
		positionBall();
		writeScoreLeft();
	}
	public void writeScoreLeft() {
		font.draw(batch, scoreBallLeft + " ", 97, 457);
	}
	
	public void positionBall() {
		if(shootBall == false) {
			if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
				if (x != -100) {
					x -= 2;
				}
			} else if (Gdx.input.isKeyPressed(Input.Keys.C)) {
				if (x != 140) {
					x += 2;
				}
			}
		}
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			shootBall = true;
			positionY = 200;
		}
		
		if (shootBall == true) {
			if (y < positionY && positionY != -100) {
				y += 2;
				x += 1;
			} else if (y >= positionY) {
				positionY = -100;
				y -= 2;
				x += 2;
			} else if (y == -102) {
				shootBall = false;
				x = leftPlayer.getPositionX();
				y = leftPlayer.getPositionY();
			}
			if(x == 314 && y == 126){
				scoreBallLeft += 1;
			}
			//System.out.println("position x : " + x);
			//System.out.println("position y : " + y);
		}
	}
}
