package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BasRight {
	SpriteBatch batch;
	BasGame basGame;
	Texture ball;
	RightPlayer rightPlayer;
	int x = 0, y = 0;
	int positionY = 0;
	boolean shootBall = false;
	
	public BasRight(BasGame basGame, RightPlayer rightPlayer) {
		this.basGame = basGame;
		this.rightPlayer = rightPlayer;
		batch = basGame.batch;
		ball = new Texture("ballOrange.png");
	}
	
	public void render() {
		batch.draw(ball, x, y);
		positionBall();
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
			positionY = 100;
		}
		
		if (shootBall == true) {
			if (y < positionY && positionY != -100) {
				y += 2;
			} else if (y >= positionY) {
				positionY = -100;
				y -= 2;
			} else if (y == -102) {
				shootBall = false;
				x = rightPlayer.getPositionX();
				y = rightPlayer.getPositionY();
			}
		}
	}
}
