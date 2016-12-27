package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BasRight {
	SpriteBatch batch;
	BasGame basGame;
	Texture ball;
	RightPlayer rightPlayer;
	BitmapFont font;
	public int x = 0, y = 0 , scoreBallRight = 0 , positionY = 0;
	boolean shootBall = false;
	
	public BasRight(BasGame basGame, RightPlayer rightPlayer) {
		this.basGame = basGame;
		this.rightPlayer = rightPlayer;
		batch = basGame.batch;
		ball = new Texture("ballOrange.png");
		font = new BitmapFont();
	}
	
	public void render() {
		batch.draw(ball, x, y);
		positionBall();
		writeScoreRight();
	}
	
	public void writeScoreRight() {
		font.draw(batch, scoreBallRight + " ", 900, 457);
	}
	
	public void positionBall() {
		if(shootBall == false) {
			if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
				if (x != -150) {
					x -= 2;
				}
			} else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				if (x != 110) {
					x += 2;
				}
			}
		}
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			shootBall = true;
			positionY = 200;
		}
		
		if (shootBall == true) {
			if (y < positionY && positionY != -100) {
				y += 2;
				x -= 1;
			} else if (y >= positionY) {
				positionY = -100;
				y -= 2;
				x -= 2;
			} else if (y == -102) {
				shootBall = false;
				x = rightPlayer.getPositionX();
				y = rightPlayer.getPositionY();
			}
		}
		if(x == -330 && y == 120){
			scoreBallRight += 1;
		}
	}
}
