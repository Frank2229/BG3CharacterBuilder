package com.advantageplay.bg3characterbuilder;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class MenuButton extends StackPane {
    private final Button button = new Button();
    private final ImageView buttonImageView = new ImageView(new Image(getClass().getResource("/com/advantageplay/bg3characterbuilder/MenuButton.png").toString()));
    public MenuButton(String buttonName) {
        button.setMinSize(100, 25);
        button.setOpacity(0);
        buttonImageView.setFitHeight(25);
        buttonImageView.setPreserveRatio(true);
        Label label = new Label(buttonName);
        label.getStyleClass().add("menu-button-text");
        getChildren().addAll(buttonImageView, label, button);
    }

    public Button getButton() {
        return button;
    }

    public ImageView getButtonImageView() {
        return buttonImageView;
    }
}