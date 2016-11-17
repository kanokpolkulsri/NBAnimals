package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GroundPlayer {
	
	SpriteBatch batch;
	BasGame basGame;
	Texture ground;
	
	
	public GroundPlayer(BasGame basGame) {
		this.basGame = basGame;
		batch = basGame.batch;
		ground = new Texture("floor.png");
	}
	
	public void render() {
		batch.draw(ground, 0, 0);
	}
}
