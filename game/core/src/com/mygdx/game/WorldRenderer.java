package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {
	
	SpriteBatch batch;
	BasGame basGame;
	BackGround backGround;
	GroundPlayer groundPlayer;
	BasHoop basHoop;
	BasLeft basLeft;
	BasRight basRight;
	LeftPlayer leftPlayer;
	RightPlayer rightPlayer;
	
	public WorldRenderer(BasGame basGame) {
		batch = basGame.batch;
		backGround = new BackGround(basGame);
		groundPlayer = new GroundPlayer(basGame);
		basHoop = new BasHoop(basGame);
		leftPlayer = new LeftPlayer(basGame);
		rightPlayer = new RightPlayer(basGame);
		basLeft = new BasLeft(basGame, leftPlayer);
		basRight = new BasRight(basGame, rightPlayer);
	}
	
	public void render() {
		backGround.render();
		groundPlayer.render();
		basHoop.render();
		basLeft.render();
		basRight.render();
		leftPlayer.render();
		rightPlayer.render();
	}
}
