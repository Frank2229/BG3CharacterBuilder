package com.advantageplay.bg3characterbuilder;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SpellButton extends StackPane {
    private boolean isSelected = false;
    private Button button = new Button();
    private ImageView borderImageView = new ImageView(new Image(getClass().getResource("/com/advantageplay/bg3characterbuilder/SpellIconBorder.png").toString()));

    public SpellButton(String path, String name) {
        button.setOpacity(0);
        button.setMinSize(80, 80);
        ImageView iconImageView = new ImageView(new Image(getClass().getResource(path).toString()));
        iconImageView.setFitHeight(50);
        iconImageView.setPreserveRatio(true);
        borderImageView.setFitHeight(80);
        borderImageView.setPreserveRatio(true);
        borderImageView.setVisible(false);
        Label iconLabel = new Label(name);
        iconLabel.getStyleClass().add("spells-label");
        iconLabel.setAlignment(Pos.CENTER);
        VBox buttonVBox = new VBox(iconImageView, iconLabel);
        buttonVBox.setAlignment(Pos.CENTER);
        getChildren().addAll(buttonVBox, borderImageView, button);

        button.setOnMouseEntered(event -> borderImageView.setVisible(true));
        button.setOnMouseExited(event -> {
            if (!isSelected) borderImageView.setVisible(false);
        });
    }

    public Button getButton() {
        return button;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void reset() {
        isSelected = false;
        borderImageView.setVisible(false);
        button.setDisable(false);
    }

    public void setSelected() {
        if (isSelected) isSelected = false;
        else isSelected = true;

        if (isSelected) borderImageView.setVisible(true);
        else borderImageView.setVisible(false);
    }
}
