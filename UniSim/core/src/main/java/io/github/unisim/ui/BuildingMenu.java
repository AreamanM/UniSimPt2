package io.github.unisim.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import io.github.unisim.Point;
import io.github.unisim.building.Building;
import io.github.unisim.world.World;

/**
 * Menu used to place buildings in the world by clicking and dragging them
 * from the list onto the map.
 */
public class BuildingMenu {
  private ShapeActor bar = new ShapeActor(Color.GRAY);
  private Table table;
  private final int NUM_BUILDINGS = 4;
  private Building[] buildings = new Building[NUM_BUILDINGS];
  private Image[] buildingImages = new Image[NUM_BUILDINGS];

  /**
   * Create a Building Menu and attach its actors and components to the provided stage.

   * @param stage - The stage on which to draw the menu.
   */
  public BuildingMenu(Stage stage, World world) {
    // Set building images and sizes
    buildings[0] = new Building(
      new Texture(Gdx.files.internal("building_1.png")), new Point(), new Point(4, 4)
    );
    buildings[1] = new Building(
      new Texture(Gdx.files.internal("building_2.png")), new Point(), new Point(3, 3)
    );
    buildings[2] = new Building(
      new Texture(Gdx.files.internal("building_3.png")), new Point(), new Point(3, 4)
    );
    buildings[3] = new Building(
      new Texture(Gdx.files.internal("building_4.png")), new Point(), new Point(2, 2)
    );

    table = new Table();
    // Add buldings to the table
    for (int i = 0; i < NUM_BUILDINGS; i++) {
      buildingImages[i] = new Image(buildings[i].texture);
      final int buildingIndex = i;
      buildingImages[i].addListener(new ClickListener() {
        @Override
        public void clicked(InputEvent e, float x, float y) {
          if (world.selectedBuilding == buildings[buildingIndex]) {
            world.selectedBuilding = null;
          } else {
            world.selectedBuilding = buildings[buildingIndex];
          }
        }
      });
      table.add(buildingImages[i]).width(64).height(64);
    }

    stage.addActor(bar);
    stage.addActor(table);
  }

  public void resize(int width, int height) {
    table.setBounds(0, 0, width, height * 0.1f);
    bar.setBounds(0, 0, width, height * 0.1f);
  }
}
