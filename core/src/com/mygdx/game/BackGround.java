package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackGround {
	
	SpriteBatch batch;
	Texture img;
	BasGame basGame;
	BackGround backGround;
	
	public BackGround(BasGame basGame) {
		this.basGame = basGame;
		batch = basGame.batch;
		img = new Texture("1.png");
	}
	
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
}
