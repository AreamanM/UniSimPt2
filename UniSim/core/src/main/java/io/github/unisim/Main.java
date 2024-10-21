package io.github.unisim;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class Main extends Game {
  private io.github.unisim.Game game;
  private Skin defaultSkin;
  private float volume = 1.0f; // Default volume

  @Override
  public void create() {
    game = new io.github.unisim.Game();
    defaultSkin = new Skin(Gdx.files.internal("ui/uiskin.json"));
    this.setScreen(new StartMenuScreen(this));
  }

  @Override
  public void render() {
    super.render(); // Ensures the active screen is rendered
  }

  @Override
  public void dispose() {
    game.dispose();
  }

  @Override
  public void resize(int width, int height) {
    game.resize(width, height);
  }

  public float getVolume() {
    return volume;
  }

  public void setVolume(float volume) {
    this.volume = volume;
  }

  public Skin getDefaultSkin() {
    return defaultSkin;
  }
}
