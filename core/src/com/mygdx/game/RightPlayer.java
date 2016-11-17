package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RightPlayer {
	SpriteBatch batch;
	BasGame basGame;
	Texture player;
	
	public RightPlayer(BasGame basGame) {
		this.basGame = basGame;
		batch = basGame.batch;
		player = new Texture("aTiger.psd");
	}
	
	public void render() {
		batch.draw(player, 0, 0);
	}
}
