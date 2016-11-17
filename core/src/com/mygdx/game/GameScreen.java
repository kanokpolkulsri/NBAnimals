package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	
	SpriteBatch batch;
	BasGame basGame;
	BackGround backGround;
	
	public GameScreen(BasGame basGame) {
		this.basGame = basGame;
		batch = basGame.batch;
		backGround = new BackGround(basGame);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		backGround.render();
		batch.end();
	}
}
