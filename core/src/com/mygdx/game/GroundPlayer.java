package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GroundPlayer {
	
	SpriteBatch batch;
	BasGame basGame;
	Texture ground;
	Music bgSound;
	
	public GroundPlayer(BasGame basGame) {
		this.basGame = basGame;
		batch = basGame.batch;
		ground = new Texture("floor.png");
		bgSound = Gdx.audio.newMusic(Gdx.files.internal("bgSound.mp3"));
		bgSound.setLooping(true);
		bgSound.play();
	}
	
	public void render() {
		batch.draw(ground, 0, 0);
	}
}
