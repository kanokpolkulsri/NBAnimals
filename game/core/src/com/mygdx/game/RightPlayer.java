package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RightPlayer {
	SpriteBatch batch;
	BasGame basGame;
	Texture player;
	public int x = 0, y = 0;
	
	public RightPlayer(BasGame basGame) {
		this.basGame = basGame;
		batch = basGame.batch;
		player = new Texture("aTiger.psd");
	}
	
	public void render() {
		batch.draw(player, x, y);
		button();
	}
	
	public void button() {
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
	
	public int getPositionX() {
		return x;
	}
	
	public int getPositionY() {
		return y;
	}
}
