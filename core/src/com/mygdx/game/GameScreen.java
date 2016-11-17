package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
	
	BasGame basGame;
	BackGround backGround;
	
	public GameScreen(BasGame basGame) {
		this.basGame = basGame;
		backGround = new BackGround(basGame);
	}

	@Override
	public void render(float delta) {
		backGround.render();
	}
}
