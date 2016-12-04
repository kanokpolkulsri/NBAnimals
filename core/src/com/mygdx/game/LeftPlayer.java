package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LeftPlayer {
	
	SpriteBatch batch;
	BasGame basGame;
	Texture player1;
	public int x = 0, y = 0;
	int count = 0;
	
	public LeftPlayer(BasGame basGame) {
		this.basGame = basGame;
		batch = basGame.batch;
		player1 = new Texture("aFox.psd");
	}
	
	public void render() {
		batch.draw(player1, x, y);
		button();
	}
	
	public void button() {
		if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
			count += 1;
			if (x != -100) {
				x -= 2;
			}
		} else if (Gdx.input.isKeyPressed(Input.Keys.C)) {
			count += 1;
			if(x != 140) {
				x += 2;
			}
		}
	}
	
	public int getPositionX() {
		return x;
	}
	
	public int getPositionY() {
		return y;
	}
}
