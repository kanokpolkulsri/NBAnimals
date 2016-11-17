package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LeftPlayer {
	
	SpriteBatch batch;
	BasGame basGame;
	Texture player;
	
	public LeftPlayer(BasGame basGame) {
		this.basGame = basGame;
		batch = basGame.batch;
		player = new Texture("aFox.psd");
	}
	
	public void render() {
		batch.draw(player, 0, 0);
	}
}
