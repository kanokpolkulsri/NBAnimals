package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BasHoop {
	SpriteBatch batch;
	BasGame basGame;
	Texture hoop, tabScore;
	
	public BasHoop(BasGame basGame) {
		this.basGame = basGame;
		batch = basGame.batch;
		hoop = new Texture("basHoop.png");
		tabScore = new Texture("scoreTab.png");
	}
	
	public void render() {
		batch.draw(hoop, 0, 0);
		batch.draw(tabScore, 0, 0);
	}
}
